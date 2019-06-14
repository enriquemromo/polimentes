package com.toto.testpolimentes.util;

import java.util.regex.Pattern;

public class Utility {

    private static final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private static final String UPPERCASE_LETTER_PATTERN = ".*[A-Z].*";
    private static final String DIGIT_PATTERN = ".*\\d.*";
    private static final String SPECIAL_CHARACTERS_PATTERN = ".*[\\.\\-@\\,].*";
    private static final String GMAIL_DOMAIN = "gmail.com";
    private static final String YAHOO_DOMAIN = "yahoo.com";
    private static final String HOTMAIL_DOMAIN = "hotmail.com";

    public static boolean validateLongitudeEmail(String email){
        return email.length() > 4 ? true : false;
    }
    public static boolean valiateDomain(String email){

        if(email.contains(GMAIL_DOMAIN)||email.contains(YAHOO_DOMAIN)||email.contains(HOTMAIL_DOMAIN)){
            return  true;
        } else{
            return false;
        }

    }

    public static boolean  validateEmailPattern(String email){
        return Pattern.compile(EMAIL_PATTERN).matcher(email).matches();
    }


    public static boolean containsUppercaseLetter(String value){
        return Pattern.compile(UPPERCASE_LETTER_PATTERN).matcher(value).matches();
    }

    public static boolean containsDigit(String value){
        return Pattern.compile(DIGIT_PATTERN).matcher(value).matches();
    }
    public static boolean containsSpecialCharacters(String value){
        return Pattern.compile(SPECIAL_CHARACTERS_PATTERN).matcher(value).matches();
    }

}
