package com.ruyicai.omp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ruyicai.omp.domain.TcashDetail;
import com.ruyicai.omp.domain.User;

@Service
public class SSJDemoService {
	
	public List<User> queryUserList()
	{
		List<User> gridModel = new ArrayList<User>();
		for(int i =0;i<100;i++)
		{
			User u = new User();
			u.setId(String.valueOf(i));
			u.setName("test" + String.valueOf(i));
			u.setCountry(String.valueOf(i));
			u.setCreditLimit(String.valueOf(i));
			u.setCity(String.valueOf(i));
			
			gridModel.add(u);
		}
		return gridModel;
	}

}
