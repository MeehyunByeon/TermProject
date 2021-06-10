package cs.term.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.term.service.termService;
import cs.term.vo.Term;

public class EnrollController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mem = (String)request.getSession().getAttribute("sessionId");
		String term = request.getParameter("term");
		String con = request.getParameter("con");
		String cate = request.getParameter("cate");

		Term eterm = new Term();
		eterm.setTermmem(mem);
		eterm.setTerm(term);
		eterm.setTermcon(con);
		eterm.setTermcate(cate);
		
		termService s = termService.getInstance();
		s.enrollTerm(eterm);
		request.setAttribute("result", "용어 등록 성공");
		request.setAttribute("msg", "["+term+"] 등록에 성공했습니다. 내가 직접 등록한 용어들은 MY에서도 볼 수 있습니다.");
		
		HttpUtil.forward(request, response, "/termResult/enrollSuccess.jsp");

	}

}
