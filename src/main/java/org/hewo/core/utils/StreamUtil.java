package org.hewo.core.utils;

import cn.hutool.core.collection.CollUtil;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamUtil {
    public StreamUtil() {
    }

    public static <T, R> Set<R> toSet(List<T> sourceList, Function<T, R> fun) {
        if (CollUtil.isEmpty(sourceList)) {
            throw new IllegalArgumentException();
        } else {
            return (Set)sourceList.stream().map(fun).collect(Collectors.toSet());
        }
    }
}
