<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html lang="en">
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
<body>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
		<a class="navbar-brand" href="/">Get Started</a>
    </nav>

    <div class="container">
        <div>
            <h1>Registration</h1>
        </div>

        <form:form modelAttribute="registration">
            <!-- <form:errors path="*" cssClass="errorblock" element="div" /> -->
            
			<div><label>Username: <input type="text" name="username"/></label> </div>
			<div><label>First Name: <input type="text" name="firstName"/></label> </div>
			<div><label>Last Name: <input type="text" name="lastName"/></label> </div>
			<div><label>Email: <input type="text" name="email"/></label> </div>
			<div><label>Password: <input type="password" name="password"/></label> </div>
			<div><label>Confirm Password: <input type="password" name="matchingPassword"/></label> </div>

            <input type="submit" class="btn btn-lg btn-primary" role="button" value="Submit"/>
        </form:form>

        <div class="control-group">
        </div>
    </div>
</body>
</html>



