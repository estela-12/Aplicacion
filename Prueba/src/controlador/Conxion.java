package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conxion {
	private Connection cone;
	private PreparedStatement ps;
	public Connection conectar() {
		try {
			cone=DriverManager.getConnection("jdbc:mysql://localhost:3306/mahe6","root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al conectar"+ e);
		}
		return cone;
	}

}
