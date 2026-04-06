package PhelipeProject.EncurtadorDeUrl.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class RequestUrl {

    @NotBlank(message = "Campo não pode ficar vazio")
    private String url;

    public RequestUrl(String url) {
        this.url = url;
    }
}
