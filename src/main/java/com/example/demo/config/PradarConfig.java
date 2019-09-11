package com.example.demo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pamirs.maxplanck.module.base.shared.custominterface.BusinessJavaCode;
import com.pamirs.maxplanck.module.base.shared.entrance.BeanPostProcessor;
import com.pamirs.maxplanck.module.base.shared.filter.DataReceiverFilter;
import com.pamirs.maxplanck.module.base.shared.filter.ValidateFilter;

@Configuration
public class PradarConfig {
	
	@Bean
	public BusinessJavaCode businessJavaCode() {
		BusinessJavaCode businessJavaCode = new BusinessJavaCode();
		businessJavaCode.setCandoTest(true);
		return businessJavaCode;
	}

	@Bean
	public BeanPostProcessor beanPostProcessor() {
		BeanPostProcessor beanPostProcessor = new BeanPostProcessor();
		beanPostProcessor.setTroControlWebUrl("http://10.32.112.161:8000/tro-web");
		beanPostProcessor.setDubboRegisterUrl("http://10.32.112.161:8000");
		return beanPostProcessor;
	}

	@Bean
	public FilterRegistrationBean perssureMeasureFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.addUrlPatterns("/*");
		registration.setFilter(new DataReceiverFilter());
		registration.setName("perssureMeasureFilter");
		return registration;
	}

	@Bean
	public FilterRegistrationBean perssureValidateFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.addUrlPatterns("/*");
		registration.setFilter(new ValidateFilter());
		registration.setName("perssureValidateFilter");
		return registration;
	}

}
