<%-- 
    Document   : login
    Created on : Apr 21, 2016, 7:17:04 PM
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
      <title>Login</title>
      <meta name="keywords" content="CiCiro,login,azzardo,gioco">
      <meta name="description" content="sito di E-commerce">
      <meta name="author" content="Ciro Borrelli">
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
   <body>
      <div class="page">
          <%@ include file="header.jsp"%>
              <h1>Login</h1>
          <%@include file="sidebar.jsp"%>
      <div class="content">
          <c:choose>
              <c:when test="${empty utente_autenticato}">
          <div class="vendform">
              <form method="get" action="login.html">
                <div class="text-input">
                   <label for ="username"> Username: </label>
                   <input type="text" id="username" name="username">
                </div>
                <div class="text-input">
                   <label for ="password"> Password: </label>
                   <input type="password" id="password" name="password">
                </div>
                <c:if test="${not empty login_fallito}">
                    <div class="errore"> Login fallito! </div>
                </c:if>
                   <input type="submit" value="LOGIN" name="Submit" class="btn">
             </form>
           </div>
              </c:when>
              <c:otherwise> <h2 class="benvenuto">Benvenuto ${utente_autenticato.username}</h2></c:otherwise>
          </c:choose>
      </div> 
      <%@ include  file="footer.jsp"%>
      </div>
   </body>
</html>
