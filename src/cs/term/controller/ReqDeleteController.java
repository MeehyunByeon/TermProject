package cs.term.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.term.service.termService;

public class ReqDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String term = request.getParameter("term");
		String sessionId = (String)request.getSession().getAttribute("sessionId");
		
		termService s = termService.getInstance();
		s.reqDelete(sessionId,term);
		
		HttpUtil.forward(request, response, "/request.do");
	}

}
