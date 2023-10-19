package pl.connectapp.uwaperow.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.connectapp.uwaperow.model.Image;
import pl.connectapp.uwaperow.model.Product;
import pl.connectapp.uwaperow.repository.ProductRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsById() {
        return productRepository.getProductsBySt_MagIdAndSt_Stan();

    }

    // Inne metody serwisu
}

