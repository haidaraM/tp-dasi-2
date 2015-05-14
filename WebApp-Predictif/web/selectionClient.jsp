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
            var idClient = "-1";
            $(document).ready(function () {


                /* TODO : il y'a un petit bug qui traine encore quand on selectionne
                 client et change de page dans la datatable */

                /* desactive le bouton au lancement de la page */
                $("#validation").attr("disabled", true);

                /* met à jour la prise en compte du click */
                function setElementClick() {
                    $('tbody tr').click(function () {
                        if (idClient === this.id) {
                            idClient = "-1";
                            $("#validation").attr("disabled", true);
                        }
                        else {
                            $("#validation").attr("disabled", false);
                            idClient = this.id;
                            MajButton();
                            //console.log(idClient);
                        }
                        console.log(idClient);
                    });
                }

                /* initialisation de la datatable */
                $('#listeClients').DataTable({
                    dom: 'T<"clear">lfrtip',
                    "drawCallback": function () {
                        /* on demande la mise à jour a chaque nouveau rafraichissement */
                        setElementClick();
                    },
                    paging: true,
                    tableTools: {
                        "sRowSelect"
                                : "single"
                    }
                });

                /* cache les trucs deguelasses : PDF, CSV et tout ça */
                $(".DTTT").hide();

                /* fonction mettant à jour le href bouton */
                function MajButton() {
                    var newUrl = "ActionServlet?todo=horoscope=?idCl=" + idClient;
                    $("#validation").attr("href", newUrl);
                }

            });

        </script>
    </head>

    <body class="container">
        <div class="page-header">
            <h1 style="text-align: center">Choisissez votre client</h1>
        </div>

        <div class="row">
            <div class="col-md-offset-5 col-md-6">
                <a class="btn btn-success btn-lg" disabled id="validation">Choisir ce client </a>
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
