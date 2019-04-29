package pl.softsystem.wyklad1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import pl.softsystem.wyklad1.controller.validators.ValidationException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@RestController
public class ErrorHandler {

    private static final Logger LOG = LoggerFactory.getLogger("LOG");

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> defaultErrorHandler(HttpServletRequest req, Exception e) {
        logExceptionAndPrintStackTrace(e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<String> exceptionWithValidationMessage(HttpServletRequest req, Exception e) {
        LOG.error("Model is not valid");
        logExceptionAndPrintStackTrace(e);
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(e.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public final ResponseEntity<String> handleAccessDeniedException(AccessDeniedException e, WebRequest request) {
        logExceptionAndPrintStackTrace(e);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
    }

    private void logExceptionAndPrintStackTrace(Exception e) {
        LOG.error(e.getLocalizedMessage());
        e.printStackTrace(System.out);
    }
}
