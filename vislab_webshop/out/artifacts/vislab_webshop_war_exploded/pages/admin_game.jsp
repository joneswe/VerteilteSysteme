<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<html>
<head>
    <title ><s:text name="admin.title"/></title>
    <s:head/>
    <sb:head/>
    <link rel="stylesheet" href="../css/style.css" type="text/css" />
</head>

<body class="access">
<%@include file="includes/header.jsp" %>


<s:form action="game_post" theme="bootstrap" cssClass="well form-vertical">
    <s:textfield name="game.title" key="product.name" size="20" />
    <s:textfield name="game.price" key="product.price" size="20" />
    <s:textfield name="game.description" key="product.description" size="20" />
    <s:textfield name="game.url" key="product.url" size="20" />
    <s:select list="categoryList" name="game.category.name" key="product.category" />
    <s:checkbox key="product.usk" name="game.adult"/>
    <s:actionerror/>
    <s:submit cssClass="btn btn-primary" value="Speichern"/>
</s:form>
</body>
</html>
