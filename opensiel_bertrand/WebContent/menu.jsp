<%@ page pageEncoding="UTF-8" %>

<html >
<title>Menu OpenSIEL1.0</title>
<head>
	<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />
	<meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1' />
	<link rel='stylesheet' type='text/css' href='style.css' />
</head>
<body>
<div id='cssmenu'> Menu OpenSIEL1.0
<ul>
   <li class='active'><a href='index.jsp'><span>Home</span></a></li>
   <li class='has-sub'><a><span>Outils</span></a>
      <ul>
         <li class='last'><a href='base.jsp'><span>Créer une base de données</span></a></li>
         <li class='has-sub'><a><span>Créer un Kit d'entrée</span></a>
              <ul>
               <li><a href='kitentreeCa.jsp'><span>Uploader Shape Centre d'Activitée</span></a></li>
               <li class='last'><a href='kitentreeContour.jsp'><span>Uploader Shape Contour de l'Observatoire</span></a></li>
               <li><a href='kitentreeAptitude.jsp'><span>Uploader Shape Aptitude Sol</span></a></li>
               <li class='last'><a href='kitentreeUP.jsp'><span>Uploader Shape UP</span></a></li>
              </ul>
         </li>     
         <li class='last'><a href='modifier.jsp'><span>Modifier la base </span></a></li>
         <li class='last'><a href='couche.jsp'><span>Modifier les couches</span></a></li>
		 <li class='last'><a href='jointure.jsp'><span>Jointure</span></a></li>
      </ul>
   </li>
   <li class='has-sub'><a><span>Modélisation OpenSIEL</span></a>
      <ul>
         <li class='last'><a href='lancer.jsp'><span>Lancer Une Modélisation</span></a>
         <li class='has-sub'><a><span>Délimittation des Territoires</span></a>
            <ul>
               <li><a href='delimitation.jsp'><span>Délimittation</span></a></li>
               <li class='last'><a href='validation.jsp'><span>Validation</span></a></li>
            </ul>
         </li>
		 <li class='has-sub'><a><span>Spatialisation des UPC</span></a>
            <ul>
               <li><a href='besoin.jsp'><span>Calculs des Besoins</span></a></li>
               <li class='last'><a href='upc.jsp'><span>Construction des UPC</span></a></li>
			   <li class='last'><a href='validation.jsp'><span>Validation</span></a></li>
            </ul>
         </li>
		 <li class='last'><a href='usr.jsp'><span>Construction des USR</span></a></li>
		 <li class='has-sub'><a><span>Indices de Risque</span></a>
            <ul>
               <li><a href='disponibilitee.jsp'><span>Disponibilitée</span></a></li>
               <li class='last'><a href='prelevement.jsp'><span>Prélèvement</span></a></li>
			   <li class='last'><a href='bilan.jsp'><span>Bilan</span></a></li>
			   <li class='last'><a href='indice.jsp'><span>Indices Spatialisés</span></a></li>
            </ul>
         </li>
		 <li class='last'><a href='export.jsp'><span>Export</span></a></li>
      </ul>
   </li>
   <li class='last'><a href='contact.jsp'><span>Contact</span></a></li>
</ul>
</div>
<p>&nbsp;</p>
<form method="post" action="siel.jsp">
 <p class="small" align="left">Entrer Login et password.</p>
 <table align="left" bgcolor="#e0e0e0">
 <tr>
   <td class="small">Login id</td>
   <td><input name=loginid size=14 class="small"></td>
  </tr>
  <tr>
   <td  class="small">Password</td>
   <td><input name=password type="password" size=14 class="small"></td>
  </tr>
 
  <tr>
   <td align="center"><input type="submit" value="Login" />
    </td>
 </tr>
  </table>
</form>

</body>
</html>