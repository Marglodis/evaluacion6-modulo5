package com.evaluacion6.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.evaluacion6.entidades.CursoDTO;
import com.evaluacion6.entidades.FormaDePagoDTO;
import com.evaluacion6.entidades.InscripcionDTO;
import com.evaluacion6.facade.Facade;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PreListarInscripciones
 */
@WebServlet("/PreListarInscripciones")
public class PreListarInscripciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreListarInscripciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Facade facade = new Facade();

			List<InscripcionDTO> listaInscripciones = facade.obtenerInscripciones();
			List<CursoDTO> listaCursos = facade.obtenerCursos();
			List<FormaDePagoDTO> listaFormasPago = facade.obtenerFormasDePago();

			Map<Integer, String> cursoMap = new HashMap<>();

			for(CursoDTO curso: listaCursos) {
				cursoMap.put(curso.getIdCurso(), curso.getDescripcion());
			}

			Map<Integer, String> formaPagoMap = new HashMap<>();

			for(FormaDePagoDTO formaPago: listaFormasPago) {
				formaPagoMap.put(formaPago.getIdFormaDePago(), formaPago.getDescripcion());
			}

			request.setAttribute("inscripciones", listaInscripciones);
			request.setAttribute("cursoMap",cursoMap);
			request.setAttribute("formaPagoMap", formaPagoMap);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaInscripciones.jsp");
			dispatcher.forward(request, response);

		} catch(Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener inscripciones.");
		}
	}

}
