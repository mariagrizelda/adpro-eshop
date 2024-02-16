package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProduct() {
        Product product = new Product();
        when(productRepository.create(any(Product.class))).thenReturn(product);

        Product createdProduct = productService.create(product);

        assertEquals(product, createdProduct);
        verify(productRepository, times(1)).create(product);
    }

    @Test
    void testFindAllProducts() {
        List<Product> productList = List.of(new Product(), new Product());
        Iterator<Product> productIterator = productList.iterator();
        when(productRepository.findAll()).thenReturn(productIterator);

        List<Product> allProducts = productService.findAll();

        assertEquals(productList.size(), allProducts.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void testGetProductById() {
        String productId = UUID.randomUUID().toString();
        Product product = new Product();
        product.setProductId(productId);

        Iterator<Product> productIterator = List.of(product).iterator();
        when(productRepository.findAll()).thenReturn(productIterator);

        Product retrievedProduct = productService.get(productId);

        assertEquals(product, retrievedProduct);
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void testEditProduct() {
        Product product = new Product();
        productService.edit(product);

        verify(productRepository, times(1)).edit(product);
    }

    @Test
    public void testDeleteProduct() {
        Product product = new Product();
        productService.delete(product);

        verify(productRepository, times(1)).delete(product);
    }
}
