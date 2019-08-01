package com.demo;

/**
 * Description:
 * <p>
 * Create on 2019/08/01
 *
 * @author zys
 */
@FunctionalInterface
public interface Converter<F,T> {

    public T converter(F from);
}
