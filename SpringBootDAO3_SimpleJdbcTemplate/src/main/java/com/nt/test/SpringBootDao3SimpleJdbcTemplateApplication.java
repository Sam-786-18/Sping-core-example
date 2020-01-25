package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

@SpringBootApplication
@ComponentScan(basePackages={"com.nt.dao","com.nt.service"})
public class SpringBootDao3SimpleJdbcTemplateApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		StudentService service=null;
		StudentDTO dto=null;
		ctx=SpringApplication.run(SpringBootDao3SimpleJdbcTemplateApplication.class, args);
		service=ctx.getBean("stService",StudentService.class);
		dto=new StudentDTO();
		dto.setSno(1005);dto.setSname("Rahul");dto.setBranch("IT");dto.setDept("Cs");
		System.out.println("Registration:: "+service.register(dto));
		((ConfigurableApplicationContext) ctx).close();
	}
}
