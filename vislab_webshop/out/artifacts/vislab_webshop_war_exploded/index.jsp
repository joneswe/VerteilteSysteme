<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Webshop login</title>
    <s:head/>
    <sb:head/>
    <link rel="stylesheet" href="../css/style.css" type="text/css" />
</head>
<body class="access">
<div>
    <p><s:text name="index.intro" /></p>
</div>

<s:form action="login" theme="bootstrap" cssClass="well form-vertical" focusElement="username">
    <s:textfield name="username" key="prompt.username" size="20" />
    <s:password name="password" key="prompt.password" size="20" /><br>
    <s:actionerror/>
    <s:submit cssClass="btn btn-primary" value="Login"/>

</s:form>
    <a href="<s:url action="registration" />"><s:text name="link.register" /></a>


</body>
</html>