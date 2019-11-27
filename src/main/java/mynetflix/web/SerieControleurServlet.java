package mynetflix.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mynetflix.dao.AffectationDAO;
import mynetflix.dao.PaysDAO;
import mynetflix.dao.PersonneDAO;
import mynetflix.dao.SerieDAO;
import mynetflix.dao.StatutDAO;
import mynetflix.modele.FormulaireInvalide;
import mynetflix.modele.Pays;
import mynetflix.modele.Serie;
import mynetflix.modele.Statut;

@WebServlet("/addSerie")
public class SerieControleurServlet extends HttpServlet {
	private static final String VUE_FORM = "/WEB-INF/jsp/formSerie.jsp";
	private static final String VUE_ACCUEIL = "/WEB-INF/jsp/accueil.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idaffectation = new AffectationDAO().selectIdAffectation("Série");
		List<Statut> statut = new StatutDAO().selectStatut(idaffectation);
		List<Pays> pays = new PaysDAO().selectPays();
		req.setAttribute("statut", statut);
		req.setAttribute("pays", pays);
		getServletContext().getRequestDispatcher(VUE_FORM).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		try {
			String nom = req.getParameter("nom");
			String nomoriginal = req.getParameter("nomoriginal");
			String synopsys = req.getParameter("synopsys");
			String anneeparution = req.getParameter("anneeparution");
			String idstatut = req.getParameter("idstatut");
			String idpays = req.getParameter("idpays");
			Serie serie = new Serie(nom, nomoriginal, synopsys, anneeparution, idstatut, idpays);
			new SerieDAO().insertSerie(serie);
			getServletContext().getRequestDispatcher(VUE_ACCUEIL).forward(req, resp);
		} catch (FormulaireInvalide e) {
			req.setAttribute("message", e.getMessage());
			getServletContext().getRequestDispatcher(VUE_FORM).forward(req, resp);
		}
		
	}
}
