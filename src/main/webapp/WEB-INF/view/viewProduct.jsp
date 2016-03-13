<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/view/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>


            <p class="lead">Check out all the awswome products available now!!!</p>
        </div>

        <div class="container" ng-app="cartApp">
            <div class="row">
                <div class="col-md-5">
                    <img src="${product.productImageWebPath}" style="width: 100%;"/>
                </div>
                <div class="col-md-5">
                    <h3>${product.productName}</h3>
                    <p>${product.productDescription}</p>
                    <p><strong>Manufacturer</strong> : ${product.productManufacturer}</p>
                    <p><strong>Category</strong> : ${product.productCategory}</p>
                    <p><strong>Condition</strong> : ${product.productCondition}</p>
                    <h4><strong>Price</strong> : ${product.productPrice}</h4>

                    <br/>

                    <c:set var="role" scope="page" value="${param.role}" />
                    <c:set var="url" scope="page" value="/productList" />
                    <c:if test="${role == 'admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory" />
                    </c:if>

                    <p ng-controller="cartCtrl">
                        <a href="<c:url value="${url}" />" class="btn btn-default">Back</a>
                        <a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}', '${_csrf.token}')">
                            <span class="glyphicon glyphicon-shopping-cart"></span>Order New</a>
                        <a href="<spring:url value="/cart" />" class="btn btn-default">
                            <span class="glyphicon glyphicon-hand-right"></span>New Cart</a>
                    </p>
                </div>
            </div>
        </div>

        <script src="<c:url value="/resources/static/js/controller.js" />"></script>

<%@ include file="/WEB-INF/view/template/footer.jsp" %>