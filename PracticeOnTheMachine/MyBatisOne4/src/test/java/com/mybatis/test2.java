package com.mybatis;

import com.mybatis.dao.ProviderMapper;
import com.mybatis.dao.RoleMapper;
import com.mybatis.dao.UserMapper;
import com.mybatis.pojo.Address;
import com.mybatis.pojo.Provider;
import com.mybatis.pojo.Role;
import com.mybatis.pojo.User;
import com.mybatis.util.myBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class test2 {

    @Test
    public void updateUser() {
        SqlSession sqlsession = null;
        List<User> list = null;
        Integer[] num = new Integer[2];
        num[0] = 1;
        num[1] = 2;
        try {
            sqlsession = myBatisUtil.openSession();
            list = sqlsession.getMapper(UserMapper.class).getClomnInfo(num);
            for (User user : list) {
                System.out.println("姓名是：" + user.getUserName() + "  密码是：" + user.getUserPassword());
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }


    @Test
    public void updateUserList() {
        SqlSession sqlsession = null;
        List<User> list = null;
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(1);
        try {
            sqlsession = myBatisUtil.openSession();
            list = sqlsession.getMapper(UserMapper.class).getListInfo(list1);
            for (User user : list) {
                System.out.println("姓名是：" + user.getUserName() + "  密码是：" + user.getUserPassword());
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }

    @Test
    public void updateUserMap() {
        SqlSession sqlsession = null;
        List<User> list = null;
        Map<String, Object> map = new HashMap<String, Object>();
        List<Integer> list1 = new ArrayList<>();
//        list1.add(2);
        list1.add(3);
        map.put("gender9", 1);
        map.put("roleIds9", list1);
        try {
            sqlsession = myBatisUtil.openSession();
            list = sqlsession.getMapper(UserMapper.class).getListUserInfo(map);
            for (User user : list) {
                System.out.println("姓名是：" + user.getUserName() + "  密码是：" + user.getUserPassword());
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }

    @Test
    public void updateUserMaps() {
        SqlSession sqlsession = null;
        List<User> list = null;
        Map<String, Object> map = new HashMap<String, Object>();
        List<Integer> list1 = new ArrayList<>();
//        list1.add(1);
        list1.add(3);
        map.put("key9", list1);
        try {
            sqlsession = myBatisUtil.openSession();
            list = sqlsession.getMapper(UserMapper.class).getListInfoMap(map);
            for (User user : list) {
                System.out.println("姓名是：" + user.getUserName() + "  密码是：" + user.getUserPassword());
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }

    @Test
    public void updateUserChoose() {
        SqlSession sqlsession = null;
        List<User> list = null;
        String userPassword = "0000000";
//        Integer id=1;
//        String userCode="admin";
//        String userName="系统管理员";
        String userCode = null;
        String userName = null;
//        String userPassword=null;
        Integer id = null;
        try {
            sqlsession = myBatisUtil.openSession();
            list = sqlsession.getMapper(UserMapper.class).getListInfoChoose(id, userCode, userName, userPassword);
            for (User user : list) {
                System.out.println("姓名是：" + user.getUserName() + "  密码是：" + user.getUserPassword());
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }

    @Test
    public void updateUserPage() {
        SqlSession sqlsession = null;
        List<User> list = null;
        try {
            sqlsession = myBatisUtil.openSession();

            list = sqlsession.getMapper(UserMapper.class).getListInfoListLimit(0, 5);
            for (User user : list) {
                System.out.println("姓名是：" + user.getUserName() + "  密码是：" + user.getUserPassword());
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }

    @Test
    public void updateUserRole() {
        SqlSession sqlsession = null;
        List<User> list = null;
        try {
            sqlsession = myBatisUtil.openSession();
            list = sqlsession.getMapper(UserMapper.class).getListRoleId(2);
            for (User user : list) {
                System.out.println("姓名是：" + user.getUserName() + "  密码是：" + user.getUserPassword()
                        + "  角色创建者：" + user.getRole().getRoleCode() + "角色名称：" + user.getRole().getRoleName());
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }


    @Test
    public void updateUserAddress() {
        SqlSession sqlsession = null;
        List<User> list = null;
        try {
            sqlsession = myBatisUtil.openSession();
            list = sqlsession.getMapper(UserMapper.class).getAddressByUserId(1);
            for (User user : list) {
                System.out.println("姓名是：" + user.getUserName() + "  密码是：" + user.getUserPassword());
                for (Address address : user.getAddressList()) {
                    System.out.println("姓名是：" + address.getContact() + "  地址是：" + address.getAddressDesc());
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }


    @Test
    public void updateUserProvider() {
        SqlSession sqlsession = null;
        List<Provider> list = null;
        try {
            sqlsession = myBatisUtil.openSession();
            list = sqlsession.getMapper(ProviderMapper.class).allProviderInfo();
            for (Provider provider : list) {
                System.out.println("供应商名称:" + provider.getProName() + "   供应商详细描述:" + provider.getProDesc());
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }


    @Test
    public void updateUserAddresUser() {
        SqlSession sqlsession = null;
        List<User> list = null;
        String userName = "张";
        Integer id = 3;
        try {
            sqlsession = myBatisUtil.openSession();
            list = sqlsession.getMapper(UserMapper.class).listConcatInfo(userName, id);
            for (User user : list) {
                System.out.println("姓名是：" + user.getUserName() + "  密码是：" + user.getUserPassword()
                        + "   角色名称是：" + user.getRole().getRoleName());

            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }


    @Test
    public void insertRoleInfo() {
        Integer num = 0;
        SqlSession sqlsession = null;
        try {
            Role role = new Role();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2018-07-11");
            role.setId(10);
            role.setRoleCode("SMBMS_ADMIN");
            role.setRoleName("老板");
            role.setCreatedBy(1);
            role.setCreationDate(date);
            role.setModifyBy(1);
            role.setModifyDate(date);

            System.out.println(num);
            sqlsession = myBatisUtil.openSession();
            num = sqlsession.getMapper(RoleMapper.class).insertRoleInfo(role);
            System.out.println("88888888888888888");
            sqlsession.commit();
        } catch (Exception e) {
            e.getStackTrace();
            sqlsession.rollback();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }



    @Test
    public void selectAddresUserInfo() {
        SqlSession sqlsession = null;
        List<User> list = null;
        Integer id=2;
        try {
            sqlsession = myBatisUtil.openSession();
            list = sqlsession.getMapper(UserMapper.class).getIdUserAdderssInfo(id);
            for (User user : list) {
                System.out.println("姓名会是：" + user.getUserName() + "  密码会是：" + user.getUserPassword());
                for (Address address:user.getAddressList()){
                    System.out.println("联系人姓名:"+address.getContact()+ "  收货地址明细: " +address.getAddressDesc());
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            myBatisUtil.closeSession(sqlsession);
        }
    }




}
