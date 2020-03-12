package BD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class bd {
	
	static final String driver="com.mysql.cj.jdbc.Driver";
	static final String db_url="jdbc:mysql://localhost/bd19202au03e11sql?serverTimezone=UTC";
	static final String user="root";
	static final String pwd="Diego0904";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection com=null;
		Statement stmt= null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		com= DriverManager.getConnection(db_url,user,pwd);
		
		stmt=com.createStatement();
		String sql;
		
		//-----------CONSULTAS MYSQL--------------
		sql="Select * from libros;";
		//-----------------------------------------
		
		ResultSet rs=stmt.executeQuery(sql);
		
		while (rs.next()) {
			
			int id= rs.getInt(1);
			
			String Titulo=rs.getString(2);
			
			String Nombre=rs.getString(3);
			
			String Editorial=rs.getString(4);
			
			int Precio= rs.getInt(5);
			
				System.out.print("-----------------------------------------------------");
				System.out.print("\nCódigo_id: "+id+"\nTítulo: "+Titulo+"\nAutor: "+ Nombre+"\nEditorial: "+Editorial+"\nPecio: "+Precio+"€"+"\n");
				System.out.print("-----------------------------------------------------");
		}
		rs.close();
		stmt.close();
		com.close();
		
		
		
		
	}


}


