<%-- 
    Document   : cliente
    Created on : May 1, 2016, 3:50:29 PM
    Author     : Ciro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
   <head>
      <link rel="stylesheet" type="text/css" href="style.css"
         media="screen">
      <title>Cliente</title>
      <meta name="keywords" content="gioco d'azzardo,donne,CiCiro,">
      <meta name="description" content="sito di E-commerce">
      <meta name="author" content="Ciro Borrelli">
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
   <body>
        <%@ include file="header.jsp"%>
       <div class="page">
               <h1>Acquista</h1>
      <%@ include file="sidebar.jsp"%>
      <div class="content">
             <c:choose>
                 <c:when test="${not empty compratore && not empty complimenti}">
                     <div><h2 class="acquisto">Acquisto completato</h2></div>
                 </c:when>
                 <c:when test="${not empty compratore && not empty riprova}">
                     <div><h2 class="acquisto">Riprova</h2></div>
                 </c:when>
                 <c:when test="${empty dettagli && not empty compratore}">
            <table>
                <c:forEach var="oggetto" items="${oggettoList}">
               <tr>
                  <td>  
                      <h3>${oggetto.nome}</h3>
                    <img src="${oggetto.url}" alt="Articolo" width="210" height="210"/>
                  </td>
                  <td>
                    Prezzo: ${oggetto.prezzo}€
                  </td>
                  <td>
                     Disponibilita: ${oggetto.quantita}
                  </td>
                  <td>
                      <a href="cliente.html?oggettoId=${oggetto.id}" class="btn">Acquisto</a>
                  </td>
               </tr>
               </c:forEach>
            </table>
            </c:when>
                 <c:when test="${not empty dettagli && not empty compratore}">
                     <div>
                         <h2>Dettagli</h2>
                         <p>Nome ${dettagli.nome}</p>
                         <p>Prezzo ${dettagli.prezzo}</p>
                         <p>Quantita ${dettagli.quantita}</p>
                         <p>Descrizione ${dettagli.descrizione}</p>
                         <p>Immagine</p>
                         <img src="${dettagli.url}" alt="Articolo" width="210" height="210"/>
                         <a href="cliente.html?acquisto=${dettagli.id}" class="btn">Acquista</a>
                     </div>
                 </c:when>
                     <c:when test="${not empty errore}">
                         <div class="accesso">Accesso negato!</div>
                     </c:when>
             </c:choose>    
       </div>
      <%@ include file="footer.jsp"%>
       </div>
   </body>
</html>
