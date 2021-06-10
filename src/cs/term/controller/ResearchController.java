package cs.term.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.term.service.termService;
import cs.term.vo.Term;

public class ResearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String researchTerm = request.getParameter("research");
		String present = (String)request.getSession().getAttribute("sessionId");
		String enroll = request.getParameter("enroll");
		String term = request.getParameter("term");
		String path = null;
		
		termService s = termService.getInstance();
		ArrayList<Term> research = new ArrayList<Term>();
		
		if(enroll!=null)
		{
			if(present==null) {
				request.setAttribute("result", "용어 등록을 할 수 없음");
				request.setAttribute("msg", "용어 등록은 회원만 가능하오니 로그인 또는 회원가입을 해주세요.");
				path = "/termResult/toStorageFail.jsp";
			}
			else
				if(term != null) request.setAttribute("term", term);
				path = "/enroll.jsp";
		}
		else if(enroll == null && research != null)
		{
			research = s.researchTerms(researchTerm);
			if(research == null) {
				request.setAttribute("result", "검색 결과");
				request.setAttribute("msg", researchTerm+" 과 일치하는 용어가 존재하지 않습니다.");
				path = "/termResult/storeSuccess.jsp";
			}
			else
				path = "/termResult/searchResult.jsp";
		}
		
		request.setAttribute("researchTerms", research);
		HttpUtil.forward(request, response, path);
	}

}
