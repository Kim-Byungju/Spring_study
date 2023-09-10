package com.mycompany.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceimpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
		//오류발생 추가
//				if(vo.getSeq()==0) {
//					throw new IllegalArgumentException("0번 글은 동록 할수 없슴돠");
//					}
		boardDAO.insertBoard(vo);
		System.out.println(">>>>>>>> insert");
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList();
	}
}



