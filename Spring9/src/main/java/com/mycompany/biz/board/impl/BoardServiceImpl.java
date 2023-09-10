package com.mycompany.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.biz.board.BoardVO;
import com.mycompany.biz.common.Log4jAdvice;
import com.mycompany.biz.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	
	
	@Override
	public void insertBoard(BoardVO vo) {
		System.out.println(">>>>>>insert");
		boardDAO.insertBoard(vo);
		
	}

	@Override
	public void updatetBoard(BoardVO vo) {
		System.out.println(">>>>>>update");
		boardDAO.updateBoard(vo);
		
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		System.out.println(">>>>>>delete");
		boardDAO.deleteBoard(vo);
		
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		System.out.println(">>>>>>getboard");
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		System.out.println(">>>>>>getList");
		return boardDAO.getBoardList();
	}

}
