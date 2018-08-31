package org.study.web;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.dao.HRDShopDao;
import org.study.model.Member;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	HRDShopDao dao = new HRDShopDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("register doget called...");
		
		try {
			int nextMemberId = dao.getNextMemberId();
			request.setAttribute("id", nextMemberId);
			Date date = new Date(System.currentTimeMillis());
			DateFormat format = new SimpleDateFormat("yyyyMMdd");
			request.setAttribute("today", format.format(date));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/views/registerForm.jsp").forward(request, response);
	}


	// AJAX call 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("register dopost called");
		
		Member member = new Member();
		member.setMember_num(request.getParameter("member_num"));
		member.setMember_name(request.getParameter("member_name"));
		member.setMember_phone(request.getParameter("member_phone"));
		member.setMember_address(request.getParameter("member_address"));
		
		System.out.println("join date: " + request.getParameter("member_join_date"));
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		try {
			java.util.Date join_date = format.parse(request.getParameter("member_join_date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		member.setMember_title(request.getParameter("member_title"));
		member.setMember_city(request.getParameter("member_city"));
		
		System.out.println(member);
		/*
		if (dao != null) {
			if (dao.insertMember(member)) {
				System.out.println("dabase update success");
			} else {
				System.out.println("dabase update fail");
			}
		}
		*/
		
	}

}
