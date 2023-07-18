package org.javacream.books.isbngenerator.web;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.util.aspect.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
@CrossOrigin
public class WebIsbnGenerator {
	@Autowired
	IsbnGenerator isbnGenerator;

	@PostMapping(path = "isbn", produces = MediaType.TEXT_PLAIN_VALUE)
	@Trace
	public String nextIsbn() {
		return isbnGenerator.next();
	}
}