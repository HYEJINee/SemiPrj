package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;

public class customerlogout implements Command {
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws SerialException, IOException {
		// �α׾ƿ��� ������ ���� ���� 0 �̶�� ������ id�� �˻��ؼ� null�� �ǵ��� �Ͽ� �α׾ƿ���
		// id�� 1������ �����ϱ� ������ 0�� id�� ����� �������� �ʱ� ������ ��� ȸ���� �α׾ƿ��� �� �� ����
		customerDao dao = new customerDao();
		
		String out = req.getParameter("out");
		customerDto list = dao.coutomerLogout(out);
		HttpSession session = req.getSession();
		session.setAttribute("list", list);
		return "index.jsp";
	}
}
