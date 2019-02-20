package com.demo.mybatisexample.mapper;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.demo.mybatisexample.param.RoleParams;
import com.demo.mybatisexample.pojo.Role;

public interface RoleMapper {
	
	public int insertRole(Role role);
	
	public int deleteRole(Long id);
	
	public int updateRole(Role role);
	
	public Role getRole(Long id);
	
	public List<Role> findRoles(String roleName);
	
	// ͨ��map���ݶ������
	public List<Role> findRolesByMap(Map<String, Object>parameterMap);
	
	// ͨ��ע�⴫�ݶ������
	public List<Role> findRolesByAnnotation(@Param("roleName") String roleName,@Param("note") String note);
	
	// ͨ��javabean���ݶ������
	public List<Role> findRolesByBean(RoleParams roleparam);
	
	// ���÷�ҳ
	public List<Role> findRolesByRowBounds(@Param("roleName") String rolename , @Param("note") String note , RowBounds rowBounds);

}
