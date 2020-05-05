<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 <c:if test="${not loggato}">
    	<script>window.location = "provaLogin.jsp" </script> 
    </c:if>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalogo</title>
	<meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link href="style.css" rel="stylesheet">

    <!-- Responsive CSS -->
    <link href="css/responsive/responsive.css" rel="stylesheet">

</head>

<body>
<%
	String keyword = "";
	if(request.getParameter("txtKeyword") != null) {
		keyword = request.getParameter("txtKeyword");
	}
%>
    <!-- Preloader -->
    <div id="preloader">
        <div class="dorne-load"></div>
    </div>


    <!-- ***** Header Area Start ***** -->
    <header class="header_area" id="header">
        <div class="container-fluid h-100">
            <div class="row h-100">
                <div class="col-12 h-100">
                    <nav class="h-100 navbar navbar-expand-lg">
                        <a class="navbar-brand" href="index.jsp"><img src="img/core-img/logo.png" alt=""></a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#dorneNav" aria-controls="dorneNav" aria-expanded="false" aria-label="Toggle navigation"><span class="fa fa-bars"></span></button>
                        <!-- Nav -->
                        <div class="collapse navbar-collapse" id="dorneNav">
                            <ul class="navbar-nav mr-auto" id="dorneMenu">
                                <li class="nav-item active">
                                    <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                                </li>
                                <li class="nav-item dropdown">
                                	<a class="nav-link dropdown-toggle" href="#" id="dropdown-a" data-toggle="dropdown">Courses </a>
									<div class="dropdown-menu" aria-labelledby="dropdown-a">
									<a class="dropdown-item" href="course-grid-3.html">Free Courses </a>
									<a class="dropdown-item" href="course-grid-2.html">Premium Courses </a>
								</div>
                                </li>
                                <li class="nav-item dropdown">
                                	<a class="nav-link" href="contatti.jsp">Teachers </a>
                                </li>
                                <li class="nav-item dropdown">
                                	<a class="nav-link" href="flotta.jsp">Pricing </a>
                                </li>
                                
                                <li class="nav-item dropdown">
                                	<a class="nav-link" href="flotta.jsp">About us </a>
                                </li>
                            </ul>

   					<c:if test="${not loggato }">                         
                            <!-- Signin btn -->
                            <div class="dorne-signin-btn">
                                <a href="provaLogin.jsp">Accedi</a>
                            </div>
                            
                            </c:if>
                            
                      	<c:if test="${loggato }">    
                            <div class="dorne-signin-btn">
                                <a href="disconnectServlet">Disconnetti</a>
                            </div>
       
                            <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Il mio profilo <i class="fa fa-angle-down" aria-hidden="true"></i></a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    	<a class="dropdown-item" href="profilo.jsp">${nome}</a>
                                        <a class="dropdown-item" href="prenotazioniCliente">Le tue prenotazioni</a>
                                        <a class="dropdown-item" href="noleggioCliente">I tuoi noleggi</a>
                                    </div>
                                </li>
                            </c:if>
                            
                            
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- ***** Header Area End ***** -->

    <div class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/hero-1.jpg)">
    </div>
<%
	Connection connect = null;
	Statement s = null;
	
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		
			
		connect =  DriverManager.getConnection("jdbc:mysql://localhost:3306/webcomputing?serverTimezone=UTC","root","");
		
		s = connect.createStatement();
		
		String sql = "SELECT * FROM  corsi WHERE nome like '%" +  keyword + "%' " ;
		
		System.out.println(sql);
		
		ResultSet rec = s.executeQuery(sql);
		%>
                      
 <section class="dorne-listing-destinations-area section-padding-100-50">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="section-heading dark text-center">
                        <span></span>
                        <form form name="frmSearch" method="get" action="catalogo.jsp"> 
                                
                       									
                       									<input name="txtKeyword" type="text" id="txtKeyword" size="70"
										     placeholder="   COSA VUOI IMARARE?" value="<%=keyword%>">
										       
										       
								
	 								<!-- <div class="container-login100-form-btn"> -->
	                                    <button type="submit" class="btn dorne-btn">
	                                    <i class="fa fa-search pr-2" aria-hidden="true">
	                                    
	                                    </i> 
                                   	 <h7> Conferma</h7>
                                    </button>
                                	
		                                </form> 
                       
                        <h4>Seleziona il corso</h4>
                        <p>Scegli il corso piu' adatto alle tue esigenze</p>
                    </div>
                </div>
            </div>
            <div class="row">
            <%while((rec!=null) && (rec.next())) { %>
                        
                <!-- Single Features Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-features-area mb-50">
                        <a id="A" onclick="cat(this.id)" style="cursor: pointer;"><img src="images/CatalogoAuto/Categoria A.png" alt="">
                        <!-- Price -->
                        
                        <div class="price-start">
                            <p><%=rec.getString("tipo")%></p>
                        </div>
                        <div class="feature-content d-flex align-items-center justify-content-between">
                            <div class="feature-title">
                                <h5><%=rec.getString("nome")%></h5>
                                <p><%=rec.getString("descrizione")%></p>
                            </div>
                        </div>
                        </a>
                    </div>
                </div>
                
            <%} %>    
                
                
                
                
                
        </section>
    <%	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
			e.printStackTrace();
		}
	
		try {
			if(s!=null){
				s.close();
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
			e.printStackTrace();
		}
	%>
    
    <!-- ***** Listing Destinations Area End ***** -->
    
    
       <!--  Contact Form Area -->
        <div class="contact-form-area equal-height">
            </div>
        
    
    <!-- ****** Footer Area Start ****** -->
    <footer class="dorne-footer-area">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12 d-md-flex align-items-center justify-content-between">
                    <div class="footer-text">
                        <p>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
	Copyright &copy;<script>document.write(new Date().getFullYear());</script> A cura di Matteo e Davide | Un semplice sito di noleggio by M&D
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- ****** Footer Area End ****** -->
<div id="i" data-value="${dataInizio}"></div>
	<!-- jQuery-2.2.4 js -->
    <script src="js/jquery/jquery-2.2.4.min.js"></script>
    
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    
    <!-- Popper js -->
    <script src="js/bootstrap/popper.min.js"></script>
    <!-- Bootstrap-4 js -->
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <!-- All Plugins js -->
    <script src="js/others/plugins.js"></script>
    <!-- Active JS -->
    <script src="js/active.js"></script>
    <script src="js/custom.js"></script>
    
    
</body>
</html>