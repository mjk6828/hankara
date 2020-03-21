package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;


@WebServlet("/BoardLikeServlet")
public class BoardLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        String likes = request.getParameter("likes");
        int num = Integer.parseInt(request.getParameter("PaNum"));
        String id = request.getParameter("loginID");
       
        response.getWriter().write(like(num, id)+"");
	}

	public int like(int num, String id) {
		
		BoardDAO dao = new BoardDAO();
		
		try {
		
		boolean check =
				dao.GoodCheck(num, id);
		
			if(check == true) {
				return 0;
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new BoardDAO().likeArticle(num, id);	
	} 
	
}
