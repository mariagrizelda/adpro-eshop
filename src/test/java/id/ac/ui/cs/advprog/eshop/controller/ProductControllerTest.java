package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.controller.ProductController;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        // Initialize mocks before each test
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createProductPageTest() {
        // Arrange
        Product product = new Product();

        // Act
        String viewName = productController.createProductPage(model);

        // Assert
        assertEquals("CreateProduct", viewName);
        verify(model, times(1)).addAttribute(eq("product"), any(Product.class));
    }

    @Test
    void createProductPostTest() {
        // Arrange
        Product product = new Product();

        // Act
        String viewName = productController.createProductPost(product, model);

        // Assert
        assertEquals("redirect:list", viewName);
        verify(productService, times(1)).create(any(Product.class));
    }

    @Test
    void productListPageTest() {
        // Arrange
        List<Product> productList = Arrays.asList(new Product(), new Product());
        when(productService.findAll()).thenReturn(productList);

        // Act
        String viewName = productController.productListPage(model);

        // Assert
        assertEquals("ProductList", viewName);
        verify(model, times(1)).addAttribute(eq("products"), eq(productList));
    }

    @Test
    void editProductPageTest() {
        // Arrange
        String productId = "123";
        Product product = new Product();
        when(productService.get(productId)).thenReturn(product);

        // Act
        String viewName = productController.editProductPage(model, productId);

        // Assert
        assertEquals("EditProduct", viewName);
        verify(model, times(1)).addAttribute(eq("product"), eq(product));
    }

    @Test
    void editProductPostTest() {
        // Arrange
        Product product = new Product();

        // Act
        String viewName = productController.editProductPost(product);

        // Assert
        assertEquals("redirect:list", viewName);
        verify(productService, times(1)).edit(any(Product.class));
    }

    @Test
    void deletePostTest() {
        // Arrange
        String productId = "123";
        Product product = new Product();
        when(productService.get(productId)).thenReturn(product);

        // Act
        String viewName = productController.deletePost(productId);

        // Assert
        assertEquals("redirect:/product/list", viewName);
        verify(productService, times(1)).delete(any(Product.class));
    }
}
