package com.mm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ÅäÖÃÒ³ÃæÌø×ª
 * @author w
 *
 */
@Controller
public class IndexController {
	@RequestMapping("/main.html")
	public String getmain(){
		return "forward:/views/main.html";
	}
	@RequestMapping("/admin.html")
	public String getadmin(){
		return "forward:/views/admin.html";
	}
}
