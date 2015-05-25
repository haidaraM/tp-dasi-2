<%@page import="Utilities.Erreur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erreur! </title>
        <link href="inc/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="container">

        <div class="page-header">
            <h1 style="text-align: center">${erreurTitre}</h1>

        </div>

        <div class="alert alert-danger" role="alert">
            <%
                Integer erreur = (Integer) request.getAttribute(Erreur.ATT_ERREUR);
                if (erreur != null) {

                    switch (erreur) {
                        case Erreur.ERR_INSCRIPTION_CLIENT:
            %>
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only">Error:</span>
            Un problème est servenu lors de la création de votre compte.
            <%
                    break;
                case Erreur.ERR_CREATION_HOROSCOPE:
            %>
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only">Error:</span>
            Un problème est servenu lors de la création de l'horoscope.
            <%
                    break;
                case Erreur.ERR_CONNEXION_EMPLOYE:
            %>
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only">Error:</span>
            Problème de connexion. <strong>Login</strong> ou <strong>mot de passe incorrect </strong>
            <%
                    break;
                case Erreur.ERR_ACCES_REFUSE:
            %>
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only">Error:</span>
            Vous devez vous connecter pour acceder à cette page
            <%
                    break;
                default:
            %>
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only">Error:</span> Une erreur est survenue
            <% break;

                    }
                }
            %>
        </div>
        <a href="index.jsp" class="btn btn-default">Retour à la page d'accueil</a>
    </body>
</html>
