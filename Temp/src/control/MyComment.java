package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardVO;
import model.CommentBoardDAO;


@WebServlet("/control/MyComment.do")
public class MyComment extends HttpServlet {
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
        
        String id = request.getParameter("id"); //get방식으로 아이디를 받아옵니다.
        CommentBoardDAO cdao = new CommentBoardDAO();
        int result = cdao.comment(id); //먼저 댓글을 작성했는지 검색을 해본다 result가 1이면 쓴적이 있다.
        List<BoardVO> volist = null;
        if(result == 1) { //댓글 작성한 적이 있을 경우 댓글 목록 가져옴.
        	
        	
        	volist = CommentBoardDAO.commentlist(id);
        }
        
        request.setAttribute("volist", volist);
        request.setAttribute("result", result);
        RequestDispatcher dis = request.getRequestDispatcher("../my/MyComment.jsp");
        dis.forward(request, response);
        
        
	}
}
