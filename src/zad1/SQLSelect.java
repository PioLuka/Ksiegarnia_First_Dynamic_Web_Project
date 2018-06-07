package zad1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Book;

public class SQLSelect {
	
	List<Book> listBook;
	Connection conn = null;
	
	public SQLSelect(){
		listBook = new ArrayList<>();
	}
	
	public List<Book> selectAll(){
			
		Statement stmt = null;
		ResultSet resultSet = null;
		final String select = "select a.imie, a.nazwisko, p.tytul, p.cena, p.rok, w.nazwa from pozycje p join autor_pozycje ap on p.book_id = ap.book_id join autor a on ap.autor_id = a.autor_id join wydawca w on p.wydawca_id=w.wydawca_id;";
		
		try {
			conn = ConnectionProvider.getInstance().getConnection();;
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(select);
			
			while(resultSet.next()) {
				Book book = new Book();
				book.setImie(resultSet.getString("imie"));
				book.setNazwisko(resultSet.getString("nazwisko"));
				book.setTytul(resultSet.getString("tytul"));
				book.setCena(resultSet.getFloat("cena"));
				book.setRok(resultSet.getInt("rok"));
				book.setWydawnictwo(resultSet.getString("nazwa"));
				listBook.add(book);
			}
			
			conn.close();
		} catch (SQLException e) {
			
		}
		return listBook;
	}
	
	public List<Book> selectTytul(String tytul){
		
		final String select = "select a.imie, a.nazwisko, p.tytul,  p.cena, p.rok, w.nazwa from pozycje p join autor_pozycje ap on p.book_id = ap.book_id join autor a on ap.autor_id = a.autor_id join wydawca w on p.wydawca_id=w.wydawca_id where p.tytul like ?;";
		PreparedStatement stmt = null;
		ResultSet resSet = null;
		try {
			conn = ConnectionProvider.getInstance().getConnection();
			stmt = conn.prepareStatement(select);
			stmt.setString(1, tytul + "%");
			resSet = stmt.executeQuery();
			
			while(resSet.next()) {
				Book book = new Book();
				book.setImie(resSet.getString("imie"));
				book.setNazwisko(resSet.getString("nazwisko"));
				book.setTytul(resSet.getString("tytul"));
				book.setCena(resSet.getFloat("cena"));
				book.setRok(resSet.getInt("rok"));
				book.setWydawnictwo(resSet.getString("nazwa"));
				listBook.add(book);
			}
			
		} catch (SQLException e) {

		}
		return listBook;
	}
	
	public List<Book> selectAutor(String nazwisko){
		
		final String select = "select a.imie, a.nazwisko, p.tytul, p.cena, p.rok, w.nazwa from pozycje p join autor_pozycje ap on p.book_id = ap.book_id join autor a on ap.autor_id = a.autor_id join wydawca w on p.wydawca_id=w.wydawca_id where a.nazwisko like ?;";
		PreparedStatement stmt = null;
		ResultSet resSet = null;
		try {
			conn = ConnectionProvider.getInstance().getConnection();
			stmt = conn.prepareStatement(select);
			stmt.setString(1, nazwisko + "%");
			resSet = stmt.executeQuery();
			
			while(resSet.next()) {
				Book book = new Book();
				book.setImie(resSet.getString("imie"));
				book.setNazwisko(resSet.getString("nazwisko"));
				book.setTytul(resSet.getString("tytul"));
				book.setCena(resSet.getFloat("cena"));
				book.setRok(resSet.getInt("rok"));
				book.setWydawnictwo(resSet.getString("nazwa"));
				listBook.add(book);
			}
			
		} catch (SQLException e) {

		}
		return listBook;
	}
}
