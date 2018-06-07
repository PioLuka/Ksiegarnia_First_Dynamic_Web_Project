<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List, models.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wszystkie Ksiazki</title>
<link rel="stylesheet" type="text/css" href="allBooks.css">
</head>
<body>
	<div class="header">
		<h1>Baza Ksiazek</h1>
	</div>
	
	<div class="panel_nawigacyjny">
		<a href="index.jsp">Wyszukaj</a>
		<a href="allBooks.jsp">Wszystkie ksiazki</a>
	</div>
	
	<div class=table>
		<table class="book">
			<tr>
				<th>Lp.</th>
				<th>Tytuł</th>
				<th>Imie</th>
				<th>Nazwisko</th>
				<th>Rok Wydania</th>
				<th>Cena</th>
				<th>Wydawnictwo</th>
			</tr>
			<%
			List<Book> bookList = (List<Book>)request.getAttribute("bookList");
			if(bookList != null){
				int i = 0;
				for(Book book : bookList){
					i++;
			%>
			<tr>
				<td><%= i %></td>
				<td><%= book.getTytul() %></td>
				<td><%= book.getImie() %></td>
				<td><%= book.getNazwisko() %></td>
				<td><%= book.getRok() %></td>
				<td><%= book.getCena() %></td>
				<td><%= book.getWydawnictwo() %></td>
			</tr>
			<%		
				}
			}
			%>
		</table>
	</div>
</body>
</html>