package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;


@WebServlet("/BoardScrapServlet")
public class BoardScrapServlet extends HttpServlet {
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
        String loginID = request.getParameter("loginID");
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        response.getWriter().write(ScrapFunction(num, loginID, pageNum)+"");
        
        
        
	}
	public int ScrapFunction(int num, String loginID, int pageNum) {
		BoardDAO dao = new BoardDAO();
        int result = 0;
			  result = dao.Scrap(num, loginID, pageNum);
		     
		
			return result;
		}
		
      
	}
	

