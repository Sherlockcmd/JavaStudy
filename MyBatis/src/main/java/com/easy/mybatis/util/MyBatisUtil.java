package com.easy.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

     //因为只用创建一个会话就可以调数据库，所以用静态代码块，只运行一次
    static {
        try {
            String resource = "mybatis.xml";
            InputStream inputStream = null;
            inputStream = Resources.getResourceAsStream(resource);
            // 创建 SqlSessionFactory    Session:会话 (连接数据库后就建立了一次会话，有了会话就可以操作数据库)
             sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static SqlSession getSqlSession() {
      return sqlSessionFactory.openSession();
    }
}
