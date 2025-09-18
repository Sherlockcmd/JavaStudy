package com.easy.mvc.controller;

import com.easy.mvc.pojo.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @RequestMapping(value = "/add1")
       public void add1(String name,Integer age,String gender) {
        System.out.println(name);
        System.out.println(age);
        System.out.println(gender);
       }

    @RequestMapping(value = "/add2")
    public ModelAndView add2(Student student) {
        System.out.println(student);

        ModelAndView view = new ModelAndView();
        view.addObject("student",student);
        view.setViewName("student_info");
        return view;

    }

    //get,post都能处理
    //@RequestMapping(value = "/add")
    @RequestMapping(value = "/add",method =  RequestMethod.POST)
    public String add(Student student, Model model) {
        System.out.println(student);

        model.addAttribute("student",student);

        return "student_info";

    }
    @RequestMapping(value = "/deleteAll")
    public String deleteAll(Integer[] ids) {
        System.out.println("StudentController deleteAll");
        System.out.println(Arrays.toString(ids));

        return "student_info";

    }

    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
        System.out.println("StudentController deleteById");
        System.out.println("id:"+id);

        return "redirect:/student/selectAll";
    }

    @RequestMapping("/selectAll")
    public String selectAll() {
        System.out.println("StudentController selectAll");
        return "student_info";
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public Student selectById(Integer id){
        Student student = new Student(1, "张三1", 23, "男");
        return student;
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<Student> select(){
        Student student1 = new Student(1, "张三1", 23, "男");
        Student student2 = new Student(2, "张三2", 23, "男");
        Student student3 = new Student(3, "张三3", 23, "男");
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        return list;
    }



}
