package com.kodilla.ecommercee.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Exception: Cart not found")
public class CartNotFoundException extends RuntimeException {}
