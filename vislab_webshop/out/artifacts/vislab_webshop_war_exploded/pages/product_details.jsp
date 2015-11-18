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


<div>
    <img class="cover col-xs-4" src="<s:text name="game.url" />">
</div>
<div class="col-xs-7">
    <div class="row">
        <h1><s:text name="game.title" /></h1>
        <span><s:text name="game.price"/>
        <s:text name="product_list.price.currency" /><br><br>
        <s:text name="game.description"/></span>
    </div>
</div>



</body>
</html>
