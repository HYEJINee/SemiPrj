package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;

public class customerLoseid implements Command {
	
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws SerialException, IOException {
		//�Է¹��� �̸�,����,�ڵ��� ��ȣ�� ������ �ش� ȸ���� �ִ��� �˻�
		customerDao dao = new customerDao();
		customerDto emp = new customerDto();
		emp.setUser_name(req.getParameter("Loseidname"));
		emp.setUser_nick(req.getParameter("Loseidnickname"));
		emp.setUser_phone(req.getParameter("Loseidphone") + "-" + req.getParameter("Loseidphone2") + "-"
				+ req.getParameter("Loseidphone3"));
		customerDto list = dao.coutomerLoseid(emp);

		HttpSession session = req.getSession();
		session.setAttribute("list", list);
		
		return "/WEB-INF/views/customer/Loseid.jsp";
	}
}
