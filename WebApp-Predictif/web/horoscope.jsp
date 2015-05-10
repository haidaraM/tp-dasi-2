<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Création d'un horoscope</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="inc/css/bootstrap.min.css" rel="stylesheet">
        <script src="inc/js/jquery-1.11.2.min.js"></script>
        <script src="inc/js/bootstrap.js"></script>
    </head>
    
    <body class="container">
        <form class="form-horizontal" action="ActionServlet" method="POST">
            <input type="hidden" name="todo" value="horoscope">
            <div class="row">
                <br/>
                <div class="col-md-4">
                    <div bordure style="border: 0.5px solid grey">
                        <div Infos_clients >Infos Client </div>
                            <div class="form-group">
                                <label for="medium" class="col-md-4">Medium </label>
                                <div class="col-md-7"> 
                                    <select class="form-control" name="medium" id="medium">
                                        <option value="Medium[0]">ToComplete</option>
                                        <option value="Medium[1]">ToComplete</option>
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
                </div>
                <br/>
                <div prediction>
                    <label for="prediction" class ="col-md-3">Prédiction</label>
                    <div class="col-md-8">
                        <textarea class="form-control" readonly="readonly" name="prediction" rows="8">
                            lorem ipsum ...... TODO TO COMPLETE
                        </textarea>
                    </div>
                    <button class="btn btn-default">Choisir</button>
                </div>
                <hr/>
                <div choix_pred bordure style="border: 0.5px solid grey">
                    <div> Prédictions choisies</div>
                        <label for="chTravail" class="col-md-4">Travail </label>
                        <div class="col-md-7"> 
                            <input type="text" name="chTravail" rows="1" class="uneditable-input" readonly="readonly">
                        </div>
                        <br/>
                        <label for="chSante" class="col-md-4">Santé </label>
                        <div class="col-md-7"> 
                            <input type="text" name="chSante" rows="1" class="uneditable-input" readonly="readonly">
                        </div>
                        <br/>
                        <label for="chTravail" class="col-md-4">Travail </label>
                        <div class="col-md-7"> 
                            <input type="text" name="chTravail" rows="1" class="uneditable-input" readonly="readonly">
                        </div>
                </div>
                </div>
            </div>
                    
                    

        </form>
    </body>
</html>
</html>
