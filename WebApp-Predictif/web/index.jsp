<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bienvenue à Predict'if</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="inc/css/bootstrap.min.css" rel="stylesheet">
        <script src="inc/js/jquery-1.11.2.min.js"></script>
        <script src="inc/js/bootstrap.js"></script>

    </head>
    <body class="container">

        <div class="row">
            <div class="col-md-offset-2 col-md-6">
                <div class="page-header">
                    <h1>Bienvenue à Predict'if</h1>
                </div>

                 <p>
                    <a class="btn btn-success btn-lg" href="ActionServlet?todo=page-inscription"> Inscription  </a>
                    <img src="inc/img/bonhomme.png" alt="bonhomme" width="40" height="40">
                </p>
                
                <p>
                    Predict'if est un cabinet de voyance. Nos horoscopes personnalisés pour chacun de nos clients
                    répondent à toutes les questions d'ordre sentimental, professionnel ou financier dans le plus
                    strict respect de déontologie. N'hésitez pas à vous inscrire en cliquant sur le bouton ci-dessus.
                    
                </p>

               

            </div>
        </div>

        <br/>
        <br/>
        <br/>

        <div class="row">
            <div class="col-md-offset-8 col-md-4"> <a href="#login_Modal" data-toggle="modal">Accès administrateur</a></div>
            
            <div id="login_Modal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">Connexion administrateur</h4>
                        </div>
                        <form action="ActionServlet">
                            <input type="hidden" name="todo" value="connexion-admin">
                            <div class="modal-body">
                                <div class="form-group">
                                    <label for="login">Login (nom)</label>
                                    <input type="text" class="form-control" name="login" required>
                                </div>

                                <div class="form-group">
                                    <label for="password">Mot de passe</label>
                                    <input type="password" class="form-control" id="password" name="password" required>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary" href="ActionServlet?todo=connexion">Connexion</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>



    </body>
</html>
