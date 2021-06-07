package cs.term.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

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
	
	public Term termSearch(String search) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void memberDelete(String id, String pwd) {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<Term> termListAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}