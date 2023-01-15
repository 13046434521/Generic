package org.jtl;

/**
 * Author（作者）：jtl
 * Date（日期）：2023/1/14 15:35
 * Detail（详情）：泛型类
 * 1. 必须有<T> T 代表任意类型。<T,E,K> 也可以通过,来添加新的泛型
 */
public class GenericClass<T> {
    public T data;

    /**
     * 泛型不能用于静态变量，
     * 原因是不知道T为什么类型
     * public static T msg;
     */


    /**
     * 泛型不能用于静态代码块，
     * 原因是不知道T为什么类型
     * static {
     *     T time;
     * }
     */

    /**
     * 泛型不能用于普通静态方法，
     * 原因是不知道T为什么类型
     * public static T getData(T type){
     *     return type;
     * }
     */

    /**
     * 泛型可以用于静态泛型方法
     * 由于T,E是在泛型方法中定义的
     * 此处调用T,E可以正常运行
     *
     * @param <T>
     * @param <E>
     */
    public static <T, E> T getData(T type, E kind) {
        return type;
    }

    public static <K, E> GenericClass<K> getData1(K type, E kind) {
        return new GenericClass(kind);
    }

    public GenericClass(T data) {
        this.data = data;
    }

    /**
     * 泛型方法
     *
     * @param <T> 第一个泛型（这里的T 和 GenericClass<T>中的T，代表不同类型）
     * @param <E> 第二个泛型
     */
    public <T, E> void setData(T type, E kind) {
        System.out.println("data:" + data.getClass() + "-- type:" + type.getClass() + "-- kind:" + kind.getClass());
    }

    public static <T> GenericClass tt1(T t) {
        return new GenericClass<>(t);
    }

    public static <T> GenericClass <T> tt2(T t) {
        return new GenericClass<>(t);
    }



    public void printT() {
        System.out.println(data);
    }

    public T getT() {
        return data;
    }
}
