package com.dago.produit.exceptions;

import com.dago.produit.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProduitExceptionHandler {

    @ExceptionHandler(ProduitNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleProduitNotFoundException(ProduitNotFoundException produitException){
        ErrorMessage errorMessage = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                produitException.getMessage()
        );
        return new  ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
