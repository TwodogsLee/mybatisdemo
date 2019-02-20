package com.demo.mybatisexample.main;

//�������֣��ɶ��Բ�&̫����

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import com.demo.mybatisexample.mapper.RoleMapper;
import com.demo.mybatisexample.pojo.Role;
import com.demo.mybatisexample.utils.SqlSessionFactoryUtils;

public class MapTest {

	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Map<String ,Object> parameterMap=new HashMap<String, Object>();
			parameterMap.put("roleName","1");
			parameterMap.put("note","1");
			List<Role> roles=roleMapper.findRolesByMap(parameterMap);
			//��ӡһ��
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
