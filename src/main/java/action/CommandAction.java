package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandAction {
	  public String requestPro(HttpServletRequest request, 
			     HttpServletResponse response)throws ServletException, 
	                                                  IOException;
}