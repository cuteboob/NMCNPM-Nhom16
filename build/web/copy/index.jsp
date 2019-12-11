<%-- 
    Document   : index
    Created on : Oct 12, 2019, 10:27:28 PM
    Author     : PV
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Big shope A Ecommerce Category Flat Bootstarp Resposive Website Template | Home :: w3layouts</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <!--theme-style-->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
        <!--//theme-style-->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!--fonts-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        <!--//fonts-->
        <script src="js/jquery.min.js"></script>
        <!--script-->
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="container">
                <div class="shoes-grid">
                    <a href="single.jsp">
                        <div class="wrap-in">
                            <%@include file="/WEB-INF/jspf/wmuSlider.jspf" %>
                        </div>
                    </a>
                    <!---->
                    <div class="shoes-grid-left">
                        <a href="single.jsp">				 
                            <div class="col-md-6 con-sed-grid">

                                <div class=" elit-grid"> 

                                    <h4>consectetur  elit</h4>
                                    <label>FOR ALL PURCHASE VALUE</label>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, </p>
                                    <span class="on-get">GET NOW</span>						
                                </div>						
                                <img class="img-responsive shoe-left" src="images/sh.jpg" alt=" " />

                                <div class="clearfix"> </div>

                            </div>
                        </a>
                        <a href="single.jsp">	
                            <div class="col-md-6 con-sed-grid sed-left-top">
                                <div class=" elit-grid"> 
                                    <h4>consectetur  elit</h4>
                                    <label>FOR ALL PURCHASE VALUE</label>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, </p>
                                    <span class="on-get">GET NOW</span>
                                </div>		
                                <img class="img-responsive shoe-left" src="images/wa.jpg" alt=" " />

                                <div class="clearfix"> </div>
                            </div>
                        </a>
                    </div>
                    <div class="products">
                        <h5 class="latest-product">LATEST PRODUCTS</h5>	
                        <a class="view-all" href="product.jsp">VIEW ALL<span> </span></a> 		     
                    </div>
                    <div class="product-left">
                        <div class="col-md-4 chain-grid">
                            <a href="single.jsp"><img class="img-responsive chain" src="images/ch.jpg" alt=" " /></a>
                            <span class="star"> </span>
                            <div class="grid-chain-bottom">
                                <h6><a href="single.jsp">Lorem ipsum dolor</a></h6>
                                <div class="star-price">
                                    <div class="dolor-grid"> 
                                        <span class="actual">300$</span>
                                        <span class="reducedfrom">400$</span>
                                        <span class="rating">
                                            <input type="radio" class="rating-input" id="rating-input-1-5" name="rating-input-1">
                                            <label for="rating-input-1-5" class="rating-star1"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-4" name="rating-input-1">
                                            <label for="rating-input-1-4" class="rating-star1"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-3" name="rating-input-1">
                                            <label for="rating-input-1-3" class="rating-star"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-2" name="rating-input-1">
                                            <label for="rating-input-1-2" class="rating-star"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-1" name="rating-input-1">
                                            <label for="rating-input-1-1" class="rating-star"> </label>
                                        </span>
                                    </div>
                                    <a class="now-get get-cart" href="#">ADD TO CART</a> 
                                    <div class="clearfix"> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 chain-grid">
                            <a href="single.jsp"><img class="img-responsive chain" src="images/ba.jpg" alt=" " /></a>
                            <span class="star"> </span>
                            <div class="grid-chain-bottom">
                                <h6><a href="single.jsp">Lorem ipsum dolor</a></h6>
                                <div class="star-price">
                                    <div class="dolor-grid"> 
                                        <span class="actual">300$</span>
                                        <span class="reducedfrom">400$</span>
                                        <span class="rating">
                                            <input type="radio" class="rating-input" id="rating-input-1-5" name="rating-input-1">
                                            <label for="rating-input-1-5" class="rating-star1"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-4" name="rating-input-1">
                                            <label for="rating-input-1-4" class="rating-star1"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-3" name="rating-input-1">
                                            <label for="rating-input-1-3" class="rating-star"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-2" name="rating-input-1">
                                            <label for="rating-input-1-2" class="rating-star"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-1" name="rating-input-1">
                                            <label for="rating-input-1-1" class="rating-star"> </label>
                                        </span>
                                    </div>
                                    <a class="now-get get-cart" href="#">ADD TO CART</a> 
                                    <div class="clearfix"> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 chain-grid grid-top-chain">
                            <a href="single.jsp"><img class="img-responsive chain" src="images/bo.jpg" alt=" " /></a>
                            <span class="star"> </span>
                            <div class="grid-chain-bottom">
                                <h6><a href="single.jsp">Lorem ipsum dolor</a></h6>
                                <div class="star-price">
                                    <div class="dolor-grid"> 
                                        <span class="actual">300$</span>
                                        <span class="reducedfrom">400$</span>
                                        <span class="rating">
                                            <input type="radio" class="rating-input" id="rating-input-1-5" name="rating-input-1">
                                            <label for="rating-input-1-5" class="rating-star1"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-4" name="rating-input-1">
                                            <label for="rating-input-1-4" class="rating-star1"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-3" name="rating-input-1">
                                            <label for="rating-input-1-3" class="rating-star"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-2" name="rating-input-1">
                                            <label for="rating-input-1-2" class="rating-star"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-1" name="rating-input-1">
                                            <label for="rating-input-1-1" class="rating-star"> </label>
                                        </span>
                                    </div>
                                    <a class="now-get get-cart" href="#">ADD TO CART</a> 
                                    <div class="clearfix"> </div>
                                </div>
                            </div>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="products">
                        <h5 class="latest-product">LATEST PRODUCTS</h5>	
                        <a class="view-all" href="product.jsp">VIEW ALL<span> </span></a> 		     
                    </div>
                    <div class="product-left">
                        <div class="col-md-4 chain-grid">
                            <a href="single.jsp"><img class="img-responsive chain" src="images/bott.jpg" alt=" " /></a>
                            <span class="star"> </span>
                            <div class="grid-chain-bottom">
                                <h6><a href="single.jsp">Lorem ipsum dolor</a></h6>
                                <div class="star-price">
                                    <div class="dolor-grid"> 
                                        <span class="actual">300$</span>
                                        <span class="reducedfrom">400$</span>
                                        <span class="rating">
                                            <input type="radio" class="rating-input" id="rating-input-1-5" name="rating-input-1">
                                            <label for="rating-input-1-5" class="rating-star1"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-4" name="rating-input-1">
                                            <label for="rating-input-1-4" class="rating-star1"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-3" name="rating-input-1">
                                            <label for="rating-input-1-3" class="rating-star"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-2" name="rating-input-1">
                                            <label for="rating-input-1-2" class="rating-star"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-1" name="rating-input-1">
                                            <label for="rating-input-1-1" class="rating-star"> </label>
                                        </span>
                                    </div>
                                    <a class="now-get get-cart" href="#">ADD TO CART</a> 
                                    <div class="clearfix"> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 chain-grid">
                            <a href="single.jsp"><img class="img-responsive chain" src="images/bottle.jpg" alt=" " /></a>
                            <span class="star"> </span>
                            <div class="grid-chain-bottom">
                                <h6><a href="single.jsp">Lorem ipsum dolor</a></h6>
                                <div class="star-price">
                                    <div class="dolor-grid"> 
                                        <span class="actual">300$</span>
                                        <span class="reducedfrom">400$</span>
                                        <span class="rating">
                                            <input type="radio" class="rating-input" id="rating-input-1-5" name="rating-input-1">
                                            <label for="rating-input-1-5" class="rating-star1"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-4" name="rating-input-1">
                                            <label for="rating-input-1-4" class="rating-star1"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-3" name="rating-input-1">
                                            <label for="rating-input-1-3" class="rating-star"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-2" name="rating-input-1">
                                            <label for="rating-input-1-2" class="rating-star"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-1" name="rating-input-1">
                                            <label for="rating-input-1-1" class="rating-star"> </label>
                                        </span>
                                    </div>
                                    <a class="now-get get-cart" href="#">ADD TO CART</a> 
                                    <div class="clearfix"> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 chain-grid grid-top-chain">
                            <a href="single.jsp"><img class="img-responsive chain" src="images/baa.jpg" alt=" " /></a>
                            <span class="star"> </span>
                            <div class="grid-chain-bottom">
                                <h6><a href="single.jsp">Lorem ipsum dolor</a></h6>
                                <div class="star-price">
                                    <div class="dolor-grid"> 
                                        <span class="actual">300$</span>
                                        <span class="reducedfrom">400$</span>
                                        <span class="rating">
                                            <input type="radio" class="rating-input" id="rating-input-1-5" name="rating-input-1">
                                            <label for="rating-input-1-5" class="rating-star1"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-4" name="rating-input-1">
                                            <label for="rating-input-1-4" class="rating-star1"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-3" name="rating-input-1">
                                            <label for="rating-input-1-3" class="rating-star"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-2" name="rating-input-1">
                                            <label for="rating-input-1-2" class="rating-star"> </label>
                                            <input type="radio" class="rating-input" id="rating-input-1-1" name="rating-input-1">
                                            <label for="rating-input-1-1" class="rating-star"> </label>
                                        </span>
                                    </div>
                                    <a class="now-get get-cart" href="#">ADD TO CART</a> 
                                    <div class="clearfix"> </div>
                                </div>
                            </div>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>   
                <%@include file="/WEB-INF/jspf/newjsp.jspf" %>
            <div class="clearfix"> </div>        	         
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
