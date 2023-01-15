package org.jtl;

/**
 * Author（作者）：jtl
 * Date（日期）：2023/1/14 21:20
 * Detail（详情）：实现泛型接口的方法。
 * 必须声明接口中的泛型（GInterface<J>）
 */
public class GInterface<J> implements GenericInterface<J>{

    @Override
    public J testGeneric(J t) {
        return t;
    }

    @Override
    public <E> J upData(E e) {
        return null;
    }
}
