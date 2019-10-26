package com.mm.controller;

import java.rmi.ServerException;
import java.util.List;
import java.util.Map;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.mm.pojo.Users;
import com.mm.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;

/**
 * SpringBoot HelloWorld
 * @author w
 *
 */
@Api(value = "�û���Ϣ����")
@Controller
@RequestMapping("/user")
public class UserController {
	public static MappingJackson2JsonView JSON = new MappingJackson2JsonView();
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="�û���¼", notes="�û���¼")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query",name = "name",value = "�û���",dataType = "String",required = true),
		@ApiImplicitParam(paramType = "query",name = "pwd",value = "�û�����",dataType = "String",required = true)
	})
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	@ResponseBody
	public View login(String name,String pwd,Model model){
		try {
			
			Users user = userService.login(name, pwd);
			if(user != null){
				model.addAttribute("stauts", true);
				model.addAttribute("user", user);
				model.addAttribute("msg", "��֤ͨ����");
			}else
			{
				model.addAttribute("stauts", false);
				model.addAttribute("msg", "��֤ʧ�ܣ�");
			}
			
		} catch (ServerException e) {
			model.addAttribute("stauts", false);
			model.addAttribute("msg", "��֤ʧ�ܣ�");
			e.printStackTrace();
		}
		
		return JSON;
	}
	
	@ApiOperation(value="�û���¼", notes="�û���¼")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query",name = "page",value = "�û�����",dataType = "Integer",required = true),
		@ApiImplicitParam(paramType = "query",name = "from",value = "�û�����",dataType = "Integer",required = true)
	})
	@RequestMapping(value = "getBeans",method = RequestMethod.GET)
	@ResponseBody
	public View getBeans(Integer page,Integer size,Model model){
		
		try {
			Map<String, Object> map = userService.getAllBean(page-1, size);
			List<Users> list = (List<Users>) map.get("list");
			if(list.size() == 0){
				model.addAttribute("status", false);
				model.addAttribute("msg", "û�����ݣ�");
			}else{
				model.addAttribute("list", list);
				model.addAttribute("count", map.get("count"));
				model.addAttribute("status", true);
				model.addAttribute("msg", "��ѯ�ɹ���");
			}
			
		} catch (ServiceException e) {
			model.addAttribute("status", false);
			model.addAttribute("msg", "��ѯʧ�ܣ�");
			e.printStackTrace();
		}
		return JSON;
	}
	
	@ApiOperation(value="ɾ���û�", notes="ɾ���û�")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query",name = "id",value = "�û�id",dataType = "Integer",required = true)
	})
	@RequestMapping(value = "deleteBean",method = RequestMethod.GET)
	@ResponseBody
	public View deleteBean(Integer[] id,Model model){
		
		try {
			userService.deleteBeans(id);
			model.addAttribute("status", true);
			model.addAttribute("msg", "ɾ���ɹ���");
		} catch (ServiceException e) {
			model.addAttribute("status", false);
			model.addAttribute("msg", "ɾ��ʧ�ܣ�");
			e.printStackTrace();
		}
		
		return JSON;
	}
}
