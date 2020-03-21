package membercontrol;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.StudentDAO;


@WebServlet("/membercontrol/DeleteProc.do")
public class DeleteProc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		StudentDAO dao = StudentDAO.getInstance();
		HttpSession session = request.getSession();	
		String loginID = (String)session.getAttribute("loginID");
		String pass = request.getParameter("pass");
		
		int result = dao.deleteMember(loginID, pass);
		
		if(result != 0) {
			session.invalidate();
		}
		
		request.setAttribute("result", result);
		
		RequestDispatcher dis = request.getRequestDispatcher("../page/deleteProc.jsp");
		dis.forward(request, response);
	}
}
