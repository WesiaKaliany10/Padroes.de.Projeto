package com.mycompany.academiaapi.exception;

/**
 * Exceção para recurso não encontrado.
 * @author wesia
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) { super(message); }
}
