package cs.term.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.term.service.termService;
import cs.term.vo.Storage;

public class ConnectController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String term = request.getParameter("term");
		String sessionId = (String)request.getSession().getAttribute("sessionId");
		
		termService s = termService.getInstance();
		String termcon = s.termcon(term);
		
		Storage yn = new Storage();
		yn.setStmem(sessionId);
		yn.setStterm(term);
		boolean r = s.ynterm(yn);
		if(r == true)
			request.setAttribute("yn", r);
		
		request.setAttribute("term", term);
		request.setAttribute("termcon", termcon);
		HttpUtil.forward(request, response, "/detailterm.jsp");
	}

}
