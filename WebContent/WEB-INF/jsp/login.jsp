<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
	<a class="navbar-brand" href="/">Get Started</a>
</nav>

<div class="container">
    <div>
        <h1>Login</h1>
    </div>

    <c:if test="${not empty param.logout}" >
        <div class="alert alert-success" role="alert">
            You have been logged out. 
        </div>
    </c:if>

    <div class="error">
        <c:if test="${not empty param.error}" >Invalid username and password.</c:if>
    </div>


    <form:form action="perform_login" method="post">
        <form:errors path="*" cssClass="errorblock" element="div" />
        <div><label> User Name (kuroshfarsimadan): <input type="text" name="username"/> </label></div>
        <div><label> Password (password): <input type="password" name="password"/> </label></div>
        <div><label> Remember Me: <input type="checkbox" name="remember-me" /> </label></div>
        <input type="submit" class="btn btn-lg btn-primary" role="button" value="Login"/>
        <a href="password">Forgot password</a>
    </form:form>


<div class="control-group">
    </div>
</div>
</body>
</html>