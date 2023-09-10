package com.mycompany.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycompany.biz.common.JDBCUtill;
import com.mycompany.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO implements UserService{
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String USER_GET
		="select * from users where id=? and password=?";
	private final String USER_INSERT
		="insert into users values(?,?,?,?)";
	private final String USER_UPDATE
		="";
	private final String USER_DELETE
		="";
	private final String USER_LIST
		="";
	
	
	@Override
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		
		
		try {
			conn = JDBCUtill.getConnection();
			
			stmt = conn.prepareStatement(USER_GET);
			stmt.setNString(1, vo.getId());
			stmt.setNString(2, vo.getPassword());
	
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(rs, stmt, conn);
		}
		return user;
	}

	@Override
	public void insertUser(UserVO vo) {
		
		
	}

	@Override
	public void updatetUser(UserVO vo) {
		
		
	}

	@Override
	public void deleteUser(UserVO vo) {
		
		
	}

	@Override
	public List<UserVO> getUserList() {
		
		return null;
	}
}
