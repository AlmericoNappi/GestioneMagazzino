<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action ="ArticoloSrv">
<input type= "hidden" name="operazione" value="inserimento"/>
Descrizione:
<input type= "text" name="descrizione"/>
Quantità:
<input type= "number" name="quantita"/>

<input type= "submit" value="Invia"/>


</form>
</body>
</html>