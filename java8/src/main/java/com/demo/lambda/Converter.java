package com.demo.lambda;

/**
 * Description:
 * <p>
 * Create on 2019/08/01
 *
 * @author zys
 */

public interface Converter<F,T> {

    public T converter(F from);


}
