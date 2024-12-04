package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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
			ps.setBoolean(5,regi.getSexo());
			java.sql.Date sqlDate = new java.sql.Date(regi.getFechaDeNacimiento().getTime());
			ps.setDate(6, sqlDate);
			ps.setString(7, regi.getCurp());
			ps.setInt(8,regi.getNumeroTelefonico());
			ps.setString(9,regi.getCorreoElectronico());
			ps.setString(10,regi.getDireccion());
			ps.setBoolean(11,regi.getActivo());
			int filasModificadas=ps.executeUpdate();
			if(filasModificadas>0) {
				guarda=true;
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
	
	public Registro consultarRegistro(int regi) {
		Registro reg=new Registro();
		String sql="select * from registros where idCliente=?";
		conectar();
		LocalDate VistaRegistro= null;
		try {
			ps=cone.prepareStatement(sql);
			ps.setInt(1, regi);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				reg.setIdCliente(rs.getInt(1));
				reg.setNombre(rs.getString(2));
				reg.setApellidoP(rs.getString(3));
				reg.setApellidoM(rs.getString(4));
				reg.setSexo(rs.getBoolean(5));
				VistaRegistro=rs.getDate(6).toLocalDate();
				reg.setCurp(rs.getString(7));
				reg.setNumeroTelefonico(rs.getInt(8));
				reg.setCorreoElectronico(rs.getString(9));
				reg.setDireccion(rs.getString(10));
				reg.setActivo(rs.getBoolean(11));
				
				
			}else {
				JOptionPane.showMessageDialog(null,"No se encontraron los datos");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al consultar los datos"+e);

			
		}
		return reg;
	}
	public boolean actualizar(Registro regi) {
		boolean actuali=false;
		conectar();
		try {
			ps=cone.prepareStatement("update registros set nombre=?,apellidoPaterno=?,apellidoMaterno=?,sexo=?,fechaDeNacimiento=?,curp=?,numeroTelefonico=?,correoElectronico=?,direccion=?,activo=true,where idCliente=?");
			ps.setInt(1,regi.getIdCliente());
			ps.setString(2,regi.getNombre());
			ps.setString(3,regi.getApellidoP());
			ps.setString(4,regi.getApellidoM());
			ps.setBoolean(5,regi.getSexo());
			java.sql.Date sqlDate = new java.sql.Date(regi.getFechaDeNacimiento().getTime());
			ps.setDate(6, sqlDate);
			ps.setString(7, regi.getCurp());
			ps.setInt(8,regi.getNumeroTelefonico());
			ps.setString(9,regi.getCorreoElectronico());
			ps.setString(10,regi.getDireccion());
			ps.setBoolean(11,regi.getActivo());
			int filasModificadas=ps.executeUpdate();
			if(filasModificadas>0) {
				actuali=true;
				JOptionPane.showMessageDialog(null,"Datos actualizados correctamente");
				
			}else {
				JOptionPane.showMessageDialog(null,"Datos no actualizados");

				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al actualizar"+ e);

		}
		return actuali;
		
	}
	
	public boolean eliminar(int idCliente) {
		boolean elimina=false;
		conectar();
		try {
			ps=cone.prepareStatement("update registros set activo=false where idClientes=?");
			ps.setInt(1, idCliente);
			int filasModificadas=ps.executeUpdate();
			if(filasModificadas>0) {
				JOptionPane.showMessageDialog(null,"Datos eliminados correctamente");
				
			}else {
				JOptionPane.showMessageDialog(null,"Datos no eliminados");

				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al eliminar"+ e);

		}
		return elimina;
		
	}
	
	


}
