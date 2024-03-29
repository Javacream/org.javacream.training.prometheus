package org.javacream.store.web;

import org.javacream.store.api.StoreService;
import org.javacream.util.aspect.CountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping(path = "api")
@CrossOrigin
@Timed("store")
public class StoreWebService {

	@Autowired
	private StoreService storeService;

	@CountRequest
	@GetMapping(path = "store/{category}/{item}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getStock(@PathVariable("category") String category, @PathVariable("item") String item) {
		return Integer.toString(storeService.getStock(category, item));
	}

	@CountRequest
	@PostMapping(path = "store/{category}/{item}", produces = MediaType.TEXT_PLAIN_VALUE)
	public void setStock(@PathVariable("category") String category, @PathVariable("item") String item,
			@RequestHeader("stock") int stock) {
		storeService.setStock(category, item, stock);
	}
}