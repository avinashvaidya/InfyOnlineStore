/**
 * 
 */
package com.infy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author AvinashVaidya
 *
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.infy.configuration", "com.infy.controller", "com.infy.dao", "com.infy.service" })
@EnableAspectJAutoProxy
public class InfyOnlineStoreConf {

	@Bean(name = "emailAspect")
	public OutlookAspect getEmailAspect() {
		OutlookAspect emailAspect = new OutlookAspect();
		return emailAspect;

	}

}
