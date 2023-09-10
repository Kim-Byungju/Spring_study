package com.mycompany.biz.user;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.mycompany.biz.board.BoardVO;
import com.mycompany.biz.board.impl.BoardService;
import com.mycompany.biz.user.impl.UserService;

public class UserServiceClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)container.getBean("userService");
		
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("1234");
		
		//핵심관심
		UserVO user = (UserVO)userService.getUser(vo);
		
		BoardService boardService = (BoardService)container.getBean("boardService");
		
		if(user != null) {
			System.out.println(user.getName()+"님 환영합니다.");
		} else {
			System.out.println("로그인 실패");
		}
		
		
//		ArrayList<UserVO> userList = (ArrayList<UserVO>) userService.getUserList();
//		
//		for(UserVO users : userList) {
//			System.out.println(users.toString());
//		}
		
		//게시판 글추가
		BoardVO board = new BoardVO();
		board.setSeq(0);
		board.setTitle("월요맇");
		board.setWriter("작자미상");
		board.setContent("냉무");
		
		boardService.insertBoard(board);
		
		ArrayList<BoardVO> boardList = (ArrayList<BoardVO>) boardService.getBoardList();
		
		for(int i=0; i<boardList.size(); i++) {
			board = (BoardVO)boardList.get(i);
			System.out.println(board.toString());
		}
		container.close();
	}
	
}
