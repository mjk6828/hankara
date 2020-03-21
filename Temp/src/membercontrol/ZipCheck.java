package membercontrol;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentDAO;
import model.ZipCodeVO;


@WebServlet("/membercontrol/ZipCheckCon.do")
public class ZipCheck extends HttpServlet {
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
		String check = request.getParameter("check");
		String dong = request.getParameter("dong");
		
		Vector<ZipCodeVO> zipcodeList =
				dao.zipcodeRead(dong);
		
		int totalList = zipcodeList.size();
		
		request.setAttribute("check", check);
		request.setAttribute("dong", dong);
		request.setAttribute("zipcodeList", zipcodeList);
		request.setAttribute("totalList", totalList);
		
		RequestDispatcher dis = request.getRequestDispatcher("../page/zipCheck.jsp");
		dis.forward(request, response);
	}
}
