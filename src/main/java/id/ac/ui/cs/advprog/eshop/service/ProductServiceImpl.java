package id.ac.ui.cs.advprog.eshop.service;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org. springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        product.setProductId(String.valueOf(UUID.randomUUID()));
        productRepository.create(product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        Iterator<Product> productIterator = productRepository.findAll();
        List<Product> allProduct = new ArrayList<>();
        productIterator.forEachRemaining(allProduct::add);
        return allProduct;
    }

    @Override
    public Product get(String id) {
        return null;
    }

    @Override
    public void edit(Product product) {

    }

    public Product findById(String id) {
        Product product = null;
        Iterator<Product> products = productRepository.findAll();
        while (products.hasNext()) {
            Product cur = products.next();
            if (cur.getProductId().equals(id)) {
                product = cur;
                break;
            }
        }
        return product;
    }

    public void update(Product product) {
        productRepository.edit(product);

    }

    public void delete(Product product) {
        if (product != null) {
            productRepository.delete(product);
        }
    }
}