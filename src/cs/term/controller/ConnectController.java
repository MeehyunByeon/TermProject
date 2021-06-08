package cs.term.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.term.service.termService;
import cs.term.vo.Storage;
import cs.term.vo.Term;

public class ConnectController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String term = request.getParameter("term");
		String sessionId = (String)request.getSession().getAttribute("sessionId");
		
		termService s = termService.getInstance();
		Term terms = s.terms(term);
		
		Storage yn = new Storage();
		yn.setStmem(sessionId);
		yn.setStterm(term);
		boolean r = s.ynTerm(yn);
		String rr = null;
		if(r == true)
			rr = "존재";
			request.setAttribute("rr", rr);
		
		request.setAttribute("term", term);
		request.setAttribute("terms", terms);
		HttpUtil.forward(request, response, "/detailterm.jsp");
	}

}
