<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
        <title>Création d'un kit d'entrée</title>
        <link type="text/css" rel="stylesheet" href="style.css" />
    </head>
<body style="background-image:url(image/bachground.jpg)" >
<div >
<form method="post" action="<c:url value="/creationkitmin"/>">
<fieldset>
<legend>Informations</legend>
<p >cette fenetre vous permet de créer votre base de données</p>
<p>à partir d'un kitmin (base vide ) qui contient les tables du modèle</p>
<label for="nomzone">Nom de la zone détude : <span class="requis"></span></label>
<input type="text" id="nomzone" name="nomzone" value="" size="30" maxlength="30" />
<span class="erreur"></span>
<br />
<br />
<label for="description">Description de la zone détude : </label>
<input type="text" id="description" name="description" value="" size="50" maxlength="50" />
<span class="erreur"></span>
<br />
<br />
<label for="adresse">Institution :</label>
<input type="text" id="adresse" name="adresse" value="" size="30" maxlength="60" />
<span class="erreur"></span>
<br />
<br />

<label for="nombase">Nom de votre base :<span class="requis">*</span></label>
<input type="text" id="base" name="nombase" value="" size="30" maxlength="30" />
<span class="erreur">${form.erreurs['nombase']}</span>
<br />
<br />
</fieldset>
 <p class="info">${ form.resultat }</p>
 <input type="submit" value="Valider"  />
 <input type="reset" value="Remettre à zéro" /> 
 <br />
</form>
</div>
</body>
</html>