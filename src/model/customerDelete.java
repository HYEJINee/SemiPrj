package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;

public class customerDelete implements Command {
	
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws SerialException, IOException {
		//ȸ��Ż�� ���� �̸��� �ּҸ� �޾ƿ� �� dao�� ���� �ѱ�
		customerDao dao = new customerDao();
		String del = req.getParameter("del");
		customerDto list = dao.coutomerdel(del);
		HttpSession session = req.getSession();
		session.setAttribute("list", list);
		return "/WEB-INF/views/customer/Deletemessage.jsp";
	}
}


