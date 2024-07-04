package cl.praxis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.praxis.model.dao.ActorDAO;
import cl.praxis.model.dto.Actor;

@WebServlet("/actorDetails")
public class ActorDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ActorDetailsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strId = request.getParameter("id");
		
		int id = 0;
		
		if (strId != null) {
			id = Integer.parseInt(strId);
		}
		
		if (id > 0) {
			ActorDAO aDAO = new ActorDAO();
			Actor a = aDAO.read(id);
			
			request.setAttribute("actor", a);
			
			getServletContext().getRequestDispatcher("/views/actorDetails.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
