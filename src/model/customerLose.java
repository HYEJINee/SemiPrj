package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

public class customerLose implements Command {
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws SerialException, IOException {
		// ���̵�/��й�ȣ ã�� �������� �̵�
		return "/WEB-INF/views/customer/Loseidpw.jsp";
	}
}
