package PhelipeProject.EncurtadorDeUrl.controller;

import PhelipeProject.EncurtadorDeUrl.entity.EntityUrl;
import PhelipeProject.EncurtadorDeUrl.repository.RepositoryUrl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/get/")
public class UrlGetAllUrlEncurtada {

    private final RepositoryUrl repositoryUrl;

    public UrlGetAllUrlEncurtada(RepositoryUrl repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    @GetMapping("allurl")
    public List<EntityUrl> getAll() {
        return repositoryUrl.findAll();
    }
    
    @GetMapping("url/{id}")
    public Optional<EntityUrl> getById(@PathVariable UUID id) {
        return repositoryUrl.findById(id);
    }
}
