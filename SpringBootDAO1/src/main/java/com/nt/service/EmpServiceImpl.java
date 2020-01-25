package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Named;

import org.springframework.beans.BeanUtils;


import com.nt.bo.EmployeeBo;
import com.nt.dao.EmpDao;
import com.nt.dto.EmployeeDTO;

@Named("empService")
public class EmpServiceImpl implements EmpService {
    
	@Resource
	private EmpDao dao;
	@Override
	public int findEmpcount() {
		int count=0;
		count=dao.getEmpCount();
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public List<EmployeeDTO> findEmployeeByDesg(String desg) {
		// TODO Auto-generated method stub
		List<EmployeeDTO> listdto=null;
		List<EmployeeBo> listbo=null;
		EmployeeDTO dto=null;
		listbo=dao.getEmpdetailsByDesg("dev");
		listdto=new ArrayList<>();
		for(EmployeeBo bo:listbo)
		{
			dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			listdto.add(dto);
		}
		return listdto;
	}

}
