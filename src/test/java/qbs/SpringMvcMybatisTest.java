package qbs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import qbs.config.AppConfig;
import qbs.domain.User;
import qbs.service.IUserService;

public class SpringMvcMybatisTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		IUserService userService = context.getBean(IUserService.class);
		User user = new User();
		user.setAccount("180101");
		user.setPassword("123654");
		System.out.println(userService.findUser(user));
	}
	
}
