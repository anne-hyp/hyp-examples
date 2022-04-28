package cn.hehe.examples.spring.circularDependencies;


import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author hyp
 * @title: InstanceA
 * @description: 实例类A
 * @date 2022/4/23 10:37
 */
@Component
@Scope("prototype")
public class InstanceA implements IApi {

    @Autowired
    private InstanceB instanceB;

    public InstanceB getInstanceB() {
        return instanceB;
    }

    public void setInstanceB(InstanceB instanceB) {
        this.instanceB = instanceB;
    }

    public InstanceA(InstanceB instanceB) {
        this.instanceB = instanceB;
    }


    public InstanceA() {
        System.out.println("InstanceA实例化");
    }

	@Override
	public void say() {
		System.out.println("I'm A");
	}
}
