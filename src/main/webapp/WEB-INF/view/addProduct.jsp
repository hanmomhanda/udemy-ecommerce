<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/view/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>


            <p class="lead">Fill the below to add product!!!</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/productInventory/addProduct"
                   method="post" commandName="product"
                   enctype="multipart/form-data">
        <div class="form-group">
            <label for="productName">Name</label>
            <form:input path="productName" class="form-control" />
            <form:errors path="productName" class="form-control" cssStyle="color: #f55; background: #ffdddd" />
        </div>

        <div class="form-group">
            <label for="productCategory">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" value="Instrument" />Instrument</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" value="Record" />Record</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" value="Accessory" />Accessory</label>
        </div>

        <div class="form-group">
            <label for="productDescription">Description</label>
            <form:textarea path="productDescription" class="form-control" />
        </div>

        <div class="form-group">
            <label for="productPrice">Price</label>
            <form:input path="productPrice" class="form-control" />
            <form:errors path="productPrice" class="form-control" cssStyle="color: #f55; background: #ffdddd" />
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
            <form:input path="unitInStock" class="form-control" />
            <form:errors path="unitInStock" class="form-control" cssStyle="color: #f55; background: #ffdddd" />
        </div>

        <div class="form-group">
            <label for="productManufacturer">Manufacturer</label>
            <form:input path="productManufacturer" class="form-control" />
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