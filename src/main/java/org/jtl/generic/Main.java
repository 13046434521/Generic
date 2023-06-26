package org.jtl.generic;

import org.jtl.generic.traffic.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GenericClass<String> genericClass = new GenericClass<>("测试数据");
        genericClass.setData(123,456L);

        Main main = new Main();

        main.testClass();
        // 测试泛型通配符
        main.testWildcard();

        // 测试泛型限定符
        main.testQualifier();

        GInterface<Integer> gInterface = new GInterface<>();

        // 逆变/协变测试
        main.testInverterCovariance();
    }


    public void testClass(){
        GenericClass.tt1("test").printT();
        GenericClass.tt2("test").printT();
    }

    public void testInverterCovariance() {
        System.out.println("-----------------------print 协变----------------------");
        // 协变 ， Class<父类> = Class<子类>
        // 可以理解为：由于Traffic是YangWang，AirPlane它们的父类，
        // 所以 ArrayList<? extends Traffic> 是 ArrayList<YangWang>，ArrayList<AirPlane>它们的父类

        ArrayList<? extends Traffic> covarianceList = new ArrayList<YangWang>();
        covarianceList = new ArrayList<AirPlane>();
        covarianceList = new ArrayList<BYD>();

        System.out.println("-----------------------print 逆变----------------------");
        // 逆变，  和协变正好相反，把协变的结果逆转过来
        ArrayList<? super BYD> inverterList = new ArrayList<Traffic>();
        covarianceList = new ArrayList<AirPlane>();
        covarianceList = new ArrayList<YangWang>();


        // ArrayList<Traffic> covarianceList = new ArrayList<YangWang> ();
        // 上面这句话报错原因是，等号两边是不同的类型。

        System.out.println("-----------------------print 协变逆变测试----------------------");
        GenericClass<? extends Traffic> covarianceGeneric = new GenericClass<YangWang>(new YangWang());
        System.out.println(covarianceGeneric.getT().getClass());

        covarianceGeneric = new GenericClass<AirPlane>(new AirPlane());
        System.out.println(covarianceGeneric.getT().getClass());

        covarianceGeneric = new GenericClass<BYD>(new BYD());
        System.out.println(covarianceGeneric.getT().getClass());



        // 逆变，  和协变正好相反，把协变的结果逆转过来
        GenericClass<? super BYD> inverterGeneric = new GenericClass<Traffic>(new Traffic());
        System.out.println(inverterGeneric.getT().getClass());

        inverterGeneric = new GenericClass<BYD>(new BYD());
        System.out.println(inverterGeneric.getT().getClass());

        inverterGeneric = new GenericClass<Car>(new Car());
        System.out.println(inverterGeneric.getT().getClass());


        // 这句话，会报错，原因：协变（上界通配符）只允许获取泛型对象，但是不能修改（传入）泛型对象
        covarianceGeneric.upData(new YangWang());
        // 这句话，不会报错，原因：逆变（下界通配符）可以修改（传入）泛型对象
        inverterGeneric.upData(new YangWang());

    }

    /**
     * 通配符测试
     */
    public void testWildcard(){
        // 传入的泛型，必须是Traffic或者它的子类，
        GenericClass<?extends Traffic> genericExtends1 = new GenericClass<YangWang>(new YangWang());
        genericExtends1.getT().printName();

        GenericClass<?extends Traffic> genericExtends2 = new GenericClass<Traffic>(new Traffic());
        genericExtends2.getT().printName();

        // 传入的泛型，必须是YangWang或者它的父类
        GenericClass<?super YangWang> genericSuper1 = new GenericClass<YangWang>(new YangWang());
        System.out.println( genericSuper1.getT().getClass());

        GenericClass<?super YangWang> genericSuper2 = new GenericClass<Traffic>(new Traffic());
        System.out.println( genericSuper2.getT().getClass());
    }
    /**
     * 限定符测试
     */
    public void testQualifier (){
        GenericQualifierExtends<Traffic> traffic = new GenericQualifierExtends<>(new BYD());

        GenericQualifierExtends<AirPlane> airplane = new GenericQualifierExtends<>(new AirPlane());

        GenericQualifierExtends<Car> car = new GenericQualifierExtends<>(new BYD());

        GenericQualifierExtends<BYD> byd = new GenericQualifierExtends<>(new BYD());
        System.out.println("-----------------------print class----------------------");
        System.out.println(traffic.getClass());
        System.out.println(airplane.getClass());
        System.out.println(car.getClass());
        System.out.println(byd.getClass());

        System.out.println("-----------------------print T----------------------");
        System.out.println(traffic.getT());
        System.out.println(airplane.getT());
        System.out.println(car.getT());
        System.out.println(byd.getT());
    }
}