package com.mycompany.biz.board.impl;

import java.util.List;

import com.mycompany.biz.board.BoardVO;


public interface BoardService {
	
	public void insertBoard(BoardVO vo);
	public void updatetBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public BoardVO getBoard(BoardVO vo);
	public List<BoardVO> getBoardList();
}
