/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tw.shoppingapp.loader;

import com.tw.shoppingapp.entity.Product;
import com.tw.shoppingapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final ProductRepository repository;

	@Autowired
	public DatabaseLoader(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		this.repository.save(new Product("Spectacles", "Awesome Spectacles", 10.2D, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLjO4vMxSkwHP4N9i-3FPsbBrJ4oBzYI97LMAHsebHAY_Q_WEL", 2, "Apparels"));
		this.repository.save(new Product("Shirt", "Awesome Shirt", 20.2D, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLjO4vMxSkwHP4N9i-3FPsbBrJ4oBzYI97LMAHsebHAY_Q_WEL", 2, "Apparels"));
		this.repository.save(new Product("Pants", "Awesome Pants", 30.2D, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLjO4vMxSkwHP4N9i-3FPsbBrJ4oBzYI97LMAHsebHAY_Q_WEL", 2, "Apparels"));
		this.repository.save(new Product("Belt", "Awesome Belt", 40.2D, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLjO4vMxSkwHP4N9i-3FPsbBrJ4oBzYI97LMAHsebHAY_Q_WEL", 2, "Apparels"));
	}
}