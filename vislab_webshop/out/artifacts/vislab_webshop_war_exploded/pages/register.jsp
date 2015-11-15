<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<html>
<head>
    <title><s:text name="welcome.title"/></title>
    <s:head/>
    <sb:head/>
    <link rel="stylesheet" href="../css/style.css" type="text/css" />
</head>

<body class="access">
<%--<p><s:text name="registration.message"/></p>--%>
<s:property value="username"/>

<font color="red">
    <s:actionerror label="label" />
</font>

<s:form action="register" theme="bootstrap" cssClass="well form-vertical" focusElement="username">
    <s:textfield name="username" key="prompt.username" size="20" />
    <s:password name="password" key="prompt.password" size="20" />
    <s:textfield name="firstname" key="prompt.firstname" size="20" />
    <s:textfield name="lastname" key="prompt.lastname" size="20" />
    <s:submit value="register" align="center"/>
</s:form>

</body>
</html>
