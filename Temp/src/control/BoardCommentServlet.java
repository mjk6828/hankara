package control;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardVO;
import model.CommentBoardDAO;
import model.CommentBoardVO;


@WebServlet("/BoardCommentServlet")
public class BoardCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
		
        String commentContent = request.getParameter("commentContent");
        String commentWriter = request.getParameter("commentWriter");
        String num = request.getParameter("PaNum");
        
        response.getWriter().write(Comment(commentContent, commentWriter, num)+"");
	}

	public int Comment(String commentContent, String commentWriter, String num) {
		
		CommentBoardVO cbvo = new CommentBoardVO();
		
	
		
		try {
			cbvo.setNum(Integer.parseInt(num));
			cbvo.setWriter(commentWriter);
			cbvo.setContent(commentContent);
			cbvo.setRegdate(new Date(System.currentTimeMillis()));
			
		}catch (Exception e) {
			return 0;
		}
		return new CommentBoardDAO().insert(cbvo);
	}
}
