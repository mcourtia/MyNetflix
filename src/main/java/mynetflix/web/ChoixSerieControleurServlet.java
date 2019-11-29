package mynetflix.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mynetflix.dao.AffectationDAO;
import mynetflix.dao.PublicDAO;
import mynetflix.dao.SaisonDAO;
import mynetflix.dao.SerieDAO;
import mynetflix.dao.StatutDAO;
import mynetflix.modele.FormulaireInvalide;
import mynetflix.modele.PublicAge;
import mynetflix.modele.Saison;
import mynetflix.modele.Serie;
import mynetflix.modele.Statut;

@WebServlet("/choixSerie")
public class ChoixSerieControleurServlet extends HttpServlet {
	private static final String VUE_CHOIX = "/WEB-INF/jsp/formChoixSerie.jsp";
	private static final String VUE_FORM = "/WEB-INF/jsp/formEpisode.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Serie> serie = new SerieDAO().selectSerie();
		req.setAttribute("serie", serie);
		getServletContext().getRequestDispatcher(VUE_CHOIX).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		try {
			int idserie = Integer.valueOf(req.getParameter("idserie"));
			if (idserie == 0) {
				throw new FormulaireInvalide("Veuillez sélectionner une série !");
			}
			int idaffectation = new AffectationDAO().selectIdAffectation("Episode");
			List<Statut> statut = new StatutDAO().selectStatut(idaffectation);
			List<PublicAge> publicAge = new PublicDAO().selectPublic();
			List<Saison> saison = new SaisonDAO().selectSaison(idserie);
			Serie serie = new SerieDAO().selectSerie(idserie);
			req.setAttribute("serie", serie);
			req.setAttribute("statut", statut);
			req.setAttribute("publicAge", publicAge);
			req.setAttribute("saison", saison);
			getServletContext().getRequestDispatcher(VUE_FORM).forward(req, resp);
		} catch (FormulaireInvalide e) {
			List<Serie> serie = new SerieDAO().selectSerie();
			req.setAttribute("serie", serie);
			req.setAttribute("message", e.getMessage());
			getServletContext().getRequestDispatcher(VUE_CHOIX).forward(req, resp);
		}
		
	}
}