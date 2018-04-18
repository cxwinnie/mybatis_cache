package com.xuxianda.test;

import com.xuxianda.entity.Employee;
import com.xuxianda.factory.ZSqlSessionFactory;
import com.xuxianda.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by Xianda Xu on 2018/04/18 09:38.
 */
public class OneLevelCacheTest {

    @Test
    public void testCache1() {
        //使用工厂类获得SqlSession对象
        SqlSession sqlSession = ZSqlSessionFactory.getSqlSession();
        //获得EmployeeMapping对象
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee1 = employeeMapper.selectEmployeeById(1);
        System.out.println(employee1);
        //关闭一级缓存
        sqlSession.close();
        //再次访问，需要再次获取一级缓存，然后才能查找数据，否则会抛出异常
        sqlSession = ZSqlSessionFactory.getSqlSession();
        //再次获得EmployeeMapper对象
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        //再次查询id为1的Employee对象，因为DML操作会清空sqlSession缓存，所以会再次执行select语句
        Employee employee2 = employeeMapper.selectEmployeeById(1);
        System.out.println(employee2);
        sqlSession.close();
    }

}
