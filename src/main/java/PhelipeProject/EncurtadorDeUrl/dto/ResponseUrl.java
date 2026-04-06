package PhelipeProject.EncurtadorDeUrl.dto;

import lombok.Getter;

@Getter
public class ResponseUrl {

    private boolean success;

    private String message;

    public ResponseUrl(boolean success, String urlEncurtada) {
        this.success = success;
        this.message = urlEncurtada;
    }
}
