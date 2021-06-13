package cs.term.dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cs.term.vo.Member;
import cs.term.vo.Term;
import cs.term.vo.Request;
import cs.term.vo.Storage;

public class termDAO {
	private static termDAO dao = new termDAO();
	private termDAO() {}
	public static termDAO getInstance() {
		return dao;
	}
	
	public Connection connect()
	{
		Connection conn = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "1234");
		}catch(Exception e) {
			System.out.print("MDAO:connect"+e);
		}
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement pstmt)
	{
		if(pstmt != null)
		{
			try {
				conn.close();
			}catch(Exception e) 
			{
				System.out.print("Pstmt close error"+e);
			}
		}
		
		if(conn != null)
		{
			try {
				conn.close();
			}catch(Exception e) 
			{
				System.out.print("Conn close error"+e);
			}
		}
	}
	
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
	{
		if(rs != null)
		{
			try {
				rs.close();
			}catch(Exception e) {
				System.out.print("rs close error"+e);
			}
		}
	}
	
	public void close(Connection conn, PreparedStatement pstmt, Statement stmt)
	{
		if(stmt != null)
		{
			try {
				conn.close();
			}catch(Exception e) {
				System.out.print("stmt close error"+e);
			}
		}
	}
	
	// 메인화면에 보이는 용어 리스트
	public ArrayList<Term> mainTermlist() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Term term = null;
		ArrayList<Term> main = new ArrayList<Term>();
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select term, termcon from term;");
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				term = new Term();
				term.setTerm(rs.getString(1));
				term.setTermcon(rs.getString(2));
				main.add(term);
			}
		}catch (Exception e) 
		{
			System.out.print("main term list Error"+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return main;
	}
	
	// 로그인
	public boolean memberLogin(String id, String pwd) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from member where id=? and pwd=?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				result = true;
			}
			else
				result = false;
			
		}catch (Exception e) 
		{
			System.out.print("Login Error: "+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 회원가입
	public void memberJoin(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into member values(?,?,?,?,?,?);");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getTel());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getMailing());
			pstmt.executeUpdate();
		}catch (Exception e) 
		{
			System.out.print("Join Error: "+e);
		}finally {
			close(conn, pstmt);
		}
	}
	
	// 회원 정보 수정
	public void memberUpdate(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("update member set pwd=?, name=?, tel=?, email=? where id=?;");
			pstmt.setString(5, member.getId());
			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getTel());
			pstmt.setString(4, member.getEmail());
			pstmt.executeUpdate();
		}catch(Exception e)
		{
			System.out.print("Member Update Error"+e);
		}finally {
			close(conn, pstmt);
		}
		
	}
	
	// myinfo.jsp에 회원 정보 셋팅
	public Member meminfo(String sessionId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member meminfo = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from member where id=?;");
			pstmt.setString(1, sessionId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				meminfo = new Member();
				meminfo.setId(rs.getString(1));
				meminfo.setPwd(rs.getString(2));
				meminfo.setName(rs.getString(3));
				meminfo.setTel(rs.getString(4));
				meminfo.setEmail(rs.getString(5));
			}
			
		}catch (Exception e) 
		{
			System.out.print("MyInfo Error: "+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return meminfo;
	}
	
	// 모든 용어 리스트
	public ArrayList<Term> termListAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Term t = null;
		ArrayList<Term> all = new ArrayList<Term>();
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from term;");
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				t = new Term();
				t.setTermmem(rs.getString(1));
				t.setTerm(rs.getString(2));
				t.setTermcon(rs.getString(3));
				t.setTermcate(rs.getString(4));
				t.setTermdate(rs.getString(5));
				t.setTermhits(rs.getInt(6));
				all.add(t);
			}
		}catch (Exception e) 
		{
			System.out.print("Term list All Error"+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return all;
	}
	
	// 용어 상세보기
	public Term terms(String term) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Term terms = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement(" select termcon, termcate from term where term=?;");
			pstmt.setString(1, term);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				terms = new Term();
				terms.setTermcon(rs.getString(1));
				terms.setTermcate(rs.getString(2));
			}
		}catch(Exception e) {
			System.out.print("Detail term Error"+e);
		}finally
		{
			close(conn, pstmt, rs);
		}
		return terms;
	}
	
	// 보관함에 존재하는지 확인
	public boolean ynTerm(Storage yn) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from storage where stmem=? and stterm=?;");
			pstmt.setString(1, yn.getStmem());
			pstmt.setString(2, yn.getStterm());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				result = true;
			}
			
		}catch (Exception e) 
		{
			System.out.print("YN Store Error: "+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return result;
		
	}
	
	// 보관함에 저장
	public boolean storeTerm(Storage store) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try
		{	
			conn = connect();
			pstmt = conn.prepareStatement("insert into storage(stmem, stterm) values(?,?);");
			pstmt.setString(1, store.getStmem());
			pstmt.setString(2, store.getStterm());
			pstmt.executeUpdate();
			result = true;
		}catch (Exception e) 
		{
			System.out.print("Store Term Error: "+e);
		}finally {
			close(conn, pstmt);
		}
		return result;
	}
	
	// 보관함에 저장 취소
	public void cancleTerm(Storage cancle) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("delete from storage where stmem=? and stterm=?;");
			pstmt.setString(1, cancle.getStmem());
			pstmt.setString(2, cancle.getStterm());
			pstmt.executeUpdate();
		}catch (Exception e) 
		{
			System.out.print("Cancle term Error: "+e);
		}finally {
			close(conn, pstmt);
		}
	}
	
	// 회원이 보관함에 저장한 용어 리스트
	public ArrayList<Term> storage(String sessionId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Term t = null;
		ArrayList<Term> myst = new ArrayList<Term>();
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select termmem, term, termcon, termcate, termdate, termhits "
					+ "from term, storage where storage.stmem=? and storage.stterm = term.term;");
			pstmt.setString(1, sessionId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) 
			{
				t = new Term();
				t.setTermmem(rs.getString(1));
				t.setTerm(rs.getString(2));
				t.setTermcon(rs.getString(3));
				t.setTermcate(rs.getString(4));
				t.setTermdate(rs.getString(5));
				t.setTermhits(rs.getInt(6));
				myst.add(t);
			}
			
		}catch (Exception e) 
		{
			System.out.print("Storage Error: "+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return myst;
	}
	
	// 용어 검색
	public ArrayList<Term> researchTerms(String researchTerm){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Term term = null;
		ArrayList<Term> rterms = new ArrayList<Term>();
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from term where term=? or term like '%?%' or term like '?%' or term like '%?';");
			pstmt.setString(1, researchTerm);
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				term = new Term();
				term.setTermmem(rs.getString(1));
				term.setTerm(rs.getString(2));
				term.setTermcon(rs.getString(3));
				term.setTermcate(rs.getString(4));
				term.setTermdate(rs.getString(5));
				term.setTermhits(rs.getInt(6));
				rterms.add(term);
			}
		}catch (Exception e) 
		{
			System.out.print("Search Term Error"+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return rterms;
	}
	
	// 용어 등록
	public void enrollTerm(Term eterm) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into term(termmem, term, termcon, termcate) values(?,?,?,?);");
			pstmt.setString(1, eterm.getTermmem());
			pstmt.setString(2, eterm.getTerm());
			pstmt.setString(3, eterm.getTermcon());
			pstmt.setString(4, eterm.getTermcate());
			pstmt.executeUpdate();
		}catch (Exception e) 
		{
			System.out.print("Enroll Error: "+e);
		}finally {
			close(conn, pstmt);
		}
	}
	
	// 회원의 용어 정의 요청 리스트 
	public ArrayList<Request> myreq(String sessionId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Request req = null;
		ArrayList<Request> myreq = new ArrayList<Request>();
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select reqterm, reqdate from req where reqmem=?;");
			pstmt.setString(1, sessionId);
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				req = new Request();
				req.setReqterm(rs.getString(1));
				req.setReqdate(rs.getString(2));
				myreq.add(req);
			}
		}catch (Exception e) 
		{
			System.out.print("My req Error"+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return myreq;
	}
	
	// 모든 용어 정의 요청 리스트
	public ArrayList<Request> allreq() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Request req = null;
		ArrayList<Request> allreq = new ArrayList<Request>();
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select reqid, reqmem, reqterm, reqdate from req;");
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				req = new Request();
				req.setReqid(rs.getString(1));
				req.setReqmem(rs.getString(2));
				req.setReqterm(rs.getString(3));
				req.setReqdate(rs.getString(4));
				allreq.add(req);
			}
		}catch (Exception e) 
		{
			System.out.print("All req Error"+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return allreq;
	}
	
	// 회원 요청 리스트에서 요청 용어 삭제
	public void reqDelete(String reqmem, String reqterm)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("delete from req where reqmem=? and reqterm=?;");
			pstmt.setString(1, reqmem);
			pstmt.setString(2, reqterm);
			pstmt.executeUpdate();
		}catch (Exception e) 
		{
			System.out.print("Req Delete Error: "+e);
		}finally {
			close(conn, pstmt);
		}	
	}
	
	public void plusreq(Request req) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into req(reqmem, reqterm) values(?,?);");
			pstmt.setString(1, req.getReqmem());
			pstmt.setString(2, req.getReqterm());
			pstmt.executeUpdate();
		}catch (Exception e) 
		{
			System.out.print("Plus Req Error: "+e);
		}finally {
			close(conn, pstmt);
		}
	}
	// 용어 요청 리스트 정리
	public void reqUpdate(String term) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("delete from req where reqterm=?;");
			pstmt.setString(1, term);
			pstmt.executeUpdate();
		}catch (Exception e) 
		{
			System.out.print("Req Update Error: "+e);
		}finally {
			close(conn, pstmt);
		}
		
		Statement stmt = null;
		try
		{
			conn = connect();
			stmt = conn.createStatement();
			stmt.executeUpdate("set @cnt = 0;");
			stmt.executeUpdate("update req set reqid = @cnt:= @cnt + 1;");
			stmt.executeUpdate("alter table req auto_increment=1;");
		}catch (Exception e) 
		{
			System.out.print("Req Sort Error: "+e);
		}finally {
			close(conn, pstmt, stmt);
		}
	}
	
	// 회원이 등록한 용어 리스트
	public ArrayList<Term> myenroll(String sessionId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Term term = null;
		ArrayList<Term> myenroll = new ArrayList<Term>();
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select term, termcate, termdate, termhits, termcon from term where termmem=?;");
			pstmt.setString(1, sessionId);
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				term = new Term();
				term.setTerm(rs.getString(1));
				term.setTermcate(rs.getString(2));
				term.setTermdate(rs.getString(3));
				term.setTermhits(rs.getInt(4));
				term.setTermcon(rs.getString(5));
				myenroll.add(term);
			}
		}catch (Exception e) 
		{
			System.out.print("My Enroll List Error"+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return myenroll;
	}
	
	// 용어 수정
	public void termupdate(Term u) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("update term set termcon=?, termcate=? where term=?;");
			pstmt.setString(1, u.getTermcon());
			pstmt.setString(2, u.getTermcate());
			pstmt.setString(3, u.getTerm());
			pstmt.executeUpdate();
		}catch(Exception e)
		{
			System.out.print("Term Update Error"+e);
		}finally {
			close(conn, pstmt);
		}
	}
	
	//아이디 찾기
	public String findId(String fid_tel, String fid_mail) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String findId = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select id from member where tel=? and email=?");
			pstmt.setString(1, fid_tel);
			pstmt.setString(2, fid_mail);
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				findId = rs.getString(1);
			}
		}catch (Exception e) 
		{
			System.out.print("Find ID Error"+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return findId;
	}
	
	// 비밀번호 찾기
	public String findPwd(String fpwd_id, String fpwd_mail) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String findPwd = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select pwd from member where id=? and email=?");
			pstmt.setString(1, fpwd_id);
			pstmt.setString(2, fpwd_mail);
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				findPwd = rs.getString(1);
			}
		}catch (Exception e) 
		{
			System.out.print("Find Pwd Error"+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return findPwd;
	}
	
	// 조회수 증가
	public void plusHits(String term) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("update term set termhits=termhits+1 where term=?;");
			pstmt.setString(1, term);
			pstmt.executeUpdate();
		}catch(Exception e)
		{
			System.out.print("Plus TermHits Error"+e);
		}finally {
			close(conn, pstmt);
		}
	}
	
	// 모든 회원리스트_관리자
	public ArrayList<Member> memListAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		ArrayList<Member> allmems = new ArrayList<Member>();
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from member;");
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				m = new Member();
				m.setId(rs.getString(1));
				m.setName(rs.getString(3));
				m.setTel(rs.getString(4));
				m.setEmail(rs.getString(5));
				m.setMailing(rs.getString(6));
				allmems.add(m);
			}
		}catch (Exception e) 
		{
			System.out.print("Member list All Error"+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return allmems;
	}
	
	// 용어 삭제_관리자
	public void termDelete(String term) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("delete from term where term=?;");
			pstmt.setString(1, term);
			pstmt.executeUpdate();
		}catch (Exception e) 
		{
			System.out.print("Term Delete Error: "+e);
		}finally {
			close(conn, pstmt);
		}
	}
	
}