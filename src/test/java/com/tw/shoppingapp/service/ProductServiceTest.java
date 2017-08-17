package com.tw.shoppingapp.service;

import com.tw.shoppingapp.entity.Category;
import com.tw.shoppingapp.entity.Product;
import com.tw.shoppingapp.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    ProductService service;

    @Mock
    ProductRepository repository;

    @Test
    public void shouldFetchProductListWhenproductsExists() throws Exception {
        Page<Product> products = getProducts();
        when(repository.findByCategoryId(PageRequest.of(0, 20), 1L)).thenReturn(products);
        Page<Product> returnedProducts = service.getProductsByCategory(0, 1L);

        for (int counter = 0; counter < returnedProducts.getContent().size(); counter++) {
            assertThat(returnedProducts.getContent().get(counter), is(products.getContent().get(counter)));
        }
    }


    @Test
    public void shouldCreateProduct() throws Exception {
        Product product = new Product("Spectacles", "Awesome Spectacles", 10.2D, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLjO4vMxSkwHP4N9i-3FPsbBrJ4oBzYI97LMAHsebHAY_Q_WEL", 2, new Category("Apparels"));
        Product productWithId = new Product("Spectacles", "Awesome Spectacles", 10.2D, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLjO4vMxSkwHP4N9i-3FPsbBrJ4oBzYI97LMAHsebHAY_Q_WEL", 2, new Category("Apparels"));
        productWithId.setId(1);
        when(repository.save(product)).thenReturn(productWithId);
        Product createdProduct = service.createProduct(product);
        assertThat(createdProduct, is(productWithId));
    }

    @Test
    public void shouldUpdateProductWhenProductExists() throws Exception {
        Product product = new Product("Spectacles", "Awesome Spectacles", 10.2D, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLjO4vMxSkwHP4N9i-3FPsbBrJ4oBzYI97LMAHsebHAY_Q_WEL", 2, new Category("Apparels"));
        product.setId(1);
        when(repository.getOne(1L)).thenReturn(product);
        when(repository.save(product)).thenReturn(product);
        Product updateProduct = service.updateProduct(product);
        assertThat(updateProduct, is(product));
    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldThrowExceptionWhenProductDoesNotExists() throws Exception {
        Product product = new Product("Spectacles", "Awesome Spectacles", 10.2D, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLjO4vMxSkwHP4N9i-3FPsbBrJ4oBzYI97LMAHsebHAY_Q_WEL", 2, new Category("Apparels"));
        product.setId(1L);
        when(repository.getOne(1L)).thenReturn(null);
        service.updateProduct(product);
    }

    @Test
    public void deleteProduct() throws Exception {
        Product product = new Product("Spectacles", "Awesome Spectacles", 10.2D, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLjO4vMxSkwHP4N9i-3FPsbBrJ4oBzYI97LMAHsebHAY_Q_WEL", 2, new Category("Apparels"));
        product.setId(1L);
        when(repository.getOne(1L)).thenReturn(product);
        service.deleteProduct(1L);
    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldThrowExceptionWhenProductDoesNotExistsWhileDeletingTheproduct() throws Exception {
        Product product = new Product("Spectacles", "Awesome Spectacles", 10.2D, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLjO4vMxSkwHP4N9i-3FPsbBrJ4oBzYI97LMAHsebHAY_Q_WEL", 2, new Category("Apparels"));
        product.setId(1L);
        when(repository.getOne(1L)).thenReturn(null);
        service.deleteProduct(1L);
    }

    public Page<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Spectacles", "Awesome Spectacles", 10.2D, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLjO4vMxSkwHP4N9i-3FPsbBrJ4oBzYI97LMAHsebHAY_Q_WEL", 2, new Category("Apparels")));
        products.add(new Product("Shirt", "Awesome Shirt", 20.2D, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLjO4vMxSkwHP4N9i-3FPsbBrJ4oBzYI97LMAHsebHAY_Q_WEL", 2, new Category("Apparels")));
        Page<Product> productPage = new PageImpl<>(products, PageRequest.of(0, 10), 50);
        return productPage;
    }
}