package cs.term.service;
import java.util.ArrayList;

import cs.term.dao.termDAO;
import cs.term.vo.Member;
import cs.term.vo.Term;
import cs.term.vo.Request;
import cs.term.vo.Storage;

public class termService {
	private static termService service = new termService();
	private termService() {}
	private termDAO dao = termDAO.getInstance();
	
	public static termService getInstance()
	{
		return service;
	}
	
	public ArrayList<Term> mainTermlist() {
		return dao.mainTermlist();
	}

	public boolean memberLogin(String id, String pwd) {
		return dao.memberLogin(id, pwd);
	}

	public void memberJoin(Member member) {
		dao.memberJoin(member);
	}
	
	public Term termSearch(String search){
		Term term = dao.termSearch(search);
		return term;
	}
	
	public void memberUpdate(Member member)
	{
		dao.memberUpdate(member);
	}
	
	public void memberDelete(String id, String pwd)
	{
		dao.memberDelete(id, pwd);
	}
	
	public ArrayList<Term> termListAll() {
		return dao.termListAll();
	}

	public Member myinfo(String sessionId) {
		Member meminfo = dao.meminfo(sessionId);
		return meminfo;
	}
}