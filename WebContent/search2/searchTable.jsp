<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Search_Table</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
		<link rel="stylesheet" href="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.css"/>
		<script src="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.js"></script>
		<script>
			jQuery(function($){
				$("#foo-table").DataTable({
					// 件数切替の値を10～50の10刻みにする
					lengthMenu: [ 10, 20, 30, 40, 50 ],
					// 件数のデフォルトの値を10にする
					displayLength: 10,
					// 横スクロールバーを有効にする (scrollXはtrueかfalseで有効無効を切り替え)
					scrollX: true,
					// 縦スクロールバーを有効にする (scrollYは200, "200px"など「最大の高さ」を指定)
					scrollY: 400,
					columnDefs: [
					// n列目を消す(visibleをfalseにすると消える)n-1をtarget(ゼロベース)
					 { targets: [0, 1, 3], width: 200 },
					 { targets: 2, visible: false },
				　　]
				});
			});
		</script>
	</head>
	<body class="is-preload">

		<!-- Page Wrapper -->
			<div id="page-wrapper">

				<!-- Header -->
					<header id="header">
						<h1><a href="#"></a></h1>
						<nav id="nav">
							<ul>
								<li class="special"></li>
							</ul>
						</nav>
					</header>

				<!-- Main -->
					<article id="main">
						<header>
							<h1>Search Result</h1>
						</header>
						<section class="wrapper style5">
							<div class="inner">
							<body>
								<table id="foo-table" class="table table-bordered">
									<thead>
										<!-- <tr><th>No</th><th>resutaurant name</th><th>ココ書いても非表示</th><th>category</th></tr> -->
										<tr><th>No</th><th>resutaurant name</th><th>材料(非表示)</th><th>category</th></tr>
									</thead>
									<tbody>
										<tr><td>1</td><td><a href="#">ミートパスタ</a></td><th>挽き肉/玉ねぎ/ニンニク</th><th>洋食</th></tr>
										<tr><td>3</td><td><a href="#">餃子</a></td><th>合挽きミンチ/白菜/キャベツ/ニラ/たけのこ</th><th>中華</th></tr>
										<tr><td>4</td><td><a href="#">回鍋肉</a></td><th>豚肉/ピーマン/キャベツ/玉ねぎ</th><th>中華</th></tr>
										<tr><td>5</td><td><a href="#">麻婆豆腐</a></td><th>豆腐/挽き肉/ねぎ</th><th>中華</th></tr>
										<tr><td>6</td><td><a href="#">青椒肉絲</a></td><th>牛肉/ピーマン/たけのこ/ニンニク</th><th>中華</th></tr>
										<tr><td>7</td><td><a href="#">棒棒鶏</a></td><th>鶏肉/トマト/胡瓜/ねぎ</th><th>中華</th></tr>
										<tr><td>8</td><td><a href="#">タコライス</a></td><th>アボカド/挽き肉/トマト/レタス/セロリ/</th><th>洋食</th></tr>
										<tr><td>9</td><td><a href="#">ミネストローネ</a></td><th>トマト缶/レタス/セロリ/玉ねぎ/ベーコン</th><th>洋食</th></tr>
									</tbody>
								</table>

								<h3><a href="#">Logout</a></h3>
							</body>

							</div>
						</section>
					</article>

				<!-- Footer -->
					<footer id="footer">
						<ul class="icons">
							<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
							<li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
							<li><a href="#" class="icon solid fa-envelope"><span class="label">Email</span></a></li>
						</ul>
						<ul class="copyright">
							<li>&copy; Untitled</li><li><a href="#">GURUSHIBU.com</a></li>
						</ul>
					</footer>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>