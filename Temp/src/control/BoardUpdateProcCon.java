package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

@WebServlet("/control/BoardUpdateProc.do")
public class BoardUpdateProcCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	requestPro(request, response);
	}
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String pageNum = request.getParameter("pageNum");
		
		BoardVO article = new BoardVO();
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setWriter(request.getParameter("writer"));
	    article.setEmail(request.getParameter("email"));		
	    article.setSubject(request.getParameter("subject"));
	    article.setContent(request.getParameter("content"));	
	    article.setPass(request.getParameter("pass"));
	    article.setB_type(request.getParameter("b_type"));
		
	    BoardDAO dbPro = new BoardDAO();
	    int check = dbPro.updateArticle(article);
	    
	    request.setAttribute("pageNum",new Integer(pageNum));
		request.setAttribute("check", new Integer(check));
		
			RequestDispatcher dis = request.getRequestDispatcher("../page/updateProc.jsp");
			dis.forward(request, response);
	
		
	}
}
