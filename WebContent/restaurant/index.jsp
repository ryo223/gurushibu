<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dao.Reservation_courseDao" %>

<%
	request.setCharacterEncoding("utf-8");
	String restaurant_name = request.getParameter("restaurant_name");
	Reservation_courseDao course = new Reservation_courseDao();
	List<String> courseList = course.getCourse(restaurant_name);
	String loginUser = (String) session.getAttribute("loginUser");
 %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Restaurant &mdash; TOP</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">

	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Themify Icons-->
	<link rel="stylesheet" href="css/themify-icons.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">
	<!-- Magnific Popup -->
	<link rel="stylesheet" href="css/magnific-popup.css">
	<!-- Bootstrap DateTimePicker -->
	<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">
	<!-- Owl Carousel  -->
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="css/style.css">
	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>

	</head>
	<body>

	<div class="gtco-loader"></div>

	<div id="page">


	<!-- <div class="page-inner"> -->
	<nav class="gtco-nav" role="navigation">
		<div class="gtco-container">

			<div class="row">
				<div class="col-sm-4 col-xs-12">
					<div id="gtco-logo"><a href="index.jsp?restaurant_name=<%=restaurant_name %>">RESTAURANT - TOP</a></div>
				</div>
				<div class="col-xs-8 text-right menu-1">
					<ul>
						<li><a href="menu.jsp">Menu</a></li><!--class="btn-cta"-->
						<li><a href="contact.jsp?restaurant_name=<%=restaurant_name %>">Contact</a></li>
						<li><a href="#">Logout</a></li> <!-- ログアウト.jsp -->
					</ul>
				</div>
			</div>

		</div>
	</nav>

	<header id="gtco-header" class="gtco-cover gtco-cover-md" role="banner" style="background-image: url(images/img_bg_1.jpg)" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-12 col-md-offset-0 text-left">


					<div class="row row-mt-15em">
						<div class="col-md-7 mt-text animate-box" data-animate-effect="fadeInUp">
							<h1 class="cursive-font"><%= restaurant_name %></h1>
						</div>
						<div class="col-md-4 col-md-push-1 animate-box" data-animate-effect="fadeInRight">
							<div class="form-wrap">
								<div class="tab">

									<div class="tab-content">
										<div class="tab-content-inner active" data-content="signup">
											<h3 class="cursive-font">席を予約する</h3>
											<form action="/gurusibu/RestaurantReservation" method="post">
												<div class="row form-group">
													<div class="col-md-12">

														<label for="activities">Persons</label>
														<select name="#" id="activities" class="form-control">
															<option value="">人数を選択</option>
															<option value="">1</option>
															<option value="">2</option>
															<option value="">3</option>
															<option value="">4</option>
															<option value="">5+</option>
														</select>
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label for="activities">Course</label>
														<select name="#" id="activities" class="form-control">
															<option value="">コースを選択</option>
															<% for(int i = 0; i < courseList.size(); i++) {%>
															<option value="<%= courseList.get(i) %>"><%= courseList.get(i) %></option>
															<% } %>
															<option value="">コースを選択しない</option>
														</select>
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label for="date-start">Date</label>
														<input type="text" id="date" class="form-control">
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label for="date-start">Time</label>
														<input type="text" id="time" class="form-control">
													</div>
												</div>

												<div class="row form-group">
													<div class="col-md-12">
													<!-- reserveResult.jsp -->
														<input type="submit" class="btn btn-primary btn-block" value="予約する">
													</div>

												</div>
											</form>
										</div>


									</div>
								</div>
							</div>
						</div>
					</div>


				</div>
			</div>
		</div>
	</header>

	<!-- review 用 -->

	<div id="gtco-counter" class="gtco-section" style="background-image: url(images/img_bg_1.jpg)"  data-stellar-background-ratio="0.5">
		<div class="gtco-container">

			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center gtco-heading animate-box">
					<h2 class="cursive-font primary-color">Fun Facts</h2>
				</div>
			</div>

			<div class="row">

				<div class="col-md-3 col-sm-6 animate-box" data-animate-effect="fadeInUp">
					<div class="feature-center">
						<span class="counter js-counter" data-from="0" data-to="5" data-speed="5000" data-refresh-interval="50">1</span>
						<span class="counter-label">review評価</span>
					</div>
				</div>

				<div class="col-md-3 col-sm-6 animate-box" data-animate-effect="fadeInUp">
					<div class="feature-center">
						<span class="counter js-counter" data-from="0" data-to="33" data-speed="5000" data-refresh-interval="50">1</span>
						<span class="counter-label">メニュー数</span>
					</div>
				</div>

				<div class="col-md-3 col-sm-6 animate-box" data-animate-effect="fadeInUp">
					<div class="feature-center">
						<span class="counter js-counter" data-from="0" data-to="1975" data-speed="5000" data-refresh-interval="50">1</span>
						<span class="counter-label">設立(?)年</span>

					</div>
				</div>

			</div>
		</div>
	</div>

	<footer id="gtco-footer" role="contentinfo" style="background-image: url(images/img_bg_1.jpg)" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row row-pb-md">

				<div class="col-md-12 text-center">
					<div class="gtco-widget">
						<h3>お問い合わせ</h3>
						<ul class="gtco-quick-contact">
							<li><a href="#"><i class="icon-phone"></i> +1 234 567 890</a></li>
							<li><a href="#"><i class="icon-mail2"></i> gurushibu@mail.com</a></li>
						</ul>
					</div>

				</div>

				<div class="col-md-12 text-center copyright">
					<p><small class="block">&copy; All Rights Reserved.</small> <!-- All Rights Reserved. -->
						<small class="block">Designed by <a href="#" target="_blank">Gurushibu.com</a>
				</div>

			</div>
		</div>
	</footer>
	<!-- </div> -->
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>

	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="js/jquery.countTo.js"></script>
	<!-- Stellar Parallax -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	<script src="js/moment.min.js"></script>
	<script src="js/bootstrap-datetimepicker.min.js"></script>
	<!-- Main -->
	<script src="js/main.js"></script>

	</body>
</html>