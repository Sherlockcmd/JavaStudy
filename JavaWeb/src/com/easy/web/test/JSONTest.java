package com.easy.web.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

public class JSONTest {

    //Java对象转为JSON字符串
    @Test
    public void test1() throws JsonProcessingException {
        //1、创建Person对象
        Person person = new Person();
        person.setId(2);
        person.setName("张三");
        person.setAge(23);
        person.setGender("男");
        person.setBirthday(new Date());
        //2、创建Jackson核心对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);
        //{"id":2,"name":"张三","gender":"男","birthday":"2025-03-08"}
        System.out.println(json);
    }

    //演示 JSON字符串转为Java对象
    @Test
    public void test3() throws IOException {
        // 1、创建一个json字符串
        // String json = "{"id":2,"name":"张三","gender":"男","birthday":"2025-03-08"}";
        //转义
        String json = "{\"id\":2,\"name\":\"张三\",\"gender\":\"男\",\"birthday\":\"2025-03-08\"}";
        //2、创建ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3、json字符串转换为java对象
        Person person = mapper.readValue(json, Person.class);
        //Person{id=2, name='张三', age=null, gender='男', birthday=Sat Mar 08 08:00:00 CST 2025}
        System.out.println(person);
    }
}
