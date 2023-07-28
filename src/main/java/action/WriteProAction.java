package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDAO;

public class WriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int r=0;
		try {
			r = BoardDAO.getInstance().writeArticle(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        String msg = null;				
		if(r>0) msg = "글저장 성공";
		else msg = "글저장 실패";
		request.setAttribute("msg", msg);
		request.setAttribute("url", "list.to");
		return "freeboard/Msg.jsp";
	}

}
