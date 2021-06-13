package cs.term.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.term.service.termService;
import cs.term.vo.Request;

public class RequestController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String sessionId = (String)request.getSession().getAttribute("sessionId");
		
		termService s = termService.getInstance();
		ArrayList<Request> allreq = s.allreq();
		request.setAttribute("allreq", allreq);

		if(sessionId==null)
		{
			request.setAttribute("reqresult", "요청 목록이 없습니다.");
			request.setAttribute("reqmsg", "요청 기능을 사용하려면 로그인 또는 회원가입을 해주세요.");
		}
		else{
			ArrayList<Request> myreq = s.myreq(sessionId);
			request.setAttribute("myreq", myreq);
		}

		HttpUtil.forward(request, response, "/request.jsp");
	}

}
