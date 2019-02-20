package com.demo.mybatisexample.main;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import com.demo.mybatisexample.mapper.RoleMapper;
import com.demo.mybatisexample.pojo.Role;
import com.demo.mybatisexample.utils.SqlSessionFactoryUtils;

public class MainTest {

	public static void main(String[] args) {
		Logger log = Logger.getLogger(MainTest.class);
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = roleMapper.getRole(1L);
			System.out.println(role);
			log.info(role.getRoleName());
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
