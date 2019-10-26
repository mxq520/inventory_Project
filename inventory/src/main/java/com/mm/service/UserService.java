package com.mm.service;

import java.rmi.ServerException;
import java.util.List;
import java.util.Map;

import org.hibernate.service.spi.ServiceException;

import com.mm.pojo.Users;

public interface UserService {
	
	/**
	 * 用户信息验证
	 * @param user
	 * @param pwd
	 * @return
	 * @throws ServerException
	 */
	Users login(String user,String pwd) throws ServerException;
	
	/**
	 * 查询全部用户
	 * @param page
	 * @param from
	 * @return
	 * @throws ServiceException
	 */
	Map<String, Object> getAllBean(Integer page,Integer from) throws ServiceException;
	
	/**
	 * 删除用户
	 * @param id
	 * @throws ServiceException
	 */
	void deleteBeans(Integer[] id) throws ServiceException;
}
