package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataUsuarios {
	Conxion co=new Conxion();
	private Connection cone;
	private PreparedStatement ps;
	public  boolean validarUsuario(User us) {
        boolean esValido = false;
        String query = "SELECT * FROM usuarios1 WHERE usuario = ? and contrasena = ?";
        cone=co.conectar();
        try {
        	ps=cone.prepareStatement(query);
        	ps.setString(1, us.getUsuario());
        	ps.setString(2, us.getContraseña());
        	
        	ResultSet rs=ps.executeQuery();
        	if(rs.next()) {
        		esValido = true;
        	}
        		
        	//ps.close();
        	//rs.close();
        	//cone.close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esValido;

}
	/* public  String obtenerRol(User us) {
	        String rol = null;
	        String query = "SELECT role FROM usuarios1 WHERE usuario = ?";
	        try {
				ps=cone.prepareStatement(query);
				ps.setString(1, us.getUsuario());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	               
	            }
	            
	         
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			return rol;
	        
	
	}*/
	 public  boolean existeUsuario(User us) {
	 boolean existe = false;
     String query = "SELECT * FROM usuarios1 WHERE usuario = ?";
     cone=co.conectar();
     try {
     	ps=cone.prepareStatement(query);
     	ps.setString(1, us.getUsuario());
     	
     	
     	ResultSet rs=ps.executeQuery();
     	if(rs.next()) {
     		existe = true;
     	}
     		
     	//ps.close();
     	//rs.close();
     	//cone.close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return existe;

}
	 public boolean registrarUsuario(User us, String role) {
		    boolean registrado = false;
		    String query = "INSERT INTO usuarios1 (usuario, contrasena) VALUES (?, ?)";
		    cone = co.conectar();

		    try {
		        ps = cone.prepareStatement(query);
		        ps.setString(1, us.getUsuario());
		        ps.setString(2, us.getContraseña());  
		     

		        int filas = ps.executeUpdate();
		        if (filas > 0) {
		            registrado = true;
		        }
		    } catch (SQLException e) {
		    	// TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		    return registrado;
		}
	/* public boolean registrarUsuario(User usuario) {
		    boolean registrado = false;
		    String query = "INSERT INTO usuarios (usuario, contraseña) VALUES (?, ?, )";

		   
		    if (usuario.getUsuario() == null || usuario.getUsuario().trim().isEmpty()) {
		      //  System.out.println("El nombre de usuario no puede estar vacío.");
		        return false;  
		    }

		    try (Connection con = co.conectar(); 
		         PreparedStatement ps = con.prepareStatement(query)) {

		       
		        ps.setString(1, usuario.getUsuario());   
		        ps.setString(2, usuario.getContraseña()); 
		           

		        int resultado = ps.executeUpdate();
		        if (resultado > 0) {
		            registrado = true;  
		        }

		    } catch (SQLException e) {
		        System.out.println("Error al registrar usuario: " + e);
		    }

		    return registrado;
		}*/

}
