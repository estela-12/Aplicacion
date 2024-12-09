package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Pagos;
import modelo.Reporte;

public class DataPAGOS {
	private Conxion co=new Conxion();

	private Connection cone;
	private PreparedStatement ps;

	
	public boolean guardar(String id_Pago, int pagoPendiente, double saldoAPagar,String fechaLimite) {
		boolean guarda=false;
		String sql="insert into pagos1(id_Pago,pagoPendiente, saldoAPagar, fechaLimite ) values(?,?,?,?) ";
		cone=co.conectar(); 
		try {
			ps=cone.prepareStatement(sql);
			ps.setString(1, id_Pago);
			ps.setInt(2, pagoPendiente);
			ps.setDouble(3, saldoAPagar);
			//java.sql.Date sqlDate = new java.sql.Date(pag.getFechaLimiteaPagar().getTime());
			ps.setString(4, fechaLimite);
			int filasModificadas=ps.executeUpdate();
			if(filasModificadas>0) {
				guarda=true;
				JOptionPane.showMessageDialog(null,"Pago realizado correctamente");
				
			}else {
				JOptionPane.showMessageDialog(null,"Pago no realizado correctamente");

				
			}
			ps.close();
			cone.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al guardar pago"+ e);

		}
		return guarda;
	}
	public List<Object[]>obtenerPagos(){
		List<Object[]> pagos= new ArrayList<>();
		cone=co.conectar();
		String sql="select * from pagos1";
		try {
			ps=cone.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			 while(rs.next()) {
				Object[] pago=new Object[4];
				pago[0]=rs.getString("id_Pago");
				pago[1]=rs.getInt("pagoPendiente");
				pago[2]=rs.getDouble("SaldoAPagar");
				pago[3]=rs.getDate("fechaLimite").toString();
				pagos.add(pago);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al obtener los pagos"+ e);
		}
		
		return pagos;
	}
	
		
	

public boolean eliminarPago(String id) {
	//boolean elimi=false;
	String sql="delete from pagos1 where id_Pago=?";
	cone=co.conectar();
	try {
		ps=cone.prepareStatement(sql);
		ps.setString(1, id);
		ps.executeUpdate(); 
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		JOptionPane.showMessageDialog(null,"Error al Eliminar el pago"+ e);
		return false;

	}
	
	
	
	
}
public boolean editarPago( String id_Pago, int pagoPendiente, double saldoAPagar,String fechaLimite) {
	
	String sql="update pagos1 set pagoPendiente=?, saldoAPagar=?, fechaLimite=? where id_Pago=?";
	cone=co.conectar();
	try {
		ps=cone.prepareStatement(sql);
		ps.setInt(1, pagoPendiente);
		ps.setDouble(2, saldoAPagar);
		ps.setString(3, fechaLimite);
		ps.setString(4, id_Pago);

		ps.executeUpdate();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		JOptionPane.showMessageDialog(null,"Error al Editarel pago"+ e);
		return false;

	}
	
	
}
}

