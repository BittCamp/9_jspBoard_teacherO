package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDAO;
import model.dto.BoardDTO;

public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 데이터베이스 일하는 DAO 불러서
		//리스트 갖고오게 하고
		//그걸 화면에서 볼 수 있게 저장
		List<BoardDTO> articles= null;
		int total =0;
		try {
			total = BoardDAO.getInstance().getTotCnt();
			articles = BoardDAO.getInstance().getArticles(1, 100);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		request.setAttribute("articles", articles);
		request.setAttribute("total", total);
		return "freeboard/list.jsp";
	}

}
