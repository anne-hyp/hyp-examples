package cn.hehe.examples.designpattern.creatation.factory.simplefactory;

/**
 * @author hyp
 * @title: Main
 * @projectName hyp-examples
 * @description: 测试入口
 * @date 2022/3/16 17:50
 */
public class Main {

    public static void main(String[] args){
        WulinFactory wulinFactory = new WulinFactory();
        WulinCar miniCar = wulinFactory.newCar("mini");
        WulinCar vanCar = wulinFactory.newCar("van");
        miniCar.run();
        vanCar.run();
    }

}
