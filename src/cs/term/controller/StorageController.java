package cs.term.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.term.service.termService;
import cs.term.vo.Term;

public class StorageController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sessionId = (String)request.getSession().getAttribute("sessionId");
		String path = null;
		
		if(sessionId==null)
		{
			path = "/termResult/toStorageFail.jsp";
			request.setAttribute("result", "보관함이 존재하지 않음");
			request.setAttribute("msg", "보관함 이용은 회원만 가능하오니 로그인 또는 회원가입을 해주세요.");
		}
		else{
			termService s = termService.getInstance();
			ArrayList<Term> myst = s.storage(sessionId);
			request.setAttribute("myst", myst);
			path = "/storage.jsp";
		}

		HttpUtil.forward(request, response, path);
	}

}
