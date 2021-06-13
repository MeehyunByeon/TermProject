package cs.term.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.term.service.termService;
import cs.term.vo.Member;

public class JoinController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String mailing = request.getParameter("mailing");
		if(mailing.equals("mail_y")) mailing = "Y";
		else if(mailing.equals("mail_n")) mailing = "N";
		
		Member member = new Member();
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setTel(tel);
		member.setEmail(email);
		member.setMailing(mailing);
		
		termService s = termService.getInstance();
		s.memberJoin(member);
		
		request.setAttribute("id", id);
		HttpUtil.forward(request, response, "/termResult/joinsuccess.jsp");

	}

}
