package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;





public class CommentBoardDAO {
		 private static CommentBoardDAO instance = null;
		 
		 public CommentBoardDAO() {}
		 
		 public static CommentBoardDAO getInstance() {
		  if(instance == null) {
		   synchronized (CommentBoardDAO.class) {
		    instance = new CommentBoardDAO();
		   }
		  }
		  return instance;
		 }		 
		 public int insert(CommentBoardVO cbvo){
			 Connection con = null;
			  PreparedStatement pstmt = null;
			  
			  String sql = "insert into commentBoard(comnum, boardnum, writer, content, regdate)"
			  		 + "values(commentBoard_seq.nextval, ?, ?, ?, ?)";
			  
			  try {
				  con = ConnUtil.getConnection();
				  pstmt=con.prepareStatement(sql);
				  pstmt.setInt(1, cbvo.getNum());
				  pstmt.setString(2, cbvo.getWriter());
				  pstmt.setString(3, cbvo.getContent());
				  pstmt.setDate(4, cbvo.getRegdate());
				  return pstmt.executeUpdate(); //성공하면 1이 반환된다
			  }catch (Exception e) {
				e.printStackTrace();
			}finally {
				   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
				   if(con != null) try {con.close();}catch(SQLException ss) {}
			}
			  return -1; //데이터베이스 오류
		 }
		 
		 public static ArrayList<CommentBoardVO> search(String comment, int num){
			 
			 Connection con = null;
			  PreparedStatement pstmt = null;
			  ResultSet rs = null;
			
			  String sql = "select * from commentBoard where boardnum = ? order by comnum desc";
			ArrayList<CommentBoardVO> CVOList = new ArrayList<CommentBoardVO>();
			
			  try {
				  con = ConnUtil.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					CommentBoardVO CVO = new CommentBoardVO();
					CVO.setWriter(rs.getString(3));
					CVO.setContent(rs.getString(4));
					CVO.setRegdate(rs.getDate(5));
					CVOList.add(CVO);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				   if(rs != null) try {rs.close();}catch(SQLException ss) {}
				   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
				   if(con != null) try {con.close();}catch(SQLException ss) {}
				}
			  return CVOList;
			 
		 }
		 public int comment(String id){
			 Connection con = null;
			  PreparedStatement pstmt = null;
			  ResultSet rs = null;
			  
			  String sql = "select * from commentboard where writer=?";
			  try {
				  con=ConnUtil.getConnection();
				  pstmt = con.prepareStatement(sql);
				  pstmt.setString(1, id);
				  rs=pstmt.executeQuery();
				  if(rs.next()) {
					  return 1; //자신이 쓴 댓글이 있으면 1 반환
				  }
			  }catch (Exception e) {
				e.printStackTrace();
			}
			  return -1; //데이터베이스 오류
		 }
		 public static ArrayList<BoardVO> commentlist(String id){
			 Connection con = null;
			  PreparedStatement pstmt = null;
			  ResultSet rs = null;
			  
			  
				String sql = "select board.num,board.subject,commentboard.content,"
						+ "commentboard.regdate from board, commentboard where board.num = "
						+ "commentboard.boardnum and commentboard.writer=? order by commentboard.regdate desc";
				ArrayList<BoardVO> VOList = new ArrayList<BoardVO>();
				try {
					con = ConnUtil.getConnection();
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);
					rs=pstmt.executeQuery();
					while(rs.next()) {

							BoardVO vo = new BoardVO();
							vo.setNum(rs.getInt(1));
							vo.setSubject(rs.getString(2));
							vo.setContent(rs.getString(3));
							vo.setRegdate(rs.getDate(4));
							VOList.add(vo);
						
					}
				
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					   if(rs != null) try {rs.close();}catch(SQLException ss) {}
					   if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
					   if(con != null) try {con.close();}catch(SQLException ss) {}
					}
				
				return VOList;
				}
		 }

