package com.kwan.home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwan.home.monster.MonsterController;

/**
 * Servlet implementation class FrontController
 */
//@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Action action = new Action();

		MonsterController mc = new MonsterController();

		// 요청 데이터 안의 uri 불러오기
		String uri = request.getRequestURI();

		// uri에서 루트 다음 경로 추출
		StringTokenizer st = new StringTokenizer(uri, "/");
		ArrayList ar = new ArrayList();

		while (st.hasMoreTokens()) {
			ar.add(st.nextToken());

		}

		System.out.println(ar.size());

		if (ar.size() == 0) {
			action.setFlag(true);
			action.setPath("/WEB-INF/views/Index.jsp");
		} else if (ar.get(0).equals("monster")) {

			action = mc.start(action);
		}

		if (action.isFlag()) {

			RequestDispatcher view = request.getRequestDispatcher(action.getPath());
			view.forward(request, response);

		} else if (action.isFlag() == false) {

		} else {

			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/warning.jsp");
			view.forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
