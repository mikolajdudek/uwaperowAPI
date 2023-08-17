package pl.connectapp.uwaperow.controller;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/getimages")
public class ImageController {

    private final String JSON_FILE_PATH = "images.json";
    private List<String> imageUrls = new ArrayList<>();

    @GetMapping("/all")
    public List<String> getAllImages() {
        try {
            int totalPages = 40; // Liczba stron do przeszukania
            String baseUrl = "https://evaper.pl/2-strona-glowna?page=";

            for (int page = 1; page <= totalPages; page++) {
                String url = baseUrl + page;
                Document document = Jsoup.connect(url).get();
                Elements imgElements = document.select("img"); // Znajdź wszystkie elementy <img>

                for (Element imgElement : imgElements) {
                    String imageUrl = imgElement.attr("src"); // Pobierz atrybut src obrazka
                    if (!imageUrl.isEmpty() && !imageUrls.contains(imageUrl)) {
                        imageUrls.add(imageUrl);
                    }
                }
            }

            saveToJSON();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageUrls;
    }

    private void saveToJSON() throws IOException {
        try (FileWriter fileWriter = new FileWriter(JSON_FILE_PATH)) {
            for (String imageUrl : imageUrls) {
                fileWriter.write("'"+imageUrl + "'"+ "\n");
            }
        }
    }
}
