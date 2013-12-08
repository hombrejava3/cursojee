package com.microforum.repartido6;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String nextPage = "showResult.jsp";
		String message = "action nulo o invalido";
		try {
			HttpSession session = request.getSession();
			switch (action) {
			case "inicializarEmpresa":
				session.setAttribute("empresa", new Empresa("empresa1", new ArrayList<Liquidable>()));
				nextPage = "showResult.jsp";
				message = "empresa inicializada";
				break;
			case "inicioAgregarEmpleadoAnual":
				nextPage = "agregarEmpleadoAnual.jsp";
				break;
			case "agregarEmpleadoAnual":
				EmpleadoAnual empleadoAnual = new EmpleadoAnual(request.getParameter("nombre"), request.getParameter("dni"), request.getParameter("direccion"),
						Double.parseDouble(request.getParameter("salarioAnual")));
				Empresa empresa = (Empresa) session.getAttribute("empresa");
				empresa.getLiquidables().add(empleadoAnual);
				nextPage = "showResult.jsp";
				message = "empleado anual dado de alta";
				break;
			case "inicioAgregarEmpleadoHora":
				nextPage = "agregarEmpleadoHora.jsp";
				break;
			case "agregarEmpleadoHora":
				EmpleadoHora empleadoHora = new EmpleadoHora(request.getParameter("nombre"), request.getParameter("dni"), request.getParameter("direccion"),
						Double.parseDouble(request.getParameter("valorHora")), Double.parseDouble(request.getParameter("cantidadHoras")));
				empresa = (Empresa) session.getAttribute("empresa");
				empresa.getLiquidables().add(empleadoHora);
				nextPage = "showResult.jsp";
				message = "empleado hora dado de alta";
				break;
			case "obtenerLiquidacion":
				empresa = (Empresa) session.getAttribute("empresa");
				nextPage = "showResult.jsp";
				message = String.valueOf(empresa.calcularTotalPagosMensuales());
				break;
			case "mostrarSession":
				nextPage = "mostrarSession.jsp";
				break;
			case "invalidarSession":
				nextPage = "showResult.jsp";
				message = "sesion invalidada";
				break;
			}
		} catch (Throwable t) {
			t.printStackTrace();
			message = t.getMessage();
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher(nextPage).forward(request, response);
	}
}
