package com.mm.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.mm.pojo.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>,JpaSpecificationExecutor<Users> {
	
	/**
	 * 根据用户id查询，并与密码比较
	 * @param name
	 * @param pwd
	 * @return
	 */
	Users findByNameAndPwd(String name,String pwd);
	
	/**
	 * 分页查询全部用户
	 * @param pageable
	 * @return
	 */
	@Query(value = "from Users")
	List<Users> findAllByUsers(Pageable pageable);
	
}
