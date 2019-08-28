package com.kodilla.ecommercee.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Group not found")
public class GroupNotFoundException extends Exception {}
