package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import sun.rmi.server.Dispatcher;


@WebServlet("/control/BoardDeleteForm.do")
public class BoardDeleteCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	int num = Integer.parseInt(request.getParameter("num"));
		
		// 해당 페이지 번호
		String pageNum = request.getParameter("pageNum");
		
		// 해당 하는 뷰에서 사용할 속성 저장
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));
		
		RequestDispatcher dis = request.getRequestDispatcher("../page/boardDeleteForm.jsp");
		dis.forward(request, response);
	}
}
