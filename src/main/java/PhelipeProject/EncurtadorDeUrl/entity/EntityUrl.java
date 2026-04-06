package PhelipeProject.EncurtadorDeUrl.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "url")
@Getter
public class EntityUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String url;

    @NotBlank
    private String urlEncurtada;

    private LocalDate date;

    public EntityUrl(String url, String urlEncurtada, LocalDate date) {
        this.url = url;
        this.urlEncurtada = urlEncurtada;
        this.date = date;
    }

    public EntityUrl() {

    }
}
