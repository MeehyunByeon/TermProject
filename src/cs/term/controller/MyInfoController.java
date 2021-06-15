package cs.term.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.term.service.termService;
import cs.term.vo.Member;
import cs.term.vo.Term;

public class MyInfoController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sessionId = (String)request.getSession().getAttribute("sessionId"); 
		
		termService s = termService.getInstance();
		
		Member memInfo = new Member();
		memInfo = s.myinfo(sessionId);
		
		ArrayList<Term> myenroll = s.myenroll(sessionId);
		if(myenroll == null)
		{
			request.setAttribute("myenrollresult", "내가 등록한 용어 없음");
			request.setAttribute("myenrollmsg", "용어 또는 요청 페이지에서 용어를 등록할 수 있습니다.");
		}
		
		request.setAttribute("memInfo", memInfo);
		request.setAttribute("myenroll", myenroll);
		HttpUtil.forward(request, response, "/myinfo.jsp");
	}

}
