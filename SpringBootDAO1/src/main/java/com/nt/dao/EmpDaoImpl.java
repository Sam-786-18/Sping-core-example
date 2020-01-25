package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.nt.bo.EmployeeBo;
@Named("empDAO")
public class EmpDaoImpl implements EmpDao {
private static final String Get_EMP_COUNT="SELECT COUNT(*) FROM EMP";
private static final String GET_EMP_DETAILS_BY_DESG="SELECT EMPID,ENAME,JOB,SAL FROM EMP WHERE JOB=?";
@Resource
private JdbcTemplate jt;
@Override
	public int getEmpCount() {
	int count=0;
		// TODO Auto-generated method stub
	count=jt.queryForObject(Get_EMP_COUNT, Integer.class);
		return count;
	}

	@Override
	public List<EmployeeBo> getEmpdetailsByDesg(String desg) {
		// TODO Auto-generated method stub
		List<EmployeeBo> listbo=null;
		listbo=new ArrayList<EmployeeBo>();
		jt.query(GET_EMP_DETAILS_BY_DESG, new EmployeeRowCallBackHandler(listbo),desg);
		return listbo;
	}
	private static class EmployeeRowCallBackHandler implements RowCallbackHandler{

		private List<EmployeeBo> listbo;
		public EmployeeRowCallBackHandler(List<EmployeeBo> listbo) {
			this.listbo =listbo;
			// TODO Auto-generated constructor stub
		}
		@Override
		public void processRow(ResultSet rs) throws SQLException {
			// TODO Auto-generated method stub
			System.out.println("ProcessRow");
			EmployeeBo bo=null;
			//copy resultset obj record each record to bo
			bo=new EmployeeBo();
			bo.setEmpno(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSalary(rs.getInt(4));
					
			listbo.add(bo);
		}
		
	}

}
