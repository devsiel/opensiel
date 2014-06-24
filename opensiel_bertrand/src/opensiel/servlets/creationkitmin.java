package opensiel.servlets;

import java.io.IOException;
import java.sql.SQLException;

import opensiel.forms.*;
import opensiel.beans.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class creationkitmin extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public static final String ATT_BASE= "nombase";
    public static final String ATT_FORM = "form";

    public static final String VUE= "/base.jsp";


    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* À la réception d'une requête GET, simple affichage du formulaire */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
    	creationkitminform form = new creationkitminform();

        /* Traitement de la requête et récupération du bean en résultant */
            kitmin kit = null;
			try {
				kit = form.creerkitmin( request );
			} catch (Exception e) {
				e.printStackTrace();
			}

        /* Ajout du bean et de l'objet métier à l'objet requête */
        //System.out.println(kit.getbasenom());
        request.setAttribute( ATT_BASE, kit );
        request.setAttribute( ATT_FORM, form );
        System.out.println(form.getResultat());
        
            /* Si aucune erreur, alors affichage de la fiche récapitulative */
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        
    }
}