package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import modelo.Reporte;

public class DataReporte {
	private Conxion co=new Conxion();

	private Connection cone;
	private PreparedStatement ps;

	
	public boolean guardar(Reporte repo) {
		boolean guarda=false;
		cone=co.conectar(); 
		try {
			ps=cone.prepareStatement("insert into reportes values(?,?,?,?)");
			ps.setInt(1,repo.getIdReporte());
			java.sql.Date sqlDate = new java.sql.Date(repo.getFechaDelLevantamientoDelReporte().getTime());
			ps.setDate(2, sqlDate);
			java.sql.Date sqlDate1 = new java.sql.Date(repo.getFechaDelCorteDeAgua().getTime());
			ps.setDate(3, sqlDate1);
			//ps.setString(4,repo.getDireccion());
			//ps.setInt(5,repo.getNumeroTelefonico());
			ps.setString(4,repo.getDescripcionDelReporte());


			int filasModificadas=ps.executeUpdate();
			if(filasModificadas>0) {
				guarda=true;
				JOptionPane.showMessageDialog(null,"Reporte guardado correctamente");
				
			}else {
				JOptionPane.showMessageDialog(null,"Reporte no guardado");

				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al guardar reporte"+ e);

		}
		return guarda;
	}
	public Reporte consultarReporte(int idReporte) {
		Reporte rep=new Reporte();
		String sql="select * from reportes where idCliente=?";
		cone=co.conectar();
		LocalDate VistaReportes= null;
		try {
			ps=cone.prepareStatement(sql);
			ps.setInt(1,idReporte);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				rep.setIdReporte(rs.getInt(1));
				VistaReportes=rs.getDate(2).toLocalDate();
				VistaReportes=rs.getDate(3).toLocalDate();
				//rep.setDireccion(rs.getString(4));
				//rep.setNumeroTelefonico(rs.getInt(5));
				rep.setDescripcionDelReporte(rs.getString(4));
				
				
			}else {
				JOptionPane.showMessageDialog(null,"No se encontro el reporte");
			}
			ps.close();
			cone.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al consultar los datos"+e);

			
		}
		return rep;
	}
	
	public boolean actualizar(Reporte repo) {
		boolean actuali=false;
		cone=co.conectar();
		try {
			ps=cone.prepareStatement("update reportes set fechaDelLevantamientoDelReporte=?,fechaDelCorteDeAgua=?,descripcionDelReporte=?,,where idReporte=?");
			ps.setInt(1,repo.getIdReporte());
			java.sql.Date sqlDate = new java.sql.Date(repo.getFechaDelLevantamientoDelReporte().getTime());
			ps.setDate(2, sqlDate);
			java.sql.Date sqlDate1 = new java.sql.Date(repo.getFechaDelCorteDeAgua().getTime());
			ps.setDate(3, sqlDate1);
			//ps.setString(4, repo.getDireccion());
			//ps.setInt(5,repo.getNumeroTelefonico());
			ps.setString(4,repo.getDescripcionDelReporte());
			int filasModificadas=ps.executeUpdate();
			if(filasModificadas>0) {
				actuali=true;
				JOptionPane.showMessageDialog(null,"Datos actualizados correctamente");
				
			}else {
				JOptionPane.showMessageDialog(null,"Datos no actualizados");

				
			}
			ps.close();
			cone.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al actualizar"+ e);

		}
		return actuali;
		
	}
	public boolean eliminar(int idReporte) {
		boolean elimina=false;
		cone=co.conectar();
		try {
			ps=cone.prepareStatement("update reportes set where idReportes=?");
			ps.setInt(1, idReporte);
			int filasModificadas=ps.executeUpdate();
			if(filasModificadas>0) {
				JOptionPane.showMessageDialog(null,"Datos Eliminados Correctamente");
				
			}else {
				JOptionPane.showMessageDialog(null,"Datos no Eliminados");

				
			}
			ps.close();
			cone.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al eliminar"+ e);

		}
		return elimina;
		
	}
	

}
