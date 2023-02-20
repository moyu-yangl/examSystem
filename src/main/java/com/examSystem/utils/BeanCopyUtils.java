package com.examSystem.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {
    private BeanCopyUtils() {

    }

    /**
     * 转化拷贝返回vo类
     *
     * @param source 数据源
     * @param clazz  待转化的vo类
     * @param <O>
     * @param <V>
     * @return
     */
    public static <O, V> V copyBean(O source, Class<V> clazz) {
        V v;
        try {
            v = clazz.newInstance();
            BeanUtils.copyProperties(source, v);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return v;
    }

    /**
     * 转化拷贝返回一个vo类的List
     *
     * @param source 数据源的list
     * @param clazz  待转换的vo类
     * @param <O>
     * @param <V>
     * @return
     */
    public static <O, V> List<V> copyBeanList(List<O> source, Class<V> clazz) {
        return source.stream().map(o -> copyBean(o, clazz)).collect(Collectors.toList());
    }
}
