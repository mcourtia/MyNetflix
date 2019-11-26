package mynetflix.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mynetflix.modele.FormulaireInvalide;
import mynetflix.modele.Statut;

@WebServlet("/addSerie")
public class SerieControleurServlet extends HttpServlet {
	private static final String VUE_FORM = "/WEB-INF/jsp/formSerie.jsp";
	private static final String VUE_ACCUEIL = "/WEB-INF/jsp/accueil.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Map<Integer, String> statut = new Statut().getStatuts();
			req.setAttribute("statut", statut);
			getServletContext().getRequestDispatcher(VUE_FORM).forward(req, resp);
		} catch (SQLException e) {
			req.setAttribute("message", e.getMessage());
			getServletContext().getRequestDispatcher(VUE_FORM).forward(req, resp);
		}
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		try {
//			String nom = req.getParameter("nom");
//			Serie serie = new Serie();
//			serie.addSerie();
//			getServletContext().getRequestDispatcher(VUE_ACCUEIL).forward(req, resp);
//		} catch (FormulaireInvalide | SQLException e) {
//			req.setAttribute("message", e.getMessage());
//			getServletContext().getRequestDispatcher(VUE_FORM).forward(req, resp);
//		}
//		
//	}
}
