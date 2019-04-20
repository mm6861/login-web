package com.login.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.web.service.LoginUserService;
import com.login.web.service.impl.LoginUserServiceImpl;
import com.login.web.vo.LoginUserVO;

@WebServlet({"/user/*"})
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginUserService lus = new LoginUserServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if(cmd!=null) {
			if("login".equals(cmd)) {
				String luId = request.getParameter("luId");
				String luPwd = request.getParameter("luPwd");
				LoginUserVO lu = new LoginUserVO();
				lu.setLuId(luId);
				lu.setLuPwd(luPwd);
				lu = lus.loginUser(lu);
				if(lu==null) {
					pw.println("로그인 실패~");
				}else {
					HttpSession session= request.getSession();
					pw.println(session.getId() + "로그인 성공~");
				}
			} 
		}
	}

}
