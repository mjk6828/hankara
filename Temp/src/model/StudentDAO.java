package model;
//�����ͺ��̽��� �����ϴ� ��ü ����
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.*;

public class StudentDAO {
   
	private static StudentDAO instance = null;
	
	public StudentDAO() {}
	
	public static StudentDAO getInstance() {
		
		if(instance == null) {
			synchronized (StudentDAO.class) {
				instance = new StudentDAO();
			}
		}
		return instance;
	}
	
	
   private Connection getConnection() {
      
      Connection conn = null;
      
      try {
         Context init = new InitialContext();
         DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/myoracle");
         //context.xml�� �ִ� resource�� �ҷ��´�.
         
         conn = ds.getConnection();
      }catch(Exception e) {
         System.out.println("Connection ���� ����!!!!");
      }
      return conn;
   }//end getConnection()
   
   //-------------------------------------------------------------------------------//
   
   //���̵� üũ
   public boolean idCheck(String id) {
      
      boolean result = true;
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      try {
         conn = getConnection();
         
         pstmt = conn.prepareStatement("select * from student where id=?");
         pstmt.setString(1, id);
         rs = pstmt.executeQuery();
         
         if(!rs.next()) result=false;
      }catch(SQLException se) {
         se.printStackTrace();
      }finally {
         if(rs != null) try{ rs.close(); }catch(SQLException ss) {}
         if(pstmt != null) try{ pstmt.close(); }catch(SQLException ss) {}
         if(conn != null) try{ conn.close(); }catch(SQLException ss) {}
      }
      return result;
   }//end idCheck(String id)
   
   //-------------------------------------------------------------------------------//
   
   //�����ȣ�� �����ͺ��̽����� �о ���Ϳ� ����
   public Vector<ZipCodeVO> zipcodeRead(String dong){
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      Vector<ZipCodeVO> vecList = new Vector<ZipCodeVO>();
      
      try {
         conn=getConnection();
         
         String strQuery="select * from zipcode where dong like '"+ dong +"%'";
         
         pstmt = conn.prepareStatement(strQuery);
         
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
            ZipCodeVO tempZipcode = new ZipCodeVO();
            tempZipcode.setZipcode(rs.getString("zipcode"));
            tempZipcode.setSido(rs.getString("sido"));
            tempZipcode.setGugun(rs.getString("gugun"));
            tempZipcode.setDong(rs.getString("dong"));
            tempZipcode.setRi(rs.getString("ri"));
            tempZipcode.setBunji(rs.getString("bunji"));
            
            vecList.addElement(tempZipcode);
         }
      }catch(SQLException se) {
         se.printStackTrace();
      }finally {
         if(rs != null) try{ rs.close(); }catch(SQLException ss) {}
         if(pstmt != null) try{ pstmt.close(); }catch(SQLException ss) {}
         if(conn != null) try{ conn.close(); }catch(SQLException ss) {}
      }
      return vecList;
   }//end zipcodeRead()
   
   //-------------------------------------------------------------------------------//
   //���������ͺ��̽��� ȸ�������͸� �ֱ� ���� �޼ҵ� �߰�
   public boolean memberInsert(StudentVO vo) {
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      boolean flag = false;
      
      try {
         conn = getConnection();
         
         String strQuery="insert into student values(?,?,?,?,?,?,?,?,?,?)";
         
         pstmt = conn.prepareStatement(strQuery);
         
         pstmt.setString(1, vo.getId());
         pstmt.setString(2, vo.getPass());
         pstmt.setString(3, vo.getName());
         pstmt.setString(4, vo.getPhone1());
         pstmt.setString(5, vo.getPhone2());
         pstmt.setString(6, vo.getPhone3());
         pstmt.setString(7, vo.getEmail());
         pstmt.setString(8, vo.getZipcode());
         pstmt.setString(9, vo.getAddress1());
         pstmt.setString(10, vo.getAddress2());
         
         int count = pstmt.executeUpdate();
         
         if(count > 0)
            flag = true;
         
      }catch(SQLException se) {
         se.printStackTrace();
      }finally {
         if(rs != null) try{ rs.close(); }catch(SQLException ss) {}
         if(pstmt != null) try{ pstmt.close(); }catch(SQLException ss) {}
         if(conn != null) try{ conn.close(); }catch(SQLException ss) {}
      }
      return flag;
   }//end memberInsert()
   
   //-------------------------------------------------------------------------------//
   
   /*
    * DB���� ID/PASS�� ���Ͽ� �� ����� ���������� �������ִ� �޼ҵ� ����
    * 1 :�α��� ����   
    * 0 :��й�ȣ ����
    * -1:���̵� �������
    */
   public int loginCheck(String id, String pass) {
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      int check = -1;
      
      try {
         
         conn = getConnection();
         
         String strQuery="select pass from student where id=?";
         
         pstmt = conn.prepareStatement(strQuery);
         
         pstmt.setString(1, id);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            String dbpass = rs.getString("pass");
            if(pass.equals(dbpass)) check = 1; //�α��� ����
            else check = 0; //�α��� ����
         }
      }catch(SQLException se) {
         se.printStackTrace();
      }finally {
         if(rs != null) try{ rs.close(); }catch(SQLException ss) {}
         if(pstmt != null) try{ pstmt.close(); }catch(SQLException ss) {}
         if(conn != null) try{ conn.close(); }catch(SQLException ss) {}
      }
      
      return check;
   }//end loginCheck()
   
   //-------------------------------------------------------------------------------//
   
   //���̵� ������ �ִ� ȸ�������� ���� �޼ҵ� ����
   public StudentVO getMember(String id) {
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      StudentVO vo = null;
      
      try {
         
         conn = getConnection();
         
         String strQuery = "select * from student where id=?";
         pstmt = conn.prepareStatement(strQuery);
         pstmt.setString(1, id);
         
         rs = pstmt.executeQuery();
         
         if(rs.next()) { //�ش� ���̵� ���� ȸ�� ����
            vo = new StudentVO();
            
            vo.setId(rs.getString("id"));
            vo.setPass(rs.getString("pass"));
            vo.setName(rs.getString("name"));
            vo.setPhone1(rs.getString("phone1"));
            vo.setPhone2(rs.getString("phone2"));
            vo.setPhone3(rs.getString("phone3"));
            vo.setEmail(rs.getString("email"));
            vo.setZipcode(rs.getString("zipcode"));
            vo.setAddress1(rs.getString("address1"));
            vo.setAddress2(rs.getString("address2"));
         }
         
      }catch(SQLException se) {
         se.printStackTrace();
      }finally {
         if(rs != null) try{ rs.close(); }catch(SQLException ss) {}
         if(pstmt != null) try{ pstmt.close(); }catch(SQLException ss) {}
         if(conn != null) try{ conn.close(); }catch(SQLException ss) {}
      }
      
      return vo;
      
   }//end getMember()
   
   //-------------------------------------------------------------------------------//
   
   /*
    * �������� ��ư�� ������ ���� �����ͺ��̽��� update�� �����Ѵ�.
    * �������� ó���� �޼ҵ带 ����
    */
   public void updateMember(StudentVO vo) {
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      
      try {
         
         conn = getConnection();
         
         String strQuery = "update student set pass=?, phone1=?, phone2=?, phone3=?,"
               + "email=?, zipcode=?, address1=?, address2=? where id=?";
         
         pstmt = conn.prepareStatement(strQuery);
         
         pstmt.setString(1, vo.getPass());
         pstmt.setString(2, vo.getPhone1());
         pstmt.setString(3, vo.getPhone2());
         pstmt.setString(4, vo.getPhone3());
         pstmt.setString(5, vo.getEmail());
         pstmt.setString(6, vo.getZipcode());
         pstmt.setString(7, vo.getAddress1());
         pstmt.setString(8, vo.getAddress2());
         pstmt.setString(9, vo.getId());
         
         pstmt.executeUpdate();
         
      }catch(Exception se) {
         se.printStackTrace();
      }finally {
         if(pstmt != null) try{ pstmt.close(); }catch(SQLException ss) {}
         if(conn != null) try{ conn.close(); }catch(SQLException ss) {}
      }
      
   }//end updateMember()
   
   //-------------------------------------------------------------------------------//
   
   //DB���� ȸ�� ������ ó���� �޼ҵ� ����
   public int deleteMember(String id, String pass) {
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String dbPass=""; //�����ͺ��̽��� ���� ����� ��й�ȣ
      int result = -1;
      /*
       * DB���� ID/PASS�� ���Ͽ� �� ����� ���������� �������ִ� �޼ҵ� ����
       * 1 :�α��� ����   
       * 0 :��й�ȣ ����
       * -1:���̵� �������
       */
      
      try {
         conn = getConnection();
         String strQuery="select pass from student where id=?";
         
         pstmt = conn.prepareStatement(strQuery);
         pstmt.setString(1, id);
         
         rs = pstmt.executeQuery();
         
         if(rs.next()) {
            
            dbPass = rs.getString("pass");
            
            if(dbPass.equals(pass)) {
               //������ ������ true ��ȯ
               //���ڵ� ���� ����
               String delQuery = "delete from student where id=?";
               pstmt = conn.prepareStatement(delQuery);
               
               pstmt.setString(1, id);
               
               pstmt.executeUpdate();
               
               result = 1;   
            }else { //ȸ���� �ƴ� ��� => ��й�ȣ ����
               result = 0;
            } //end if ~ else            
         } //end if
   
      }catch(SQLException se) {
         se.printStackTrace();
      }finally {
         if(rs != null) try{ rs.close(); }catch(SQLException ss) {}
         if(pstmt != null) try{ pstmt.close(); }catch(SQLException ss) {}
         if(conn != null) try{ conn.close(); }catch(SQLException ss) {}
      }
      return result;
   }//end deleteMember()
   
   //---------------------------------------------------------------------------//
   
   //비번찾기
   public String forgetPass(String stext, String iid) {
       Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
        
         String pass = null;
         
         try {
            con = ConnUtil.getConnection();
            if(iid.equals("id")) {
              pstmt = con.prepareStatement("select pass from student where id=?");
              pstmt.setString(1, stext);
            }else if(iid.equals("name")) {
              pstmt = con.prepareStatement("select pass from student where name=?");
             pstmt.setString(1, stext); 
             }else if(iid.equals("email")) {
               pstmt = con.prepareStatement("select pass from student where email=?");
              pstmt.setString(1, stext);  
             }
           rs = pstmt.executeQuery();
          if(rs.next()) {
             pass = rs.getString("pass");
          }
             
         }catch(Exception e) {
            e.printStackTrace();
         }finally {
             if(rs != null) try {rs.close();}catch(SQLException ss) {}
             if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
             if(con != null) try {con.close();}catch(SQLException ss) {}
    }
         return pass;
    }
   
    //ID찾기
    public String forgetID(String stext, String iid) {
       Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         String id = null; 
         
         try {
            con = ConnUtil.getConnection();
            
          if(iid.equals("name")) {
              pstmt = con.prepareStatement("select id from student where name=?");
              pstmt.setString(1, stext);
          }else if(iid.equals("email")){
             pstmt = con.prepareStatement("select id from student where email=?");
             pstmt.setString(1, stext);
          }
           rs = pstmt.executeQuery();
          if(rs.next()) {
             id = rs.getString("id");
           }  
         }catch(Exception e) {
            e.printStackTrace();
         }finally {
             if(rs != null) try {rs.close();}catch(SQLException ss) {}
             if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
             if(con != null) try {con.close();}catch(SQLException ss) {}
    }
         return id;
    }
    
    public int PassCheck(String id, String password) {
    	
    	Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        
        try {
        	con = ConnUtil.getConnection();
        String sql = "select * from student where id=?";
        	
        	pstmt = con.prepareStatement(sql);
        	pstmt.setString(1, id);
        	rs = pstmt.executeQuery();
        	if(rs.next()) {
        		
        		if(password.equals(rs.getString("pass"))) {
        			return 1; //비밀번호 같을시 1 반환
        		}else {
        			return 0; //비밀번호가 다름
        		}
        	}
        }catch (Exception e) {
        	e.printStackTrace();
        }finally {
            if(rs != null) try {rs.close();}catch(SQLException ss) {}
            if(pstmt != null) try {pstmt.close();}catch(SQLException ss) {}
            if(con != null) try {con.close();}catch(SQLException ss) {}
        }
    	return -1; //데이터베이스 오류
    }

   //----------------------------------------------------------------------------//
   
}//end class