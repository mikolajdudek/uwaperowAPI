package pl.connectapp.uwaperow.controller;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.connectapp.uwaperow.model.Image;
import pl.connectapp.uwaperow.model.dto.ImageDTO;
import pl.connectapp.uwaperow.repository.ImageRepository;
import pl.connectapp.uwaperow.service.ImageService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequiredArgsConstructor
@RequestMapping("/getimages")
public class ImageController {

    private final ImageService imageService;
    private ImageRepository imageRepository;

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
                        //dodanie do bazy
                        imageService.addImage(imageUrl);
                    }
                }

                if (!foundNewImages) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageUrls;
    }

}
