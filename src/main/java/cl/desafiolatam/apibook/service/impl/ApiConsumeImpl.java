package cl.desafiolatam.apibook.service.impl;


import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cl.desafiolatam.apibook.response.Book;
import cl.desafiolatam.apibook.service.ApiConsume;
import cl.desafiolatam.apibook.response.BookDetail;

public class ApiConsumeImpl implements ApiConsume{
	private static Client client;
	public ApiConsumeImpl() {
		super();
		client = ClientBuilder.newClient();
		
	}

	public List<Book> getBooks() {
		WebTarget target = client.target("https://my-json-server.typicode.com/Himuravidal/anchorBooks").path("books");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		List<Book> listaBook = response.readEntity(new GenericType<List<Book>>() {});
		
		return listaBook;
	}

	public void setBook(Book book) {
		WebTarget target = client.target("https://my-json-server.typicode.com/Himuravidal/anchorBooks").path("books");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(book, MediaType.APPLICATION_JSON));
		Book book1 = response.readEntity(new GenericType<Book>() {});
		System.out.println("book: setBook(): Servicio invocado correctamente:" + response.getStatus() + "-" + book1.toString());

		
	}

	public Book getBook(String id) {
		//id = Integer.toString((Integer.valueOf(id)-1));
		WebTarget target = client.target("https://my-json-server.typicode.com/Himuravidal/anchorBooks").path("books").path(id);
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		Book book1 = response.readEntity(new GenericType<Book>() {});
		System.out.println("Codigo:" + response.getStatus());
		System.out.println("Libro número "+ id + ":" + book1.getAuthor()+ ", " + book1.getTitle() + ", " + book1.getCountry());
		return book1;
	}


	public List<BookDetail> getBooksDetail() {
		//https://my-json-server.typicode.com/Himuravidal/anchorBooks/bookDetail
		WebTarget target = client.target("https://my-json-server.typicode.com/Himuravidal/anchorBooks").path("bookDetail");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		List<BookDetail> listaBookD = response.readEntity(new GenericType<List<BookDetail>>() {});
		System.out.println("BOOK: getBooks(): Servicio invocado correctamente:" + response.getStatus() );
		
		return listaBookD;
	}

	public List<BookDetail> getBookDelevery(boolean delivery) {
		String url = "https://my-json-server.typicode.com/Himuravidal/anchorBooks/bookDetail?delivery=" + String.valueOf(delivery);  
		WebTarget target = client.target(url);
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		List<BookDetail> listaBook = response.readEntity(new GenericType<List<BookDetail>>() {});
		System.out.println("BOOK: getBooks(): Servicio invocado correctamente:" + response.getStatus() );
		
		return listaBook;
	}
	
	public List<BookDetail> getBookAuthor(String author1) {
		String url = "https://my-json-server.typicode.com/Himuravidal/anchorBooks/bookDetail?author=";
		author1 = author1.replace(" ", "%20");
		String aux = "";
		aux = url.concat(author1);
		System.out.println(aux);
		WebTarget target = client.target(aux);
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		List<BookDetail> listaBook = response.readEntity(new GenericType<List<BookDetail>>() {});
		System.out.println("BOOK: getBooks(): Servicio invocado correctamente:" + response.getStatus() );
		
		return listaBook;
	}
	
	public List<BookDetail> getBookAuthor1(String author1) {
		
		WebTarget target = client.target("https://my-json-server.typicode.com/Himuravidal/anchorBooks/bookDetail").queryParam("author", author1);
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		List<BookDetail> listaBook = response.readEntity(new GenericType<List<BookDetail>>() {});
		System.out.println("BOOK: getBooks(): Servicio invocado correctamente:" + response.getStatus() );
		
		return listaBook;
	}

	
	//https://my-json-server.typicode.com/Himuravidal/anchorBooks/bookDetail?author=Unknown
	
}
