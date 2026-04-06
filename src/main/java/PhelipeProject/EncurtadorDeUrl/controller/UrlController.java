package PhelipeProject.EncurtadorDeUrl.controller;

import PhelipeProject.EncurtadorDeUrl.dto.RequestUrl;
import PhelipeProject.EncurtadorDeUrl.dto.ResponseUrl;
import PhelipeProject.EncurtadorDeUrl.service.ServiceUrl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class UrlController {

    private final ServiceUrl serviceUrl;

    public UrlController(ServiceUrl serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    @PostMapping("/add")
    public ResponseUrl addUrlEncurtada(@Valid @RequestBody RequestUrl requestUrl) throws IOException, InterruptedException {
        return serviceUrl.urlEncurtadaBanco(requestUrl);
    }
}
