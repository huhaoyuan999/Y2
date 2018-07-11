package com.mybatis;

import com.mybatis.dao.UserMapper;
import com.mybatis.pojo.User;
import com.mybatis.util.myBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class test {


    @Test
    public void test1() {
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
    public void deleteTest() {
        int count = 0;
        SqlSession sqlsession = null;
        try {
            sqlsession = myBatisUtil.openSession();
            count = sqlsession.getMapper(UserMapper.class).deleteID(13);
            System.out.println("删除的影响行数是：" + count);
            sqlsession.commit();
        } catch (Exception e) {
            e.getStackTrace();
            sqlsession.rollback();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }


    @Test
    public void updateTest() {
        int count = 0;
        SqlSession sqlsession = null;
        Integer id = 7;
        String userName = "pppk";
        try {
            sqlsession = myBatisUtil.openSession();
            count = sqlsession.getMapper(UserMapper.class).updateSetInfo(id, userName);
            System.out.println("修改的影响行数是：" + count);
            sqlsession.commit();
        } catch (Exception e) {
            e.getStackTrace();
            sqlsession.rollback();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }

    @Test
    public void selectAllTest() {
        SqlSession sqlsession = null;
        List<User> list = null;
        try {
            sqlsession = myBatisUtil.openSession();
            list = sqlsession.getMapper(UserMapper.class).selectAllInfo();
            System.out.println(list);

            for (User user : list) {
                System.out.println("姓名是：" + user.getUserName() + "   密码是：" + user.getUserPassword() + "  出生日期是：");
            }
            sqlsession.commit();
        } catch (Exception e) {
            e.getStackTrace();
            sqlsession.rollback();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }


    @Test
    public void selectRootTest() {
        SqlSession sqlsession = null;
        List<User> list = null;
        Integer sex = 1;
        try {
            sqlsession = myBatisUtil.openSession();
            list = sqlsession.getMapper(UserMapper.class).listRootInfo();
            for (User user : list) {
                System.out.println("姓名是：" + user.getUserName() + "   电话是：" + user.getPhone() + "  职位是：" + user.getRole().getRoleName());
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }


    @Test
    public void selectAllInfo() {
        SqlSession sqlsession = null;
        List<User> list = null;
        try {
            sqlsession = myBatisUtil.openSession();
            list = sqlsession.getMapper(UserMapper.class).listAllInfos();
            System.out.println(list);
            for (User user : list) {
                System.out.println("姓名是：" + user.getUserName() + "   密码是：" + user.getUserPassword() + "  出生日期是：");
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }


    @Test
    public void selectLIstUser() {
        SqlSession sqlsession = null;
        List<User> list = null;
        Integer role = 2;
        String name = "赵";
        try {
            sqlsession = myBatisUtil.openSession();
            list = sqlsession.getMapper(UserMapper.class).getUserList(name, role);
            System.out.println(list);
            for (User user : list) {
                System.out.println("姓名是：" + user.getUserName() + "   密码是：" + user.getUserPassword());
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }


    @Test
    public void updateUser() {
        SqlSession sqlsession = null;
        Integer num = -1;
        User user = new User();
        user.setId(1);
        user.setUserName("系统管理员啊");
        user.setAddress("地址测试修改");
        user.setModifyBy(1);
        try {
            sqlsession = myBatisUtil.openSession();
            num = sqlsession.getMapper(UserMapper.class).updateUser(user);
            System.out.println("修改过后的影响行数是：" + num);
            sqlsession.commit();
        } catch (Exception e) {
            e.getStackTrace();
            sqlsession.rollback();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }

    @Test
    public void updateUserName() {
        SqlSession sqlsession = null;
        Integer num = -1;
        User user = new User();
        user.setId(8);
//        user.setUserName("系统管理员");
//        user.setUserCode("ceshiyixua");
//        user.setUserPassword("33333333333");
//        user.setGender(1);
        user.setAddress("湖南郴州");
        try {
            sqlsession = myBatisUtil.openSession();
            num = sqlsession.getMapper(UserMapper.class).updateUserName(user);
            System.out.println("修改过后的影响行数是：" + num);
            sqlsession.commit();
        } catch (Exception e) {
            e.getStackTrace();
            sqlsession.rollback();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }
}
