package org.hewo.core.support.filter;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.hewo.core.exception.BusinessException;
import org.hewo.core.model.entity.R;
import org.hewo.core.utils.JwtUtil;
import org.hewo.core.utils.ThreadLocalGroup;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Filter;
import org.noear.solon.core.handle.FilterChain;

@Slf4j
@Component
public class JwtAuthFilter implements Filter {
    @Override
    public void doFilter(Context ctx, FilterChain chain) throws Throwable {
        try {
            String token = ctx.header("Authorization");
            if (ctx.path().contains("verifyAuth")
                    || ctx.path().contains("test")
                    || ctx.path().contains("js")
                    || ctx.path().contains("css")
                    || ctx.path().contains("toLogin")
                    || ctx.path().contains("images")) {
                chain.doFilter(ctx);
            } else if (StrUtil.isEmpty(token)) {
                throw new BusinessException(-1, "没有提供token");
            } else {
                boolean verify = JwtUtil.verify(token);
                if (verify) {
                    String userId = "632afb843a1c45e6a9b90713826c6fad";
                    if (token != null && JwtUtil.getUserId(token) != null) {
                        userId = JwtUtil.getUserId(token);
                    }

                    ThreadLocalGroup.setUserId(userId);
                    ThreadLocalGroup.setToken(token);
                    chain.doFilter(ctx);
                } else {
                    throw new BusinessException(10004, "10004");
                }
            }
        }catch (BusinessException var12) {
            Object obj = R.error(100,var12.getMessage());
            ctx.render(obj);
        }catch (Exception var13){
            Object obj = R.error(100,var13.getMessage());
            ctx.render(obj);
        }
    }
}
