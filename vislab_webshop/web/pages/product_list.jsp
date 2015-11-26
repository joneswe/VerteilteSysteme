<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<html>
<head>
    <title><s:text name="product.title"/></title>
    <s:head/>
    <sb:head/>
    <link rel="stylesheet" href="../css/style.css" type="text/css"/>
</head>

<body class="container">
<%@include file="includes/header.jsp" %>

<h2>
    <s:text name="product.welcome"/>
    <s:property value="firstname"/>
    <s:property value="lastname"/>
</h2>


<div class="filter">
    <s:form action="productSearch" theme="bootstrap" cssClass="well form-vertical">
        <label><s:text name="product.text_search"/></label><br><input type="text" name="textSearch"/><br><br>
        <s:checkboxlist key="product.genre" list="categoryList" name="categoryFilter"/>
        <label><s:text name="product.age_range"/></label><br>
        <s:checkbox key="product.usk" name="adult"/>
        <label><s:text name="product.price_range"/></label><br>
        <input class="small-input" type="text"
               name="priceMin"/>-<input class="small-input" type="text" name="priceMax" /><br><br>

        <s:submit cssClass="btn btn-primary" key="button.search"/>
    </s:form>
</div>
<div class="products">
    <ul class="list-group">
        <s:iterator value="gamesList">
            <li class="list-group-item">
                <s:property value="value.title"/>
                <s:form action="productDetail">
                    <s:hidden type="hidden" name="gameId" value="%{value.id}"/>
                    <s:submit value="Details"/>
                </s:form>
            </li>
        </s:iterator>
    </ul>
</div>


</body>
</html>
