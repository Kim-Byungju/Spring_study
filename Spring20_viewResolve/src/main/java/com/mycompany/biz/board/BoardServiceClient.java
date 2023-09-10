package com.mycompany.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.mycompany.biz.board.BoardService;

public class BoardServiceClient  {

	public static void main(String args[]) {
		

		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		

		BoardService boardService =  (BoardService)container.getBean("boardService"); 
		
		BoardVO vo = new BoardVO();
		vo.setTitle("임시제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용.............");
		vo.setCnt(10);
		

		boardService.insertBoard(vo);
		
		

		List<BoardVO>  boardList = boardService.getBoardList(vo);   
		for(BoardVO board : boardList) {
			System.out.println("===> "+board.toString());
		}
		

		container.close();
		
	}
	
}
