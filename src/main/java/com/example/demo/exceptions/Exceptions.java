package com.example.demo.exceptions;

/**
 * Exception Handler
 */
public interface Exceptions {
    public static RuntimeException RUNTIME_EXCEPTION = new RuntimeException(":: EXCEPTION :: Runtime Occurr.");
    public static RuntimeException FAILED_LOGIN_EXCEPTION = new RuntimeException(":: EXCEPTION:: Failed to Login.");
    public static RuntimeException FAILED_QUERY_EXCEPTION = new RuntimeException(":: EXCEPTION:: Failed to SQL Query.");
}
