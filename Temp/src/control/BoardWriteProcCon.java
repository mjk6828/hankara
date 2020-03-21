package control;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;


@WebServlet("/control/BoardWriteProc.do")
public class BoardWriteProcCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		// 데이터 처리
		BoardVO article = new BoardVO();
		
		 article.setNum(Integer.parseInt(request.getParameter("num")));
		 article.setWriter(request.getParameter("writer"));
		 article.setEmail(request.getParameter("email"));
		 article.setSubject(request.getParameter("subject"));
		 article.setPass(request.getParameter("pass")); 
		 article.setRegdate(new Date(System.currentTimeMillis()));
		 article.setRef(Integer.parseInt(request.getParameter("ref")));
		 article.setStep(Integer.parseInt(request.getParameter("step")));
		 article.setDepth(Integer.parseInt(request.getParameter("depth")));
		 article.setContent(request.getParameter("content"));
		 article.setB_type(request.getParameter("b_type"));	
    
   
    
    
    // 데이터 베이스 처리
    BoardDAO dbPro = BoardDAO.getInstance();
    dbPro.insertArticle(article);
 // 데이터 처리
		RequestDispatcher dis = request.getRequestDispatcher("../page/writePro.jsp");
		dis.forward(request, response);
	}
}
