<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation inscription client</title>
        <link href="inc/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="container">
        <div class="page-header">
            <h1 style="text-align: center">Confirmation inscription</h1>
        </div>

        <div class="alert alert-success">
            <strong>Success!</strong> Nous confirmons la création de votre compte.
            Un email de confirmation vient d'être envoyé à l'adresse suivante : 
            <strong>
                <c:out value="${clientInscrit.email}" />  </strong>
        </div>

        <a href="index.jsp" class="btn btn-default">Retour à la page d'accueil</a>

    </body>
</html>
