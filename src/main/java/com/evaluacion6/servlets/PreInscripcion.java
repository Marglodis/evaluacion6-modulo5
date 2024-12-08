package com.evaluacion6.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.evaluacion6.entidades.CursoDTO;
import com.evaluacion6.entidades.FormaDePagoDTO;
import com.evaluacion6.facade.Facade;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PreInscripcion
 */
@WebServlet("/PreInscripcion")
public class PreInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreInscripcion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Facade facade = new Facade();
		try {
			List<CursoDTO> listaCursos = null;
			try {
				listaCursos = facade.obtenerCursos();
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}

			List<FormaDePagoDTO> listaFormasDePago = null;
			try {
				listaFormasDePago = facade.obtenerFormasDePago();
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}

			request.setAttribute("cursos", listaCursos);
			request.setAttribute("formasPago", listaFormasDePago);
			request.getRequestDispatcher("Inscripcion.jsp").forward(request, response);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
