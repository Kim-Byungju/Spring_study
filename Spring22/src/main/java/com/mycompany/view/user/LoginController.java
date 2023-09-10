package com.mycompany.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.mycompany.biz.user.UserVO;
import com.mycompany.biz.user.impl.UserDAO;

@Controller
public class LoginController{
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login(UserVO vo) { //${userVO.id}, userVO.password
		
		vo.setId("test");
		vo.setPassword("1234");
		
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) throws IllegalAccessException {
		
		if(vo.getId()==null || vo.getId()=="") {
			throw new IllegalAccessException("아이디는 반드시입력해야합니다.");
		}
		if(userDAO.getUser(vo) != null) {
			session.setAttribute("username", userDAO.getUser(vo).getName());
			return "redirect:getBoardList.do";
		} else {
			return "login.jsp";
		}
	}
}