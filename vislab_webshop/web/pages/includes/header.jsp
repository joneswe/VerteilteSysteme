<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<header class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <a class="navbar-brand" href="<s:url action="productList" />"></a>
        <ul class="nav navbar-nav navbar-right">
            <li>
                    <a href="<s:url action="admin_forward" />"><s:text name="link.admin" /></a>
            </li>
            <li>
                <a href="<s:url action="logout" />"><s:text name="link.logout" /></a>
            </li>
        </ul>
    </div>
</header>