package org.jtl;

import org.jtl.traffic.Traffic;


/**
 * Author（作者）：jtl
 * Date（日期）：2023/1/14 21:25
 * Detail（详情）：泛型 限定符
 */
public class  GenericQualifierExtends<T extends Traffic> {
    public T t;
    public  GenericQualifierExtends(T t){
        this.t = t;
    }

    public T getT() {
        return t;
    }

    // 要求K必须继承GenericClass 并且实现 GenericInterface 接口
    public <K extends GenericClass & GenericInterface> void test(K k){};

}
