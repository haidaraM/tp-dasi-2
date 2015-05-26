<%@page import="modele.Horoscope"%>
<%@page import="Controller.Actions.HoroscopeFormAction"%>
<%@page import="modele.Client"%>
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
            <h1 style="text-align: center">Confirmation création horoscope</h1>
        </div>

        <div class="alert alert-success">
            <strong>Success!</strong> L'horoscope à bien été crée pour le client.
        </div>

        <div id="detail">
            <h3>
                Récapitulatif de la création de l'horoscope - Mail envoyé à l'utilisateur
            </h3>

            <div id="civilite">
                ${client.civilite} <strong> ${client.prenom} ${client.nom} </strong> <br/>
                ${client.adresse} <br/>
                ${client.tel}
            </div>

            <div id="moreInfo">
                Votre numéro de client : ${client.id} <br/>
                Votre signe : ${client.signe.nom} <br/>
                Vos mediums favoris : <c:forEach var="medium" items="${listMedium}">
                    ${medium.nom}; 
                </c:forEach> <br/>
                
                Le <% java.text.DateFormat df=new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
                <%= df.format(new java.util.Date()) %> <br/>
                Cher(e) ${client.prenom}, aujourd'hui votre voyance vous est offerte par ${horoscope.medium.nom}.<br/>
                Travail (${horoscope.pT.icone}) : ${horoscope.pT.texte} <br/>
                Sante (${horoscope.pS.icone}) : ${horoscope.pS.texte} <br/> 
                Amour (${horoscope.pA.icone}) : ${horoscope.pA.texte} <br/> 
                Votre signe partenaire : ${horoscope.pA.partenaire} <br/>
            </div>
        </div>
        <br/>
        <a href="index.jsp" class="btn btn-default">Retour à la page d'accueil</a>

    </body>
</html>
