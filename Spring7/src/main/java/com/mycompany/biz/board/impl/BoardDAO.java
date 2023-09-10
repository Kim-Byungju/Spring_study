package com.mycompany.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycompany.biz.board.BoardVO;
import com.mycompany.biz.common.JDBCUtill;

@Repository("boardDAO")
public class BoardDAO {
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String BOARD_INSERT
		="insert into board(seq, title, writer, content) values((select seq from(select ifnull(max(seq),0)+1 as seq from board)tmp),?,?,?)";
	private final String BOARD_UPDATE
		="update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE
		="delete board where seq=?";
	private final String BOARD_GET
		="select * from board where seq=?";
	private final String BOARD_LIST
		="select * from board order by seq desc";
	
	//CRUD
	public void insertBoard(BoardVO vo) {
		
		try {
			
			conn =JDBCUtill.getConnection();
			
			stmt = conn.prepareStatement(BOARD_INSERT);
			
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(stmt, conn);
		}
	}
	
	public void updateBoard(BoardVO vo) {
		try {
			
			conn = JDBCUtill.getConnection();
			
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(stmt, conn);
		}
	}
	
	public void deleteBoard(BoardVO vo) {
		try {
			conn = JDBCUtill.getConnection();
			
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(stmt, conn);
		}
	}
	
	public BoardVO getBoard(BoardVO vo) {
		BoardVO v = null;
		
		try {
			conn = JDBCUtill.getConnection();
			
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			
			v.setCnt(rs.getInt("seq"));
			v.setTitle(rs.getString("title"));
			v.setWriter(rs.getString("writer"));
			v.setContent(rs.getString("content"));
			v.setCnt(rs.getInt("cnt"));
			v.setRegDate(rs.getDate("regdate"));
			
			stmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(stmt, conn);
		}
		return v;
	}
	
	public List<BoardVO> getBoardList() {
		
		List<BoardVO> boards = new ArrayList<BoardVO>();
		
		try {
			conn = JDBCUtill.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				
				vo.setCnt(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setCnt(rs.getInt("cnt"));
				vo.setRegDate(rs.getDate("regdate"));
				
				boards.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(rs, stmt, conn);
		}
		return boards;
	}
}
