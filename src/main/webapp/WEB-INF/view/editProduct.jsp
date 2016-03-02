<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/view/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Edit Product</h1>


            <p class="lead">Fill the below to edit product!!!</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/productInventory/editProduct"
                   method="post" commandName="product"
                   enctype="multipart/form-data">
            <form:hidden path="productId" value="${product.productId}" />
            <form:hidden path="productImageWebPath" value="${product.productImageWebPath}" />
        <div class="form-group">
            <label for="productName">Name</label>
            <form:input path="productName" class="form-control" value="${product.productName}" />
            <form:errors path="productName" class="form-control" cssStyle="color: #ff0000; background: #ffaaaa" />
        </div>

        <div class="form-group">
            <label for="productCategory">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" value="Instrument" />Instrument</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" value="Record" />Record</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" value="Accessory" />Accessory</label>
        </div>

        <div class="form-group">
            <label for="productDescription">Description</label>
            <form:textarea path="productDescription" class="form-control" value="${product.productDescription}" />
        </div>

        <div class="form-group">
            <label for="productPrice">Price</label>
            <form:input path="productPrice" class="form-control" value="${product.productPrice}" />
            <form:errors path="productPrice" class="form-control" cssStyle="color: #ff0000; background: #ffaaaa" />
        </div>

        <div class="form-group">
            <label for="productCondition">Condition</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" value="new" />New</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" value="used" />Used</label>
        </div>

        <div class="form-group">
            <label for="productStatus">Status</label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" value="active" />Active</label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" value="inactive" />Inactive</label>
        </div>

        <div class="form-group">
            <label for="unitInStock">Unit in Stock</label>
            <form:input path="unitInStock" class="form-control" value="${product.unitInStock}" />
            <form:errors path="unitInStock" class="form-control" cssStyle="color: #f55; background: #ffdddd" />
        </div>

        <div class="form-group">
            <label for="productManufacturer">Manufacturer</label>
            <form:input path="productManufacturer" class="form-control" value="${product.productManufacturer}" />
        </div>

        <div class="form-group">
            <label for="productImage" class="control-label">Upload Picture</label>
            <form:input type="file" path="productImage" class="form:input-large" />
        </div>

        <br/>

        <input type="submit" value="submit" class="btn btn-success" />
        <a href="<c:url value="/admin/productInventory" />" class="btn btn-danger">Cancel</a>
        </form:form>

<%@ include file="/WEB-INF/view/template/footer.jsp" %>