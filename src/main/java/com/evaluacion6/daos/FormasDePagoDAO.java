package com.evaluacion6.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.evaluacion6.entidades.FormaDePagoDTO;

public class FormasDePagoDAO {

	public List<FormaDePagoDTO> obtieneFormasDePago() throws SQLException, ClassNotFoundException{
		List<FormaDePagoDTO> formaDePago = new ArrayList<>();

		String consultaSql = " SELECT id_forma_pago, descripcion, recargo"
				+ " FROM public.forma_pago ";

		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/universidad", "postgres", "mtg.2029");

		try(PreparedStatement stmt = conn.prepareStatement(consultaSql)){
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				FormaDePagoDTO formaPago = new FormaDePagoDTO();

				formaPago.setIdFormaDePago(resultado.getInt("id_forma_pago"));
				formaPago.setDescripcion(resultado.getString("descripcion"));
				formaPago.setRecargo(resultado.getDouble("recargo"));
				formaDePago.add(formaPago);
			}

		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return formaDePago;
	}
}
