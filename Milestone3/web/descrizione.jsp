<%-- 
    Document   : descrizione
    Created on : Apr 21, 2016, 7:17:18 PM
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
      <title> CiCiro </title>
      <meta name="keywords" content="gioco d'azzardo,donne,CiCiro,carte,tavoli">
      <meta name="description" content="sito di E-commerce">
      <meta name="author" content="Ciro Borrelli">
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
   <body>
      <div class="page">
          <%@ include file="header.jsp"%>
         <h1>CiCiro</h1>
          <%@ include file="sidebar.jsp"%>
      <div class="content">
         <p>
            Il primo sito di E-commerce che ti permette di vendere e comprare qualsiasi cosa legata al gioco d'azzardo.
            Per voi appassionati di gioco d'azzardo, per voi che scommettete anche 
            sulle gare degli scarafaggi, questo è il sito che stavate cercando!!
         </p>
         <ul>
            <li><a href="#carte">Carte</a></li>
            <li><a href="#tavoli">Tavoli</a></li>
            <li><a href="#donne">Donne</a></li>
         </ul>
         <h2 id="carte"> Carte:
         </h2>
         <img src='./img/invisible.jpg' alt="sorry wait" width="300" height="300"/>
         <h3>
            Acquistare carte semplici o truccate, a voi la scelta!!
         </h3>
         <p>
            Un incredibile mazzo di carte che vi permettera di vincere tutti i soldi dei vostri amici
         </p>
         <h2 id="tavoli"> Tavoli:
         </h2>
         <img src="./img/table2.jpg" alt="sorry wait" width="300" height="300"/>
         <h3>
            I migliori tavoli da gioco sul mercato!
         </h3>
         <p>
            Da noi è possibile trovare tavoli da gioco per ogni specialita, 
            blackjack,poker,roulette e tanti altri.
            Per i più coraggiosi, tavoli con armi incorporate.
         </p>
         <h2 id="donne">
            Donne:
         </h2>
         <img src="./img/donne2.jpg" alt="sorry wait" width="300" height="300"/>
         <h3>
            Le più belle e simpatiche donne del mondo... tutte da noi!
         </h3>
         <p>
            Donne da "compagnia" Mediterranee,Russe,Polacche e tante altre, 
            da noi ogni desiderio diventa realta!!
         </p>
      </div>
      <%@ include file="footer.jsp"%>
      </div>
   </body>
</html>

