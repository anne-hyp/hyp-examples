package cn.hehe.examples.javase.collections;

import cn.hehe.examples.javase.vo.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hyp
 * @title: ListTest
 * @projectName hyp-examples
 * @description: List测试类
 * @date 2022/4/28 16:32
 */
public class ListTest {

    public static void main(String[] args){
//        removeMultipleEle();
//        listSort();
        comparatorSort();
    }

//ArrayList
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//元素删除
//----------------------------------------------------------------------------------------------------------------------------------
    /**
     * ArrayList根据下标删除多个元素
     */
    public static void removeMultipleEle(){
        ArrayList list = new ArrayList(Arrays.asList(0,1,2,3,4,5,6,7,8,9));

        System.out.println(list);
        Iterator iterator = list.iterator();
        int i = 1;
        while (iterator.hasNext()) {
            if (iterator.next()!=null && (i==1 || i==3 || i==6)) {
                iterator.remove();
            }
            i++;
        }
        System.out.println(list);
    }
//----------------------------------------------------------------------------------------------------------------------------------

//排序
//----------------------------------------------------------------------------------------------------------------------------------
    /**
     * Collections排序：
     * ①Collections.sort()方法可以对Integer和String类型排序
     * ②实体类继承Comparable接口后调用Collections.sort()方法实现排序
     * 其实①和②都是通过继承Comparable接口来实现排序
     */
    public static void listSort(){
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers,1,3,2,6,4,8,7,9);
        Collections.sort(numbers);
        System.out.println("numbers："+numbers.toString());
        //运行结果 --> numbers：[1, 2, 3, 4, 6, 7, 8, 9]

        List<String> strNumbers = new ArrayList<>();
        Collections.addAll(strNumbers,"1","3","2","6","4","8","7","9");
        Collections.sort(strNumbers);
        System.out.println("strNumbers："+strNumbers.toString());
        //运行结果 --> strNumbers：[1, 2, 3, 4, 6, 7, 8, 9]
        
        List<User> userList = new ArrayList<>();
        Collections.addAll(userList,
                new User(1,"Jack",25,"男"),
                new User(2,"Jason",24,"男"),
                new User(3,"Jimmy",20,"男"),
                new User(4,"Lucy",19,"男"),
                new User(5,"Tom",21,"男")
        );
        //User实现Comparable接口
        Collections.sort(userList);
        System.out.println(userList);
    }

    /**
     * 调用List的sort方法，传入Comparator类并实现compare方法进行排序
     */
    public static void comparatorSort(){
        List<User> userList = new ArrayList<>();
        Collections.addAll(userList,
                new User(1,"Jack",25,"男"),
                new User(2,"Jason",24,"男"),
                new User(3,"Jimmy",20,"男"),
                new User(4,"Lucy",19,"男"),
                new User(5,"Tom",21,"男")
        );
        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });
        System.out.println(userList);
    }

    /**
     * 通过Collection.stream().sort()方法，传入Comparable.compareTo()或Comparator.comparing()进行排序
     */
    public static void streamSort(){
        //排序整数类型集合中的元素
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 1, 3, 2, 6, 4, 8, 7, 9);
        numbers = numbers.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println("numbers：" + numbers);
        //运行结果 --> numbers：[1, 2, 3, 4, 6, 7, 8, 9]

        //排序其他范型集合中的数据
        //比如现在有一个User类型的List集合，要求根据User对象中的age属性对List集合中的User对象进行排序
        List<User> userList = new ArrayList<>();
        Collections.addAll(userList,
                new User(1,"Jack",25,"男"),
                new User(2,"Jason",24,"男"),
                new User(3,"Jimmy",20,"男"),
                new User(4,"Lucy",19,"男"),
                new User(5,"Tom",21,"男")
        );
        userList =userList
                .stream()
                .sorted(Comparator.comparing(User::getAge).reversed())//加上reversed()方法就是逆序排序
                .collect(Collectors.toList());
        System.out.println("userList："+userList.toString());
    }
//----------------------------------------------------------------------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
