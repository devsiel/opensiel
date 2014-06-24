package opensiel.servlets;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig(fileSizeThreshold=1024*1024*2,	// 2MB 
maxFileSize=1024*1024*10,		// 10MB
maxRequestSize=1024*1024*50)	// 50MB
public class Upload extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/kitentree.jsp";
	public static final String CHAMP_CA= "ca";
	private String erreur= "";
	private String resultat;
	private static final String SAVE_DIR = "uploadFiles";
	public String getResultat() {
	    return resultat;
	}
	/**
	 * 
	 */
	/**
	 * Name of the directory where uploaded files will be saved, relative to
	 * the web application directory.
	 */
	
	/**
	 * handles file upload
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// gets absolute path of the web application
		String appPath =request.getServletContext().getRealPath("");
		// constructs path of the directory to save uploaded file
		String savePath = appPath + File.separator + SAVE_DIR;
		System.out.println(savePath);
		// creates the save directory if it does not exists
		File fileSaveDir = new File("C:"+ File.separator + SAVE_DIR);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		
	if (request.getParts()!=null){
		for ( Part part : request.getParts()) {
			String fileName = extractFileName(part);
			try {
				validationFichier( fileName );
	        } catch ( Exception e ) {
	           erreur=  fileName+" : "+ e.getMessage();
	        }
			part.write(savePath + File.separator + fileName);
		}

		request.setAttribute("resultat", "Upload has been done successfully!");}
	else{request.setAttribute("resultat", "Upload errors!");}
	
	request.setAttribute( "erreur", erreur);
    System.out.println(this.getResultat());

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * Extracts file name from HTTP header content-disposition
	 */
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
private void validationFichier( String nomFichier) throws Exception {
	    if (!nomFichier.endsWith(".shp")){
	    	throw new Exception( "Merci de sélectionner un fichier shape (.shp)." );
	    }
	}
}