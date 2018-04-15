package cn.itcast.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.pojo.User;

@Controller
public class MyController {
	@Autowired
	private UserMapper bean= null;
	@RequestMapping("/demo")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("demo");
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
//		UserMapper bean = ctx.getBean(UserMapper.class);
		User u = bean.selectByPrimaryKey(10);
		System.out.println(u);
		mv.addObject("user",u);
		return mv;
	}
}
