package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.BoardDTO;

public class BoardDAO {
    private static BoardDAO instance = new BoardDAO();
    		
    private BoardDAO() {}
    
    public static BoardDAO getInstance() {
    	return instance;
    }
   //Connection을 얻기 위한 클래스 따로 만들고 connection을 얻어와서 처리
    
    public List<BoardDTO> getArticles(int start, int end) 
    		   throws Exception {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs =null;
    	List<BoardDTO> articles =new ArrayList<BoardDTO>();
    	try {
    		//데이터베이스 연결하고
    		conn = DBConnector.getInstance().getConnection();
        	// 데이터베이스에 넘겨주는 rs 받아서 한나씩 읽어서 리스트에 담고 리스트 리턴
    		String sql ="select  num, readcount,step,ref, level, writer,\n";
    	   	       sql+="subject, reg_date, content, ip, passwd, email \n";
    	   	       sql+="from board \n";
    	   	       sql+="where num >=? and num <=? ";
    	   	pstmt = conn.prepareStatement(sql);
    	   	pstmt.setInt(1, start);
    	   	pstmt.setInt(2, end);
    	   	rs = pstmt.executeQuery();
    	   	while(rs.next()) {
    	   		BoardDTO article = new BoardDTO();
    	   		article.setNum(rs.getInt("num"));
    	   		article.setReadcount((rs.getInt("readcount")));
    	   		article.setStep(rs.getInt("step"));
    	   		article.setRef(rs.getInt("ref"));
    	   		article.setLevel(rs.getInt("level"));
    	   		article.setWriter(rs.getString("writer"));
    	   		article.setSubject(rs.getString("subject"));
    	   		article.setReg_date(rs.getString("reg_date"));
    	   		article.setContent(rs.getString("content"));
    	   		article.setIp(rs.getString("ip"));
    	   		article.setPasswd(rs.getString("passwd"));
    	   		article.setEmail(rs.getString("email"));
    	   		articles.add(article);
    	   	}
    	}catch (Exception e) {
    		System.out.println(e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(pstmt !=null) pstmt.close();
			if(conn!=null)conn.close();
		}
		return articles;
	}

	public int getTotCnt() throws Exception{
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs =null;
    	int cnt = 0;
    	try {
    		conn = DBConnector.getInstance().getConnection();
    		String sql ="select count(num) from board";
    		pstmt = conn.prepareStatement(sql);
    		rs = pstmt.executeQuery();
    		if(rs.next()) {
    			cnt = rs.getInt(1);
    		}
    	}catch (Exception e) {
    		System.out.println(e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(pstmt !=null) pstmt.close();
			if(conn!=null)conn.close();
		}
		return cnt;
	}

	public int writeArticle(HttpServletRequest request, 
			 HttpServletResponse response) throws Exception{
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	int r = 0;
    	try {
		//내부 매세드 호출.. num의 번호를 확인하는 것
		int newNm = generateNum();
		BoardDTO article = new BoardDTO();
		article.setNum(newNm);
		article.setSubject(request.getParameter("subject"));
		article.setWriter(request.getParameter("writer"));
		article.setContent(request.getParameter("content"));
		article.setEmail(request.getParameter("email"));
		article.setPasswd(request.getParameter("passwd"));
		article.setIp(request.getLocalAddr());
		
		//만약에 답글인경우, num을 가져오므로 해당되는 num ref의 참조가 되어야 함
		if(request.getParameter("num")!=null) {
			article.setRef(Integer.parseInt(request.getParameter("num")));
		}else {
			article.setRef(newNm);
		}
		
		String sql = "insert into board(num,subject,writer,content,email,passwd,ip,reg_date,ref) "
				+ "values(?,?,?,?,?,?,?,sysdate(),?)";
		conn = DBConnector.getInstance().getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, newNm);
		pstmt.setString(2, article.getSubject());
		pstmt.setString(3, article.getWriter());
		pstmt.setString(4, article.getContent());
		pstmt.setString(5, article.getEmail());
		pstmt.setString(6, article.getPasswd());
		pstmt.setString(7, article.getIp());
		pstmt.setInt(8, newNm);
		 r = pstmt.executeUpdate();
    	}catch (Exception e) {
    		System.out.println(e.getMessage());
		}
		return r;
	}

	private int generateNum() throws Exception {
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs =null;
    	int newNm=0;
    	try {
    		String sql = "select ifnull(max(num),0)+1 as num from board";
    		conn = DBConnector.getInstance().getConnection();
    		pstmt = conn.prepareStatement(sql);
    		rs = pstmt.executeQuery();
    		if(rs.next()) {
    			newNm = rs.getInt("num");
    		}
    	}catch (Exception e) {
		}finally {
			if(rs!=null) rs.close();
			if(pstmt !=null) pstmt.close();
			if(conn!=null)conn.close();
		}
		return newNm;
	}  
 }