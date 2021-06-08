package cs.term.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.term.service.termService;
import cs.term.vo.Storage;

public class StoreController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choice = request.getParameter("choice");
		String term = request.getParameter("term");
		String sessionId = (String)request.getSession().getAttribute("sessionId");
		String path = null;
		
		if(sessionId != null)
		{
			Storage store = new Storage();
			store.setStmem(sessionId);
			store.setStterm(term);
			termService s = termService.getInstance();
			path = "/termResult/storeSuccess.jsp";
			
			if(choice.equals("cancle")){
				s.cancleTerm(store);
				request.setAttribute("result", "저장 취소");
				request.setAttribute("msg", "용어 [" +term+ "] 저장 취소에 성공했습니다.");
			}

			else {
				boolean r = s.storeTerm(store);
				if(r==true) {
					request.setAttribute("result", "저장 성공");
					request.setAttribute("msg", "용어 저장에 성공했습니다");
				}
				else {
					request.setAttribute("result", "저장 결과");
					request.setAttribute("msg", r);
				}
			}
			
		}
		
		else
		{
			path = "/termResult/storeFail.jsp";
			request.setAttribute("msg1", "용어 저장에 실패했습니다.");
			request.setAttribute("msg2", "회원이 아니면 용어를 저장할 수 없으니 로그인 또는 회원가입을 해주세요.");
		}

		HttpUtil.forward(request, response, path);
	}

}
