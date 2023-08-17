package pl.connectapp.uwaperow.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api")
public class ImageApiController {

    @GetMapping("/putimages")
    public String getImageUrls() throws IOException {
        Resource resource = new ClassPathResource("images.json");
        InputStream inputStream = resource.getInputStream();
        return StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
    }
}
