<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Création d'un horoscope</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="inc/css/bootstrap.min.css" rel="stylesheet">
        <script src="inc/js/jquery-1.11.2.min.js"></script>
        <script src="inc/js/bootstrap.js"></script>
        <link href="inc/css/custom.css" rel="stylesheet">
    </head>

    <body class="container">
        <form class="form-horizontal" action="ActionServlet" method="POST">
            <input type="hidden" name="todo" value="horoscope">
            <div class="row">
                <br/>
                <div class="col-md-4">

                    <fieldset>
                        <legend>Infos Client</legend> 
                        <div class="form-group">
                            <label for="medium" class="col-md-4">Medium </label>
                            <div class="col-md-7"> 
                                <select class="form-control" name="medium" id="medium">
                                <c:forEach var="medium" items="${listMedium}">
                                    <c:out value="<option value=${medium.id}> " escapeXml="false" />
                                    <c:out value="${medium.nom}" />
                                    <c:out value="</option>" escapeXml="false"/>
                                </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group"> 
                            <label for="client" class="col-md-4">Client </label>
                            <div class="col-md-7"> 
                                <select class="form-control" name="client" id="client">
                                    <option value="Client[0]">ToComplete</option>
                                    <option value="Client[1]">ToComplete</option>
                                </select>
                            </div>
                        </div>
                    </fieldset>

                    <br/>
                    <div class="form-group">
                        <label for="prediction" class ="col-md-3">Prédiction</label>
                        <div class="col-md-8">
                            <textarea class="form-control" readonly="readonly" name="prediction" rows="8">
        lorem ipsum ...... TODO TO COMPLETE
                            </textarea>
                        </div>
                        <button class="btn btn-default">Choisir</button>
                    </div>

                    <fieldset>
                        <legend>Prédictions choisies</legend> 
                        <div class="form-group"> 
                            <label for="chTravail" class="col-md-4">Travail </label>
                            <div class="col-md-7"> 
                                <input type="text" name="chTravail" rows="1" class="uneditable-input" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group"> 
                            <label for="chSante" class="col-md-4">Santé </label>
                            <div class="col-md-7"> 
                                <input type="text" name="chSante" rows="1" class="uneditable-input" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group"> 
                            <label for="chTravail" class="col-md-4">Travail </label>
                            <div class="col-md-7"> 
                                <input type="text" name="chTravail" rows="1" class="uneditable-input" readonly="readonly">
                            </div>
                        </div>
                    </fieldset>

                </div>
            </div>

        </form>
    </body>
</html>
</html>
