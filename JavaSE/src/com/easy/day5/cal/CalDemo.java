package com.easy.day5.cal;

import com.easy.day5.Person;
import com.easy.day5.Student;

public class CalDemo {

    public static void main(String[] args) {
        Add add = new Add(3, 5);
        System.out.println(add.getResult());
        Sub sub = new Sub(3, 5);
        System.out.println(sub.getResult());

        //Person person = new Student();
        Cal cal = new Add(3, 5);
        System.out.println(cal.getResult());
        cal = new Sub(3, 5);
        System.out.println(cal.getResult());

        //init
        //'Cal' is abstract; cannot be instantiated
        //Cal c = new Cal(3, 5);
        //System.out.println(c.getResult());
    }


}
