package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import action.ListAction;
import action.WriteFormAction;
import action.WriteProAction;

//@WebServlet("/member")
@WebServlet(//확장자가 .do인 요청은 모두 이리로 와라.
		name = "BoardController",
		urlPatterns = {"*.to"})
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		requestPro(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/* Servlet에서 Ajax 할 때 requestPro를 타는 것은 동기식 처리를 요청하는것으로 하면 안된다.
		 * Ajax url에 대해서는 PrintWriter out을 활용해서 출력하면 화면단에서 받을 수 있다.
		 * */
		requestPro(request, response);
	}
	public void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = null;
		CommandAction com = null; //다형성을 위한 인터페이스
	 //uri를 받아서 주소로 넘온 것을 해당 비즈니스 로직으로 보내고 리턴받기
		String command = request.getRequestURI();
		if(command.indexOf(request.getContextPath())==0) {
			command = command.substring(request.getContextPath().length());
		}
//		System.out.println("command :::"+command);
		switch(command) {
		case "/list.to":{
			 view = new ListAction().requestPro(request, response);
			 break;
		  }
		case "/writeForm.to":{
			view = new WriteFormAction().requestPro(request, response);
			break;
		}
		case "/writePro.to":{
			view = new WriteProAction().requestPro(request, response);
			break;
		}
		
		}
		// response의 redirect(주소가 변경되게 하고 싶을 때)이거나 forward(주소는 변화없고 제어만 넘길때)한다.
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
//		if(view.contains(".to")) {//주소부분이 바뀌게 하려고 할 때
//            response.sendRedirect(view);			
//		}else {
			dispatcher.forward(request, response);	//주소는 바뀌않고 결과만 받을 때
//		}
		
	}
}
