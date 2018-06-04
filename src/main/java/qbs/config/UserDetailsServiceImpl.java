package qbs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import qbs.service.IUserService;

@Service
// @Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	//注入用户服务接口，用于调用DAO层方法与数据库进行交互
	@Autowired
	private IUserService userService;

	// 当Spring security需要用户详情时调用此方法，传入用户名
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//打印用户名，用于测试
		System.out.println("loadUserByName:" + username);
		//调用用户服务接口方法从数据库获取数据
		qbs.domain.User user = userService.findUserByAccount(username);
		System.out.println("userService.findUserByAccount(account)" + user);
		//判断用户是否存在
		if (user != null) {
			//判断用户是否为管理员用户，用于区别权限
			if (username.equals("180101")) {
				return new User(username, user.getPassword(), "manager");
			} else {
				return new User(username, user.getPassword(), "user");
			}
		} else {
			//用户不存在，抛出错误
			throw new UsernameNotFoundException("该用户不存在！");
		}
	}

}
