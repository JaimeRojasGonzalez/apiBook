package cl.desafiolatam.apibook.service;

import java.util.List;

import cl.desafiolatam.apibook.response.Book;
import cl.desafiolatam.apibook.response.BookDetail;

public interface ApiConsume {
	public List<Book> getBooks();
	public void setBook(Book book);
	public Book getBook(String id);
	public List<BookDetail> getBookDelevery(boolean delivery);
	public List<BookDetail> getBookAuthor(String author1);
	public List<BookDetail> getBooksDetail();
	public List<BookDetail> getBookAuthor1(String author1);
}
