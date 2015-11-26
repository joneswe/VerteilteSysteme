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


<s:form action="category_post" theme="bootstrap" cssClass="well form-vertical">
    <label>Kategorie ändern</label><br><br>
    <s:textfield size="20" name="newCategoryName"  value="%{categoryName}"/><br>
    <s:actionerror/>
    <s:submit cssClass="btn btn-primary" value="Aktualisieren"/>

</s:form>
</body>
</html>
