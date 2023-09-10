package com.mycompany.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mycompany.biz.board.BoardVO;

/*
	JdbcTemplate
		
		- insert
			void update(query, Object...args);
		- update
			void update(query, Object...args);
		- Delete
			void update(query, Object...args);
		
		- 특정 객체검색
			Object queryForObject(query, args, RowMappper<Object> rowMapper);
		- 전체 객체검색
			List query(query, RowMappper<Object> rowMapper);
		- 존재개수검색
			int queryForInt(query, Object...args);
			
	RowMappper<Object> 
		- Object mapRow(Resultset rs, int rowNum) {
			// 객체에다 row수만큼 반복하면서 rs의 값으로 매핑해준다
		 }
*/
@Repository
public class BoardDAOSpring {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	private final String BOARD_INSERT 
//		= "INSERT INTO board (seq, title, writer, content) VALUES ((SELECT seq from(select ifnull(MAX(seq), 0) + 1 AS seq FROM board) tmp), ?, ?, ?)";
	
	private final String BOARD_INSERT 
	= "INSERT INTO board (seq, title, writer, content) VALUES (?, ?, ?, ?)";
	private final String BOARD_UPDATE 
		= "update board set title=?,content=? where seq=?";
	private final String BOARD_DELETE 
		= "delete board where seq=?";
	private final String BOARD_GET 
		= "select * from board where seq=?";
	private final String BOARD_LIST 
		= "select * from board order by seq desc";
	
	// 등록
//	public void insertBoard(BoardVO vo) {
		
//		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent()); // 쿼리의 ?갯수와 맞게 매핑
		
//	}
	public void insertBoard(BoardVO vo) {
		
		jdbcTemplate.update(BOARD_INSERT, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent()); // 쿼리의 ?갯수와 맞게 매핑
		
	}
	//	수정
	public void updateBoard(BoardVO vo) {
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getWriter(), vo.getSeq());
	}
	// 삭제
	public void deleteBoard(BoardVO vo) {
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
	//특정 객체검색
	public BoardVO getBoard(BoardVO vo) {
		
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	//전체조회
	public List<BoardVO> getBoardList(){
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		
	}
}
