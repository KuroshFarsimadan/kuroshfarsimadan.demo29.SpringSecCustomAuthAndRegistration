<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html lang="en">
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <title><spring:message code="Application.Name" /></title>

  <!-- Bootstrap core CSS -->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

  <meta name="theme-color" content="#563d7c">

  <style>
    .bd-placeholder-img {
      font-size: 1.125rem;
      text-anchor: middle;
      -webkit-user-select: none;
      -moz-user-select: none;
      -ms-user-select: none;
      user-select: none;
    }

    @media (min-width: 768px) {
      .bd-placeholder-img-lg {
        font-size: 3.5rem;
      }
    }
  </style>
  <!-- Custom styles for this template -->
  <link href="navbar-top.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
	<a class="navbar-brand" href="/">Get Started</a>
	<!-- Use a partial header file so you don't need to copy paste and add a logged in user check to show and hide functionality -->
  
	<sec:authorize access="isAuthenticated()">
  		<a class="navbar-brand" href="perform_logout">Logout</a>
  	</sec:authorize> 
   
</nav>

<main role="main" class="container">
  <div class="jumbotron">
  	<h1>Hello <!-- ${message} --></h1>
 
  	<sec:authorize access="isAuthenticated()">
		Hello <sec:authentication property="name" />	    
  	</sec:authorize>    	


    
  	<sec:authorize access="!isAuthenticated()">
  	    <p class="lead">To use this application, you need to add and "register" the user.</p>
		<a class="btn btn-lg btn-primary" href="login" role="button">
	      Login
	    </a>
	    <a class="btn btn-lg btn-primary" href="registration" role="button">
	      Add Registration
	    </a>
	    <a class="btn btn-lg btn-primary" href="user" role="button">
	      Add User
	    </a>		    
  	</sec:authorize>    

  </div>
</main>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
</html>



