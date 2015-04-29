package br.edu.horus;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class TestConnection {

	public static void main(String[] args) throws Exception{
		final Connection connection =
		
		DriverManager.getConnection(
				"jdbc:hsqldb:file:target/database;hsqldb.lock_file=false;");
				
		
		Path path = new File("src/main/java/ddl.sql").toPath();
		byte[] bytes = Files.readAllBytes(path);
		String sql = new String(bytes);
		System.err.println(sql);
		
		connection.createStatement().execute(sql);
		
		String insert = "INSERT INTO teste (id,nome,nascido_em, genero)"
				+ "VALUES(1,'José','2015-01-01', 'M');";
		connection.createStatement().execute(insert);
		
		String insert2 = "INSERT INTO teste (id,nome,nascido_em, genero)"
				+ "VALUES(2,'Pedro','2012-02-28', 'M');";
		connection.createStatement().execute(insert2);
		
		String select = "SELECT * FROM teste";
		
		ResultSet resultSet = connection.createStatement()
				.executeQuery(select);		
		
		while (resultSet.next()) {
			char genero = resultSet.getString("genero").charAt(0);
			Date nascidoEm = resultSet.getDate("nascido_em");
			String nome = resultSet.getString("nome");
			Integer id = resultSet.getInt("id");
			System.out.println(id + " " +nome+" "+nascidoEm);
		}
		
		
		
		
		
		
	}
	
}
