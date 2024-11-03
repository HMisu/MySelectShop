package com.sparta.myselectshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 컨트롤러마다 예외 처리하는 것이 아닌 글로벌하게 예외처리
// @RestControllerAdvice : ControllerAdvice + Response body
// @ControllerAdvice : Spring Framework에서 제공하는 애너테이션으로, 전역적인 예외 처리 및 모델 속성 설정을 가능하게 함
// ControllerAdvice는 클래스에만 달 수 있음 문서 보면, @Target(ElementType.Type)
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<RestApiException> handleException(IllegalArgumentException ex) {
        RestApiException restApiException = new RestApiException(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(
                // HTTP body
                restApiException,
                // HTTP status code
                HttpStatus.BAD_REQUEST
        );
    }
}