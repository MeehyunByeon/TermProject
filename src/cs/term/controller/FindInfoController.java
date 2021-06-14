package cs.term.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.term.service.termService;

public class FindInfoController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String findid = request.getParameter("findid");
		String findpwd = request.getParameter("findpwd");
		String path = null;
		String fid = null;
		String fpwd = null;
		String mem = null;
		boolean find = false;
		
		termService s = termService.getInstance();
		if(findid != null)
		{
			mem = "아이디";
			String fid_tel = request.getParameter("fid_tel");
			String fid_mail = request.getParameter("fid_mail");
			fid = s.findId(fid_tel, fid_mail);
			if(fid != null) find = true;
		}
		else if(findpwd != null)
		{
			mem = "비밀번호";
			String fpwd_id = request.getParameter("fpwd_id");
			String fpwd_mail = request.getParameter("fpwd_mail");
			fpwd = s.findPwd(fpwd_id, fpwd_mail);
			if(fpwd != null) find = true;
			System.out.println(fpwd);
		}
		
		if(find) {
			request.setAttribute("result", mem + " 찾기 성공!");
			if(fid !=null) request.setAttribute("msg", fid);
			else request.setAttribute("msg", fpwd);
		}
		else {
			request.setAttribute("result", mem + " 찾기 실패!");
			request.setAttribute("msg", "입력하신 정보와 일치하는" + mem + "가 없습니다! 다시 시도해주세요.");
		}
		request.setAttribute("find", find);
		HttpUtil.forward(request, response, "/termResult/findInfo.jsp");
	}

}
