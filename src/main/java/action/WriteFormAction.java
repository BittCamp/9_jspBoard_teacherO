package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//답글이냐 아니냐 비교해서 화면을 다르게 할것임... 
		//setting필요
		return "freeboard/writeForm.jsp";
	}

}
