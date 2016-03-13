<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/view/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator Page</h1>
            <p class="lead">Admin Page</p>
        </div>

        <form id='logoutForm' action="<c:url value="/logout" />" method="post">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>
                Welcome ${pageContext.request.userPrincipal.name} | <a href='#' id="logout">Logout</a>
            </h2>
        </c:if>
            <input type="hidden" name='${_csrf.parameterName}' value="${_csrf.token}" />
        </form>
        <script>
        var logout = document.querySelector('#logout');
        logout.addEventListener('click', function(e) {
            e.preventDefault();
            var form = document.querySelector('#logoutForm');
            form.submit();
        });
        </script>

        <h3><a href="<c:url value="/admin/productInventory" />">Product Inventory</a></h3>

        <p>Here you can view, check and modify the product inventory!</p>

<%@ include file="/WEB-INF/view/template/footer.jsp" %>