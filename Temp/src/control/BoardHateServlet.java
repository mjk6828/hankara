package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;


@WebServlet("/BoardHateServlet")
public class BoardHateServlet extends HttpServlet {
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
        
        String hates = request.getParameter("hates");
        int num = Integer.parseInt(request.getParameter("PaNum"));
        String id = request.getParameter("loginID");
       
        response.getWriter().write(hate(num, id)+"");
        
        
	}
	public int hate(int num, String id) {
		
		BoardDAO dao = new BoardDAO();
		
		try {
		
		boolean check =
				dao.BadCheck(num, id);
		
			if(check == true) {
				return 0;
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new BoardDAO().hateArticle(num, id);	
	} 

}
