package cs.term.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs.term.service.termService;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String path = null;
		boolean result=false;
		
		termService s = termService.getInstance();
		result = s.memberLogin(id, pwd);
		
		if(result)
		{
			HttpSession session = request.getSession();
			session.setAttribute("sessionId", id);
			path = "main.do";
		}
		else if(!result){
			path = "/termResult/loginfail.jsp";
			request.setAttribute("msg", "아이디나 비밀번호가 올바르지 않습니다. 다시 시도해주세요.");
		}

		HttpUtil.forward(request, response, path);
	}

}
