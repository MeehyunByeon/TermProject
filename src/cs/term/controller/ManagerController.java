package cs.term.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.term.service.termService;
import cs.term.vo.Member;
import cs.term.vo.Term;

public class ManagerController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		termService s = termService.getInstance();
		ArrayList<Term> allterms = s.termListAll();
		ArrayList<Member> allmems = s.memListAll();
		
		request.setAttribute("allterms", allterms);
		request.setAttribute("allmems", allmems);
		HttpUtil.forward(request, response, "/manager.jsp");
	}

}
