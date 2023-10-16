package org.example.advising;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;

import java.time.Clock;
import java.time.OffsetDateTime;

@RestControllerAdvice
public class ApiExceptionAdvising {

  private final Clock clock;

  public ApiExceptionAdvising(final Clock clock) {
    this.clock = clock;
  }

  @ExceptionHandler(PersonAgeException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ApiError handle(PersonAgeException exception, ServletWebRequest request) {
    return ApiError.builder()
        .label(HttpStatus.NOT_FOUND.getReasonPhrase())
        .status(HttpStatus.NOT_FOUND.value())
        .message(exception.getMessage())
        .path(request.getRequest().getRequestURI())
        .timestamp(OffsetDateTime.now(clock))
        .build();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ApiError handle(Exception exception, ServletWebRequest request) {
    return ApiError.builder()
        .label(HttpStatus.BAD_REQUEST.getReasonPhrase())
        .status(HttpStatus.BAD_REQUEST.value())
        .message(exception.getMessage())
        .path(request.getRequest().getRequestURI())
        .timestamp(OffsetDateTime.now(clock))
        .build();
  }
}
