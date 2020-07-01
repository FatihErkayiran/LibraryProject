package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.Book;

public class BookDao {

	public static final Connection conn = ConnectionManager.getConnection();
	
	private static String SELECT_ALL_BOOKS = "select * from book";
	private static String UPDATE_BOOKS = "update book set title = ?, descr = ? where isbn = ?";
	private static String INSERT_BOOKS = "insert into book(isbn, title, descr, rented, added_to_library) values(?, ?, ?, ?, ?)";
	
	public List<Book> getAllBooks() {
		
		List<Book> allBooks = new ArrayList<Book>();
		
		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_BOOKS);
				ResultSet rs = pstmt.executeQuery() ) {
			
			while(rs.next()) {
				
				int isbn = rs.getInt("isbn");
				String title = rs.getString("title");
				String descr = rs.getString("descr");
				boolean rented = rs.getBoolean("rented");
				Date added_to_library = rs.getDate("added_to_library");
				
				allBooks.add(new Book(isbn, title, descr, rented, added_to_library));
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return allBooks;
	}
	
	public boolean updateBook(Book book) {
		
		try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_BOOKS)) {

			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getDescr());

			// at least one row updated
			if (pstmt.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean addBook(Book book) {
		
		try(PreparedStatement pstmt = conn.prepareStatement(INSERT_BOOKS)) {
			
			pstmt.setInt(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getDescr());
			pstmt.setBoolean(4, book.isRented());
			pstmt.setDate(5, book.getAdded_to_libray());
			
			// at least one row added
			if(pstmt.executeUpdate() > 0) {
				return true;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}