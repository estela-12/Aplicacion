package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.Registro;

public class DataRegistro {
	private Connection cone;
	private PreparedStatement ps;
	public Connection conectar() {
		try {
			cone=DriverManager.getConnection("jdbc:mysql://localhost:3306/mahe","root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al conectar"+ e);
		}
		return cone;
	}
	
	public boolean guardar(Registro regi) {
		boolean guarda=false;
		conectar();
		try {
			ps=cone.prepareStatement("insert into registros values(?,?,?,?,?,?,?,?,?,,?,true)");
			ps.setInt(1,regi.getIdCliente());
			ps.setString(2,regi.getNombre());
			ps.setString(3,regi.getApellidoP());
			ps.setString(4,regi.getApellidoM());
			ps.setString(5,regi.getSexo());
			java.sql.Date sqlDate = new java.sql.Date(regi.getFechaDeNacimiento().getTime());
			ps.setDate(6, sqlDate);
			ps.setString(7, regi.getCurp());
			ps.setInt(8,regi.getNumeroTelefonico());
			ps.setString(9,regi.getCorreoElectronico());
			ps.setString(10,regi.getDireccion());
			ps.setBoolean(11,regi.isActivo());
			int filasModificadas=ps.executeUpdate();
			if(filasModificadas>0) {
				JOptionPane.showMessageDialog(null,"Datos guardados correctamente");
				
			}else {
				JOptionPane.showMessageDialog(null,"Datos no guardados");

				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al guardar"+ e);

		}
		return guarda;
		
	}


}
