package mynetflix.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mynetflix.dao.AffectationDAO;
import mynetflix.dao.EpisodeDAO;
import mynetflix.dao.PublicDAO;
import mynetflix.dao.SaisonDAO;
import mynetflix.dao.SerieDAO;
import mynetflix.dao.StatutDAO;
import mynetflix.modele.Episode;
import mynetflix.modele.FormulaireInvalide;
import mynetflix.modele.PublicAge;
import mynetflix.modele.Saison;
import mynetflix.modele.Serie;
import mynetflix.modele.Statut;

@WebServlet("/addEpisode")
public class EpisodeControleurServlet extends HttpServlet {
	private static final String VUE_FORM = "/WEB-INF/jsp/formEpisode.jsp";
	private static final String VUE_RECAP = "/WEB-INF/jsp/recap.jsp";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		try {
			String numero = req.getParameter("numero");
			String titre = req.getParameter("titre");
			String titreoriginal = req.getParameter("titreoriginal");
			String duree = req.getParameter("duree");
			String resume = req.getParameter("resume");
			String dateReal = req.getParameter("dateReal");
			String dateDiff = req.getParameter("dateDiff");
			String idstatut = req.getParameter("idstatut");
			String idpublic = req.getParameter("idpublic");
			String idsaison = req.getParameter("idsaison");
			Episode episode = new Episode(numero, titre, titreoriginal, duree, resume, dateReal, dateDiff, idpublic, idstatut, idsaison);
			new EpisodeDAO().insertEpisode(episode);
			getServletContext().getRequestDispatcher(VUE_RECAP).forward(req, resp);
		} catch (FormulaireInvalide e) {
			int idserie = Integer.valueOf(req.getParameter("idserie"));
			int idaffectation = new AffectationDAO().selectIdAffectation("Episode");
			List<Statut> statut = new StatutDAO().selectStatut(idaffectation);
			List<PublicAge> publicAge = new PublicDAO().selectPublic();
			List<Saison> saison = new SaisonDAO().selectSaison(idserie);
			Serie serie = new SerieDAO().selectSerie(idserie);
			req.setAttribute("serie", serie);
			req.setAttribute("statut", statut);
			req.setAttribute("publicAge", publicAge);
			req.setAttribute("saison", saison);
			req.setAttribute("message", e.getMessage());
			getServletContext().getRequestDispatcher(VUE_FORM).forward(req, resp);
		}
		
	}
}
