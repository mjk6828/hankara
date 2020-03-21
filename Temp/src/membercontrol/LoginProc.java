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


@WebServlet("/membercontrol/LoginProc.do")
public class LoginProc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	requestPro(request, response);	
	}
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDAO dao = StudentDAO.getInstance();
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		int check = dao.loginCheck(id, pass);
		
		if(check == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("loginID", id);
		}else if(id != null && pass != null) {
			request.setAttribute("check", check);
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("../page/loginForm.jsp");
		dis.forward(request, response);
	}
}
