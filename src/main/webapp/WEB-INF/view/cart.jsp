<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/view/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Cart</h1>

                    <p>All the selected products in your shopping cart</p>
                </div>
            </div>
        </section>

        <section class="container" ng-app="cartApp">
            <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
                <div>
                    <a class="btn btn-danger pull-left" ng-click="clearCart()"><span class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
                </div>

                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Product</th>
                            <th>Unit Price</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr ng-repeat="item in cart.cartItems">
                            <td>{{item.product.productName}}</td>
                            <td>{{item.product.productPrice}}</td>
                            <td>{{item.product.quantity}}</td>
                            <td>{{item.product.totalPrice}}</td>
                            <td>
                                <a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)">
                                    <span class="glyphicon glyphicon-remove"></span>remove button</a>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td>Grand Total</td>
                            <td>{{cart.grandTotal}}</td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>

                <a href="<spring:url value="/productList" />" class="btn btn-default">Continue Shopping</a>
            </div>
        </section>
    </div>
</div>

<script src="<c:url value="/resources/static/js/controller.js" />"></script>

<%@ include file="/WEB-INF/view/template/footer.jsp" %>