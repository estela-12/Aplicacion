package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Reporte;

public class DataReporte {
	private Conxion co=new Conxion();

	private Connection cone;
	private PreparedStatement ps;
	
	public boolean guardar(String id_Reporte,String fechaLevantamiento, String fechaCorte ,String descripcion) {
		boolean guarda=false;
		String sql="insert into reportes(id_Reporte,fecha_Levantamiento, fecha_Corte, descripsion ) values(?,?,?,?) ";
		cone=co.conectar(); 
		try {
			ps=cone.prepareStatement(sql);
			ps.setString(1, id_Reporte);
			ps.setString(2, fechaLevantamiento);
			ps.setString(3, fechaCorte);
			ps.setString(4, descripcion);
			//java.sql.Date sqlDate = new java.sql.Date(pag.getFechaLimiteaPagar().getTime());
			//ps.setString(4, fechaLimite);
			int filasModificadas=ps.executeUpdate();
			if(filasModificadas>0) {
				guarda=true;
				JOptionPane.showMessageDialog(null,"Reporte realizado correctamente");
				
			}else {
				JOptionPane.showMessageDialog(null,"Reporte no realizado correctamente");

				
			}
			ps.close();
			cone.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al guardar reporte"+ e);

		}
		return guarda;
	}
	public List<Object[]>obtenerReporte(){
		List<Object[]> reporte= new ArrayList<>();
		cone=co.conectar();
		String sql="select * from reportes";
		try {
			ps=cone.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			 while(rs.next()) {
				Object[] repo=new Object[4];
				repo[0]=rs.getString("id_Reporte");
				repo[1]=rs.getDate("fecha_Levantamiento").toString();
				repo[2]=rs.getDate("fecha_Corte").toString();
				repo[3]=rs.getString("descripsion");
				reporte.add(repo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al obtener los reporte"+ e);
		}
		
		return reporte;
	}
	
		
	

public boolean eliminarReporte(String id) {
	//boolean elimi=false;
	String sql="delete from reportes where id_Reporte=?";
	cone=co.conectar();
	try {
		ps=cone.prepareStatement(sql);
		ps.setString(1, id);
		ps.executeUpdate(); 
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		JOptionPane.showMessageDialog(null,"Error al Eliminar el reporte"+ e);
		return false;

	}
	
	
	
	
}
public boolean editarReporte( String id_Reporte,String fechaLevantamiento, String fechaCorte ,String descripcion) {
	
	String sql="update reportes set fecha_Levantamiento=?, fecha_Corte=?, descripsion=? where id_Reporte=?";
	cone=co.conectar();
	try {
		ps=cone.prepareStatement(sql);
		ps.setString(1, fechaLevantamiento);
		ps.setString(2, fechaCorte);
		ps.setString(3, descripcion);
		ps.setString(4, id_Reporte);

		ps.executeUpdate();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		JOptionPane.showMessageDialog(null,"Error al Editar el reporte"+ e);
		return false;

	}
	
	
}
}

	

	


