package model;

import java.sql.*;
import java.util.*;

import model.BoardVO;
import model.ConnUtil;

public class BoardDAO {
 
 private static BoardDAO instance = null;
 
 public BoardDAO() {}
 
 public static BoardDAO getInstance() {
  if(instance == null) {
   synchronized (BoardDAO.class) {
    instance = new BoardDAO();
   }
  }
  return instance;
 }
 // 여기 까지가 디비연결
 
 // 게시판 작업기능은 여기서부터 하나씩  메소드 추가해 나감
 
 // 실제 데이터베이스에 데이터를 넣어줄 메소드 추가
 
	
 public void insertArticle(BoardVO article) {
	  
	  Connection con = null;
	  PreparedStatement pstmt = null;
	  ResultSet rs = null;
	  
	  int num = article.getNum();
	  int ref = article.getRef();
	  int step = article.getStep();
	  int depth = article.getDepth();
	  
	  int number =0;
	  String sql = "";
	  
	  try
	  {
	   con = ConnUtil.getConnection();
	   pstmt = con.prepareStatement(
	     "select max(num) from board");
	   rs = pstmt.executeQuery();
	   
	   if(rs.next())
	    number = rs.getInt(1)+1;
	   else number = 1;
	   
	   if(num != 0) {
	    // 답변글 일 경우 처리
	    sql ="update board set step=step+1 where ref=? and step > ?";
	    
	    pstmt=con.prepareStatement(sql);
	    
	    pstmt.setInt(1, ref);
	    pstmt.setInt(2, step);
	    pstmt.executeUpdate();
	    
	    step = step +1;
	    depth= depth+1;
	    
	   } else {
	    // 새글일 경우
	    ref= number;
	    step =0;
	    depth=0;
	    
	   }
	   //쿼리 작성
	   sql ="insert into board(num, writer, email, "
	     + "subject, pass, regdate, ref, step, "
	     + "depth, content, b_type) "
	     +"values(board_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	   pstmt = con.prepareStatement(sql);
	   
	   pstmt.setString(1, article.getWriter());
	   pstmt.setString(2, article.getEmail());
	   pstmt.setString(3, article.getSubject());
	   pstmt.setString(4, article.getPass());
	   pstmt.setDate(5, article.getRegdate());
	   pstmt.setInt(6, ref);
	   pstmt.setInt(7, step);
	   pstmt.setInt(8, depth);
	   pstmt.setString(9, article.getContent());
	   pstmt.setString(10, article.getB_type());
	   
	   
	   pstmt.executeUpdate();
	  }catch(Exception e) {
	   e.printStackTrace();
	  }finally {
	   if(rs != null) try {rs.close();}catch(SQLException ss) {}
	   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
	   if(con != null) try {con.close();}catch(SQLException ss) {}
	  }
	 }
	
	  //end insertArticle
 	
 
 
 /*
 public void insertBoard(BoardVO article) {
	 Connection con = null; 
	 PreparedStatement pstmt = null; 
	 ResultSet rs = null;
	 
	 int ref=0;
	 int step=1;
	 int depth=1;
	 
	 try {
		 //쿼리 작성
		 String refsql="select max(ref) from board";
		 pstmt = con.prepareStatement(refsql);
		 //쿼리 실행 후 결과를 리턴
		 rs= pstmt.executeQuery();
		 
		 if(rs.next()) {
			 ref = rs.getInt(1)+1;//가장 큰 값에 1을 더해줌
		 }
		 //데이터 삽입하는 쿼리
		String sql ="insert into board(num, writer, email, "
			     + "subject, pass, regdate, ref, step, "
			     + "depth, content, ip) "
			     +"values(board_seq.nextval, ?,?,?,?,?,?,?,?,?,?)";
		 
		 pstmt = con.prepareStatement(sql);
		   
		   pstmt.setString(1, article.getWriter());
		   pstmt.setString(2, article.getEmail());
		   pstmt.setString(3, article.getSubject());
		   pstmt.setString(4, article.getPass());
		   pstmt.setTimestamp(5, article.getRegdate());
		   pstmt.setInt(6, ref);
		   pstmt.setInt(7, step);
		   pstmt.setInt(8, depth);
		   pstmt.setString(9, article.getContent());
		   pstmt.setString(10, article.getIp());
		   
		   pstmt.executeUpdate();
		   
		 
	 }catch (Exception e) {
		 e.printStackTrace();
	}finally {
		   if(rs != null) try {rs.close();}catch(SQLException ss) {}
		   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
		   if(con != null) try {con.close();}catch(SQLException ss) {}
 }}
 */
 
 // writePro.jsp 페이지에서 작성글의 디비에 추가하고 list.jsp로 리다이렉트했고
 // 수행결과를 보여주려면 list.jsp 페이지를 작성해야함 리스트를 가져올 메소드작성
 
 // 첫번째 전체 글의 개수를 가져올 메소드를 추가하여 작성
  
public int getArticleCount() {
  
  Connection con = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  
  int x = 0; // 글의 개수
  
  try {
   
   con = ConnUtil.getConnection();
        
   pstmt =con.prepareStatement("select count(*) from board");
     
        rs = pstmt.executeQuery();
   
   if(rs.next()) {
    x = rs.getInt(1);
   }
   
   
  }catch(Exception e) {
   e.printStackTrace();
  }finally {
   if(rs != null) try {rs.close();}catch(SQLException ss) {}
   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
   if(con != null) try {con.close();}catch(SQLException ss) {}
  
  }
  return x;
 }
 
 /*   검색한 내용이 몇개인지 반환
  *   what : 검색 조건, content : 검색 내용     
  * 
  */
 
 public int getArticleCount(String find, String find_box) {
  
  Connection con = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  
  int x = 0; // 글의 개수
  
  try {
   
   con = ConnUtil.getConnection();
   
   if(find.equals("writer")) {
   
   pstmt =con.prepareStatement("select count(*) from board where writer=?");
   pstmt.setString(1, find_box);
   
   } else if (find.equals("subject")) {
      
   pstmt =con.prepareStatement("select count(*) from board where subject like '%"+find_box+"%' ");
   }  else if (find.equals("content")) {
	      
   pstmt =con.prepareStatement("select count(*) from board where content like '%"+find_box+"%' ");
   }else {
	   pstmt =con.prepareStatement("select count(*) from board ");
   }
   
   rs = pstmt.executeQuery();
   
   if(rs.next()) {
    x = rs.getInt(1);
   }
   
   
  }catch(Exception e) {
   e.printStackTrace();
  }finally {
   if(rs != null) try {rs.close();}catch(SQLException ss) {}
   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
   if(con != null) try {con.close();}catch(SQLException ss) {}
  
  }
  return x;
 }
 
 // board  테이블에서 가져올 메소드를 추가
 // List를 이용함
 
 // 페이징 기법 : 한 화면에 보여질 게시물을 정하고 그것을 일정 블럭으로
 //                  묶어서 처리해주는 기법
 
 public List<BoardVO> getArticles(String find, String find_box, int start, int end) {/*<수정 1>*/
  
  Connection con = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  
  List<BoardVO> articleList = null;
  
  try {
   con = ConnUtil.getConnection();
   
   StringBuffer sql = new StringBuffer();
   sql.append("select * from");
   sql.append("(select rownum rnum, num,"
   		+ " writer, email, subject , pass, "
   		+ "regdate, readcount, ref, step, depth, "
   		+ "content, b_type from ");
   
   if(find.equals("writer")) {
	 sql.append("(select * from board where writer=? order by ref desc, step asc))"
	 		+ " where rnum >=? and rnum <=?");
	 pstmt = con.prepareStatement(sql.toString()); 
	   pstmt.setString(1, find_box);
	   pstmt.setInt(2, start);
	   pstmt.setInt(3, end);
   
   }else if(find.equals("subject")) {
	   sql.append("(select * from board where subject like '%"+find_box+"%' "
	   		+ "order by ref desc, step asc)) where rnum >=? and rnum <=?"); 
	   
	   pstmt = con.prepareStatement(sql.toString()) ; 
	   pstmt.setInt(1, start);
	   pstmt.setInt(2, end);
	   
   }else if(find.equals("content")) {
	   sql.append("(select * from board where  content like '%"+find_box+"%' "
	   		+ "order by ref desc, step asc)) where rnum >=? and rnum <=?");
	   pstmt = con.prepareStatement(sql.toString()) ; 
	   pstmt.setInt(1, start);
	   pstmt.setInt(2, end);
   }else {
	   sql.append("(select * from board order by ref desc, step asc)) "
	   		+ "where rnum >=? and rnum <=?");
	   pstmt = con.prepareStatement(sql.toString()) ; 
	   pstmt.setInt(1, start);
	   pstmt.setInt(2, end);
   }
   
   rs = pstmt.executeQuery();
   
   if(rs.next()) {
    /*수정<4>*/
    articleList = new ArrayList<BoardVO>(end-start+1);
    
    do
    {
     BoardVO article = new BoardVO();
     article.setNum(rs.getInt("num"));
     article.setWriter(rs.getString("writer"));
     article.setEmail(rs.getString("email"));
     article.setSubject(rs.getString("subject"));
     article.setPass(rs.getString("pass"));
     article.setRegdate(rs.getDate("regdate"));
     article.setReadcount(rs.getInt("readcount"));
     article.setRef(rs.getInt("ref"));
     article.setStep(rs.getInt("step"));
     article.setDepth(rs.getInt("depth"));
     article.setContent(rs.getString("content"));
     article.setB_type(rs.getString("b_type"));
     articleList.add(article);
     
    }while(rs.next());
   }
  }catch(Exception e) {
   e.printStackTrace();
  }finally {
   if(rs != null) try {rs.close();}catch(SQLException ss) {}
   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
   if(con != null) try {con.close();}catch(SQLException ss) {}
  
  }
  
  return articleList;
  
 } // end getArticles()
 
 
 // 메소드 추가
 public List<BoardVO> getArticles(int start, int end) {/*<수정 1>*/
  
  Connection con = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  
  List<BoardVO> articleList = null;
  
  try {
   con = ConnUtil.getConnection();
   /*수정<2>*/
   
			/*
			 * String sql
			 * ="select num, writer, email, subject, pass, readcount, ref, step, depth, TO_CHAR(regdate, 'YY/MM/DD HH:MI:SS') regdate, content, b_type"
			 * +
			 * " from (select rownum rnum, num, writer, email, subject, pass, readcount, ref, step, depth, regdate, content, b_type"
			 * +
			 * " from (select num, writer, email, subject, pass, readcount, ref, step, depth, regdate, content, b_type"
			 * + " from board order by ref desc, step asc)) where rnum >= ? and rnum <= ?";
			 */
   
			
			 String sql ="select * from ( select rownum rnum, num, writer, " +
			 "email, subject , pass, regdate, readcount, ref, step, depth, " +
			 "content, b_type from (select * from board " + "order by ref desc, " +
			 "step asc)) where rnum >= ? and rnum <=?";
			 
   
   pstmt = con.prepareStatement(sql);
   

   /*수정<3>*/
   // 기존 내용에 추가
   pstmt.setInt(1, start);
   pstmt.setInt(2, end);
     
   
   rs = pstmt.executeQuery();
   
   if(rs.next()) {
    /*수정<4>*/
    articleList = new ArrayList<BoardVO>(5);
    
    do
    {
     BoardVO article = new BoardVO();
     article.setNum(rs.getInt("num"));
     article.setWriter(rs.getString("writer"));
     article.setEmail(rs.getString("email"));
     article.setSubject(rs.getString("subject"));
     article.setPass(rs.getString("pass"));
     article.setRegdate(rs.getDate("regdate"));
     article.setReadcount(rs.getInt("readcount"));
     article.setRef(rs.getInt("ref"));
     article.setStep(rs.getInt("step"));
     article.setDepth(rs.getInt("depth"));
     article.setContent(rs.getString("content"));
     article.setB_type(rs.getString("b_type"));
     articleList.add(article);
     
    }while(rs.next());
   }
  }catch(Exception e) {
   e.printStackTrace();
  }finally {
   if(rs != null) try {rs.close();}catch(SQLException ss) {}
   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
   if(con != null) try {con.close();}catch(SQLException ss) {}
  
  }
  
  return articleList;
  
 } // end getArticles()
 
 
 
 
 
 
 // 게시글의 num을 매개변수로 해서 하나의 글에 대한 세부 정보를 
 // 데이터 베이스에서 가져와야함
 
 // 데이터베이스에서 글 하나의 정보를 가져오는 메소드를 구현
 public BoardVO getArticle(int num) {
  
  Connection con = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  
  BoardVO article = null;
  
  try {
   
   con = ConnUtil.getConnection();
   pstmt = con.prepareStatement(
     "update board set readcount=readcount+1 where num=?");
   //  조회수 증가
   
   pstmt.setInt(1, num);
   pstmt.executeUpdate();
   
   pstmt = con.prepareStatement(
     "select * from board where num=?");
   // 게시글의 정보
      
   pstmt.setInt(1, num);
   rs = pstmt.executeQuery();
   
   if(rs.next()) {
    
    article= new BoardVO();
    article.setNum(rs.getInt("num"));
    article.setWriter(rs.getString("writer"));
    article.setEmail(rs.getString("email"));
    article.setSubject(rs.getString("subject"));
    article.setPass(rs.getString("pass"));
    article.setRegdate(rs.getDate("regdate"));
    article.setReadcount(rs.getInt("readcount"));
    article.setRef(rs.getInt("ref"));
    article.setStep(rs.getInt("step"));
    article.setDepth(rs.getInt("depth"));
    article.setContent(rs.getString("content"));
    article.setB_type(rs.getString("b_type"));
    
   }
  
  }catch(Exception e) {
   e.printStackTrace();
  }finally {
   if(rs != null) try {rs.close();}catch(SQLException ss) {}
   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
   if(con != null) try {con.close();}catch(SQLException ss) {}
  
  }
  
  return article;  

 }// end getArticle()
 
  //글 수정시에는 글 목록 보기와 다르게 조회수를 증가 시킬 필요가 없음
 // 따라서 조회수를 증가시키는 부분을 제외하고 단순히 num에 해당하는
  // 글을 가져오는 메소드를 구현해야함
 

 public BoardVO updateGetArticle(int num) {
  
  
  Connection con = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  BoardVO article = null;
  
  try
  {
   
   con = ConnUtil.getConnection();
   pstmt = con.prepareStatement(
     "select * from board where num=?");
   
   pstmt.setInt(1, num);
   rs = pstmt.executeQuery();
   
   if(rs.next()) {
    
    article= new BoardVO();
    article.setNum(rs.getInt("num"));
    article.setWriter(rs.getString("writer"));
    article.setEmail(rs.getString("email"));
    article.setSubject(rs.getString("subject"));
    article.setPass(rs.getString("pass"));
    article.setRegdate(rs.getDate("regdate"));
    article.setReadcount(rs.getInt("readcount"));
    article.setRef(rs.getInt("ref"));
    article.setStep(rs.getInt("step"));
    article.setDepth(rs.getInt("depth"));
    article.setContent(rs.getString("content"));
    article.setB_type(rs.getString("b_type"));
   
   }
  }catch(Exception e) {
   e.printStackTrace();
  }finally {
   if(rs != null) try {rs.close();}catch(SQLException ss) {}
   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
   if(con != null) try {con.close();}catch(SQLException ss) {}
  
  }
  return article;  
 }// end updateGetArticle
 
 // 글 수정 버튼을 클릭할 경우 
 // 실제 데이터 베이스에 있는 글이 수정이 이루어져야함
 
 public int updateArticle(BoardVO article) {
  
  Connection con = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  
  String dbpasswd="";
  String sql ="";
  
  int result = -1;  // 수정 작업전
  // result 값이 1이면 수정 성공, 0이면 수정 실패
  
  try {
   con = ConnUtil.getConnection();
   pstmt =con.prepareStatement(
     "select pass from board where num=?");
   // 글쓰기할 때의 비밀번호를 검색해옴
   pstmt.setInt(1, article.getNum());
   rs = pstmt.executeQuery();
   
   if(rs.next()) {
    // 데이터베이스에 저장했을 때의 비밀번호를 가져와서 맞는지를 비교함
     dbpasswd = rs.getString("pass");
     
     if(dbpasswd.equals(article.getPass())) {
      // 비밀번호가 일치 했을 경우
      // 실제 데이터베이스에 수정 작업이 이루어짐
      sql = "update board set writer=?, email=?, subject=?, "
        +" content=? where num=?";
      
      pstmt = con.prepareStatement(sql);
      
      pstmt.setString(1, article.getWriter());
      pstmt.setString(2, article.getEmail());
      pstmt.setString(3, article.getSubject());
      pstmt.setString(4, article.getContent());
      pstmt.setInt(5, article.getNum());
      
      pstmt.executeUpdate();
      
      result =1;
      // 수정 작업 성공
     }
     else 
     {
      result = 0;
      //수정 작업 실패
     }
   }
 
  }catch(Exception e) {
   e.printStackTrace();
  }finally {
   if(rs != null) try {rs.close();}catch(SQLException ss) {}
   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
   if(con != null) try {con.close();}catch(SQLException ss) {}
  
  }
     return result;

 }
 
 // 삭제처리를 하기 위해서는  비밀번호를 입력받아서 데이터베이스의 
 // 비밀번호와 비교하여 일치하면 삭제 그렇치 않으면 
 // 틀렸다고 알려주면 됨
 
 // 데이터베이스 비밀번호를 비교하여 실제 디비에서 삭제 처리 할 수
 // 있는 메소드를 구현
 
 public int deleteArticle(int num, String pass) {
  
  Connection con = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  
  String dbpasswd="";
  
  int result = -1;
  
  try
  {
   con = ConnUtil.getConnection();
   pstmt = con.prepareStatement(
     "select pass from board where num =?");
   
   pstmt.setInt(1, num);
   
   rs = pstmt.executeQuery();
   
   if(rs.next()) {
    // 입력받은 비밀번호와 실제 데이터베이스에 저장된 비밀번호 비교
    dbpasswd = rs.getString("pass");
    
    if(dbpasswd.equals(pass)) {
     // 비밀번호가 일치하면 삭제처리 
     pstmt = con.prepareStatement(
     "delete from board where num =?");
     
     pstmt.setInt(1, num);
     pstmt.executeUpdate();
     
     // 삭제 성공
     result =1;
    }else {
     result = 0;
     // 비밀번호 틀림
    }
   }
  }catch(Exception e) {
   e.printStackTrace();
  }finally {
   if(rs != null) try {rs.close();}catch(SQLException ss) {}
   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
   if(con != null) try {con.close();}catch(SQLException ss) {}
  
  }
     return result;
 
 }
 
//------------------------------------------------Tip------------------------------------------------
 public int getTipArticleCount(String find, String find_box) {
	  
	  Connection con = null;
	  PreparedStatement pstmt = null;
	  ResultSet rs = null;
	  
	  int x = 0; // 글의 개수
	  
	  try {
	   
	   con = ConnUtil.getConnection();
	   
	   if(find.equals("writer")) {
	   
	   pstmt =con.prepareStatement("select count(*) from board where writer=? and b_type='tip'");
	   pstmt.setString(1, find_box);
	   
	   } else if (find.equals("subject")) {
	      
	   pstmt =con.prepareStatement("select count(*) from board where subject like '%"+find_box+"%' and b_type='tip'");
	   }  else if (find.equals("content")) {
		      
	   pstmt =con.prepareStatement("select count(*) from board where content like '%"+find_box+"%' and b_type='tip'");
	   }else {
		   pstmt =con.prepareStatement("select count(*) from board where b_type='tip' ");
	   }
	   
	   rs = pstmt.executeQuery();
	   
	   if(rs.next()) {
	    x = rs.getInt(1);
	   }
	   
	   
	  }catch(Exception e) {
	   e.printStackTrace();
	  }finally {
	   if(rs != null) try {rs.close();}catch(SQLException ss) {}
	   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
	   if(con != null) try {con.close();}catch(SQLException ss) {}
	  
	  }
	  return x;
	 }
	 
 
 public List<BoardVO> getTipArticles(String find, String find_box, int start, int end) {/*<수정 1>*/
	  
	  Connection con = null;
	  PreparedStatement pstmt = null;
	  ResultSet rs = null;
	  
	  List<BoardVO> articleList = null;
	  
	  try {
	   con = ConnUtil.getConnection();
	     
	   StringBuffer sql = new StringBuffer();
	   sql.append("select * from ");
	   sql.append("(select rownum rnum, num, writer, email, subject , pass, regdate, readcount, ref, step, depth, content, b_type from ");
	   
	   if(find.equals("writer")) {
		 sql.append("(select * from board where  writer=? order by ref desc, step asc)) where rnum >=? and rnum <=? and b_type='tip'");
		 pstmt = con.prepareStatement(sql.toString()) ; 
		   pstmt.setString(1, find_box);
		   pstmt.setInt(2, start);
		   pstmt.setInt(3, end);
	   
	   }else if(find.equals("subject")) {
		   sql.append("(select * from board where  subject like '%"+find_box+"%' order by ref desc, step asc)) where rnum >=? and rnum <=? and b_type='tip'"); 
		   
		   pstmt = con.prepareStatement(sql.toString()) ; 
		   pstmt.setInt(1, start);
		   pstmt.setInt(2, end);
		   
	   }else if(find.equals("content")) {
		   sql.append("(select * from board where  content like '%"+find_box+"%' order by ref desc, step asc)) where rnum >=? and rnum <=? and b_type='tip'");
		   pstmt = con.prepareStatement(sql.toString()) ; 
		   pstmt.setInt(1, start);
		   pstmt.setInt(2, end);
	   }else {
		   sql.append("(select * from board order by ref desc, step asc)) where rnum >=? and rnum <=? and b_type='tip'");
		   pstmt = con.prepareStatement(sql.toString()) ; 
		   pstmt.setInt(1, start);
		   pstmt.setInt(2, end);
	   }
	   
	   rs = pstmt.executeQuery();
	   
	   if(rs.next()) {
	    /*수정<4>*/
	    articleList = new ArrayList<BoardVO>(end-start+1);
	    
	    do
	    {
	     BoardVO article = new BoardVO();
	     article.setNum(rs.getInt("num"));
	     article.setWriter(rs.getString("writer"));
	     article.setEmail(rs.getString("email"));
	     article.setSubject(rs.getString("subject"));
	     article.setPass(rs.getString("pass"));
	     article.setRegdate(rs.getDate("regdate"));
	     article.setReadcount(rs.getInt("readcount"));
	     article.setRef(rs.getInt("ref"));
	     article.setStep(rs.getInt("step"));
	     article.setDepth(rs.getInt("depth"));
	     article.setContent(rs.getString("content"));
	     article.setB_type(rs.getString("b_type"));
	     articleList.add(article);
	     
	    }while(rs.next());
	   }
	  }catch(Exception e) {
	   e.printStackTrace();
	  }finally {
	   if(rs != null) try {rs.close();}catch(SQLException ss) {}
	   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
	   if(con != null) try {con.close();}catch(SQLException ss) {}
	  
	  }
	  
	  return articleList;
	  
	 } // end getArticles()
 //------------------------------------------------Tip end------------------------------------
 
 
//------------------------------------------------YouTube------------------------------------------------
public int getYTArticleCount(String find, String find_box) {
	  
	  Connection con = null;
	  PreparedStatement pstmt = null;
	  ResultSet rs = null;
	  
	  int x = 0; // 글의 개수
	  
	  try {
	   
	   con = ConnUtil.getConnection();
	   
	   if(find.equals("writer")) {
	   
	   pstmt =con.prepareStatement("select count(*) from board where writer=? and b_type='youtube'");
	   pstmt.setString(1, find_box);
	   
	   } else if (find.equals("subject")) {
	      
	   pstmt =con.prepareStatement("select count(*) from board where subject like '%"+find_box+"%' and b_type='youtube'");
	   }  else if (find.equals("content")) {
		      
	   pstmt =con.prepareStatement("select count(*) from board where content like '%"+find_box+"%' and b_type='youtube'");
	   }else {
		   pstmt =con.prepareStatement("select count(*) from board where b_type='youtube' ");
	   }
	   
	   rs = pstmt.executeQuery();
	   
	   if(rs.next()) {
	    x = rs.getInt(1);
	   }
	   
	   
	  }catch(Exception e) {
	   e.printStackTrace();
	  }finally {
	   if(rs != null) try {rs.close();}catch(SQLException ss) {}
	   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
	   if(con != null) try {con.close();}catch(SQLException ss) {}
	  
	  }
	  return x;
	 }
	 

public List<BoardVO> getYTArticles(String find, String find_box, int start, int end) {/*<수정 1>*/
	  
	  Connection con = null;
	  PreparedStatement pstmt = null;
	  ResultSet rs = null;
	  
	  List<BoardVO> articleList = null;
	  
	  try {
	   con = ConnUtil.getConnection();
	     
	   StringBuffer sql = new StringBuffer();
	   sql.append("select * from ");
	   sql.append("(select rownum rnum, num, writer, email, subject , pass, regdate, readcount, ref, step, depth, content, b_type from ");
	   
	   if(find.equals("writer")) {
		 sql.append("(select * from board where  writer=? order by ref desc, step asc)) where rnum >=? and rnum <=? and b_type='youtube'");
		 pstmt = con.prepareStatement(sql.toString()) ; 
		   pstmt.setString(1, find_box);
		   pstmt.setInt(2, start);
		   pstmt.setInt(3, end);
	   
	   }else if(find.equals("subject")) {
		   sql.append("(select * from board where  subject like '%"+find_box+"%' order by ref desc, step asc)) where rnum >=? and rnum <=? and b_type='youtube'"); 
		   
		   pstmt = con.prepareStatement(sql.toString()) ; 
		   pstmt.setInt(1, start);
		   pstmt.setInt(2, end);
		   
	   }else if(find.equals("content")) {
		   sql.append("(select * from board where  content like '%"+find_box+"%' order by ref desc, step asc)) where rnum >=? and rnum <=? and b_type='youtube'");
		   pstmt = con.prepareStatement(sql.toString()) ; 
		   pstmt.setInt(1, start);
		   pstmt.setInt(2, end);
	   }else {
		   sql.append("(select * from board order by ref desc, step asc)) where rnum >=? and rnum <=? and b_type='youtube'");
		   pstmt = con.prepareStatement(sql.toString()) ; 
		   pstmt.setInt(1, start);
		   pstmt.setInt(2, end);
	   }
	   
	   rs = pstmt.executeQuery();
	   
	   if(rs.next()) {
	    /*수정<4>*/
	    articleList = new ArrayList<BoardVO>(end-start+1);
	    
	    do
	    {
	     BoardVO article = new BoardVO();
	     article.setNum(rs.getInt("num"));
	     article.setWriter(rs.getString("writer"));
	     article.setEmail(rs.getString("email"));
	     article.setSubject(rs.getString("subject"));
	     article.setPass(rs.getString("pass"));
	     article.setRegdate(rs.getDate("regdate"));
	     article.setReadcount(rs.getInt("readcount"));
	     article.setRef(rs.getInt("ref"));
	     article.setStep(rs.getInt("step"));
	     article.setDepth(rs.getInt("depth"));
	     article.setContent(rs.getString("content"));
	     article.setB_type(rs.getString("b_type"));
	     articleList.add(article);
	     
	    }while(rs.next());
	   }
	  }catch(Exception e) {
	   e.printStackTrace();
	  }finally {
	   if(rs != null) try {rs.close();}catch(SQLException ss) {}
	   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
	   if(con != null) try {con.close();}catch(SQLException ss) {}
	  
	  }
	  
	  return articleList;
	  
	 } // end getArticles()
//------------------------------------------------YouTube end------------------------------------


//------------------------------------------------자유게시판------------------------------------------------
public int getFreeArticleCount(String find, String find_box) {
	  
	  Connection con = null;
	  PreparedStatement pstmt = null;
	  ResultSet rs = null;
	  
	  int x = 0; // 글의 개수
	  
	  try {
	   
	   con = ConnUtil.getConnection();
	   
	   if(find.equals("writer")) {
	   
	   pstmt =con.prepareStatement("select count(*) from board where writer=? and b_type='free'");
	   pstmt.setString(1, find_box);
	   
	   } else if (find.equals("subject")) {
	      
	   pstmt =con.prepareStatement("select count(*) from board where subject like '%"+find_box+"%' and b_type='free'");
	   }  else if (find.equals("content")) {
		      
	   pstmt =con.prepareStatement("select count(*) from board where content like '%"+find_box+"%' and b_type='free'");
	   }else {
		   pstmt =con.prepareStatement("select count(*) from board where b_type='free' ");
	   }
	   
	   rs = pstmt.executeQuery();
	   
	   if(rs.next()) {
	    x = rs.getInt(1);
	   }
	   
	   
	  }catch(Exception e) {
	   e.printStackTrace();
	  }finally {
	   if(rs != null) try {rs.close();}catch(SQLException ss) {}
	   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
	   if(con != null) try {con.close();}catch(SQLException ss) {}
	  
	  }
	  return x;
	 }
	 

public List<BoardVO> getFreeArticles(String find, String find_box, int start, int end) {/*<수정 1>*/
	  
	  Connection con = null;
	  PreparedStatement pstmt = null;
	  ResultSet rs = null;
	  
	  List<BoardVO> articleList = null;
	  
	  try {
	   con = ConnUtil.getConnection();
	     
	   StringBuffer sql = new StringBuffer();
	   sql.append("select * from ");
	   sql.append("(select rownum rnum, num, writer, email, subject , pass, regdate, readcount, ref, step, depth, content, b_type from ");
	   
	   if(find.equals("writer")) {
		 sql.append("(select * from board where  writer=? order by ref desc, step asc)) where rnum >=? and rnum <=? and b_type='free'");
		 pstmt = con.prepareStatement(sql.toString()) ; 
		   pstmt.setString(1, find_box);
		   pstmt.setInt(2, start);
		   pstmt.setInt(3, end);
	   
	   }else if(find.equals("subject")) {
		   sql.append("(select * from board where  subject like '%"+find_box+"%' order by ref desc, step asc)) where rnum >=? and rnum <=? and b_type='free'"); 
		   
		   pstmt = con.prepareStatement(sql.toString()) ; 
		   pstmt.setInt(1, start);
		   pstmt.setInt(2, end);
		   
	   }else if(find.equals("content")) {
		   sql.append("(select * from board where  content like '%"+find_box+"%' order by ref desc, step asc)) where rnum >=? and rnum <=? and b_type='free'");
		   pstmt = con.prepareStatement(sql.toString()) ; 
		   pstmt.setInt(1, start);
		   pstmt.setInt(2, end);
	   }else {
		   sql.append("(select * from board order by ref desc, step asc)) where rnum >=? and rnum <=? and b_type='free'");
		   pstmt = con.prepareStatement(sql.toString()) ; 
		   pstmt.setInt(1, start);
		   pstmt.setInt(2, end);
	   }
	   
	   rs = pstmt.executeQuery();
	   
	   if(rs.next()) {
	    /*수정<4>*/
	    articleList = new ArrayList<BoardVO>(end-start+1);
	    
	    do
	    {
	     BoardVO article = new BoardVO();
	     article.setNum(rs.getInt("num"));
	     article.setWriter(rs.getString("writer"));
	     article.setEmail(rs.getString("email"));
	     article.setSubject(rs.getString("subject"));
	     article.setPass(rs.getString("pass"));
	     article.setRegdate(rs.getDate("regdate"));
	     article.setReadcount(rs.getInt("readcount"));
	     article.setRef(rs.getInt("ref"));
	     article.setStep(rs.getInt("step"));
	     article.setDepth(rs.getInt("depth"));
	     article.setContent(rs.getString("content"));
	     article.setB_type(rs.getString("b_type"));
	     articleList.add(article);
	     
	    }while(rs.next());
	   }
	  }catch(Exception e) {
	   e.printStackTrace();
	  }finally {
	   if(rs != null) try {rs.close();}catch(SQLException ss) {}
	   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
	   if(con != null) try {con.close();}catch(SQLException ss) {}
	  
	  }
	  
	  return articleList;
	  
	 } // end getArticles()
//------------------------------------------------자유게시판 end------------------------------------

public int likeArticle(int num, String id) {
	
	Connection con = null;
	  PreparedStatement pstmt = null;
	 ResultSet rs = null;
	
	 
	 String sql = "insert into goodtable values(?, ?)";

	 try {

			  con = ConnUtil.getConnection();
			  pstmt = con.prepareStatement(sql);
			  pstmt.setInt(1, num);
			  pstmt.setString(2, id);
			  return pstmt.executeUpdate(); //성공 했을 때 1이 반환
	}catch (Exception e) {
		  e.printStackTrace();	
}	finally {
	   if(rs != null) try {rs.close();}catch(SQLException ss) {}
	   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
	   if(con != null) try {con.close();}catch(SQLException ss) {}
	
}
	 return -1; // 데이터베이스 오류 
}

public boolean GoodCheck(int num, String id) {
	Connection con = null;
	  PreparedStatement pstmt = null;
	 ResultSet rs = null;
	 
	 boolean check = false;
	 
	 String sql = "select * from goodtable where Gnum = ? and id = ?";
	 
	
	 
	 try {
		 con = ConnUtil.getConnection();
		 pstmt = con.prepareStatement(sql);
		 pstmt.setInt(1, num);
		 pstmt.setString(2, id);
		 rs = pstmt.executeQuery();
		 
		 
		 if(rs.next()) {return check = true;
		 }
		
	 }catch (SQLException se) {
		 se.printStackTrace();
	}finally {
        if(rs != null) try{ rs.close(); }catch(SQLException ss) {}
        if(pstmt != null) try{ pstmt.close(); }catch(SQLException ss) {}
        if(con != null) try{ con.close(); }catch(SQLException ss) {}
}
return check;
}

public int hateArticle(int num, String id) {
	
	Connection con = null;
	  PreparedStatement pstmt = null;
	 ResultSet rs = null;
	
	 
	 String sql = "insert into badtable values(?, ?)";

	 try {

			  con = ConnUtil.getConnection();
			  pstmt = con.prepareStatement(sql);
			  pstmt.setInt(1, num);
			  pstmt.setString(2, id);
			  return pstmt.executeUpdate(); //성공 했을 때 1이 반환
	}catch (Exception e) {
		  e.printStackTrace();	
}	finally {
	   if(rs != null) try {rs.close();}catch(SQLException ss) {}
	   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
	   if(con != null) try {con.close();}catch(SQLException ss) {}
	
}
	 return -1; // 데이터베이스 오류 
}

public boolean BadCheck(int num, String id) {
	Connection con = null;
	  PreparedStatement pstmt = null;
	 ResultSet rs = null;
	 
	 boolean check = false;
	 
	 String sql = "select * from badtable where bnum = ? and id = ?";
	 
	
	 
	 try {
		 con = ConnUtil.getConnection();
		 pstmt = con.prepareStatement(sql);
		 pstmt.setInt(1, num);
		 pstmt.setString(2, id);
		 rs = pstmt.executeQuery();
		 
		 
		 if(rs.next()) {return check = true;
		 }
		
	 }catch (SQLException se) {
		 se.printStackTrace();
	}finally {
        if(rs != null) try{ rs.close(); }catch(SQLException ss) {}
        if(pstmt != null) try{ pstmt.close(); }catch(SQLException ss) {}
        if(con != null) try{ con.close(); }catch(SQLException ss) {}
}
return check;
}

public int likecount(int num) {
	Connection con = null;
	  PreparedStatement pstmt = null;
	 ResultSet rs = null;
	 
	 int like = 0;
	 
	 String sql = "select count(*) from goodtable where gnum = ?";
	 
	 try {
		 con=ConnUtil.getConnection();
		 pstmt = con.prepareStatement(sql);
		 pstmt.setInt(1, num);
		 rs=pstmt.executeQuery();
		 
		 if(rs.next()) {
			 like = rs.getInt(1);
		 }
		 
	 }catch (Exception e) {
		e.printStackTrace();
	}finally {
        if(rs != null) try{ rs.close(); }catch(SQLException ss) {}
        if(pstmt != null) try{ pstmt.close(); }catch(SQLException ss) {}
        if(con != null) try{ con.close(); }catch(SQLException ss) {}
}
	 return like; 
}
public int hatecount(int num) {
	Connection con = null;
	  PreparedStatement pstmt = null;
	 ResultSet rs = null;
	 
	 int hate = 0;
	 
	 String sql = "select count(*) from badtable where bnum = ?";
	 
	 try {
		 con=ConnUtil.getConnection();
		 pstmt = con.prepareStatement(sql);
		 pstmt.setInt(1, num);
		 rs=pstmt.executeQuery();
		 
		 if(rs.next()) {
			 hate = rs.getInt(1);
		 }
		 
	 }catch (Exception e) {
		e.printStackTrace();
	}finally {
        if(rs != null) try{ rs.close(); }catch(SQLException ss) {}
        if(pstmt != null) try{ pstmt.close(); }catch(SQLException ss) {}
        if(con != null) try{ con.close(); }catch(SQLException ss) {}
}
	 return hate; 
}

	public boolean ScrapCheck(String loginID, int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean result = false;
		String sql = "select * from scrap where snum=? and id=?";
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, loginID);
			rs = pstmt.executeQuery();
			if(!rs.next()) {
				return result=true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
	        if(rs != null) try{ rs.close(); }catch(SQLException ss) {}
	        if(pstmt != null) try{ pstmt.close(); }catch(SQLException ss) {}
	        if(con != null) try{ con.close(); }catch(SQLException ss) {}
	}
		return result;
	}

	public int Scrap(int num, String loginID, int pageNum) {
		Connection con = null;
		  PreparedStatement pstmt = null;

		 String sql = "insert into scrap values(?,?,?)";
		 try {
			 con = ConnUtil.getConnection();
			 pstmt = con.prepareStatement(sql);
			 pstmt.setInt(1, num);
			 pstmt.setString(2, loginID);
			 pstmt.setInt(3, pageNum);
			 return pstmt.executeUpdate();
		 }catch (Exception e) {
			e.printStackTrace();
		}finally {
	        if(pstmt != null) try{ pstmt.close(); }catch(SQLException ss) {}
	        if(con != null) try{ con.close(); }catch(SQLException ss) {}
	}
	return -1;
}
	public static ArrayList<BoardVO> scraplist(String id){
		Connection con = null;
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  
		  ArrayList<BoardVO> volist = new ArrayList<BoardVO>();
		  
		  String sql = "select board.num,board.subject,board.writer,board.regdate,scrap.pnum from board, scrap where board.num = scrap.snum and scrap.id = ? order by scrap.snum asc";
		  try {
			  con = ConnUtil.getConnection();
			  pstmt = con.prepareStatement(sql);
			  pstmt.setString(1, id);
			  rs = pstmt.executeQuery();
			  while(rs.next()) {
				  BoardVO vo = new BoardVO();
				  vo.setNum(rs.getInt("num"));
				  vo.setSubject(rs.getString("subject"));
				  vo.setWriter(rs.getString("writer"));
				  vo.setRegdate(rs.getDate("regdate"));
				  vo.setPagenum(rs.getInt("pnum"));
				  volist.add(vo);
			  }
		  }catch (Exception e) {
			e.printStackTrace();
		}finally {
	        if(rs != null) try{ rs.close(); }catch(SQLException ss) {}
	        if(pstmt != null) try{ pstmt.close(); }catch(SQLException ss) {}
	        if(con != null) try{ con.close(); }catch(SQLException ss) {}
	}
		  return volist;
	}
	public int DeleteScrap(int num, String id) {
		Connection con = null;
		  PreparedStatement pstmt = null;

		  
		  String sql = "delete from scrap where snum=? and id=?";
		  try {
			  con = ConnUtil.getConnection();
			  pstmt = con.prepareStatement(sql);
			  pstmt.setInt(1, num);
			  pstmt.setString(2, id);
			  return pstmt.executeUpdate();
		  }catch (Exception e) {
			  e.printStackTrace();
		}finally {
	        if(pstmt != null) try{ pstmt.close(); }catch(SQLException ss) {}
	        if(con != null) try{ con.close(); }catch(SQLException ss) {}
	}
		  return -1;
	}

}


