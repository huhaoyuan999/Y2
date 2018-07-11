package com.mybatis.util;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class myBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打开资源
     *
     * @return
     */
    public static SqlSession openSession() {
        return sqlSessionFactory.openSession(false);
    }

    /**
     * 释放资源！
     *
     * @param sqlSession
     */
    public static void closeSession(SqlSession sqlSession) {
        if (null != sqlSession) {
            sqlSession.close();
        }
    }
}
