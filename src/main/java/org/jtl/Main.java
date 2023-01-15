package org.jtl;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import org.jtl.traffic.*;

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


    }

    public void rxJava(){
        Observable.just(1,2,3)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Throwable {
                        System.out.println("result："+ integer);
                    }
                });
    }

    public void testClass(){
        GenericClass.tt1  ("test").printT();
        GenericClass.tt2("test").printT();
    }

    /**
     * 通配符测试
     */
    public void testWildcard(){
        GenericClass<?extends Traffic> genericExtends1 = new GenericClass<YangWang>(new YangWang());
        genericExtends1.getT().printName();

        GenericClass<?extends Traffic> genericExtends2 = new GenericClass<Traffic>(new Traffic());
        genericExtends2.getT().printName();

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