package com.ecodeup.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("usuario");
		String pass = request.getParameter("pass");

		if (name.equals("admin") && pass.equals("admin")) {
			System.out.println("Usuario y clave correcta");

			RequestDispatcher rd = request.getRequestDispatcher("login-exito.jsp");
			request.setAttribute("usuario", name);
			
      //variable de sesion
      HttpSession session = request.getSession();
			session.setAttribute("usuarioSesion", name);
			

			rd.forward(request, response);

		} else {
			System.out.println("Usuario y clave incorrecta");
			RequestDispatcher rd= request.getRequestDispatcher("login-error.jsp");
			rd.forward(request, response);
		}

	}

}
