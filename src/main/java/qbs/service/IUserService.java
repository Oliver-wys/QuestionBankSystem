package qbs.service;

import java.util.List;
import java.util.Map;

import qbs.domain.User;

public interface IUserService {
	
	/*
	 * 登陆时查找用户
	 * 还需要判断是否是管理员
	 */
	User findUser(User user);
	
	/*
	 * 根据account来查找用户
	 */
	User findUserByAccount(String account);
	
	/*
	 * 查询用户列表的时候查找所有用户
	 * 排除管理员
	 */
	List<User> findAllUser();
	
	/*
	 * 分页查询
	 */
	List<User> findPage(int offset, int limit);
	
	/*
	 * 添加用户
	 */
	void addUser(User user);
	
	/*
	 * 删除单个用户
	 */
	void delUser(Long id);
	
	/*
	 * 批量删除用户
	 */
	void delUsers(List<Long> ids);
	
	/*
	 * 修改密码
	 */
	int changePassword(Map<String, String> password);
	
	void updateInf(User user);
}
