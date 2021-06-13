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
	
	public void memberUpdate(Member member)
	{
		dao.memberUpdate(member);
	}

	public Member myinfo(String sessionId) {
		Member meminfo = dao.meminfo(sessionId);
		return meminfo;
	}

	public Term terms(String term) {
		Term terms = dao.terms(term);
		return terms;
	}
	
	public boolean ynTerm(Storage yn) {
		return dao.ynTerm(yn);
	}
	
	public boolean storeTerm(Storage store){
		boolean r = dao.storeTerm(store);
		return r;
	}
	
	public ArrayList<Term> termListAll() {
		return dao.termListAll();
	}
	
	public void cancleTerm(Storage cancle) {
		dao.cancleTerm(cancle);
	}

	public ArrayList<Term> storage(String sessionId) {
		return dao.storage(sessionId);
	}

	public ArrayList<Term> researchTerms(String researchTerm) {
		return dao.researchTerms(researchTerm);
	}

	public void enrollTerm(Term eterm) {
		dao.enrollTerm(eterm);
	}

	public ArrayList<Request> myreq(String sessionId) {
		return dao.myreq(sessionId);
	}

	public ArrayList<Request> allreq() {
		return dao.allreq();
	}

	public void reqDelete(String reqmem, String reqterm) {
		dao.reqDelete(reqmem, reqterm);
	}
	
	public void plusreq(Request req) {
		dao.plusreq(req);
	}

	public void reqUpdate(String term) {
		dao.reqUpdate(term);
	}

	public ArrayList<Term> myenroll(String sessionId) {
		return dao.myenroll(sessionId);
	}

	public void termupdate(Term u) {
		dao.termupdate(u);
	}

	public String findId(String fid_tel, String fid_mail) {
		String findId = dao.findId(fid_tel, fid_mail);
		return findId;
	}
	public String findPwd(String fpwd_id, String fpwd_mail) {
		String findPwd = dao.findId(fpwd_id, fpwd_mail);
		return findPwd;
	}

	public void plusHits(String term) {
		dao.plusHits(term);
	}

	public ArrayList<Member> memListAll() {
		return dao.memListAll();
	}

	public void termDelete(String term) {
		dao.termDelete(term);
	}

}