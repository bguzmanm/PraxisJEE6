package cl.praxis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.praxis.model.dao.ActorDAO;
import cl.praxis.model.dto.Actor;

@WebServlet("/actors")
public class ActorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ActorController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ActorDAO aDAO = new ActorDAO();
		
		List<Actor> actores = aDAO.read();
		
		request.setAttribute("actores", actores);
		
		getServletContext().getRequestDispatcher("/views/actors.jsp").forward(request, response);
		
			
		//actores.stream().forEach(System.out::println);
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
