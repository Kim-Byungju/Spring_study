package com.mycompany.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mycompany.biz.board.BoardVO;
import com.mycompany.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@RequestMapping(value = "/insertBoard.do")  //value 생략가능
	public String insertBoard( BoardVO vo, BoardDAO boardDAO) {
		boardDAO.insertBoard(vo);
		
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board")BoardVO vo, BoardDAO boardDAO) {
		boardDAO.updateBoard(vo);
		System.out.println("번호 : "+vo.getSeq());
		System.out.println("제목 :"+vo.getTitle());
		System.out.println("작성자 :"+vo.getWriter());
		System.out.println("내용 :"+vo.getContent());
		System.out.println("등록일 :"+vo.getRegDate());
		System.out.println("조회수 :"+vo.getCnt());
		
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo ,BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		
		model.addAttribute("board",boardDAO.getBoard(vo));
		return "getBoard";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList";
	}
}
