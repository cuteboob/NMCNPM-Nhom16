<%-- 
    Document   : footer
    Created on : Oct 12, 2019, 10:18:49 PM
    Author     : PV
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
</head>
    <body>
        <div class="footer">
		<div class="footer-top">
			<div class="container">
				<div class="latter">
					<h6>Nhập môn công nghệ phần mềm</h6>
					<div class="sub-left-right">
                                            <form action="index.jsp">
							<input type="submit" value="Nhóm 16">
						</form>
					</div>
					<div class="clearfix"> </div>
				</div>
				
				<div class="clearfix"> </div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="container">
				<div class="footer-bottom-cate">
					<h6>Hãng</h6>
					<ul>
                                            <c:forEach var="copany" items="${newCopany}">
                                                <li><a href="company?Company=${copany}">${copany}</a></li>
<!--                        <li class="subitem1"><a href="company?Company=${copany}">${copany}</a></li>-->
                        </c:forEach>
<!--						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Ultrices id du</a></li>
						<li><a href="#">Commodo sit</a></li>
						<li><a href="#">Urna ac tortor sc</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Urna ac tortor sc</a></li>
						<li><a href="#">Eget nisi laoreet</a></li>
						<li><a href="#">Faciisis ornare</a></li>-->
					</ul>
				</div>
				<div class="footer-bottom-cate bottom-grid-cat">
					<h6>Tầm giá</h6>
					<ul>
<!--						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Ultrices id du</a></li>
						<li><a href="#">Commodo sit</a></li>-->
                                                <li><a href="priceRange?priceRange=0">Dưới 10 triệu đồng</a></li>
                    <li><a href="priceRange?priceRange=1">Từ 10 đến 20 triệu đồng</a></li>
                    <li><a href="priceRange?priceRange=2">Từ 20 đến 30 triệu đồng</a></li>
                    <li><a href="priceRange?priceRange=3">Trên 30 triệu đồng</a></li>
					</ul>
				</div>
				<div class="footer-bottom-cate">
					<h6>Sắp xếp theo</h6>
					<ul>
                                            <li><a href="sortBy?sortBy=a-z">A-Z</a></li>
                    <li><a href="sortBy?sortBy=priceASC">Giá tăng dần</a></li>
                    <li><a href="sortBy?sortBy=priceDESC">Giá giảm dần</a></li>
<!--						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Ultrices id du</a></li>
						<li><a href="#">Commodo sit</a></li>
						<li><a href="#">Urna ac tortor sc</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Urna ac tortor sc</a></li>
						<li><a href="#">Eget nisi laoreet</a></li>
						<li><a href="#">Faciisis ornare</a></li>-->
					</ul>
				</div>
				<div class="footer-bottom-cate cate-bottom">
					<h6>Thành viên</h6>
					<ul>
						<li>Nguyễn Văn Trung</li>
						<li>Bùi Minh Tuấn</li>
						<li>Bùi Phó Bền</li>
						
						<li>Đồng Văn Hiệp</li>
						<li class="phone">PH: 0941778071</li>
						<li class="temp"> <p class="footer-class">Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a> </p></li>
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
    </body>
</html>
