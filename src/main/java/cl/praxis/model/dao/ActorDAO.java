package cl.praxis.model.dao;

import java.util.List;

import cl.praxis.model.dto.Actor;

/*
 * C = create - crear
 * R = read - leer
 * U = update - actualizar
 * D = delete - borrar
 */
public interface ActorDAO {
	void create(Actor a);
	Actor read(int id);
	List<Actor> read();
	void update(Actor a);
	void delete(int id);
}
