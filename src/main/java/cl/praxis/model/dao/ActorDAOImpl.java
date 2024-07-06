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

public class ActorDAOImpl implements ActorDAO {

	public void create(Actor a) {

		String sql = "insert into actor (first_name, last_name) values ('" + a.getFirstName() + "', '" + a.getLastName() + "')";
		
		System.out.println(sql);
		
		try {
			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			s.execute(sql);
		}  catch (SQLException e) {
			System.out.println("ERROR en método create()");
			e.printStackTrace();
		}
		
	}

	public Actor read(int id) {
		Actor a = null;

		try {
			Connection c = Conexion.getCon();

			Statement s = c.createStatement();
			String sql = "select actor_id, first_name, last_name from actor where actor_id = " + id;

			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				a = new Actor(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name"));
			}
		} catch (SQLException e) {
			System.out.println("ERROR en método read(id)");
			e.printStackTrace();
		}

		return a;
	}

	public List<Actor> read() {

		List<Actor> actores = new ArrayList<Actor>();

		try {

			// pido una conección a la BD
			Connection c = Conexion.getCon();

			Statement s = c.createStatement();
			String sql = "select actor_id, first_name, last_name from actor";

			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				actores.add(new Actor(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name")));
			}

		} catch (SQLException e) {
			System.out.println("ERROR en método read()");
			e.printStackTrace();
		}

		return actores;
	}

	public void update(Actor a) {
		String sql = "update actor set first_name = '" + a.getFirstName() + "', last_name = '" + a.getLastName()
				+ "' where actor_id = " + a.getId();

		try {
			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			
			s.execute(sql);

		} catch (SQLException e) {
			System.out.println("ERROR en método update()");
			e.printStackTrace();
		}

	}

	public void delete(int id) {
		String sql = "delete from actor where actor_id = " + id;
		try {
			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			s.execute(sql);
			
		} catch (SQLException e) {
			System.out.println("ERROR en método delete()");
			e.printStackTrace();
		}
	}

}
