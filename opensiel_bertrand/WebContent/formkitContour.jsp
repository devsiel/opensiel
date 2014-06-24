<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
        <title>Création d'un kit d'entrée : Contour de l'observatoire (Polygon)</title>
        <link type="text/css" rel="stylesheet" href="style.css" />
 </head>
<body style="background-image:url(image/bachground.jpg)" >
<div >
<form  method="post" enctype="multipart/form-data"  action="<c:url value="/upload"/>">
<fieldset>
<legend>Informations</legend>
<p>cette fenetre vous permet de créer votre kit d'entée</p>
<p> qui contiendra vos couches spatiales en format shape (.shp)</p>
<p> Création de : Contour de l'observatoire (Polygon))</p>
<br />
<br />
<label for="shp">fichier .shp : <span class="requis">*</span></label>
<input name="shp" type="file" id="shp" size="50" />
<br />
<br />
<label for="dbf">fichier .dbf : <span class="requis">*</span></label>
<input  type="file" name="dbf" id="dbf" size="50" />
<br />
<br />
<label for="shx">fichier .shx <span class="requis">*</span></label>
<input name="shx" type="file" id="shx" size="50" />
<span class="erreur"></span>
<br />
 <input type="submit" value="Valider"  />
 <input type="reset" value="Remettre à zéro" /> 
<br />
<br />
</fieldset>
<p class="info">${resultat}</p>
</form>
</div>
</body>
</html>