package com.example.demo.test;

import com.example.demo.bo.Employee;
import com.example.demo.factory.ZSqlSessionFactory;
import com.example.demo.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;

/**
 * create by sunzhongwei on 2019/07/26
 * Desc:
 **/
@SuppressWarnings("Duplicates")
public class OneLevelCacheTest {

    public static void main(String[] args) {
        OneLevelCacheTest t = new OneLevelCacheTest();
        //t.testCache1();
        //t.testCache2();
        //t.testCache3();
        t.testCache4();
    }

    public void testCache1(){
        //使用工厂类获得SqlSession对象
        SqlSession sqlSession = ZSqlSessionFactory.getSqlSession();
        //获得EmployeeMapping对象
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee1 = employeeMapper.selectEmployeeById(1);
        System.out.println(employee1);

        try {
            Thread.sleep(20*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //再次查询id为1的Employee对象，因为是同一个SqlSession,所以会从之前的一级缓存中查找数据
        Employee employee2 = employeeMapper.selectEmployeeById(1);
        System.out.println(employee2);
        sqlSession.close();

        // 会发现两个employee对象地址是一样的，mybatis没有再次查询数据库，而是从缓存中直接读出的结果
    }

    public void testCache2(){
        //使用工厂类获得SqlSession对象
        SqlSession sqlSession = ZSqlSessionFactory.getSqlSession();
        //获得EmployeeMapping对象
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee1 = employeeMapper.selectEmployeeById(1);
        System.out.println(employee1);
        //执行delete操作
        employeeMapper.deleteEmployeeById(4);
        //commit提交
        sqlSession.commit();
        //再次查询id为1的Employee对象，因为DML操作会清空sqlSession缓存，所以会再次执行select语句
        Employee employee2 = employeeMapper.selectEmployeeById(1);
        System.out.println(employee2);
        sqlSession.close();
    }

    public void testCache3(){
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
        Employee employee2 = employeeMapper.selectEmployeeById(1);
        System.out.println(employee2);
        sqlSession.close();
    }

    // 二级缓存使用测试
    public void testCache4(){
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
