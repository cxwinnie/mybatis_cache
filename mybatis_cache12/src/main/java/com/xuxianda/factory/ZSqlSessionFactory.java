package com.xuxianda.factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Xianda Xu on 2018/04/18 09:35.
 */
public class ZSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory = null;
    static{
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获取SqlSession对象的静态方法
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
    //获取SqlSessionFactory的静态方法
    public static SqlSessionFactory getSessionFactory(){
        return sqlSessionFactory;
    }
}
