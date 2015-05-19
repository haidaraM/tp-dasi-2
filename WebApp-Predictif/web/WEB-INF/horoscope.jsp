<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Création d'un horoscope</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="inc/css/bootstrap.min.css" rel="stylesheet">
        <link href="inc/css/dataTables.bootstrap.css" rel="stylesheet">
        <script src="inc/js/jquery-1.11.2.min.js"></script>
        <script src="inc/js/jquery.dataTables.min.js"></script>
        <script src="inc/js/dataTables.bootstrap.js"></script>

        <script>
            $(document).ready(function () {


                $('#choisir').attr('disabled', true);
                
                $('#listPrediction').DataTable({
                    scrollY: 405,
                    paging: false,
                    "drawCallback": function () {
                        $('.monTexte').css("max-height", "15px");
                        $('.monTexte').css("max-width", '15px');
                        $('.monTexte').css("white-space", "nowrap");
                        $('.monTexte').css("overflow", "hidden");
                    },
                    "columnDefs": [
                        {"width": "10%", "targets": 0},
                        {"width": "5%", "targets": 1}
                    ]
                });
                
                
                $('#listPrediction tbody').on('click', 'tr', function () {
                    if ($(this).hasClass('active')) {
                        $(this).removeClass('active');
                        $('#aRemplacer').text('');
                        $('#choisir').attr('disabled', true);
                    }
                    else {
                        $('tr.active').removeClass('active');

                        $('#aRemplacer').text($(this).find('.monTexte').text());

                        $(this).addClass('active');
                        
                        $('#choisir').attr('disabled', false);
                    }
                });

              
            });
        </script>

    </head>

    <body class="container">
        <br/>
        <div class="row">
            <form class="form-horizontal" action="ActionServlet" method="POST">
                <input type="hidden" name="todo" value="horoscope-validation">

                <div class="col-md-4">
                    <fieldset>
                        <legend>Infos Client</legend> 
                        <div class="form-group"> 
                            <label for="client" class="col-md-4">Client </label>
                            <div class="col-md-7"> 
                                <select class="form-control" name="client" id="client" disabled>
                                    <option value=${clientChoisi.id}> ${clientChoisi.prenom} ${clientChoisi.nom} </option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="medium" class="col-md-4">Medium </label>
                            <div class="col-md-7"> 
                                <select class="form-control" name="medium" id="medium">
                                    <c:forEach var="medium" items="${listMediumClient}">
                                        <option value=${medium.id}>
                                            ${medium.nom}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </fieldset>

                    <br/>
                    <div class="form-group">
                        <label for="prediction" class ="col-md-3">Prédiction</label>
                        <div class="col-md-8">
                            <textarea id="aRemplacer" class="form-control" readonly="readonly" name="prediction" rows="8">
                            </textarea>
                        </div>
                    </div>

                    <div class="col-md-offset-6">
                        <button id="choisir" class="btn btn-default">Choisir</button>
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
                    <br/>

                </div>

                <div class="col-md-8">
                    <div class="row">
                        <div class="col-md-2">
                            <a class="btn btn-default" href="#">Voir historique</a>
                        </div>
                        <div class="col-md-3">
                            <div id="titre">Sélection prédictions</div>
                        </div>

                        <div class="col-md-4">
                            <select class="form-control" name="medium" id="medium">
                                <option value="Sante">
                                    Sante
                                </option>
                                
                                <option value="Travail">
                                    Travail
                                </option>
                                
                                <option value="Amour">
                                    Amour
                                </option>

                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <br/>
                        <table id="listPrediction" class="table table-striped table-bordered" width="100%">
                            <thead>
                                <tr>
                                    <th>Ref</th>
                                    <th>Niveau</th>
                                    <th>Conseil</th>
                                    <th>Texte</th>
                                </tr>
                            </thead>  

                            <tbody>
                                <c:forEach var="prediction" items="${listPredictionSante}">
                                    <tr id=${prediction.id}>
                                        <td>${prediction.id}</td>
                                        <td>${prediction.niveau}</td>
                                        <td>${prediction.conseil}</td>
                                        <td  class="monTexte">${prediction.texte}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <div class="col-md-offset-4">
                        <div class="row">
                            <div class="col-md-2">
                                <button type="submit" class="btn btn-default" disabled="disabled"style="border: none">
                                    <img src="inc/img/checkmark-circled-512px.png" width="40" height="40"></button>

                            </div>
                            <div class="col-md-1">
                                <button class="btn btn-default" style="border: none"> 
                                    <img src="inc/img/icon_close_alt-512px.png" width="36" height="36"> 
                                </button>
                            </div>

                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
</html>
