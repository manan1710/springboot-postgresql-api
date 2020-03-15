package com.restwithpostgres.ApiWithPostgres.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.restwithpostgres.ApiWithPostgres.model.Book;

@Repository
public class BookRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	class BookMapper implements RowMapper<Book>{

		@Override
		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("Row Mapper : Called");
			Book book = new Book();
			book.setId(rs.getLong("id"));
			book.setBook_name(rs.getString("book_name"));
			book.setAuthor_name(rs.getString("author_name"));
			book.setIsbn(rs.getString("isbn"));
			return book;
		}
		
	}
	
	public List<Book> findAllBooks()
	{
		String sql = "SELECT * FROM BOOKS";
		List<Book> bookList = jdbcTemplate.query(sql, new BookMapper());
		return bookList;
	}
	
	public int insertBook(Book book)
	{
		String sql = "INSERT INTO books (book_name, author_name, isbn) VALUES (?, ?, ?) ";
		int i = jdbcTemplate.update(sql, new Object[] { book.getBook_name(), book.getAuthor_name(), book.getIsbn()});
		System.out.println("Records inserted : "+i);
		return i;
	}

}
