package com.mycompany.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserService userDAO;
	
	public void setUserDAO(UserService userDAO) {  //주입
		this.userDAO = userDAO;
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	@Override
	public void insertUser(UserVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatetUser(UserVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(UserVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserVO> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
