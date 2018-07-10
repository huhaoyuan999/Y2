package com.mybatis;

import com.mybatis.dao.UserMapper;
import com.mybatis.pojo.User;
import com.mybatis.util.myBatisUtil;
import com.sun.corba.se.impl.orbutil.fsm.StateEngineImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class test {


    @Test
    public void test1(){
        int count = 0;
        SqlSession sqlsession = null;

        try {
            sqlsession = myBatisUtil.openSession();
            // 调用mapper文件对数据进行操作
            count = sqlsession.getMapper(UserMapper.class).counts();
            System.out.print("得到的结果会是：" + count);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }

    @Test
    public void deleteTest(){
        int count = 0;
        SqlSession sqlsession = null;
        try {
            sqlsession=myBatisUtil.openSession();
            count=sqlsession.getMapper(UserMapper.class).deleteID(13);
            System.out.println("删除的影响行数是："+count);
            sqlsession.commit();
        }catch (Exception e){
            e.getStackTrace();
            sqlsession.rollback();
        }finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }


    @Test
    public void updateTest(){
        int count = 0;
        SqlSession sqlsession = null;
        Integer id=7;
        String userName="pppk";
        try {
            sqlsession=myBatisUtil.openSession();
            count=sqlsession.getMapper(UserMapper.class).updateSetInfo(id,userName);
            System.out.println("修改的影响行数是："+count);
            sqlsession.commit();
        }catch (Exception e){
            e.getStackTrace();
            sqlsession.rollback();
        }finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }

    @Test
    public void selectAllTest(){
        SqlSession sqlsession = null;
        List<User>list=null;
        try {
            sqlsession=myBatisUtil.openSession();
            list=sqlsession.getMapper(UserMapper.class).selectAllInfo();
            System.out.println(list);
            for (User user:list){
                System.out.println("姓名是："+user.getUserName()+"   密码是："+user.getUserPassword()+"  出生日期是："+user.getBirthday());
            }
            sqlsession.commit();
        }catch (Exception e){
            e.getStackTrace();
            sqlsession.rollback();
        }finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }
}
