<%@page import="dao.RestaurantSearchDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dao.RestaurantDao" %>

<%

	RestaurantDao restaurant = new RestaurantDao();
	request.setCharacterEncoding("UTF-8");
	String search_word = request.getParameter("search_word");
	//レストラン名のリストをDBから取得する処理
	List restaurantList = restaurant.restaurantSearch(search_word);
	%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Search Form</title>
  <link rel="stylesheet" href="/gurusibu/SearchForm/css/search-result-style.css">

</head>

<body>
<h1><span style="color:whitesmoke">検索結果</span></h1>
<div style="text-align:center">
<% for(int i = 0; i < restaurantList.size(); i++) {%>
<h3><a class="no-color-change" style="color:whitesmoke" href="restaurant/contact.jsp?restaurant_name=<%=restaurantList.get(i) %>">
<%=restaurantList.get(i) %>
</a></h3>

 	<!--  <a href="restaurant/contact.jsp?restaurant_name=<%=restaurantList.get(i) %>"><%=restaurantList.get(i) %></a>-->
 	<br>
<% } %>
</div>
<h2><a class="no-color-change" href="#"><span style="color:whitesmoke">ログアウト</span></a></h2>
</body>
