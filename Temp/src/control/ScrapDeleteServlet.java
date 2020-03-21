package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;


@WebServlet("/ScrapDeleteServlet")
public class ScrapDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        int num = Integer.parseInt(request.getParameter("PaNum"));
        String id = request.getParameter("loginID");
        response.getWriter().write(Delete(num, id)+"");
        
	}
	
	public int Delete(int num, String id ) {
		
		BoardDAO dao = new BoardDAO();
		
		int result = 0;
		result = dao.DeleteScrap(num, id);
		return result;
	}
}
