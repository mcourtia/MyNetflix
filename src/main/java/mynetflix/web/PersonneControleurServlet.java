package mynetflix.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mynetflix.modele.Civilite;
import mynetflix.modele.FormulaireInvalide;
import mynetflix.modele.Personne;

@WebServlet("/addPersonne")
public class PersonneControleurServlet extends HttpServlet {

	private static final String VUE_FORM = "/WEB-INF/jsp/formPersonne.jsp";
	private static final String VUE_ACCUEIL = "/WEB-INF/jsp/accueil.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Map<Integer, String> civilite = new Civilite().getCivilites();
			req.setAttribute("civilite", civilite);
			getServletContext().getRequestDispatcher(VUE_FORM).forward(req, resp);
		} catch (SQLException e) {
			req.setAttribute("message", e.getMessage());
			getServletContext().getRequestDispatcher(VUE_FORM).forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		try {
			String nom = req.getParameter("nom");
			String prenom = req.getParameter("prenom");
			String idcivilite = req.getParameter("civilite");
			Personne personne = new Personne(nom, prenom, idcivilite);
			personne.addPersonne();
			getServletContext().getRequestDispatcher(VUE_ACCUEIL).forward(req, resp);
		} catch (FormulaireInvalide | SQLException e) {
			req.setAttribute("message", e.getMessage());
			getServletContext().getRequestDispatcher(VUE_FORM).forward(req, resp);
		}
		
	}
}