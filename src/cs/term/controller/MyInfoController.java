package cs.term.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs.term.service.termService;
import cs.term.vo.Member;

public class MyInfoController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sessionId = (String)request.getSession().getAttribute("sessionId"); 
		
		Member memInfo = new Member();
		termService s = termService.getInstance();
		memInfo = s.myinfo(sessionId);
		
		request.setAttribute("memInfo", memInfo);
		HttpUtil.forward(request, response, "/myinfo.jsp");
	}

}
