package com.yqy.controller;

import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import com.yqy.SpringBootDemoApplication;

//@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional  // 加上这两个注解，测试时的插入数据不会插到数据库
@RunWith(SpringJUnit4ClassRunner.class)
@RestController
@SpringBootTest(classes = SpringBootDemoApplication.class) // 这里的Application是springboot的启动类名。
@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TestController {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		// mvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
		mvc = MockMvcBuilders.webAppContextSetup(context).build();// 建议使用这种
	}

	/**
	 * 测试方法中的mockMvc需要调用的方法：
	 * 
	 * 1）mockMvc.perform执行一个请求（该请求由2构造）；
	 * 
	 * 2）MockMvcRequestBuilders.get("/user/1")构造一个请求
	 * 
	 * 3）ResultActions.andExpect添加执行完成后的断言，目的测试返回结果，通过返回结果来确认测试是否成功
	 * 
	 * 4）ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.
	 * print()输出整个响应结果信息。
	 * 
	 * 5）ResultActions.andReturn表示执行完成后返回相应的结果。
	 * 
	 * 1、mockMvc.perform执行一个请求；
	 * 
	 * 2、MockMvcRequestBuilders.get("/user/1")构造一个请求
	 * 
	 * 3、ResultActions.andExpect添加执行完成后的断言
	 * 
	 * 4、ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.
	 * print()输出整个响应结果信息。
	 * 
	 * 5、ResultActions.andReturn表示执行完成后返回相应的结果。
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/user/getAll")
				// .contentType(MediaType.APPLICATION_JSON_UTF8)
				// .param("lat", "123.123").param("lon", "456.456")
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.content().string(Matchers.contains("SUCCESS")));
	}
	
	public static void main(String[] args) {
		 Stream.generate(Math::random).limit(5).forEach(System.out::println);
	}

}
