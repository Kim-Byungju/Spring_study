package com.mycompany.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.mycompany.biz.user.UserVO;
import com.mycompany.biz.user.impl.UserDAO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserVO vo = new UserVO(); 
		vo.setId(id);
		vo.setPassword(password); 
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		ModelAndView mav = new ModelAndView();
		
		//세션처리		
		if(user != null) {
			mav.setViewName("redirect:getBoardList.do");
		}else {
			//redirect를 붙이면 VireResolver가 설정된다고 해도....
			// 이를 무시하고 redirect 처리된다.
			mav.setViewName("redirect:login.jsp");
		}
		
		return mav;
	}

}















