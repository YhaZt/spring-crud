package com.crud.sample.Web;


import org.springframework.http.ResponseEntity;

import com.crud.sample.exceptions.ApiError;

public class ResponseEntityBuilder {
    public static ResponseEntity<Object> build(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
  }
}