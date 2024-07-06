package cl.praxis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.praxis.model.dao.ActorDAOImpl;
import cl.praxis.model.dao.ActorDAO;
import cl.praxis.model.dto.Actor;

@WebServlet("/actorDetails")
public class ActorDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ActorDetailsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("op");
		String strId = request.getParameter("id");
		
		int id = 0;
		
		if (strId != null) {
			id = Integer.parseInt(strId);
		}
		
		if (id > 0 && op==null) {
			ActorDAOImpl aDAO = new ActorDAOImpl();
			Actor a = aDAO.read(id);
			
			request.setAttribute("actor", a);
			
			getServletContext().getRequestDispatcher("/views/actorDetails.jsp").forward(request, response);
		} else if (id == 0) {
			getServletContext().getRequestDispatcher("/views/actorDetails.jsp").forward(request, response);
		} else if (op.equalsIgnoreCase("del")) {
			ActorDAOImpl aDAO = new ActorDAOImpl();
			aDAO.delete(id);
			
			response.sendRedirect(request.getContextPath() + "/actors");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strId = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		Actor a = null;
		ActorDAO aDAO = new ActorDAOImpl();
				
		if (!strId.isEmpty()) {
			int id = Integer.parseInt(strId);
			
			a = new Actor(id, firstName, lastName);
			aDAO.update(a);
		} else {
			a = new Actor();
			a.setFirstName(firstName);
			a.setLastName(lastName);
			
			aDAO.create(a);
		}
	
		response.sendRedirect(request.getContextPath() + "/actors");
		
	}

}
