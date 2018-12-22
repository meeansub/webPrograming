<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${R}res/common.js"></script>
    <link rel="stylesheet" href="${R}res/common.css">
</head>
<body>
<div class="container">
    <h1>고객 목록</h1>

    <table id="articles" class="table table-bordered">
        <thead>
        <tr>
            <th style="width:150px;">id</th>
            <th style="width:150px;">이름</th>
            <th style="width:150px;">직위</th>
            <th style="width:150px;">전화</th>
            <th style="width:150px;">도시</th>
            <th style="width:150px;">주문수</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customers" items="${ list }">
            <tr>
                <td>${ customers.id }</td>
                <td>${ customers.firstName } ${ customers.lastName }</td>
                <td>${ customers.jobTitle}</td>
                <td>${ customers.businessPhone }</td>
                <td>${ customers.city }</td>
                <td>${ customers.orders.size()}</td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>