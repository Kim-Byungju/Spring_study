package com.mycompany.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.biz.board.BoardService;
import com.mycompany.biz.board.BoardVO;
import com.mycompany.biz.board.impl.BoardDAO;
import com.mycompany.biz.board.impl.BoardServiceImpl;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	//의존객체주입
	@Autowired
	private BoardServiceImpl boardService;
	
	@RequestMapping(value = "/insertBoard.do")  //value 생략가능
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) throws IOException {
		
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) { //업로드한 파일의 존재여부확인
			String fileName = uploadFile.getOriginalFilename(); //업로드한 파일명
			uploadFile.transferTo(new File("C:/Users/admin/Desktop/KBJ/file1/"+fileName));// 업로드한 파일을 저장 , 경로 / 한번 쓰거나, \\두번쓰거나
		}		
		boardService.insertBoard(vo);
		
		return "getBoardList.do";
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
		
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo ,BoardDAO boardDAO) {
		boardService.deleteBoard(vo);
		
		return "getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		
		model.addAttribute("board",boardService.getBoard(vo));
		return "getBoard.jsp";
	}
	
	@ModelAttribute("conditionMap") // RequestMapping보다 우선 실행(탐색)
	public Map<String, String> searchConditionMap(){
		
		Map<String,String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목","TITLE");
		conditionMap.put("내용","CONTENT");
		
		return conditionMap; //뷰페이지 셀렉트 옵션 출력
	}
	
//	@RequestMapping("/getBoardList.do")
//	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
//		
//		//Null체크 - 시작하는 로그인 상태
//		if(vo.getSearchCondition()==null) {
//			vo.setSearchCondition("TITLE");
//		}
//		if(vo.getSearchKeyword()==null) {
//			vo.setSearchKeyword(" ");
//		}
//		System.out.println("검색메뉴 : "+vo.getSearchCondition());
//		System.out.println("검색단어 : "+vo.getSearchKeyword());
//		
//		model.addAttribute("boardList", boardService.getBoardList(vo));
//		
//		return "getBoardList";
//	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(
				@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition, //request.getparameter와 동일 
				@RequestParam(value = "searchKeyword", defaultValue="", required = false) String keyword,
				BoardVO vo, BoardDAO boardDAO, Model model) {
		
		//Null체크 - 시작하는 로그인 상태
		if(vo.getSearchCondition()==null) {
			vo.setSearchCondition("TITLE");
		}
		if(vo.getSearchKeyword()==null) {
			vo.setSearchKeyword("");
		}
		System.out.println("검색메뉴 : "+condition);
		System.out.println("검색단어 : "+keyword);
		
		model.addAttribute("boardList", boardService.getBoardList(vo));
		
		return "getBoardList.jsp";
	}
	
	//부분검색이나 다른필드의 검색 실습
}
