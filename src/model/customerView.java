package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;

public class customerView implements Command {
	
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws SerialException, IOException {
		//개인정보수정을 위해 보여주기 위해 해당 회원 정보 검색
		customerDao dao = new customerDao();
		String view = req.getParameter("view");
		customerDto list = dao.coutomerView(view);
		
		HttpSession session = req.getSession();
		session.setAttribute("list", list);
		
		return "/WEB-INF/views/customer/MyPage.jsp";
	}

}
