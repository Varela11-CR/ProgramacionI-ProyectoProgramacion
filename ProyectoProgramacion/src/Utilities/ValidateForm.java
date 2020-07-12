/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import com.sun.xml.internal.ws.util.StringUtils;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author JD101
 */
public class ValidateForm {

    public static boolean isDigit(String string) {

        try {

            Integer.parseInt(string);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static boolean isNames(String string) {

        for (int i = 0; i < string.length(); i++) {

            char character = string.toLowerCase().charAt(i);
            int characterValueASCII = (int) character;

            if ((characterValueASCII < 97 || characterValueASCII > 122)
                    && (characterValueASCII < 224 || characterValueASCII > 246)
                    && (characterValueASCII < 249 || characterValueASCII > 252)
                    && characterValueASCII != 32) {

                return false;

            }

        }

        return true;

    }
    
    public static boolean isLastname(String string) {

        for (int i = 0; i < string.length(); i++) {

            char character = string.toLowerCase().charAt(i);
            int characterValueASCII = (int) character;

            if ((characterValueASCII < 97 || characterValueASCII > 122)
                    && (characterValueASCII < 224 || characterValueASCII > 246)
                    && (characterValueASCII < 249 || characterValueASCII > 252)) {

                return false;

            }

        }

        return true;

    }

    public static boolean isPhoneNumber(String string) {

        for (int i = 0; i < string.length(); i++) {

            char character = string.charAt(i);
            int characterValueASCII = (int) character;

            if ((characterValueASCII < 48 || characterValueASCII > 57)
                    && characterValueASCII != 43 && characterValueASCII != 32) {

                return false;

            }

        }

        return true;

    }

    public static String manipulateString(String string) throws UnsupportedEncodingException {
        
        return StringUtils.capitalize(string.trim());

    }

}
