package opensiel.servlets;
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.util.HashMap;
import java.util.Map;

public class loadShape extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String VUE = "/kitentree.jsp";
	public static final String CHAMP_CA= "ca";
	private Map<String, String> erreurs= new HashMap<String, String>();
	private String resultat;
	private static final String SAVE_DIR = "uploadFiles";

	private void setErreur( String champ, String message ) {
	    erreurs.put( champ, message );
	}
	
	public String getResultat() {
	    return resultat;
	}
	
	private static String getNomFichier( HttpServletRequest request ) throws IllegalStateException, ServletException, IOException {
		//Part part = request.getPart(CHAMP_Contour);
	    /* Boucle sur chacun des paramètres de l'en-tête "content-disposition". */
	    //for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
	    	/* Recherche de l'éventuelle présence du paramètre "filename". */
	        //if ( contentDisposition.trim().startsWith("contour") ) {
	            /* Si "filename" est présent, alors renvoi de sa valeur, c'est-à-dire du nom de fichier. */
	           // return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 );
	        //}
	   // }
	    /* Et pour terminer, si rien n'a été trouvé... */
		return  (request.getParameter(CHAMP_CA));
		//return "123456";
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		  
		
		/*String fichier=getNomFichier(request);
	    System.out.println(fichier);
	      
	      try {
	    	  validationFichier( fichier );
	      } catch ( Exception e ) {
	          setErreur(  CHAMP_CA, e.getMessage() );
	      }
			        if ( erreurs.isEmpty() ) {
			        	try {
							lodashape(CHAMP_CA);
							resultat = "Succès.";
						} catch (Exception e) {
							e.printStackTrace();
						}
			        } else {
			            resultat = "Échec.";
			        }
			        request.setAttribute( "erreurs", erreurs);
			        request.setAttribute( "resultat", resultat );
			        System.out.println(this.getResultat());

			            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );*/
		//String appPath = request.getServletContext().getRealPath("");
		//String appPath ="C:";
		// constructs path of the directory to save uploaded file
		String savePath = "C:" + File.separator + SAVE_DIR;
		System.out.println(savePath);
		// creates the save directory if it does not exists
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		
		for (Part part : request.getParts()) {
			String fileName = extractFileName(part);
			part.write(savePath + File.separator + fileName);
		}
		request.setAttribute("resultat", "Succès!");
		getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	
	private void validationFichier( String nomFichier) throws Exception {
		
	    if ( nomFichier == null ) {
	        throw new Exception( "Merci de sélectionner un fichier à envoyer." );
	    }
	    else if (!nomFichier.endsWith("*.shp")){
	    	throw new Exception( "Merci de sélectionner un fichier shape (.shp)." );
	    }
	}
	public Map<String, String> getErreurs() {
	    return erreurs;
	}
	private void lodashape( String nomFichier) throws Exception {
	    System.out.println("123456789");
	}
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
		return "";
	}
}
