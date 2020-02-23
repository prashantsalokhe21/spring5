/**
 * 
 */
package prashant21tube.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import prashant21tube.springframework.spring5webapp.model.Author;
import prashant21tube.springframework.spring5webapp.model.Book;
import prashant21tube.springframework.spring5webapp.repository.AuthorRepository;
import prashant21tube.springframework.spring5webapp.repository.BookRepository;

/**
 * @author Prashant Salokhe
 *
 */
@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	
	public DevBootStrap(AuthorRepository authorRepo, BookRepository bookRepo) {
		authorRepository = authorRepo;
		bookRepository = bookRepo;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();
	}

	private void initData() {
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");

		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);

		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Developemnt without EJB", "23444", "Worx");

		rod.getBooks().add(ddd);
		noEJB.getAuthors().add(eric);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
	}

}
