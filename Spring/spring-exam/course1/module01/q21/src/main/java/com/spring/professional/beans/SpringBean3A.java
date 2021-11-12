package com.spring.professional.beans;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

public class SpringBean3A implements SpringBean3{
    private final MessageDigest messageDigest;

    public SpringBean3A(MessageDigest messageDigest) {
        this.messageDigest = messageDigest;
    }

    @Override
    public void printHash() {
        byte[] hashBytes = messageDigest.digest("test".getBytes());
        char[] hashString = Hex.encodeHex(hashBytes);
        System.out.println(hashString);
    }
}
