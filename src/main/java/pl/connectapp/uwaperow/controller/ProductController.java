package pl.connectapp.uwaperow.controller;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.connectapp.uwaperow.model.Product;
import pl.connectapp.uwaperow.repository.ProductRepository;
import pl.connectapp.uwaperow.service.ProductService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    @GetMapping("/products")
    private List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/MagId=2")
    private List<Product> getProductsById(){
        return productService.getProductsById();
    }


    //kod który skanuje strone w celu pozyskania zdj. oraz przypisuje zdj do nazwy
/*
    @GetMapping("/all")
    public List<String> getAllImages() {
        List<String> imageUrls = new ArrayList<>();
        try {
            int totalPages = 100; // Liczba stron do przeszukania
            String baseUrl = "https://evaper.pl/2-strona-glowna?page=";

            for (int page = 1; page <= totalPages; page++) {
                String url = baseUrl + page;
                Document document = Jsoup.connect(url).get();
                Elements imgElements = document.select("img"); // Znajdź wszystkie elementy <img>

                boolean foundNewImages = false; // Czy znaleziono nowe obrazy na tej stronie

                for (Element imgElement : imgElements) {
                    String imageUrl = imgElement.attr("src"); // Pobierz atrybut src obrazka
                    if (!imageUrl.isEmpty() && !imageUrls.contains(imageUrl)) {
                        imageUrls.add(imageUrl);
                        foundNewImages = true;
                    }
                }

                if (!foundNewImages) {
                    break;
                }
            }

            //List<String> productNamesAndUrls = extractProductNamesAndUrls(imageUrls);
            // Tutaj można dodać logikę zapisywania do bazy lub zwrócić listę productNamesAndUrls jako odpowiedź API
           // saveProductsAndUrlsToDatabase(productNamesAndUrls); // Dodaj tę linię do zapisu do bazy
           // return imageUrls;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageUrls;
    }
/*
    private List<String> extractProductNamesAndUrls(List<String> imageUrls) {
        List<String> productNamesAndUrls = new ArrayList<>();

        for (String imageUrl : imageUrls) {
            String productName = extractProductNameFromImageUrl(imageUrl);
            if (productName != null) {
                String productAndUrl = productName + ": " + imageUrl;
                productNamesAndUrls.add(productAndUrl);
            }
        }

        return productNamesAndUrls;
    }

    private String extractProductNameFromImageUrl(String imageUrl) {
        // Przykład adresu URL: "https://evaper.pl/1371-home_default/premix-lqdr-jabolove-jablko-wisnia-20ml.jpg"
        String[] parts = imageUrl.split("/");
        String lastPart = parts[parts.length - 1]; // Ostatni element z URL (premix-lqdr-jabolove-jablko-wisnia-20ml.jpg)
        String productName = lastPart.split("-home_default")[0]; // Wyodrębnij nazwę produktu bez "-home_default"

        // Zamień myślniki na spacje
        productName = productName.replace("-", " ");
        // Usuń rozszerzenie ".jpg"
        productName = productName.replace(".jpg", "");
        System.out.println(productName); // Wyświetli: "premix lqdr jabolove jablko wisnia 20ml"

        return productName.toUpperCase();
    }

    private void saveProductsAndUrlsToDatabase(List<String> productNamesAndUrls) {
        for (String productNameAndUrl : productNamesAndUrls) {
            String[] parts = productNameAndUrl.split(": ");
            String productName = parts[0];
            String imageUrl = parts[1];

            Product product = productRepository.findByTw_Nazwa(productName);
            if (product != null) {
                product.setImageUrl(imageUrl);
                productRepository.save(product);
            }
        }
    }

 */
}

