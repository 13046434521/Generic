package org.jtl.generic;

/**
 * Author（作者）：jtl
 * Date（日期）：2023/1/14 20:41
 * Detail（详情）：泛型接口
 */
public interface GenericInterface <T>{
    T testGeneric(T t);

    <E> T upData(E e);
}
