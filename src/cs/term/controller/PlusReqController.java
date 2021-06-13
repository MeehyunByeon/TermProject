package cs.term.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.term.service.termService;
import cs.term.vo.Request;

public class PlusReqController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqmem = (String)request.getSession().getAttribute("sessionId");
		String term = request.getParameter("term");
		String path = null;
		
		if(reqmem == null) 
		{
			path = "/termResult/toStorageFail.jsp";
			request.setAttribute("result", "용어 요청 불가");
			request.setAttribute("msg", "용어 요청은 회원만 가능하오니 로그인 또는 회원가입을 해주세요.");
		}
		else
		{
			termService s = termService.getInstance();
			Request req = new Request();
			req.setReqmem(reqmem);
			req.setReqterm(term);
			
			s.plusreq(req);
			path = "/request.do";
		}
			
		HttpUtil.forward(request, response, path);

	}

}
