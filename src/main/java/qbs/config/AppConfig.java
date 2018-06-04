package qbs.config;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("qbs")
@EnableWebMvc
@MapperScan("qbs.mapper")
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
public class AppConfig extends WebMvcConfigurerAdapter {

	private static final Logger logger = Logger.getLogger(AppConfig.class);

	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		factoryBean.setDataSource(dataSource);
		return factoryBean;
	}

	// 开启事物管理
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		// 事务管理组件,进行事务管理的xml配置
		DataSourceTransactionManager dstm = new DataSourceTransactionManager();
		dstm.setDataSource(dataSource);
		return dstm;
	}

	@Bean
	public ViewResolver viewResolver() {
		logger.info("ViewResolver");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public DataSource dataSource(Environment env) {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		// env.getProperty("someKey")获得属性值
		ds.setDriverClassName(env.getProperty("jdbc.driver"));
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		return ds;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		logger.info("addResourceHandlers");
		registry.addResourceHandler("/assets/**").addResourceLocations("/public/");
	}

	// @Bean
	// public RestTemplate restTemolate(){
	// // 使用apache hc HttpClient库来负责底层请求发送
	// ClientHttpRequestFactory requestFactory = new
	// HttpComponentsClientHttpRequestFactory();
	// RestTemplate rs = new RestTemplate(requestFactory);
	// //类型转换器 其中？代表不在意是什么类型
	// List<HttpMessageConverter<?>> messageConverters = Arrays.asList(
	// //转换成json类型
	// new MappingJackson2HttpMessageConverter()
	// );
	// rs.setMessageConverters(messageConverters);
	// return rs;
	// }
}
