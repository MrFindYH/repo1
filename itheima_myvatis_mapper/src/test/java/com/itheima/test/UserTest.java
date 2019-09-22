package com.itheima.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.Order;
import com.itheima.domain.User;
import com.itheima.mapper.OrderMapper;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTest {

    @Test
    public void test1() throws IOException {
        //獲得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapCofig.xml");
        //獲得session工廠對象
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //獲得session會話對象
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(2);
        user.setUsername("zhangsan");
        user.setPassword("333");

        List<User> userList = mapper.findByCondition(user);
        System.out.println(userList);

        sqlSession.close();

    }

    @Test
    public void test2() throws IOException {
        //獲得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapCofig.xml");
        //獲得session工廠對象
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //獲得session會話對象
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
       List<Integer> list = new ArrayList<Integer>();
       list.add(3);
       list.add(8);
        List<User> byIds = mapper.findByIds(list);
        System.out.println(byIds);


        sqlSession.close();

    }


    @Test
    public void test3() throws IOException {
        //獲得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapCofig.xml");
        //獲得session工廠對象
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //獲得session會話對象
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
       user.setUsername("zongyuan");
       user.setPassword("333");
       user.setBirthday(new Date());

       //執行保存操作
        mapper.save(user);
        sqlSession.commit();
        sqlSession.close();


        sqlSession.close();

    }

    @Test
    public void test4() throws IOException {
        //獲得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapCofig.xml");
        //獲得session工廠對象
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //獲得session會話對象
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findById(2);


        System.out.println(user.getBirthday());
        System.out.println(user.getUsername());
        System.out.println(user.toString());
        sqlSession.commit();
        sqlSession.close();

    }


    @Test
    public void test5() throws IOException {
        //獲得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapCofig.xml");
        //獲得session工廠對象
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //獲得session會話對象
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //設置分頁相關參數,  當前頁+每一頁顯示的條數
        PageHelper.startPage(1,3);
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        PageInfo<User>pageInfo =new PageInfo<User>(users);
        System.out.println("當前頁"+pageInfo.getPageNum());
        System.out.println("每頁顯示的條數"+pageInfo.getPageSize());
        System.out.println("總條數"+pageInfo.getTotal());
        System.out.println("總頁數"+pageInfo.getPages());
        System.out.println("上一頁"+pageInfo.getPrePage());
        System.out.println("下一頁"+pageInfo.getNextPage());
        System.out.println("是否是第一頁"+pageInfo.isIsFirstPage());
        System.out.println("是否是最後一頁"+pageInfo.isIsLastPage());
        System.out.println("列表展示"+pageInfo.getList());

        sqlSession.commit();
        sqlSession.close();
        resourceAsStream.close();

    }

    @Test
    public void test6() throws IOException {
        //獲得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapCofig.xml");
        //獲得session工廠對象
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //獲得session會話對象
        SqlSession sqlSession = build.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orders = mapper.findAll();
        for (Order order : orders) {
            System.out.println(order);
        }

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void test7() throws IOException {
        //獲得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapCofig.xml");
        //獲得session工廠對象
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //獲得session會話對象
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void test8() throws IOException {
        //獲得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapCofig.xml");
        //獲得session工廠對象
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //獲得session會話對象
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userAndRoleAll = mapper.findUserAndRoleAll();
        for (User user : userAndRoleAll) {
            System.out.println(user);
        }

        sqlSession.commit();
        sqlSession.close();

    }





}
