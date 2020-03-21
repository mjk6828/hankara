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
import model.StudentVO;


@WebServlet("/membercontrol/ModifyProc.do")
public class ModifyProc extends HttpServlet {
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
		
		StudentVO vo = new StudentVO(loginID,
				request.getParameter("pass"),
				request.getParameter("name"),
				request.getParameter("phone1"),
				request.getParameter("phone2"),
				request.getParameter("phone3"),
				request.getParameter("email"),
				request.getParameter("zipcode"),
				request.getParameter("address1"),
				request.getParameter("address2"));
		
		dao.updateMember(vo);
		
		RequestDispatcher dis = request.getRequestDispatcher("../page/modifyProc.jsp");
		dis.forward(request, response);
	}
}
