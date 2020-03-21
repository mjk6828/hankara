package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommentBoardDAO;
import model.CommentBoardVO;




@WebServlet("/BoardCommentSearchServlet")
public class BoardCommentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        String comment = request.getParameter("comment");
        int num = Integer.parseInt(request.getParameter("PaNum"));
        response.getWriter().write(boardsearch(comment, num));
	}

	public String boardsearch(String comment, int num) {
	        StringBuffer result = new StringBuffer("");    //result라는 변수 생성
	        result.append("{\"result\":[");        //result에 문자열을 담음
	        CommentBoardDAO CDAO= new CommentBoardDAO();
	        ArrayList<CommentBoardVO> CVOList = CDAO.search(comment, num);    //검색할 comment을 search 메소드에 넣고 리턴값을 저장함
	        for(int i=0; i<CVOList.size(); i++) {    //검색에 해당되는 userList의 길이만큼
	            result.append("[{\"value\": \""+CVOList.get(i).getWriter()+"\"},");    //해당 comment들의 정보를 result에 넣음
	            result.append("{\"value\": \""+CVOList.get(i).getContent()+"\"},");
	            result.append("{\"value\": \""+CVOList.get(i).getRegdate()+"\"}],");
	        }
	        result.append("]}");
	        return result.toString();
	}
}
