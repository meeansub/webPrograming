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
    <h1>재고 주문목록</h1>

    <table id="articles" class="table table-bordered">
        <thead>
        <tr>
            <th style="width:150px;">id</th>
            <th style="width:150px;">제품명</th>
            <th style="width:150px;">카테고리</th>
            <th style="width:150px;">수량</th>
            <th style="width:150px;">단가</th>
            <th style="width:150px;">주문날짜</th>
            <th style="width:150px;">주문자</th>
            <th style="width:150px;">공급처</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="purchaseOrderDetails" items="${ list }">
            <tr>
                <td>${ purchaseOrderDetails.id }</td>
                <td>${ purchaseOrderDetails.products.productName}</td>
                <td>${ purchaseOrderDetails.products.category}</td>
                <td style="text-align: right">${ purchaseOrderDetails.quantity }</td>
                <td style="text-align: right">${ purchaseOrderDetails.unitCost }</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${ purchaseOrderDetails.purchaseOrders.submittedDate }"/></td>
                <td>${ purchaseOrderDetails.purchaseOrders.employees.lastName },${ purchaseOrderDetails.purchaseOrders.employees.firstName}</td>
                <td>${ purchaseOrderDetails.purchaseOrders.suppliers.lastName }, ${ purchaseOrderDetails.purchaseOrders.suppliers.firstName }</td>


            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>