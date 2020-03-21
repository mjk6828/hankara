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


@WebServlet("/control/BoardInfo.do")
public class BoardInfoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	requestPro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//num
		int num = Integer.parseInt(request.getParameter("num"));
		
		
		 // 해당 페이지 번호
		 String pageNum = request.getParameter("pageNum");
	    // 데이터베이스 연결
	      BoardDAO dbPro = BoardDAO.getInstance();
			
			// 글번호에 대한 레코드를 가져옴
			BoardVO article = dbPro.getArticle(num);
			int like = dbPro.likecount(num);
			int hate = dbPro.hatecount(num);
			
			// 뷰에 대한 속성지정
			request.setAttribute("num", new Integer(num));
			request.setAttribute("pageNum", new Integer(pageNum));
			request.setAttribute("article",article);	
			request.setAttribute("like", like);
			request.setAttribute("hate", hate);
		//view.jsp 쪽으로 데이터 넘겨줌
		RequestDispatcher dis = request.getRequestDispatcher("../page/boardInfo.jsp");
		dis.forward(request, response);
		
	}
}
