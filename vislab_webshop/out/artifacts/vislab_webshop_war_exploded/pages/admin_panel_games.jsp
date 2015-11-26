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

<body class="container">
<%@include file="includes/header.jsp" %>

<div class="admin-category-editor">
    <s:form action="admin_games" theme="bootstrap" cssClass="well form-vertical">
        <label>Games bearbeiten</label><br><br>
        <s:submit cssClass="btn btn-primary" key="button.addCategory" name="buttonName" value="Hinzufügen"/><br><br>
        <s:select list="gamesList" listValue="value.title" value="value.id" name="id" />
        <s:submit cssClass="btn btn-primary" key="button.deleteCategory" name="buttonName" value="Löschen" />
        <s:submit cssClass="btn btn-primary" key="link.edit" name="buttonName" value="Bearbeiten" />
        <s:actionerror/>
        <s:actionmessage/>
    </s:form>
</div>

    <a href="<s:url action="admin_forward" />"><s:text name="link.edit_categories" /></a><br>
    <a href="<s:url action="productList" />"><s:text name="link.products" /></a>

</body>
</html>
