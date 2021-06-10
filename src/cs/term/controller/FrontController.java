package cs.term.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FrontController extends HttpServlet{
	HashMap<String, Controller> map = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, Controller>();
		map.put("/main.do", new MainpageController());
		
		// term
		map.put("/connect.do", new ConnectController());
		map.put("/store.do", new StoreController());
		map.put("/allterm.do", new AlltermController());
		map.put("/storage.do", new StorageController());
		map.put("/request.do", new RequestController());
		map.put("/research.do", new ResearchController());
		map.put("/enroll.do", new EnrollController());
		
		// member
		map.put("/login.do", new LoginController());
		map.put("/join.do", new JoinController());
		map.put("/update.do", new UpdateController());
		map.put("/myinfo.do", new MyInfoController());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = uri.substring(contextPath.length());
		
		Controller cont = map.get(path);
		cont.execute(req, resp);
	}
}
