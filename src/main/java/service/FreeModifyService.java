package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Free;
import repository.FreeDAO;

public class FreeModifyService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Long freeNo = Long.parseLong(request.getParameter("freeNo"));
		String writer = request.getParameter("writer");
		String ip = request.getParameter("ip");
		Long hit = Long.parseLong(request.getParameter("hit"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Free free = new Free();
		free.setFreeNo(freeNo);
		free.setWriter(writer);
		free.setIp(ip);
		free.setHit(hit);
		free.setTitle(title);
		free.setContent(content);
		
		int result = FreeDAO.getInstance().updateFree(free);
		
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('수정되었습니다.')");
			out.println("location.href='" + request.getContextPath() + "/free/detail.do?freeNo=" + freeNo + "'");
			out.println("</script>");
		}
		out.close();
		
		return null;
	}

}
