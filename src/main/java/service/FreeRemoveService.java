package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.FreeDAO;

public class FreeRemoveService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Long freeNo = Long.parseLong(request.getParameter("freeNo"));
			
		int result = FreeDAO.getInstance().deleteFree(freeNo);
		
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('삭제되었습니다.')");
			out.println("location.href='" + request.getContextPath() + "/student/free.do'");
			out.println("</script>");
		} else 
		out.close();
		
		return null;
	}

}
