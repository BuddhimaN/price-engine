package com.retailsuper.priceengine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class to handle Exceptions
 *
 * @author BuddhimaN
 * @since 01/20
 */

@ControllerAdvice
public class RetailSuperExceptionHandler {

    @ExceptionHandler(value = ProductNotFoundException.class)
    public void handleNotFoundExceptions(HttpServletResponse response,
                                                                 ProductNotFoundException exception) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(),exception.getMessage());
    }

    @ExceptionHandler(value ={ InvalidSettingValueException.class,DuplicateProductException.class})
    public void handleInvalidDataExceptions(HttpServletResponse response,
                                                                     InvalidSettingValueException exception) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(),exception.getMessage());
    }
}
