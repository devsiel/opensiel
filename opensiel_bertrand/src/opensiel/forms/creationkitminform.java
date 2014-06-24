package opensiel.forms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import opensiel.beans.kitmin;

public final class creationkitminform {
	private String CHAMP_NOM_BASE = "nombase";
    private String resultat;
    private Map<String, String> erreurs= new HashMap<String, String>();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public kitmin creerkitmin( HttpServletRequest request ) throws Exception {
    	//System.out.println ("creation du kitmin");
        String nom = getValeurChamp( request, CHAMP_NOM_BASE );
        kitmin kit = new kitmin();
        try {
        	validationNombase( nom );
        } catch ( Exception e ) {
            setErreur(  CHAMP_NOM_BASE, e.getMessage() );
        }
                kit.setbasenom( nom );
		        if ( erreurs.isEmpty() ) {
		         kit.creerbase(nom);
		         kit.creerkitmin(nom);
		        		resultat = "Succès de la création de la base.";
		            
		        } else {
		            resultat = "Échec de la création de la base.";
		        }

        return kit;
    }

    private void validationNombase( String nom ) throws Exception {
    	Connection conn=null;
        if ( nom != null ) {
            if ( nom.length() < 2 ) {
                throw new Exception( "Le nom doit contenir au moins 2 caractères." );
            }
            else{
            	
          	     try{
          	    	  Class.forName("org.postgresql.Driver");   
	          	      String url = "jdbc:postgresql://localhost:5432/"+nom;
	          	      String user = "postgres";
	          	      String passwd = "postgres";  
	          	      conn = DriverManager.getConnection(url, user, passwd);
          	     }
          	       catch (Exception b){
       			   b.printStackTrace(); 
       		     }
          	      if (conn!=null){
          	    	  conn.close();
          	    	  throw new Exception( "la base : "+nom+", existe déjà !" );	
                  }
            }  
            
         } else {
            throw new Exception( "Merci d'entrer un nom pour la base de donnée." );
         }
    }


    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

  
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}