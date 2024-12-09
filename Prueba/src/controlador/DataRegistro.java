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

import modelo.Registro;

public class DataRegistro {
	private Conxion co=new Conxion();
	private Connection cone;
	private PreparedStatement ps;
	
	
	public boolean guardar(String id_Registro, String nombre, String apellidoPaterno, String apellidoMaterno, 
            String sexo, String fechaNacimiento, String direccion, String curp, 
            String telefono, String correo) {
		boolean guarda=false;
		String sql="insert into persona (id_registro, nombre, apellido_paterno, apellido_materno, sexo, fecha_nacimiento, direccion, curp, telefono, correo_electronico ) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		cone=co.conectar(); 
		try {
			ps=cone.prepareStatement(sql);
			ps.setString(1, id_Registro);
			ps.setString(2, nombre);
            ps.setString(3, apellidoPaterno);
            ps.setString(4, apellidoMaterno);
            ps.setString(5, sexo);
            ps.setString(6, fechaNacimiento);
            ps.setString(7, direccion);
            ps.setString(8, curp);
            ps.setString(9, telefono);
            ps.setString(10, correo);
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
	public List<Object[]>obtenerPersonas(){
		List<Object[]> personas= new ArrayList<>();
		cone=co.conectar();
		String sql="select * from persona";
		try {
			ps=cone.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			 while(rs.next()) {
				 personas.add(new Object[] {
		                    rs.getString("id_registro"),
		                    rs.getString("nombre"),
		                    rs.getString("apellido_paterno"),
		                    rs.getString("apellido_materno"),
		                    rs.getString("sexo"),
		                    rs.getDate("fecha_nacimiento").toString(),
		                    rs.getString("direccion"),
		                    rs.getString("curp"),
		                    rs.getString("telefono"),
		                    rs.getString("correo_electronico")
		                });
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al obtener los pagos"+ e);
		}
		
		return personas;
	}
	
		
	

public boolean eliminarPersona(String idPersona) {
	//boolean elimi=false;
	String sql="delete from persona where id_registro=?";
	cone=co.conectar();
	try {
		ps=cone.prepareStatement(sql);
		ps.setString(1, idPersona);
		ps.executeUpdate(); 
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		JOptionPane.showMessageDialog(null,"Error al Eliminar el pago"+ e);
		return false;

	}
	
	
	
	
}
public boolean editarPersona(String id_Persona, String nombre, String apellidoPaterno, String apellidoMaterno, 
        String sexo, String fechaNacimiento, String direccion, String curp, 
        String telefono, String correo) {
	
	String sql="update persona set nombre = ?, apellido_paterno = ?, apellido_materno = ?, sexo = ?, fecha_nacimiento = ?, direccion = ?, curp = ?, telefono = ?, correo_electronico = ? WHERE id_registro = ?";
	cone=co.conectar();
	try {
		ps=cone.prepareStatement(sql);
		  ps.setString(1, nombre);
          ps.setString(2, apellidoPaterno);
          ps.setString(3, apellidoMaterno);
          ps.setString(4, sexo);
          ps.setString(5, fechaNacimiento);
          ps.setString(6, direccion);
          ps.setString(7, curp);
          ps.setString(8, telefono);
          ps.setString(9, correo);
          ps.setString(10, id_Persona);
          ps.executeUpdate();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		JOptionPane.showMessageDialog(null,"Error al Editar el pago"+ e);
		return false;

	}
	
}
}

