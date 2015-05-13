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
             var idMedium = "-1";

            $(document).ready(function () {
               
                $('#listeClients').DataTable({
                    dom: 'T<"clear">lfrtip',
                    tableTools: {
                        "sRowSelect": "single",
                    }
                });
                $('#listeClients tr').click(function(){
                if(idMedium===this.id){
                    idMedium="-1";
                }
                else{
                    idMedium = this.id;
                }
                console.log(idMedium);
                
            });
            
            });
            function valider(){
                <%--TODO faire en sorte de ne pas autoriser la validation tant --%>
                    var req = "ActionServlet?todo=horoscope?idMed="+idMedium;
                    location.replace(req);
                
            }
            
        </script>
    </head>

    <body>
        <div class="page-header">
            <h1 style="text-align: center">Choisissez votre client</h1>
        </div>

        <table id="listeClients" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Civilité</th>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>E-mail</th>
                    <th>Telephone</th>
                </tr>
            </thead>  

            <tbody>
                <c:forEach var="client" items="${listClient}">
                    <c:out value="<tr id=${client.id}>" escapeXml="false" />
                    <c:out value="<td >${client.id}</td>"escapeXml="false" />
                    <c:out value="<td>${client.civilite}</td>"escapeXml="false" />
                    <c:out value="<td>${client.nom}</td>" escapeXml="false" />
                    <c:out value="<td>${client.prenom}</td>" escapeXml="false" />
                    <c:out value="<td>${client.email}</td>" escapeXml="false" />
                    <c:out value="<td>${client.tel}</td>" escapeXml="false" />
                    <c:out value="</tr>" escapeXml="false" />
                </c:forEach>
            </tbody>

           <button id="validation" class="btn btn-success btn-lg" onclick="valider()" > Choisir ce client  </button>
</body>
</html>
