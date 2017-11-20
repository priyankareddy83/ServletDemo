package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmpDAO;
import com.model.Emp;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String sid = request.getParameter("userId");
		int id = Integer.parseInt(sid);
		String username = request.getParameter("userName");
		String password = request.getParameter("userPass");
		String salary = request.getParameter("userSalaryl");

		Emp e = new Emp();
		e.setId(id);
		e.setUsername(username);
		e.setPassword(password);
		e.setSalary(salary);

		int status = EmpDAO.save(e);
		if (status > 0) {
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("folder/index.html").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();
	}

}
