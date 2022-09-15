package com.app.encoder;

public interface PasswordEncoder {
    String encode(String text);
    boolean check(String text, String hashed);
}
