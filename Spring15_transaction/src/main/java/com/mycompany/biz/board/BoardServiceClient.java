package com.mycompany.biz.board;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.mycompany.biz.board.impl.BoardService;

public class BoardServiceClient {
    public static void main(String[] args) {
        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
        BoardService boardService = (BoardService)factory.getBean("boardService");

        BoardVO vo = new BoardVO();
		
		vo.setTitle("수요일");
		vo.setWriter("김길동");
		vo.setContent("야호발");
		vo.setCnt(10);
		boardService.insertBoard(vo);

        ArrayList<BoardVO> boardList = (ArrayList<BoardVO>) boardService.getBoardList();

        for (BoardVO board : boardList) {
            System.out.println(board.toString());
        }

        factory.close();
    }
}