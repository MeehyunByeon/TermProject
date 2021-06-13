package cs.term.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.term.service.termService;
import cs.term.vo.Term;

public class TermUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String term = request.getParameter("term");
		String con = request.getParameter("con");
		String cate = request.getParameter("cate");
		
		Term u = new Term();
		u.setTerm(term);
		u.setTermcon(con);
		u.setTermcate(cate);
		
		termService s = termService.getInstance();
		s.termupdate(u);
		
		HttpUtil.forward(request, response, "/myinfo.do");
	}

}
