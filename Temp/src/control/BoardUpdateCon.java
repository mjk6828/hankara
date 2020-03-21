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


@WebServlet("/control/BoardUpdate.do")
public class BoardUpdateCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//해당번호
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		//데이터베이스에서 하나의 게시글에 대한  정보를 리턴 메소드 호출
		
		BoardDAO bdao = new BoardDAO();
		 // BoardDAO dbPro = BoardDAO.getInstance();
		BoardVO article = bdao.updateGetArticle(num);
		
		
		//request
		request.setAttribute("num", new Integer(num));
		request.setAttribute("article", article);
		request.setAttribute("pageNum", new Integer(pageNum));
		
		RequestDispatcher dis = request.getRequestDispatcher("../page/updateForm.jsp");
		dis.forward(request, response);
	}
}
