package com.mm;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * …Ë÷√ƒ¨»œ ◊“≥
 * @author mxq
 *
 */
@Configuration
public class IndexViewConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		 registry.addViewController("/").setViewName("forward:/views/index.html");
	     registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}
	
}
