package com.mm.service;

import java.rmi.ServerException;
import java.util.List;
import java.util.Map;

import org.hibernate.service.spi.ServiceException;

import com.mm.pojo.Users;

public interface UserService {
	
	/**
	 * �û���Ϣ��֤
	 * @param user
	 * @param pwd
	 * @return
	 * @throws ServerException
	 */
	Users login(String user,String pwd) throws ServerException;
	
	/**
	 * ��ѯȫ���û�
	 * @param page
	 * @param from
	 * @return
	 * @throws ServiceException
	 */
	Map<String, Object> getAllBean(Integer page,Integer from) throws ServiceException;
	
	/**
	 * ɾ���û�
	 * @param id
	 * @throws ServiceException
	 */
	void deleteBeans(Integer[] id) throws ServiceException;
}
