<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Predict'if - Inscription</title>
        <link href="inc/css/bootstrap.min.css" rel="stylesheet"/>
        <script src="inc/js/jquery-1.11.2.min.js"></script>
        <script src="inc/js/jquery-ui.min.js"></script>
        <link href="inc/css/jquery-ui.min.css" rel="stylesheet"/>
        
        <style type="text/css">
            #mediums option:nth-child(odd) { background:#f3f2f2; }
        </style>

        <script>
            
            $.datepicker.setDefaults( $.datepicker.regional[ "fr" ] );
            $(document).ready(function () {
                $("#dateNaissance").datepicker({
                    changeMonth: true,
                    changeYear: true,
                    dateFormat: "dd-mm-yy",
                    minDate: "01-01-1900",
                    maxDate: 0,
                    yearRange: "c-100:c+100"
                });
            });

        </script>

    </head>
    <body class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="page-header">
                    <h1 style="text-align: center">Inscription</h1>
                </div>
            </div>
        </div>

        <form class="form-horizontal" action="ActionServlet" method="POST">
            <input type="hidden" name="todo" value="traitement-inscription">

            <div class="row">
                <div class="col-md-6">

                    <div class="form-group">
                        <label for="civilite" class="col-md-2">Civilité </label>
                        <div class="col-md-4">
                            <select class="form-control" name="civilite" id="civilite">
                                <option value="Mme">Madame</option>
                                <option value="M">Monsieur</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="nom" class="col-md-2">Nom </label>
                        <div class="col-md-5">
                            <input type="text" class="form-control" id="nom" name="nom" placeholder="Durand" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="prenom" class="col-md-2">Prenom </label>
                        <div class="col-md-5">
                            <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Paul" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="date_naissance" class="col-md-2">Date de naissance</label>
                        <div class="col-md-2">
                            <select class="form-control" name="jour_naissance">
                                <%
                                    for (int i = 1; i <= 31; i++) {
                                        out.println("<option value=" + i + ">" + i + "</option>");
                                    }
                                %>
                            </select>
                        </div>
                        <div class="col-md-3">
                            <select class="form-control" name="mois_naissance">
                                <option value="1">Janvier</option>
                                <option value="2">Février</option>
                                <option value="3">Mars</option>
                                <option value="4">Avril</option>
                                <option value="5">Mai</option>
                                <option value="6">Juin</option>
                                <option value="7">Juillet</option>
                                <option value="8">Août</option>
                                <option value="9">Septembre</option>
                                <option value="10">Octobre</option>
                                <option value="11">Novembre</option>
                                <option value="12">Decembre</option>
                            </select>
                        </div>

                        <div class="col-md-3">
                            <select class="form-control" name="annee_naissance">
                                <%
                                    for (int i = 1900; i <= 2015; i++) {
                                        out.println("<option value=" + i + ">" + i + "</option>");
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="dateNaissance" class="col-md-2">Date de naissance</label>
                        <div class="col-md-4">
                            <input type="text" id="dateNaissance" name="dateNaissance">
                        </div>

                    </div>

                    <div class="form-group">
                        <label for="adresse" class="col-md-2">Adresse </label>
                        <div class="col-md-6">
                            <input type="text" required class="form-control" id="adresse" name="adresse" placeholder="Ex : 24 avenue des belles fontaines">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="adresse2" class="col-md-2"> </label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" required id="adresse2" name="adresse2" placeholder="Ex : 91600 Savigny sur orge">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="telephone" class="col-md-2">Téléphone </label>
                        <div class="col-md-4">
                            <input type="tel" class="form-control" id="telephone" name="telephone" placeholder="Ex : 0606060606">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courriel" class="col-md-2">Courriel </label>
                        <div class="col-md-5">
                            <input type="email" class="form-control" id="courriel" name="courriel" placeholder="Ex : paul@durand.fr" required >
                        </div>
                    </div>
                </div>


                <div class="col-md-6">
                    <div class="form-group">
                        <label for="mediums" class="col-md-6">Médiums préférés </label>
                        <div class="col-md-8">
                            <select multiple class="form-control" name="mediums" id="mediums" style="height: 100%" required size="20">
                                <c:forEach var="medium" items="${listMedium}">
                                    <c:out value="<option value=${medium.id}> " escapeXml="false" />
                                    <c:out value="${medium.nom}" />
                                    <c:out value="</option>" escapeXml="false"/>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-offset-5 col-md-4">
                    <button type="submit" class="btn btn-default">Valider inscription</button>
                </div>
            </div>


        </form>
    </body>
</html>
