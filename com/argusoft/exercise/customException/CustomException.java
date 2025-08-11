package com.argusoft.exercise.customException;

class EmptyQueueException extends Exception {
    public EmptyQueueException (String message) {
        super(message);
    }
}

class EmptyStackException extends Exception {
    public EmptyStackException(String message) {
        super(message);
    }
}

class KeyNotFoundException extends Exception {
    public KeyNotFoundException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}


