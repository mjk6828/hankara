package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;


@WebServlet("/control/BoardDeleteProc.do")
public class BoardDeleteProcCon extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	requestPro(request, response);
	}
	
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
		
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String pass = request.getParameter("pass");
		
		// 데이터 베이스 연결
		BoardDAO dbPro = new BoardDAO();
		
		int check = dbPro.deleteArticle(num, pass);
		
		// 해당 뷰에서 사용할 속성 저장
		 request.setAttribute("pageNum",new Integer(pageNum));
		 request.setAttribute("check", new Integer(check));
		 
		 RequestDispatcher dis = request.getRequestDispatcher("../page/boardDeleteProc.jsp");
			dis.forward(request, response);
	}
}
