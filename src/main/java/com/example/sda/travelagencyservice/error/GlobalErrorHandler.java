package com.example.sda.travelagencyservice.error;

import com.example.sda.travelagencyservice.exception.BadRequestException;
import com.example.sda.travelagencyservice.exception.ConflictException;
import com.example.sda.travelagencyservice.exception.NotFoundException;
import com.example.sda.travelagencyservice.exception.PlaceAvailable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(value = ConflictException.class)
    public ResponseEntity<Object> handleEntityExists(ConflictException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorDto(e.getMessage()));
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(e.getMessage()));
    }


    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDto(e.getMessage()));
    }

    @ExceptionHandler(value = PlaceAvailable.class)
    public ResponseEntity<Object> handlePlace(PlaceAvailable e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDto(e.getMessage()));
    }

}
