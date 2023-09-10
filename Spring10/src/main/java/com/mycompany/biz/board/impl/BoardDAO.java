package com.mycompany.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycompany.biz.board.BoardVO;
import com.mycompany.biz.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	

	private final String BOARD_INSERT = "INSERT INTO board (seq, title, writer, content) VALUES ((SELECT seq from(select ifnull(MAX(seq), 0) + 1 AS seq FROM board) tmp), ?, ?, ?)";
	
	private final String BOARD_UPDATE 
		= "update board set title=?,content=? where seq=?";
	private final String BOARD_DELETE 
		= "delete board where seq=?";
	private final String BOARD_GET 
		= "select * from board where seq=?";
	private final String BOARD_LIST 
		= "select * from board order by seq desc";
	
	
	
	// CRUD
	public void insertBoard(BoardVO vo) {

	    try {
	        conn = JDBCUtil.getConnection();
	        stmt = conn.prepareStatement(BOARD_INSERT);

	        stmt.setString(1, vo.getTitle());
	        stmt.setString(2, vo.getWriter());
	        stmt.setString(3, vo.getContent());
	        
	        stmt.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        JDBCUtil.close(stmt, conn);
	    }
		//return result;

	}
	
	
	
	
	public void updateBoard(BoardVO vo) {
		try {
			
			conn = JDBCUtil.getConnection();
			
			stmt = conn.prepareStatement(BOARD_UPDATE);
			
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void deleteBoard(BoardVO vo) {
		
		try {
			conn = JDBCUtil.getConnection();	
			stmt = conn.prepareStatement(BOARD_DELETE);
			
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}
	
	public BoardVO getBoard(BoardVO vo) {
		
		BoardVO vo1 = null;
		
		try {
			
			conn = JDBCUtil.getConnection();			
			stmt = conn.prepareStatement(BOARD_GET);		
			stmt.setInt(1, vo.getSeq());	
			
			stmt.executeUpdate();
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				vo1 = new BoardVO();
				
				vo1.setSeq(rs.getInt("seq"));
				vo1.setTitle(rs.getString("title"));
				vo1.setWriter(rs.getString("writer"));
				vo1.setContent(rs.getString("content"));
				vo1.setRegDate(rs.getDate("regdate"));
				vo1.setCnt(rs.getInt("cnt"));
				
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return vo1;

	}
	
	public List<BoardVO> getBoardList(){
		
		ArrayList<BoardVO> bvo = new ArrayList<BoardVO>();
		
		try {
			
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				BoardVO v = new BoardVO();
				
				v.setSeq(rs.getInt("seq"));
				v.setTitle(rs.getString("title"));
				v.setWriter(rs.getString("writer"));
				v.setContent(rs.getString("content"));
				v.setRegDate(rs.getDate("regdate"));
				v.setCnt(rs.getInt("cnt"));
				
				bvo.add(v);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return bvo;
		
	}
	
}
