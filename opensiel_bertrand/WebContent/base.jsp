<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Création de la base</title>
<head>
	<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />
	<meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1' />
	<link rel='stylesheet' type='text/css' href='style.css' />
</head>
<link href="style.css" rel="stylesheet" type="text/css">
<body>
<table  height="100%" width="100%" >  
<tr>
   <td  colspan="2" height="100" width="100%"><%@ include
     file="header.jsp"%></td>
</tr>
<tr >
   <td id='pagemenu' align="left" valign="top"  width="20%" ><%@ include
     file="menu.jsp"%></td>
   <td align="center" height="100" width="80%"><%@ include
     file="formbase.jsp"%></td>
  </tr>
<tr>
   <td colspan="2" height="100" width="100%"><%@ include
     file="footer.jsp"%></td>
  </tr>
</table>
</body>
</html>