package com.demo.mybatisexample.main;

// 参数大于5个时建议使用这种

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.demo.mybatisexample.mapper.RoleMapper;
import com.demo.mybatisexample.param.RoleParams;
import com.demo.mybatisexample.pojo.Role;
import com.demo.mybatisexample.utils.SqlSessionFactoryUtils;

public class BeanTest {

	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			RoleParams roleParams=new RoleParams();
			roleParams.setRoleName("1");
			roleParams.setNote("1");
			List<Role> roles=roleMapper.findRolesByBean(roleParams);
			//打印一下
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
