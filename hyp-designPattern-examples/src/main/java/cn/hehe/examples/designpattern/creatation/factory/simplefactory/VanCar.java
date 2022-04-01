package cn.hehe.examples.designpattern.creatation.factory.simplefactory;

/**
 * @author hyp
 * @title: VanCar
 * @projectName hyp-examples
 * @description: TODO
 * @date 2022/3/16 17:46
 */
public class VanCar extends WulinCar {

    public VanCar(){
        this.engine = "Van发动机";
    }

    @Override
    public void run() {
        System.out.println(engine + " ---> 嘟嘟嘟！");
    }
}
