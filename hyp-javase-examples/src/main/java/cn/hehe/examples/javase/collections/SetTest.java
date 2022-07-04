package cn.hehe.examples.javase.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/**
 * @author hyp
 * @title: SetTest
 * @projectName hyp-examples
 * @description: Set测试类
 * @date 2022/7/2 11:21
 */
public class SetTest {

    public static void main(String[] args){
        Set set = new HashSet();
        set.add(1);set.add(2);set.add(3);set.add(4);set.add(5);set.add(6);set.add(7);
        System.out.println(set);
        Vector vector = new Vector();
        vector.add(null);vector.add(1);vector.add(null);vector.add(2);vector.add(null);
        System.out.println(vector);
    }

}
