package com.practice.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.practice.spring5webapp.model.Author;
import com.practice.spring5webapp.model.Book;
import com.practice.spring5webapp.repositories.AuthorRepository;
import com.practice.spring5webapp.repositories.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;

	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
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
	}

}
