package control;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;


@WebServlet("/control/BoardList.do")
public class BoardListCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		
		String pageNum = request.getParameter("pageNum");//페이지번호
		
		if(pageNum == null) {
			pageNum ="1";
		}
		
		// 한페이지에 보여줄 글의 개수
		int pageSize =5;
		int currentPage = Integer.parseInt(pageNum);
		
		// 한페이지의 시작글 번호
		int startRow =(currentPage - 1) * pageSize + 1;
		// 한 페이지의 마지막 글번호
		int endRow = currentPage * pageSize;

		int count = 0;
		int number =0;
		
		String find = null;
		String find_box = null;
		
		find = request.getParameter("find");
		find_box = request.getParameter("find_box");
		
		if(find == null) {
			find="no";
		}
		
		if(find_box == null) {
			find_box="no";
		}
		
		List<BoardVO> articleList = null;
		
		// 디비연동
		BoardDAO dbPro = BoardDAO.getInstance();
		
		count = dbPro.getArticleCount(find, find_box);// 전체 글의 수 
		
		
		if(count > 0) {// 현재 페이지에 해당하는 글 목록
	         articleList = dbPro.getArticles(find, find_box, startRow, endRow);
		}else {
			articleList = Collections.emptyList();
		}
		
		// 글 목록에 표시할 글 번호
		number = count - (currentPage - 1) * pageSize;
		
		
		
		// 해당 뷰에서 사용할 속성 저장
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("articleList", articleList);
		request.setAttribute("find", new String(find));
		request.setAttribute("find_box", new String(find_box));
		
			RequestDispatcher dis = request.getRequestDispatcher("../page/boardForm.jsp");
			dis.forward(request, response);
	}
}
