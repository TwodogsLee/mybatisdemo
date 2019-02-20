package com.demo.mybatisexample.main;

// ���������ʱ��ʹ��ע�⴫�ݲ���

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.demo.mybatisexample.mapper.RoleMapper;
import com.demo.mybatisexample.pojo.Role;
import com.demo.mybatisexample.utils.SqlSessionFactoryUtils;

public class AnnotationTest {

	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			List<Role> roles=roleMapper.findRolesByAnnotation("1", "1");
			for(Role role:roles) {
				System.out.println(role);
			}
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
