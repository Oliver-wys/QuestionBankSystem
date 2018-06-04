package qbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import qbs.domain.User;

public interface UserMapper {

	/*
	 * 登陆时查找用户
	 * 还需要判断是否是管理员
	 */
	User findUser(@Param("account") String account,@Param("password") String password);
	
	/*
	 * 通过account查找用户
	 */
	User findUserByAccount(String account);
	
	/*
	 * 查询用户列表的时候查找所有用户
	 * 排除管理员
	 */
	List<User> findAllUser();
	
	/*
	 * 分页查找
	 */
//	List<User> findPage(@Param("offset") int offset,@Param("limit") int limit);
	
	void addUser(User user);
	
	void delUser(Long id);
	
	void delUsers(List<Long> ids);
	
	void updateInf(User user);
	
	String getPassword(String account);
	
	void updatePassword(@Param("account")String account,@Param("password")String password);
}
