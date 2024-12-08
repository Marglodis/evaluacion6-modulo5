package com.evaluacion6.servlets;

import java.io.IOException;
import java.sql.SQLException;

import com.evaluacion6.entidades.InscripcionDTO;
import com.evaluacion6.facade.Facade;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PosInscripcion
 */
@WebServlet("/PosInscripcion")
public class PosInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PosInscripcion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String celular = request.getParameter("telefono");
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));
		int idFormaDePago = Integer.parseInt(request.getParameter("idFormaPago"));
		InscripcionDTO dto = new InscripcionDTO();
		dto.setNombre(nombre);
		dto.setCelular(celular);
		dto.setIdCurso(idCurso);
		dto.setIdFormaDePago(idFormaDePago);

		System.out.println(dto.toString());

		Facade facade = new Facade();
		int idInsc = 0;

		try {
			idInsc = facade.registrarInscripcion(dto);
		}catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("idInsc", idInsc);
		request.setAttribute("nombre", nombre);
		request.setAttribute("telefono", celular);
		request.setAttribute("idCurso",idCurso);
		request.setAttribute("idFormaDePago", idFormaDePago);
		       
		request.getRequestDispatcher("/Confirmacion.jsp").forward(request,response);

	}

}
