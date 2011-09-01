<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!doctype html>
<!--[if lt IE 7]> <html class="no-js ie6" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js ie7" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js ie8" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="en"> <!--<![endif]-->

<c:url value="/" var="contextRoot" />
<head>

	<title><decorator:title /></title>
	<style type="text/css">@import "${contextRoot}/resources/css/style.css";</style>
	<decorator:head />	
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="description" content="" />    
    
<link href='http://fonts.googleapis.com/css?family=Special+Elite&v2' rel='stylesheet' type='text/css'>


    <!-- All JavaScript at the bottom, except for Modernizr and Respond.
    	Modernizr enables HTML5 elements & feature detects; Respond is a polyfill for min/max-width CSS3 Media Queries -->
    <script src="${contextRoot}/resources/resources/js/modernizr-1.7.min.js"></script>
    <script src="${contextRoot}/resources/js/respond.min.js"></script>
</head>
<body>

<div id="wrapper">

    <header id="header" class="clearfix" role="banner">
    
        <hgroup>
            <h1 id="site-title"><a href="${contextRoot}/informationRequest">Få se mappa mi!</a></h1>
            <h2 id="site-description">The response time battle of our ISPs</h2>
        </hgroup>
    
    </header> <!-- #header -->

<div id="main" class="clearfix">
    
    <!-- Navigation -->
    <nav id="menu" class="clearfix" role="navigation">
        <ul> 
            <li><a href="${contextRoot}/informationRequest">Home</a></li>
            <li class="current">
                <a href="${contextRoot}/informationRequest/new">New ticket</a>
                <ul>
                    <li><a href="#">Subpage</a></li>
                    <li><a href="#">Subpage 2</a></li>
                </ul>
            </li>
            <li><a href="contact.html">Contact</a></li>
        </ul>
    </nav> <!-- #nav -->
       
	<!-- Sitemesh decorator -->
 	  <div id="content" role="main">
 	<decorator:body />
 	</div>
</div>

 <footer id="footer">
        <!-- You're free to remove the credit link to Jayj.dk in the footer, but please, please leave it there :) -->
        <p>
            Copyright &copy; 2011 <a href="#">f12.no</a>
            <span class="sep">|</span>
            Site design inspired by <a href="http://jayj.dk" title="Design by Jayj.dk">Jayj.dk</a>
        </p>
    </footer> <!-- #footer -->
    
    <div class="clear"></div>

</div> <!-- #wrapper -->

	<!-- JavaScript at the bottom for fast page loading -->
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js"></script>
    <script src="${contextRoot}/resources//js/script.js"></script>

</body>
</html>