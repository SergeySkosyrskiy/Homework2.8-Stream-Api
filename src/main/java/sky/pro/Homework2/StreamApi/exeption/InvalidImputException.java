package sky.pro.Homework2.StreamApi.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//домашка про библиотеки 2.10
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidImputException extends RuntimeException {
    public InvalidImputException() {
    }

    public InvalidImputException(String message) {
        super(message);
    }

    public InvalidImputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidImputException(Throwable cause) {
        super(cause);
    }

    public InvalidImputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
