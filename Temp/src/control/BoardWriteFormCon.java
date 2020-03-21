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

@WebServlet("/control/BoardWriteForm.do")
public class BoardWriteFormCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
		
	}
	
	
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int num = 0, ref =1, step=0, depth=0;
	
		try {
			
			if(request.getParameter("num") != null) {
				
				 num = Integer.parseInt(request.getParameter("num"));
		    	   ref = Integer.parseInt(request.getParameter("ref"));
		    	   step = Integer.parseInt(request.getParameter("step"));
		    	   depth = Integer.parseInt(request.getParameter("depth"));
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
			


		request.setAttribute("num",num);
		request.setAttribute("ref",ref);
		request.setAttribute("step",step);
		request.setAttribute("depth",depth);
		
		RequestDispatcher dis = request.getRequestDispatcher("../page/writeForm.jsp");
		dis.forward(request, response);
	}
}
