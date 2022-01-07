<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html lang="en">
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>de>
<body>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
		<a class="navbar-brand" href="/">Get Started</a>
    </nav>

    <div class="container">
        <div>
            <h1>Password Reset</h1>
        </div>
        
        <c:if test="${not empty param.reset}">
			<div class="alert alert-success" role="alert" >
        		Password reset successful.
        	</div>
        </c:if>
        
        <form:form modelAttribute="password" method="post">
            <!-- <form:errors path="*" cssClass="errorblock" element="div" /> -->
			<div><label>Password: <input type="password" name="password"/></label> </div>
			<div><label>Confirm Password: <input type="password" name="matchingPassword"/></label> </div>

            <input type="submit" class="btn btn-lg btn-primary" role="button" value="Reset your password"/>
        </form:form>

        <div class="control-group">
        </div>
    </div>
</body>
</html>



