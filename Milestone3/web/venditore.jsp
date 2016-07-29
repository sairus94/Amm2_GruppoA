<%-- 
    Document   : venditore
    Created on : Apr 21, 2016, 7:16:54 PM
    Author     : Ciro
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
   <head>
      <link rel="stylesheet" type="text/css" href="style.css"
         media="screen">
      <title>Venditore</title>
      <meta name="keywords" content="gioco d'azzardo,donne,CiCiro,cerca,informazioni">
      <meta name="description" content="sito di E-commerce">
      <meta name="author" content="Ciro Borrelli">
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
   <body>
      <div class="page">
          <%@ include file="header.jsp"%>
              <h1>Vendi</h1>
          <%@ include file="sidebar.jsp"%>
      <div class="content">
          <c:choose>
              <c:when test="${not empty oggettoPostato && not empty venditore}">
                  <h2>Oggetto postato con successo</h2>
                  <p>Immagine</p>
                  <img src="${oggettoPostato.url}" alt="Articolo" width="210" height="210">
                         <p>Nome ${oggettoPostato.nome}</p>
                         <p>Prezzo ${oggettoPostato.prezzo}</p>
                         <p>Quantita ${oggettoPostato.quantita}</p>
                         <p>Descrizione ${oggettoPostato.descrizione}</p>
              </c:when>
              <c:when test="${not empty venditore && empty errore_login}">
         <div class="vendform">
            <form method="get">
               <div class="text-input">
                  <label for ="oggettoNome"> Articolo: </label>
                  <input type="text" id="oggettoNome" name="oggettoNome">
               </div>
               <div class="text-input">
                  <label for ="oggettoUrl"> Immagine: </label>
                  <input type="url" id="oggettoUrl" name="oggettoUrl">
               </div>
               <div class="text-input">
                  <label for ="oggettoQuantita"> Quantita:</label>
                  <input type="number" id="oggettoQuantita" name="oggettoQuantita" min="1" max="100" step="1">
               </div>
               <div class="text-input">
                  <label for ="oggettoPrezzo"> Prezzo:</label>
                  <input type="number" id="oggettoPrezzo" name="oggettoPrezzo" min="0">
               </div>
               <div class="text-input">
                  <label for ="oggettoDescrizione"> Descrizione: </label>            
                  <textarea id="oggettoDescrizione" name="oggettoDescrizione" rows="15" cols="30"></textarea>
               </div>
               <c:if test="${not empty errore_dati}">
                   <h2 class="Datisb"> Dati sbagliati</h2>
               </c:if>
               <input type="submit" value="INSERISCI OGGETTO" name ="Submit" class="btn">
            </form>
         </div>
              </c:when>
              <c:when test="${not empty errore_login}">
                  <div class="accesso">Accesso negato!</div>
              </c:when>
          </c:choose>
      </div>
      <%@ include file="footer.jsp"%>
      </div>
   </body>
</html>