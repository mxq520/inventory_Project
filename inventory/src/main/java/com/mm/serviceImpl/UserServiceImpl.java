package com.mm.serviceImpl;

import java.rmi.ServerException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.Store;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mm.dao.UsersRepository;
import com.mm.pojo.Users;
import com.mm.service.UserService;

@Service("/userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository userdao;
	
	@Override
	public Users login(String user, String pwd) throws ServerException {
		Users usr = userdao.findByNameAndPwd(user,pwd);
		if(usr != null&&usr.getPwd().equals(pwd)){
			return usr;
		}else{
			return null;
		}
	}

	@Override
	public Map<String, Object> getAllBean(Integer page, Integer from) throws ServiceException {
		Map<String, Object> map = new HashMap<String, Object>();
		Sort sort = new Sort(Sort.Direction.ASC, "id");  //½µÐò
		Pageable pageable = PageRequest.of(page, from,sort);
		List<Users> list = userdao.findAllByUsers(pageable);
		Integer count = (int) userdao.count();
		map.put("list", list);
		map.put("count", count);
		return map;
	}

	@Override
	public void deleteBeans(Integer[] id) throws ServiceException {
		for(int i = 0;i<id.length;i++){
			userdao.deleteById(id[i]);
		}
		
	}
	
	

}
