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
        <h1>Reset Password</h1>
    </div>

    <form:form modelAttribute="password" method="post">
        <form:errors path="*" cssClass="errorblock" element="div" />
        <div><label> Username : <input type="text" name="username"/> </label></div>
        <div><label> Email : <input type="text" name="email"/> </label></div>
        <input type="submit" class="btn btn-lg btn-primary" role="button" value="Reset Password"/>
    </form:form>

    <div class="control-group">
    </div>
</div>
</body>
</html>