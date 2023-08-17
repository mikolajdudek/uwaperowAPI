package pl.connectapp.uwaperow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.connectapp.uwaperow.model.Product;
import pl.connectapp.uwaperow.service.ProductService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    private List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/MagId=2")
    private List<Product> getProductsById(){
        return productService.getProductsById();
    }


}

