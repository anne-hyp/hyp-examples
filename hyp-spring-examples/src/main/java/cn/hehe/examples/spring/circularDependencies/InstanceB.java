package cn.hehe.examples.spring.circularDependencies;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hyp
 * @title: InstanceB
 * @description: 实例类B
 * @date 2022/4/23 10:37
 */
@Component
public class InstanceB  {


    @Autowired
    private InstanceA instanceA;


    public InstanceA getInstanceA() {
        return instanceA;
    }


    public void setInstanceA(InstanceA instanceA) {
        this.instanceA = instanceA;
    }

    public InstanceB(InstanceA instanceA) {
        this.instanceA = instanceA;
    }


    public InstanceB() {
        System.out.println("InstanceB实例化");
    }

}
