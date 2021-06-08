package cs.term.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.term.service.termService;
import cs.term.vo.Term;

public class AlltermController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		termService s = termService.getInstance();
		ArrayList<Term> all = s.termListAll();
		
		request.setAttribute("all", all);
		HttpUtil.forward(request, response, "/termlist.jsp");
	}

}
