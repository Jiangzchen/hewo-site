package org.hewo.modules.article.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.solon.annotation.Db;
import org.hewo.core.exception.BusinessException;
import org.hewo.core.service.impl.AbstractServiceImpl;
import org.hewo.core.utils.DateUtil;
import org.hewo.core.utils.OptionalUtil;
import org.hewo.core.utils.StreamUtil;
import org.hewo.modules.article.mapper.PmCustomizeColumnMapper;
import org.hewo.modules.article.mapper.PmCustomizeColumnValueMapper;
import org.hewo.modules.article.model.entity.PmCustomizeColumn;
import org.hewo.modules.article.model.entity.PmCustomizeColumnValue;
import org.hewo.modules.article.service.PmCustomizeColumnService;
import org.hewo.modules.article.service.DbService;
import org.noear.solon.annotation.Inject;
import org.noear.solon.aspect.annotation.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PmCustomizeColumnServiceImpl extends AbstractServiceImpl implements PmCustomizeColumnService {

    @Inject
    private DbService dbService;
    @Db
    private PmCustomizeColumnMapper pmCustomizeColumnMapper;
    @Db
    private PmCustomizeColumnValueMapper pmCustomizeColumnValueMapper;

    @Override
    public boolean saveCustomFieldData(String tableNamePrefix, String id, Map<String, Object> customFieldMap) {
        if (CollUtil.isEmpty(customFieldMap)) {
            throw new BusinessException(10101, "customFieldNotNull");
        } else {
            String tableName = tableNamePrefix + "_custom";

            // 在判断下，自定义的表存不存在数据库
            if (!this.dbService.isExistTable(tableName)) {
                throw new BusinessException(10101, "CustomTableNotExist");
            } else {
                customFieldMap = this.convertSelectValue(customFieldMap);
                StringBuilder insertSqlPrefix = new StringBuilder("Insert into " + tableName + " ( id, ");
                StringBuilder insertValue = new StringBuilder("values ('" + id + "',");
                Iterator var7 = customFieldMap.entrySet().iterator();

                while(var7.hasNext()) {
                    Map.Entry<String, Object> entry = (Map.Entry)var7.next();
                    String key = (String)entry.getKey();
                    LOGGER.info("键 key ：" + key + " 值value ：" + entry.getValue());
                    if (!this.dbService.isExistField(tableName, key)) {
                        LOGGER.info("键 key ：" + key + " 不存在。");
                        throw new BusinessException(10101, "customFieldNotExist");
                    }

                    if (null != entry.getValue() && !"".equals(entry.getValue()) && !"id".equals(key)) {
                        insertSqlPrefix.append(key).append(",");
                        insertValue.append(" '").append(entry.getValue()).append("',");
                    }
                }

                int index = insertSqlPrefix.lastIndexOf(",");
                insertSqlPrefix.replace(index, index + 1, " ) ");
                index = insertValue.lastIndexOf(",");
                insertValue.replace(index, index + 1, " ) ");
                String insertSql = insertSqlPrefix.append(insertValue).toString();
                LOGGER.info("自定字段插入语句: {}", insertSql);
                int count = this.dbService.insert(insertSql);
                return count == 1;
            }
        }
    }

    private List<Map<String, Object>> convertSelectValue(List<Map<String, Object>> customFieldList) {
        if (!CollUtil.isEmpty(customFieldList)) {
            Set<String> keys = new HashSet();
            customFieldList.forEach((m) -> {
                keys.addAll(m.keySet());
            });
            List<PmCustomizeColumn> customizeColumnList = this.pmCustomizeColumnMapper.selectList((Wrapper)((QueryWrapper)(new QueryWrapper()).in("type", Arrays.asList("select", "dynamicSelect"))).in("code", keys));
            if (CollUtil.isEmpty(customizeColumnList)) {
                return customFieldList;
            } else {
                Map<String, PmCustomizeColumn> columnMap = (Map)customizeColumnList.stream().collect(Collectors.toMap((v) -> {
                    return v.getId();
                }, Function.identity()));
                List<PmCustomizeColumnValue> valueList = this.pmCustomizeColumnValueMapper.selectList((Wrapper)(new QueryWrapper()).in("customize_column_id", StreamUtil.toSet(customizeColumnList, (v) -> {
                    return v.getId();
                })));
                Map<String, List<PmCustomizeColumnValue>> selectValueMap = CollUtil.isEmpty(valueList) ? new HashMap() : (Map)valueList.stream().map((v) -> {
                    v.setCustomizeCode((String) OptionalUtil.ofNullable(columnMap.get(v.getCustomizeColumnId()), PmCustomizeColumn::getCode));
                    return v;
                }).collect(Collectors.groupingBy((v) -> {
                    return v.getCustomizeCode();
                }));
                Map<String, PmCustomizeColumn> dySelectColumnMap = (Map)customizeColumnList.stream().filter((f) -> {
                    return "dynamicSelect".equals(f.getType());
                }).collect(Collectors.toMap((v) -> {
                    return v.getCode();
                }, Function.identity()));
                Iterator var8 = customFieldList.iterator();

                while(var8.hasNext()) {
                    Map<String, Object> map = (Map)var8.next();
                    map.forEach((k, v) -> {
                        if (null != v && selectValueMap.keySet().contains(k)) {
                            List<PmCustomizeColumnValue> values = (List)selectValueMap.get(k);
                            Optional<String> optional = values.stream().filter((f) -> {
                                return v.equals(f.getValue());
                            }).map((m) -> {
                                return m.getId();
                            }).findFirst();
                            if (optional.isPresent()) {
                                map.put(k, optional.get());
                            }
                        }
                    });
                }

                return customFieldList;
            }
        }else {
            return customFieldList;
        }
    }

    private Map<String, Object> convertSelectValue(Map<String, Object> customFieldMap) {
        if (CollUtil.isNotEmpty(customFieldMap)) {
            List<Map<String, Object>> listMap = this.convertSelectValue(Arrays.asList(customFieldMap));
            return (Map)listMap.get(0);
        } else {
            return customFieldMap;
        }
    }

    @Override
    public Map<String, Object> queryCustomData(String tableNamePrefix, String id) {
        String tableName = tableNamePrefix + "_custom";
        boolean existTable = this.dbService.isExistTable(tableName);
        Map<String, Object> resultMap = new HashMap();
        if (existTable) {
            resultMap = this.pmCustomizeColumnMapper.queryCustomDataById(tableName, id);
            if (CollUtil.isNotEmpty((Map)resultMap)) {
                Iterator iteratorMap = ((Map)resultMap).entrySet().iterator();

                while(iteratorMap.hasNext()) {
                    Map.Entry<String, Object> entry = (Map.Entry)iteratorMap.next();
                    if (entry.getValue() instanceof Date) {
                        ((Map)resultMap).put(entry.getKey(), DateUtil.getDateStr((Date)entry.getValue(), "yyyy-MM-dd HH:mm:ss"));
                    } else if ("id".equalsIgnoreCase((String)entry.getKey())) {
                        iteratorMap.remove();
                    }
                }
            }
        }
        return (Map)resultMap;
    }
}
