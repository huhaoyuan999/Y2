package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * 数据库连接工具类
 */
public class HibernateUtil {
    //声明会话工厂
    private static SessionFactory sessionFactory;

    /**
     * 声明静态代码块
     */
    static {
        // 配置文件 hibernate.cfg.xml  默认就是使用这个名字。
        //注册服务
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            //获得会话工厂
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }catch (Exception e) {
            // 如果出现异常销毁会话工厂
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    /**
     *打开会话
     * @return
     */
    public static Session openSession(){
        return sessionFactory.getCurrentSession();
    }
}
