package com.practice.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.practice.spring5webapp.model.Author;
import com.practice.spring5webapp.model.Book;
import com.practice.spring5webapp.model.Publisher;
import com.practice.spring5webapp.repositories.AuthorRepository;
import com.practice.spring5webapp.repositories.BookRepository;
import com.practice.spring5webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Author a1 = new Author();
		a1.setFirstName("John");
		a1.setLastName("Watson");
		Book b1 = new Book();
		b1.setTitle("Spring Course");
		b1.setIsbn("djzkfhksdhfkj");
		a1.getBooks().add(b1);
		b1.getAuthors().add(a1);

		authorRepository.save(a1);
		bookRepository.save(b1);

		System.out.println("Book Count: " + bookRepository.count());
		System.out.println("---------------------------------------");
		Publisher publisher = new Publisher();
		publisher.setName("Shane Thomas");
		publisher.setCity("Bangalore");
		publisher.setState("Karnataka");
		publisher.setZip("27873812");
		publisher.setAddressLine1("51-C, Brookefield area");
		publisherRepository.save(publisher);
		System.out.println(publisher);
		System.out.println("Publisher Count: " + publisherRepository.count());
	}

}
