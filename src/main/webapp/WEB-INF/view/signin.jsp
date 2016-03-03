<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/view/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div id="login-box">
            <h2>Login with Username and Password</h2>

            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

            <form action="<c:url value="/login" />" method="post">

                <div class="form-group">
                    <label for="username">User : </label>
                    <input type="text" id="username" name="username" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="password">Password : </label>
                    <input type="password" id="password" name="password" class="form-control" />
                </div>

                <c:if test="${not empty error}">
                    <div class="error">${error}</div>
                </c:if>

                <input type="hidden" name='${_csrf.parameterName}' value="${_csrf.token}" />

                <input type="submit" value="Submit" class="btn btn-default" />

            </form>

        </div>
    </div>
</div>

<%@ include file="/WEB-INF/view/template/footer.jsp" %>