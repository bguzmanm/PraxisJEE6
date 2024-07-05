package cl.praxis.model.dao;

import java.util.List;

import cl.praxis.model.dto.Customer;

public interface CustomerDAO {
	void create(Customer c);
	Customer read(int id);
	List<Customer> read();
	void update(Customer c);
	void delete(int id);
}
