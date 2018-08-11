package com.yqy;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = { "com.yqy.mapper" })
@EnableTransactionManagement // 开启事务
@EnableAsync(proxyTargetClass=true) //配置代理为cglib代理，默认使用 的是jdk动态代理
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
	
	// 创建事务管理器
    @Bean(name = "txManager")  //给事务管理器命名
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
    // 定义错误页面
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return new EmbeddedServletContainerCustomizer() {
        	public void customize(ConfigurableEmbeddedServletContainer container) {
        		
        		ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
                ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");

                container.addErrorPages(error401Page, error404Page, error500Page);
			}
        };
    }

}
