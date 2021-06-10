package cs.term.dao;

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
	
	public void reqUpdate()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String rt = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("alter table req auto_increment=1;"
					+ "set @count=0;"
					+ "update req set req.reqid = @count:=@count+1;");
			pstmt = conn.prepareStatement("select reqterm from req;");
			rs = pstmt.executeQuery();
			while (rs.next())
			{
				rt = rs.getString(1);
				pstmt = conn.prepareStatement("select term from term where term=?;");
				pstmt.setString(1, rt);
				rs = pstmt.executeQuery();
				if(rt.equals(rs)) {
					pstmt = conn.prepareStatement("delete from req where reqterm=?;");
					pstmt.setString(1, rt);
				}
				
			}

		}catch (Exception e) 
		{
			System.out.print("Req Update Error"+e);
		}finally {
			close(conn, pstmt, rs);
		}
	}
	
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
	
	public void memberJoin(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into member values(?,?,?,?,?);");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getTel());
			pstmt.setString(5, member.getEmail());
			pstmt.executeUpdate();
		}catch (Exception e) 
		{
			System.out.print("Join Error: "+e);
		}finally {
			close(conn, pstmt);
		}
	}
	
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
	
	public ArrayList<Request> allreq() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Request req = null;
		ArrayList<Request> allreq = new ArrayList<Request>();
		
		try
		{
			conn = connect();
			reqUpdate();
			pstmt = conn.prepareStatement("select * from req;");
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
	
}