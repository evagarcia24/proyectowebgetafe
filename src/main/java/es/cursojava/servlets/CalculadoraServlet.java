package es.cursojava.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculadora")
public class CalculadoraServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operacion = request.getParameter("operacion");
		int numero1 = Integer.parseInt(request.getParameter("numero1"));
		int numero2 = Integer.parseInt(request.getParameter("numero2"));

		int resultado = 0;

		switch (operacion) {
		case "suma":
			resultado = numero1 + numero2;
			break;
		case "resta":
			resultado = numero1 - numero2;
			break;
		case "multiplicacion":
			resultado = numero1 * numero2;
			break;
		default:
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Operación no válida");
			return;
		}

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html lang='es'>");
		out.println("<head><meta charset='UTF-8'><title>Resultado</title></head>");
		out.println("<body>");
		out.println("<h1>Resultado de la operación</h1>");
		out.println("<p>" + numero1 + " " + operacion + " " + numero2 + " = <strong>" + resultado + "</strong></p>");
		out.println("<a href='" + request.getContextPath() + "/calculadora.html'>Volver</a>");
		out.println("</body></html>");
	}
}