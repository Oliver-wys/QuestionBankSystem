package qbs.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qbs.domain.User;
import qbs.mapper.UserMapper;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	//注入mapper
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/*
	 * 登陆时查找用户
	 * 还需要判断是否是管理员
	 */
	@Override
	public User findUser(User userMessage) {
		
		
		
//		if(user.getIsManager() == 1){
//			System.out.println("是管理员！");
//		}else{
//			System.out.println("不是管理员！");
//		}
		return userMapper.findUser(userMessage.getAccount(), userMessage.getPassword());
		
	}
	

	@Override
	public User findUserByAccount(String account) {
		// TODO Auto-generated method stub
		return userMapper.findUserByAccount(account);
	}

	/*
	 * 查询用户列表的时候查找所有用户
	 * 排除管理员
	 */
	@Override
//	@PreAuthorize("hasRole('Manager')")
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userMapper.findAllUser();
	}


	@Override
	public List<User> findPage(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}


	/*
	 * 添加用户
	 * @see qbs.service.IUserService#addUser(qbs.domain.User)
	 */
	@Override
	public void addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setName("未修改");
		userMapper.addUser(user);
		
	}


	/*
	 * 删除单个用户
	 * @see qbs.service.IUserService#delUser(java.lang.Long)
	 */
	@Override
	public void delUser(Long id) {
		// TODO Auto-generated method stub
		userMapper.delUser(id);
	}


	@Override
	public int changePassword(Map<String, String> password) {
		// TODO Auto-generated method stub
//		$2a$10$Tr7IYK0AyG.6zGrP31VqtuhfuKpJW9Me1jAm65dppDUi3QUWvvUuu
//		$2a$10$xnP669pfUzQrfALlNOrJweo8kd0UzVErn78O/1nZgfKbYfLJIbBva
		String userPassword = userMapper.getPassword(password.get("useraccount"));
		System.out.println("原密码:" + userPassword + "确认原密码：" + passwordEncoder.encode(password.get("oldpassword")));
		System.out.println("match1" + passwordEncoder.matches(password.get("oldpassword"), userPassword));
		if(passwordEncoder.matches(password.get("oldpassword"), userPassword)){
			userMapper.updatePassword(password.get("useraccount"),passwordEncoder.encode(password.get("newpassword")));
			return 1;
		}else{
			return 2;
		}
	}


	/*
	 * 普通用户修改用户信息
	 * @see qbs.service.IUserService#updateInf(qbs.domain.User)
	 */
	@Override
	public void updateInf(User user) {
		// TODO Auto-generated method stub
		userMapper.updateInf(user);
	}

	/*
	 * 批量删除用户
	 * @see qbs.service.IUserService#delUser(java.util.List)
	 */
	@Override
	public void delUsers(List<Long> ids) {
		// TODO Auto-generated method stub
		userMapper.delUsers(ids);
	}


	/*
	 * (non-Javadoc)
	 * @see qbs.service.IUserService#findPage(int, int)
	 * 分页查询
	 */
//	@Override
//	public List<User> findPage(int offset, int limit) {
//		// TODO Auto-generated method stub
//		return userMapper.findPage(offset, limit);
//	}


}
