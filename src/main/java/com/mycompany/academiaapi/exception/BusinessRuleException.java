package com.mycompany.academiaapi.exception;

/**
 * Exceção para regras de negócio.
 * @author wesia
 */
public class BusinessRuleException extends RuntimeException {
    public BusinessRuleException(String message) { super(message); }
}
