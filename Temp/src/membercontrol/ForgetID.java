package membercontrol;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentDAO;

@WebServlet("/membercontrol/ForgetID.do")
public class ForgetID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String iid = request.getParameter("id");
		String stext = request.getParameter("stext");
		String id = null;
		int check1 = 0;
		int num = 0;
		StudentDAO dao = new StudentDAO();
		id = dao.forgetID(stext, iid);

		if (id != null) {
			check1 = 1;
			request.setAttribute("id", id);
			request.setAttribute("num", num);
			request.setAttribute("check1", check1);
		} else if(id == null && iid != null){
			check1 = 2;
			request.setAttribute("num", num);
			request.setAttribute("check1", check1);
		} else {
			request.setAttribute("num", num);
			request.setAttribute("check1", check1);
		}

		RequestDispatcher dis = request.getRequestDispatcher("../page/forgetForm.jsp");
		dis.forward(request, response);

	}
}
