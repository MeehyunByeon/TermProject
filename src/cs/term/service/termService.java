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
	
	// 메인화면 용어 리스트
	public ArrayList<Term> mainTermlist() {
		return dao.mainTermlist();
	}
	
	// 로그인
	public boolean memberLogin(String id, String pwd) {
		return dao.memberLogin(id, pwd);
	}
	
	// 회원가입
	public void memberJoin(Member member) {
		dao.memberJoin(member);
	}
	
	// 회원정보 수정
	public void memberUpdate(Member member)
	{
		dao.memberUpdate(member);
	}

	// myinfo.jsp에 회원 정보 셋팅
	public Member myinfo(String sessionId) {
		Member meminfo = dao.meminfo(sessionId);
		return meminfo;
	}

	// 용어 상세보기
	public Term terms(String term) {
		Term terms = dao.terms(term);
		return terms;
	}
	
	// 보관함에 존재하는지 확인
	public boolean ynTerm(Storage yn) {
		return dao.ynTerm(yn);
	}
	
	// 보관함에 저장
	public boolean storeTerm(Storage store){
		boolean r = dao.storeTerm(store);
		return r;
	}
	
	// 모든 용어 리스트
	public ArrayList<Term> termListAll() {
		return dao.termListAll();
	}
	
	// 보관함에 저장 취소
	public void cancleTerm(Storage cancle) {
		dao.cancleTerm(cancle);
	}

	// 회원이 보관함에 저장한 용어 리스트
	public ArrayList<Term> storage(String sessionId) {
		return dao.storage(sessionId);
	}

	// 용어 검색
	public ArrayList<Term> researchTerms(String researchTerm) {
		return dao.researchTerms(researchTerm);
	}

	// 용어 등록
	public void enrollTerm(Term eterm) {
		dao.enrollTerm(eterm);
	}

	// 회원의 용어 정의 요청 리스트
	public ArrayList<Request> myreq(String sessionId) {
		return dao.myreq(sessionId);
	}
	
	// 모든 용어 정의 요청 리스트
	public ArrayList<Request> allreq() {
		return dao.allreq();
	}

	// 회원 요청 리스트에서 요청 용어 삭제
	public void reqDelete(String reqmem, String reqterm) {
		dao.reqDelete(reqmem, reqterm);
	}
	
	// 용어 정의 요청
	public void plusreq(Request req) {
		dao.plusreq(req);
	}

	// 용어 요청 리스트 정리
	public void reqUpdate(String term) {
		dao.reqUpdate(term);
	}
	
	// 회원이 등록한 용어 리스트
	public ArrayList<Term> myenroll(String sessionId) {
		return dao.myenroll(sessionId);
	}

	// 용어 수정
	public void termupdate(Term u) {
		dao.termupdate(u);
	}

	// 아이디 찾기
	public String findId(String fid_tel, String fid_mail) {
		String findId = dao.findId(fid_tel, fid_mail);
		return findId;
	}
	
	// 비밀번호 찾기
	public String findPwd(String fpwd_id, String fpwd_mail) {
		String findPwd = dao.findPwd(fpwd_id, fpwd_mail);
		return findPwd;
	}

	// 조회수 증가
	public void plusHits(String term) {
		dao.plusHits(term);
	}

	// 모든 회원 리스트_꽌리자
	public ArrayList<Member> memListAll() {
		return dao.memListAll();
	}

	// 용어 삭제
	public void termDelete(String term) {
		dao.termDelete(term);
	}

}