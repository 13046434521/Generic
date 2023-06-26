package org.jtl.generic;

import org.jtl.generic.traffic.Traffic;

/**
 * Author（作者）：jtl
 * Date（日期）：2023/1/14 21:39
 * Detail（详情）：
 */
public class GenericQualifierSuper <T>{
    public T t;

    public GenericQualifierSuper(T t) {
        this.t = t;
    }

    public void setData1(GenericQualifierSuper<? extends Traffic> data){
        data.t.printName();
    }

    public T getData2(GenericQualifierSuper<? super Traffic> data){
       return t;
    }
}
