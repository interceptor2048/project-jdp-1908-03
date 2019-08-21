package com.kodilla.ecommercee.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Dawid Nogacz on 21.08.2019
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Group is not empty")
public class GroupNotEmptyException extends Exception {}
