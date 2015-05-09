<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Predict'if - Inscription</title>
        <link href="inc/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="page-header">
                    <h1 style="text-align: center">Inscription</h1>
                </div>
            </div>
        </div>

        <form class="form-horizontal" action="ActionServlet ">
            <input type="hidden" name="todo" value="inscrtion">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="civilite">Civilité</label>
                        <div class="col-md-4"> 
                            <select class="form-control" name="civilite" id="civilite">
                                <option value="Madame">Madame</option>
                                <option value="Monsieur">Monsieur</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group"> 
                        <label for="nom">Nom :</label>
                        <div class="col-md-4"> 
                        <input type="text" class="form-control" id="nom" name="nom">
                        </div>
                    </div>


                </div>

                <div class="col-md-6">

                </div>
            </div>

            <div class="row"> 
                <button type="submit" class="btn btn-default">Inscription</button>
            </div>

        </form>
    </body>
</html>
