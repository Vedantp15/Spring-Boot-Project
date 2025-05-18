package com.jsp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DoesNotExistException extends RuntimeException {

	private String message;
}
