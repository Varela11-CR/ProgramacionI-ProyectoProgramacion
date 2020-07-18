package Utilities;

import org.apache.commons.lang3.StringUtils;

/**
 * @author JD101
 * 
 * Clase auxiliar para validar un formulario.
 */
public class ValidateForm {

    /**
     * Valida caracter por caracter que el valor ingresado sea un digito.
     * @param string
     * Toma un valor de tipo String para realizar las validaciones necesarias.
     * @return 
     * Retorna un valor booleano indicando si es un digito o no. True equivale a 
     * que el valor es un digito, False equivale a que el valor ingresado no es 
     * un digito.
     */
    public static boolean isDigit(String string) {

        for (int i = 0; i < string.length(); i++) {

            char character = string.charAt(i);
            int characterValueASCII = (int) character;

            //  Lista de caracteres.
            //  https://www.ajpdsoft.com/modules.php?name=News&file=article&sid=195#:~:text=Tambi%C3%A9n%20conocida%20como%20Alfabeto%20Latino,en%20total%20utilizan%208%20bits.
            if (characterValueASCII < 48 || characterValueASCII > 57) {
                return false;
            }

        }

        return true;
    }

    /**
     * Valida que el valor ingresado sea uno o varios nombres(incluye letras del 
     * abecedario en español).
     * @param string
     * Toma un valor de tipo String para realizar las validaciones necesarias.
     * @return 
     * Retorna un valor booleano indicando si es uno o varios nombres, o no. 
     * True equivale a que el valor es uno o varios nombres, False equivale a 
     * que el valor ingresado no es ni un nombre.
     */
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
    
    /**
     * Valida que el valor ingresado sea un apellido (incluye letras del 
     * abecedario en español).
     * @param string
     * Toma un valor de tipo String para realizar las validaciones necesarias.
     * @return 
     * Retorna un valor booleano indicando si es un apellido o no. True equivale 
     * a que el valor es un apellido, False equivale a que el valor ingresado no 
     * es un apellido.
     */
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

    /**
     * Valida que el valor ingresado sea un país (incluye letras del abecedario 
     * en español).
     * @param string
     * Toma un valor de tipo String para realizar las validaciones necesarias.
     * @return 
     */
    public static boolean isNationality(String string) {

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
    
    /**
     * Valida que el valor ingresado sea un número de teléfono(incluyendo los 
     * caracteres “+”, “ “).
     * @param string
     * Toma un valor de tipo String para realizar las validaciones necesarias.
     * @return 
     * Retorna un valor booleano indicando si es un número de teléfono o no. 
     * True equivale a que es un número de teléfono, False equivale a que no es 
     * un número de teléfono.
     */
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

    /**
     * Manipula el String ingresado y le da formato.
     * @param string
     * Toma un valor de tipo String y le aplica formato(Le hace un Capital Case 
     * y un .trim).
     * @return 
     * Retorna un valor de tipo String ya con el formato aplicado.
     */
    public static String manipulateString(String string){
        
        return StringUtils.capitalize(string.trim());

    }

}
