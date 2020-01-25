package com.nt.dao;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.nt.bo.StudentBO;
@Named("studDAO")
public class StudentDAOImpl implements StudentDAO {

	
	private SimpleJdbcInsert sji;
	@Inject
	public StudentDAOImpl(DataSource  ds) {
		sji=new SimpleJdbcInsert(ds);
		// TODO Auto-generated constructor stub
	}
	public int insert(StudentBO bo) {
		// TODO Auto-generated method stub
		BeanPropertySqlParameterSource source=null;
		int count=0;
		//set table name
		sji.setTableName("student");
		//source
		
		source=new BeanPropertySqlParameterSource(bo);
		count=sji.execute(source);
		return count ;
	}

}
