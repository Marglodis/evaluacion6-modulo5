package com.evaluacion6.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.evaluacion6.entidades.InscripcionDTO;

public class InscripcionDAO {

	public int insertarInscripcion(InscripcionDTO dto) throws SQLException, ClassNotFoundException{

		int idGenerado = -1;

		String insertarInscripcion = " INSERT INTO public.inscripcion("
				+ " id_inscripcion, nombre, telefono, id_curso, id_forma_pago )"
				+ " VALUES (DEFAULT,?,?,?,?) ";

		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/universidad", "postgres", "mtg.2029");

		try(PreparedStatement stmt = conn.prepareStatement(insertarInscripcion, Statement.RETURN_GENERATED_KEYS)){

			//Parametro de la consulta
				stmt.setString(1, dto.getNombre());
				stmt.setString(2,dto.getCelular());
				stmt.setInt(3, dto.getIdCurso());
				stmt.setInt(4, dto.getIdFormaDePago());

				if(stmt.executeUpdate()== 1) {
					try(ResultSet rs = stmt.getGeneratedKeys()){
						if(rs.next()) {
							idGenerado = rs.getInt(1);
						}
					}
				} else {
					throw new RuntimeException("No se insertó correctamnete nel abase de datos.");
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException("Ha ocurrido un error inesperado" + ex);
			}

		return idGenerado;

	}

	public List<InscripcionDTO> obtieneInscripciones() throws SQLException, ClassNotFoundException {

		List<InscripcionDTO> inscripciones = new ArrayList<>();

		String consultaSql = " SELECT * " + " FROM public.inscripcion ";

		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/universidad", "postgres", "mtg.2029");

		try(PreparedStatement stmt = conn.prepareStatement(consultaSql)){
			ResultSet resultado = stmt.executeQuery();

			while(resultado.next()) {
				InscripcionDTO inscripcion = new InscripcionDTO();

				inscripcion.setIdInsc(resultado.getInt("id_inscripcion"));
				inscripcion.setNombre(resultado.getString("nombre"));
				inscripcion.setCelular(resultado.getString("telefono"));
				inscripcion.setIdCurso(resultado.getInt("id_curso"));
				inscripcion.setIdFormaDePago(resultado.getInt("id_forma_pago"));
				inscripciones.add(inscripcion);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}

		return inscripciones;
	}

}