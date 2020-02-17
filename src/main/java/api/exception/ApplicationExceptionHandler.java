package api.exception;

import api.model.IncrementNumbersResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApplicationExceptionHandler {

    /**
     * Обработка исключений сервиса.
     *
     * @param ex Исключение.
     * @return Ответ HTTP.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Object handle(Exception ex) {
        return IncrementNumbersResponse.builder()
                .errorMessage(ex.getMessage())
                .build();
    }
}
