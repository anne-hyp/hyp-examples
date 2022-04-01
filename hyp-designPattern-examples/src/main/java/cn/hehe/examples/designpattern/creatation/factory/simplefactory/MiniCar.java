package cn.hehe.examples.designpattern.creatation.factory.simplefactory;

/**
 * @author hyp
 * @title: MiniCar
 * @projectName hyp-examples
 * @description: TODO
 * @date 2022/3/16 17:40
 */
public class MiniCar extends WulinCar {

    public MiniCar(){
        this.engine = "Mini发动机";
    }

    @Override
    public void run() {
        System.out.println(engine + " ----> 嘟嘟嘟！");
    }
}
