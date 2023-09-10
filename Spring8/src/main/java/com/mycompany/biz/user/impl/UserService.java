package com.mycompany.biz.user.impl;

import java.util.List;

import com.mycompany.biz.user.UserVO;

public interface UserService {
	
	UserVO getUser(UserVO vo);
	
	public void insertUser(UserVO vo);
	
	public void updatetUser(UserVO vo);
	
	public void deleteUser(UserVO vo);
	
	public List<UserVO> getUserList();
	
}
