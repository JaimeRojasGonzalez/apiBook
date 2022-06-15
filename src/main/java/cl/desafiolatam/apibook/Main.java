package cl.desafiolatam.apibook;

import java.util.List;

import cl.desafiolatam.apibook.response.Book;
import cl.desafiolatam.apibook.response.BookDetail;
import cl.desafiolatam.apibook.service.ApiConsume;
import cl.desafiolatam.apibook.service.impl.ApiConsumeImpl;

public class Main {

	public static void main(String[] args) {
		ApiConsume apiService = new ApiConsumeImpl();
		
		System.out.println("getBooks");
		
		apiService.getBooks();
		List<Book> listaBook = apiService.getBooks();
		for (Book book: listaBook) {
			System.out.println(book.toString());
		}
		Book book = new Book();
		book.setId(12);
		book.setCountry("Inglaterra");
		book.setAuthor("Jojo Moyes");
		book.setImageLink("https://images.cdn1.buscalibre.com/fit-in/360x360/fc/54/fc5448d894a6cfdf68f4ad058920f6d6.jpg");
		book.setLanguage("Español");
		book.setTitle("Yo antes de ti");
		
		System.out.println("\n\nsetBooks");
		apiService.setBook(book);
		
		System.out.println("\n\ngetBook");
		apiService.getBook("3");
		apiService.getBook("8");
		
		System.out.println("\n\ngetBooksDetail");
		List<BookDetail> listaBookD = apiService.getBooksDetail();
		for (BookDetail bookDetail: listaBookD) {
			System.out.println(bookDetail.toString());
		}
		
		System.out.println("\n\ngetBookDelevery");
		List<BookDetail> listaBookD1 = apiService.getBookDelevery(false);
		for (BookDetail bookDetail: listaBookD1) {
			System.out.println(bookDetail.toString());
		}
		
		System.out.println("\n\ngetBookAuthor");
		List<BookDetail> listaBookAuthor = apiService.getBookAuthor("Unknown");
		for (BookDetail bookDetail: listaBookAuthor) {
			System.out.println(bookDetail.toString());
		}
		
		System.out.println("\n\ngetBookAuthor1");
		List<BookDetail> listaBookAuthor1 = apiService.getBookAuthor("Hans Christian Andersen");
		for (BookDetail bookDetail: listaBookAuthor1) {
			System.out.println(bookDetail.toString());
		}
	}

}
