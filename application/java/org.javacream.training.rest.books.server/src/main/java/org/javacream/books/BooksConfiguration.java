package org.javacream.books;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.SchoolBook;
import org.javacream.books.warehouse.api.SpecialistBook;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;

@Configuration
@Profile("dev")
@EnableAspectJAutoProxy
public class BooksConfiguration {

	@Bean
	@Qualifier("generatorsMap")
	public Map<Set<String>, Function<Map<String, Object>, Book>> generatorsMap() {
		Map<Set<String>, Function<Map<String, Object>, Book>> generators = new HashMap<>();
		HashSet<String> booksKeySet = new HashSet<>();
		generators.put(booksKeySet, (Map<String, Object> options) -> {
			Book book = new Book();
			return book;
		});

		HashSet<String> schoolBooksKeySet = new HashSet<>(booksKeySet);
		schoolBooksKeySet.add("subject");
		schoolBooksKeySet.add("year");
		generators.put(schoolBooksKeySet, (Map<String, Object> options) -> {
			SchoolBook book = new SchoolBook();
			book.setSubject((String) options.get("subject"));
			book.setYear((Integer) options.get("year"));
			return book;
		});
		HashSet<String> specialistBooksKeySet = new HashSet<>(booksKeySet);
		specialistBooksKeySet.add("topic");
		generators.put(specialistBooksKeySet, (Map<String, Object> options) -> {
			SpecialistBook book = new SpecialistBook();
			book.setTopic((String) options.get("topic"));
			return book;
		});
		return generators;
	}
	
	@Bean public TimedAspect timed(MeterRegistry meterRegistry) {
		return new TimedAspect(meterRegistry);
	}


}
