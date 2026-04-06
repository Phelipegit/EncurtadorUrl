package PhelipeProject.EncurtadorDeUrl.service;

import PhelipeProject.EncurtadorDeUrl.dto.RecordUrlEncurtada;
import PhelipeProject.EncurtadorDeUrl.dto.RequestUrl;
import PhelipeProject.EncurtadorDeUrl.dto.ResponseUrl;
import PhelipeProject.EncurtadorDeUrl.entity.EntityUrl;
import PhelipeProject.EncurtadorDeUrl.repository.RepositoryUrl;
import jakarta.persistence.Entity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.concurrent.Future;

@Service
public class ServiceUrl {

    private final RepositoryUrl repositoryUrl;
    private final ObterUrlEncurtada obterUrlEncurtada;

    public ServiceUrl(RepositoryUrl repositoryUrl,ObterUrlEncurtada obterUrlEncurtada) {
        this.repositoryUrl = repositoryUrl;
        this.obterUrlEncurtada = obterUrlEncurtada;
    }

    public ResponseUrl urlEncurtadaBanco(RequestUrl url) throws IOException, InterruptedException {

        ObjectMapper objectMapper = new ObjectMapper();

        String json = obterUrlEncurtada.obterUrl(url.getUrl());

        RecordUrlEncurtada record = objectMapper.readValue(json, RecordUrlEncurtada.class);

        EntityUrl entityUrl = new EntityUrl(url.getUrl(),record.urlEncurtada(),LocalDate.now());

        Optional<EntityUrl> exist = repositoryUrl.findByUrl(url.getUrl());

        if(exist.isPresent()) {
            return new ResponseUrl(false,"URL encurtada já existe");
        }

        repositoryUrl.save(entityUrl);

        return new ResponseUrl(true,record.urlEncurtada());
    }
}
