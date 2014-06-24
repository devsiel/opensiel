<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
        <title>Nous contacter</title>
        <link type="text/css" rel="stylesheet" href="style.css" />
    </head>
<body style="background-image:url(""image/background.jpg") >
<div >
<form  method="post" action="">
<fieldset>
<legend>Informations</legend>
<p >cette fenetre vous permet d'envoyer un message direct, </p>
<p >au Développeurs/Administrateurs de l'application</p>
<label for="nomClient">Nom <span class="requis">*</span></label>
<input type="text" id="nomClient" name="nomClient" value="" size="20" maxlength="30" />
<span class="erreur"></span>
<br />
<br />
<br />
<br />
<label for="emailClient">Adresse email <span class="requis">*</span></label>
<input type="text" id="emailClient" name="emailClient" value="" size="30" maxlength="60" />
<span class="erreur"></span>
<br />
<br />
<label for="message">message </label>
<textarea name="prenomClient" cols="100" rows="20" class="small" id="prenomClient">Entrez Votre message ici...</textarea>
<span class="erreur"></span>
<br />
<br />
<input type="submit" value="Envoyer"  />
<input name="reset" type="reset" value="Effacer" />
<br />
</fieldset>
</form>
</div>
</body>
</html>