package com.wipro.aspect;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Arrays;

import org.springframework.aop.ThrowsAdvice;

public class CommonExceptionLogger implements ThrowsAdvice {
public void afterThrowingLogger(Method method,Object args[],Object target,SQLException e)
{
	System.out.println("4->Exception is raised in "+target.getClass()+" in method "+method.getName()
	+"with args "+Arrays.toString(args)+" and exception is"+e);
}

public void afterThrowing (SQLException e){
	System.out.println("3-Exception is "+e);
}
}
