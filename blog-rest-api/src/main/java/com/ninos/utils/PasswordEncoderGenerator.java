package com.ninos.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderGenerator {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println("this 'ninos' 222 password encode: " + passwordEncoder.encode("222"));
        System.out.println("this 'nahrain' 333 password encode: " + passwordEncoder.encode("333"));
        System.out.println("this 'matthew' 444 password encode: " + passwordEncoder.encode("333"));
    }
}
