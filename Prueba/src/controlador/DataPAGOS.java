package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import modelo.Pagos;
import modelo.Reporte;

public class DataPAGOS {
	Conxion co=new Conxion();

	private Connection cone;
	private PreparedStatement ps;

	
	public boolean guardar(Pagos pag) {
		boolean guarda=false;
		cone=co.conectar(); 
		try {
			ps=cone.prepareStatement("insert into pagos values(?,?,?,?)");
			ps.setInt(1,pag.getIdPago());
			ps.setInt(2,pag.getSaldoPendiente());
			ps.setInt(3,pag.getSaldoApagar());
			java.sql.Date sqlDate = new java.sql.Date(pag.getFechaLimiteaPagar().getTime());
			ps.setDate(4, sqlDate);
			int filasModificadas=ps.executeUpdate();
			if(filasModificadas>0) {
				guarda=true;
				JOptionPane.showMessageDialog(null,"Pago realizado correctamente");
				
			}else {
				JOptionPane.showMessageDialog(null,"Pago no realizado correctamente");

				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al guardar pago"+ e);

		}
		return guarda;
	}
	public Pagos consultarPago(int idPago) {
		Pagos pag=new Pagos();
		String sql="select * from pagos where idPagos=?";
		cone=co.conectar();
		LocalDate VistaPagos= null;
		try {
			ps=cone.prepareStatement(sql);
			ps.setInt(1,idPago);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				pag.setIdPago(rs.getInt(1));
				pag.setSaldoPendiente(rs.getInt(2));
				pag.setSaldoApagar(rs.getInt(3));
				VistaPagos=rs.getDate(4).toLocalDate();
				
			}else {
				JOptionPane.showMessageDialog(null,"No se encontro el pago");
			}
			ps.close();
			cone.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al consultar pago"+e);

			
		}
		return pag;
	}
	
	public boolean actualizar(Pagos pag) {
		boolean actuali=false;
		cone=co.conectar();
		try {
			ps=cone.prepareStatement("update pagos set saldoPendiente=?,saldoApagar=?,fechaLimiteParaPagar=? where idPago=?");
			ps.setInt(1,pag.getIdPago());
			ps.setInt(2,pag.getSaldoPendiente());
			ps.setInt(3,pag.getSaldoApagar());
			java.sql.Date sqlDate = new java.sql.Date(pag.getFechaLimiteaPagar().getTime());
			ps.setDate(4, sqlDate);
			int filasModificadas=ps.executeUpdate();
			if(filasModificadas>0) {
				actuali=true;
				JOptionPane.showMessageDialog(null,"Pago actualizado correctamente");
				
			}else {
				JOptionPane.showMessageDialog(null,"Pago no actualizado");

				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al actualizar"+ e);

		}
		return actuali;
		
	}
	public boolean eliminar(int idPago) {
		boolean elimina=false;
		cone=co.conectar();
		try {
			ps=cone.prepareStatement("update pagos set where idPago=?");
			ps.setInt(1, idPago);
			int filasModificadas=ps.executeUpdate();
			if(filasModificadas>0) {
				JOptionPane.showMessageDialog(null,"Pago Eliminado Correctamente");
				
			}else {
				JOptionPane.showMessageDialog(null,"Pago no Eliminado");

				
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
