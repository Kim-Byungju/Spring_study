package com.mycompany.biz.user;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.mycompany.biz.board.BoardService;
import com.mycompany.biz.board.BoardVO;


public class UserServiceClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext container 
				= new GenericXmlApplicationContext("applicationContext.xml");
		
		//UserService
		UserService userService = (UserService) container.getBean("userService");
		//BoardSevice
		BoardService boardService =(BoardService) container.getBean("boardService");		
		
		//로그인창 입력
		UserVO vo = new UserVO();
		vo.setId("admin@test.com");             //로그인할 ID
		vo.setPassword("1234");                 //로그인할 PASSWORD
		
		UserVO user = userService.getUser(vo);  
		if(user != null) {
			System.out.println(user.getName() +"님 환영합니다.");
		}else {
			System.out.println("로그인 실패");
		}
		
		

		BoardVO board = new BoardVO();
		board.setTitle("수요일");
		board.setWriter("작자미상");
		board.setContent("내용없음...");
		
		boardService.insertBoard(board);  

		
		ArrayList<BoardVO> list =(ArrayList<BoardVO>)boardService.getBoardList(null);
		for(int i=0;i<list.size();i++) {
			board = (BoardVO)list.get(i);
			System.out.println(board.toString());
		}
		
		
		container.close();
	}
}
