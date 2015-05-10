<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Predict'if - Inscription</title>
        <link href="inc/css/bootstrap.min.css" rel="stylesheet">
        <script src="inc/js/bootstrap.min.js"></script>
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
            <input type="hidden" name="todo" value="inscrtion">
            
            <div class="row">
                <div class="col-md-6">

                    <div class="form-group">
                        <label for="civilite" class="col-md-2">Civilité </label>
                        <div class="col-md-4"> 
                            <select class="form-control" name="civilite" id="civilite">
                                <option value="Madame">Madame</option>
                                <option value="Monsieur">Monsieur</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group"> 
                        <label for="nom" class="col-md-2">Nom </label>
                        <div class="col-md-5"> 
                            <input type="text" class="form-control" id="nom" name="nom" placeholder="Durand">
                        </div>
                    </div>

                    <div class="form-group"> 
                        <label for="prenom" class="col-md-2">Prenom </label>
                        <div class="col-md-5"> 
                            <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Paul">
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
                                <option value="January">January</option>
                                <option value="Febuary">Febuary</option>
                                <option value="March">March</option>
                                <option value="April">April</option>
                                <option value="May">May</option>
                                <option value="June">June</option>
                                <option value="July">July</option>
                                <option value="August">August</option>
                                <option value="September">September</option>
                                <option value="October">October</option>
                                <option value="November">November</option>
                                <option value="December">December</option>
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
                        <label for="adresse" class="col-md-2">Adresse </label>
                        <div class="col-md-6"> 
                            <input type="text" class="form-control" id="adresse" name="adresse" placeholder="Ex : 20 avenue albert einstein">
                        </div>      
                    </div>

                    <div class="form-group"> 
                        <label for="telephone" class="col-md-2">Téléphone </label>
                        <div class="col-md-4"> 
                            <input type="tel" class="form-control" id="telephone" name="telephone" placeholder="Ex : 06 06 06 06 06">
                        </div>
                    </div>

                    <div class="form-group"> 
                        <label for="courriel" class="col-md-2">Courriel </label>
                        <div class="col-md-5"> 
                            <input type="email" class="form-control" id="courriel" name="courriel" placeholder="Ex : paul@durand.fr">
                        </div>
                    </div>
                </div>


                <div class="col-md-6">
                    <div class="form-group">
                        <label for="mediums" class="col-md-4">Médiums préférés </label>
                        <div class="col-md-8"> 
                            <select multiple class="form-control" name="mediums" id="mediums">
                                <option value="Completer avec les donnees de la base">To complete</option>
                                <option value="Completer avec les donnees de la base">To complete</option>
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
