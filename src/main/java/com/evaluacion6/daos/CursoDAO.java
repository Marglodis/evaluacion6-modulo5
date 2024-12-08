package com.evaluacion6.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.evaluacion6.entidades.CursoDTO;

public class CursoDAO {

	public List<CursoDTO> obtieneCurso() throws SQLException, ClassNotFoundException {
		List<CursoDTO> listaDeCursos = new ArrayList<>();

		String consultaSql = " SELECT id_curso, descripcion, precio " + "FROM public.cursos ";

		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/universidad", "postgres",
				"mtg.2029");

		try (PreparedStatement stmt = conn.prepareStatement(consultaSql)) {
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				CursoDTO cursoDto = new CursoDTO();
				cursoDto.setIdCurso(resultado.getInt("id_curso"));
				cursoDto.setDescripcion(resultado.getString("descripcion"));
				cursoDto.setPrecio(resultado.getDouble("precio"));

				listaDeCursos.add(cursoDto);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return listaDeCursos;

	}

}
