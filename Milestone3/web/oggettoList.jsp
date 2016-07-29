<%-- 
    Document   : oggettoList
    Created on : Jun 13, 2016, 7:14:03 PM
    Author     : Ciro
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="oggetto" items="${oggettoList}">
        <json:object>
            <json:property name="quantita" value="${oggetto.quantita}"/>
            <json:property name="id" value="${oggetto.id}"/>
            <json:property name="descrizione" value="${oggetto.descrizione}"/>
            <json:property name="nome" value="${oggetto.nome}"/>
            <json:property name="url" value="${oggetto.url}"/>
            <json:property name="prezzo" value="${oggetto.prezzo}"/>
        </json:object>
    </c:forEach>
</json:array>