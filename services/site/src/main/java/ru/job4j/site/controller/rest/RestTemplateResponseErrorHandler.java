package ru.job4j.site.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import ru.job4j.site.exception.RestTemplateErrorException;

import java.io.IOException;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return (response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
                || response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
            throw new RestTemplateErrorException("Ошибка 5хх обработана RestTemplateResponseErrorHandler");
        }
        if (response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
                && response.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new RestTemplateErrorException("Ошибка 4хх и 5хх обработана RestTemplateResponseErrorHandler");
        }
    }
}
