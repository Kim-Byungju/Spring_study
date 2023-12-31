package com.mycompany.biz.board.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.mycompany.biz.board.BoardVO;


//@Repository
public class BoardDAOSpring { 
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
  
	private final String BOARD_INSERT = "insert into board(seq, title, writer,content) values((select seq from(select ifnull(max(seq),0)+1 as seq from board) tmp),?,?,?)";
	
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";

	public void insertBoard(BoardVO vo) {
		jdbcTemplate.update(BOARD_INSERT,vo.getTitle(), vo.getWriter(), vo.getContent());
	}


	public void updateBoard(BoardVO vo) {
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}


	public void deleteBoard(BoardVO vo) {
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}

	public BoardVO getBoard(BoardVO vo) {
		Object[] args = { vo.getSeq() };
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}


	public List<BoardVO> getBoardList(BoardVO vo) {
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
}
