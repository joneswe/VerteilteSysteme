<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<html >
<head>
    <title ><s:text name="product.title"/></title>
    <s:head/>
    <sb:head/>
    <link rel="stylesheet" href="../css/style.css" type="text/css" />
</head>

<body class="container">


<h2><s:text name="product.welcome"/>
    <s:property value="firstname"/>
    <s:property value="lastname" />
</h2>

<div class="products">
    <ul class="list-group">
        <s:iterator value="gamesList">
            <li class="list-group-item">
                    <s:property value="title" />
            </li>
        </s:iterator>
    </ul>
</div>


</body>
</html>
