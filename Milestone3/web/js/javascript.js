/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function ()
{
   $("#cerca").keyup(function()
    {  
        var query = $("#cerca").val();
       
        $.ajax(
        {
            url: "filtra",
            data:{
              cmd: "cerca",
              text: query
            },
            dataType: 'json',
            success : function(data){
                refreshItemList(data);
            },
            error : function(data){
                console.log("nessuna data");
            }
        });
  
        function ricaricaOggettoList(oggettoList)
        {
            $("#oggetto").empty();
            if(oggettoList.length > 0){
                for(var i in oggettoList)
                {
                    var html = "<tr><td><h3>" + oggettoList[i].nome + "</h3><img src=\"" + oggettoList[i].imgUrl + "\" alt=\"Articolo\"  width=\"100\" height=\"100\"/></td>";
                    html += "<td class=\"accesso\">Prezzo: " + oggettoList[i].prezzo + "</td><td class=\"accesso\">Pezzi disponibili: " + oggettoList[i].quantita + "</td>";
                    html += "<td><a href=\"cliente.html?oggettoId=" + oggettoList[i].id + "\" class=\"btn\">Aquista</a></td></tr>";     
                    $("#oggetto").append(html);
                }
            } else {
                $("#oggetto").append("<div class=\"errore\">Nessuna corrispondenza</div>");
            }
        }
    }); 
});