package cl.praxis.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.praxis.model.conexion.Conexion;
import cl.praxis.model.dto.Actor;

/*
 * C = create - crear
 * R = read - leer
 * U = update - actualizar
 * D = delete - borrar
 */

public class ActorDAO {

	public void create(Actor a) {
		// implementar la lógica para crear un actor
	}
	
	public Actor read(int id) {
		Actor a = null;
		
		try {
			Connection c = Conexion.getCon();
			
			Statement s = c.createStatement();
			String sql ="select actor_id, first_name, last_name from actor where actor_id = " + id;
			
			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				a = new Actor(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name"));
			}
		} catch(SQLException e) {
			System.out.println("ERROR en método read(id)");
			e.printStackTrace();
		}
		
		
		return a;
	}
	
	public List<Actor> read(){
		
		List<Actor> actores = new ArrayList<Actor>();
		
		try {
			
			// pido una conección a la BD
			Connection c = Conexion.getCon();
		
			Statement s = c.createStatement();
			String sql ="select actor_id, first_name, last_name from actor";
			
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				
				/* Actor a = new Actor();
				
				a.setId(rs.getInt("actor_id"));
				a.setFirstName(rs.getString("first_name"));
				a.setLastName(rs.getString("last_name"));
				
				actores.add(a);*/
				
				actores.add(new Actor(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name")));
				
			}		
			
		} catch (SQLException e) {
			System.out.println("ERROR en método read()");
			e.printStackTrace();
		}
		
		return actores;
	}
	
	public void update(Actor a) {
		// implementar la lógica para actualizar un actor
	}
	
	public void delete(int id) {
		// implementar la lógica para borrar un actor
	}
	
}
