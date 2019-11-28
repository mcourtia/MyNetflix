package mynetflix.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mynetflix.dao.AffectationDAO;
import mynetflix.dao.SaisonDAO;
import mynetflix.dao.SerieDAO;
import mynetflix.dao.StatutDAO;
import mynetflix.modele.FormulaireInvalide;
import mynetflix.modele.Saison;
import mynetflix.modele.Serie;
import mynetflix.modele.Statut;

@WebServlet("/addSaison")
public class SaisonControleurServlet extends HttpServlet {
	private static final String VUE_FORM = "/WEB-INF/jsp/formSaison.jsp";
	private static final String VUE_RECAP = "/WEB-INF/jsp/recap.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idaffectation = new AffectationDAO().selectIdAffectation("Série");
		List<Statut> statut = new StatutDAO().selectStatut(idaffectation);
		List<Serie> serie = new SerieDAO().selectSerie();
		req.setAttribute("statut", statut);
		req.setAttribute("serie", serie);
		getServletContext().getRequestDispatcher(VUE_FORM).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		try {
			String numero = req.getParameter("numero");
			String resume = req.getParameter("resume");
			String annee_diffusion = req.getParameter("annee_diffusion");
			String idstatut = req.getParameter("idstatut");
			String idserie = req.getParameter("idserie");
			Saison saison = new Saison(numero, resume, annee_diffusion, idstatut, idserie);
			new SaisonDAO().insertSaison(saison);
			getServletContext().getRequestDispatcher(VUE_RECAP).forward(req, resp);
		} catch (FormulaireInvalide e) {
			int idaffectation = new AffectationDAO().selectIdAffectation("Série");
			List<Statut> statut = new StatutDAO().selectStatut(idaffectation);
			List<Serie> serie = new SerieDAO().selectSerie();
			req.setAttribute("statut", statut);
			req.setAttribute("serie", serie);
			req.setAttribute("message", e.getMessage());
			getServletContext().getRequestDispatcher(VUE_FORM).forward(req, resp);
		}
		
	}
}