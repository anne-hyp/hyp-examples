package cn.hehe.examples.designpattern.creatation.factory.simplefactory;

import java.util.Objects;

/**
 * @author hyp
 * @title: WulinFactory
 * @projectName hyp-examples
 * @description: TODO
 * @date 2022/3/16 17:33
 */
public class WulinFactory {

    public WulinCar newCar(String type){
        if (Objects.equals(type, "van")) {
            return new VanCar();
        } else if (Objects.equals(type, "mini")) {
            return new MiniCar();
        }
        return null;
    }

}
