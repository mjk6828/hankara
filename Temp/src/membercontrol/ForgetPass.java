package membercontrol;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentDAO;

@WebServlet("/membercontrol/ForgetPass.do")
public class ForgetPass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requsetPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requsetPro(request, response);
	}

	protected void requsetPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String iid = request.getParameter("find");
		String stext = request.getParameter("stext");
		String pass = null;
		int check = 0;
		int num = 1;
		StudentDAO dao = new StudentDAO();
		pass = dao.forgetPass(stext, iid);
		
		if (pass != null) {
			check = 1;
			request.setAttribute("pass", pass);
			request.setAttribute("num", num);
			request.setAttribute("check", check);
		} else if(pass == null && iid != null) {
			check = 2;
			request.setAttribute("num", num);
			request.setAttribute("check", check);
		}else {
			request.setAttribute("num", num);
			request.setAttribute("check", check);
		}
		RequestDispatcher dis = request.getRequestDispatcher("../page/forgetForm.jsp");
		dis.forward(request, response);
	}

}
