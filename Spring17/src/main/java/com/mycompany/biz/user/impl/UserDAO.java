package com.mycompany.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycompany.biz.common.JDBCUtil;
import com.mycompany.biz.user.UserVO;

//@Repository("userDAO")
public class UserDAO implements UserService{

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String User_Get = "select * from users where id=? and password=?";
	private final String User_Insert = "INSERT INTO USERS values(?,?,?,?)";
	private final String User_Update = "update from users set NAME=?,ROLE=? where ID=?";
	private final String USER_DELETE = "delete from users where ID=?";
	private final String USER_LIST = "select * from users order by ID desc";
	
	// getUser()
	@Override
	public UserVO getUser(UserVO vo) {	
		UserVO user = null;
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(User_Get);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			
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
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}

	@Override
	public void insertUser(UserVO vo) {
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(User_Insert);
			
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getRole());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}

	@Override
	public void updateUser(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			
			stmt = conn.prepareStatement(User_Update);
			
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getRole());
			stmt.setString(3, vo.getId());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	@Override
	public void deleteUser(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_DELETE);
			
			stmt.setString(1, vo.getId());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}

	@Override
	public List<UserVO> getUserList() {
		
		ArrayList<UserVO> uvo = new ArrayList<UserVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_LIST);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				UserVO u = new UserVO();
				
				u.setId(rs.getString("ID"));
				u.setPassword(rs.getString("PASSWORD"));
				u.setName(rs.getString("NAME"));
				u.setRole(rs.getString("ROLE"));
				
				uvo.add(u);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return uvo;
	}
	
}
