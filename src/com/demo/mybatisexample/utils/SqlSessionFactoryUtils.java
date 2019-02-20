package com.demo.mybatisexample.utils;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtils {
	private final static Class<SqlSessionFactoryUtils> LOCK=SqlSessionFactoryUtils.class;
	private static SqlSessionFactory sqlSessionFactory=null;
	
	//其他方法不能通过new的方式来创建它
	private SqlSessionFactoryUtils() {}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		synchronized (LOCK) {
		    if (sqlSessionFactory != null) {
		    	return sqlSessionFactory;
		    }
		    String resource="com/demo/mybatisexample/mybatis-config.xml";
		    InputStream inputStream;
		    try {
		    	inputStream = Resources.getResourceAsStream(resource);
		    	sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		    }catch (IOException e) {
		    	e.printStackTrace();
		    	return null;
		    }
		    return sqlSessionFactory;
		}
	}
	
	public static SqlSession openSqlSession() {
		if(sqlSessionFactory == null) {
			getSqlSessionFactory();
		}
		//openSession创建SqlSession对象
		return sqlSessionFactory.openSession();
	}
	
}
