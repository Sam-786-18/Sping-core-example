package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBo;

public interface EmpDao {
 public int getEmpCount();
 public List<EmployeeBo> getEmpdetailsByDesg(String desg);
}
