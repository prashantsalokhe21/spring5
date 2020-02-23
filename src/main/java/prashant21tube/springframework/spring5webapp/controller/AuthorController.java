/**
 * 
 */
package prashant21tube.springframework.spring5webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import prashant21tube.springframework.spring5webapp.repository.AuthorRepository;

/**
 * @author lenovo
 *
 */
@Controller
public class AuthorController {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@RequestMapping(value="/authors", method=RequestMethod.GET)
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorRepository.findAll());
		
		return "authors";
	}

}
