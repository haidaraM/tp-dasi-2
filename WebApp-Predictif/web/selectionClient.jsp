<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sélection du client</title>
        <link href="inc/css/bootstrap.min.css" rel="stylesheet">
        <link href="inc/css/dataTables.bootstrap.css" rel="stylesheet">
        <script src="inc/js/jquery-1.11.2.min.js"></script>
        <script src="inc/js/jquery.dataTables.min.js"></script>
        <script src="inc/js/dataTables.tableTools.js"></script>
        <script src="inc/js/dataTables.bootstrap.js"></script>

        <script>

            $(document).ready(function () {
                /* desactive le bouton au lancement de la page */
                $("#validation").attr("disabled", true);
                
                
                var idClient = 0;

                /* fonction mettant à jour le href bouton */
                function MajButton(monId) {

                    var newUrl = "ActionServlet?todo=horoscope&idCl=" + monId;
                    $("#validation").attr("href", newUrl);
                }

                /* TODO : il y'a un petit bug qui traine encore quand on selectionne
                 client et change de page dans la datatable */

                /* met à jour la prise en compte du click */
                function setElementClick() {
                    console.log("Valeur idClient : " + idClient);
                    $('tbody tr').click(function () {
                        if (idClient === this.id) {
                            idClient = 0;
                            $("#validation").attr("disabled", true);
                        }
                        else {
                            idClient = this.id;
                            MajButton(idClient);
                            $("#validation").attr("disabled", false);
                            console.log(idClient);
                        }
                       // console.log(idClient);
                    });
                }

                /* initialisation de la datatable */
                $('#listeClients').DataTable({
                    dom: 'T<"clear">lfrtip',
                    "drawCallback": function () {
                        /* on demande la mise à jour a chaque nouveau rafraichissement */
                        setElementClick();
                    },
                    paging: false,
                    scrollY: 400,
                    tableTools: {
                        "sRowSelect"
                                : "single"
                    }
                    
                });

                /* cache les trucs deguelasses : PDF, CSV et tout ça */
                $(".DTTT").hide();



            });

        </script>
    </head>

    <body class="container">
        <div class="page-header">
            <h1 style="text-align: center">Choisissez votre client</h1>
        </div>

        <div class="row">
            <div class="col-md-offset-5 col-md-6">
                <a class="btn btn-success btn-lg" id="validation">Choisir ce client </a>
            </div>

        </div>

        <div class="row">
            <table id="listeClients" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Civilité</th>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>E-mail</th>
                    </tr>
                </thead>  

                <tbody>
                    <c:forEach var="client" items="${listClient}">
                        <tr id=${client.id}>
                            <td>${client.id}</td>
                            <td>${client.civilite}</td>
                            <td>${client.nom}</td>
                            <td>${client.prenom}</td>
                            <td>${client.email}</td>
                        </tr>
                    </c:forEach>
                </tbody>
        </div>

    </body>
</html>
