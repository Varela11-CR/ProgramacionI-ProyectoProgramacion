package Utilities;

/**
 *
 * @author JD101
 */
public class ValidateUser {

    /**
     * Valida que la cadena ingresada como parámetro tenga el formato de un
     * nombre de usuario.
     *
     * @param string Toma un objeto de tipo String para verificar que contenga 4
     * o más caracteres y que no tenga un espacio en blanco de carácter.
     * @return Retorna un valor booleano para indicar si es o no una cadena con
     * formato de nombre de usuario. True equivale a que es una cadena con
     * formato nombre de usuario, False equivale a que no es una cadena con
     * formato nombre de usuario.
     */
    public static boolean isUserName(String string) {

        if (string.length() < 4) {
            return false;
        }

        for (int i = 0; i < string.length(); i++) {

            char character = string.charAt(i);
            int characterValueASCII = (int) character;

            if (characterValueASCII == 32) {
                return false;
            }

        }

        return true;

    }

    /**
     * Valida que la cadena ingresada como parámetro tenga el formato de
     * contraseña.
     *
     * @param string Toma un objeto de tipo String para verificar que contenga 8
     * o más caracteres y que no tenga un espacio en blanco de carácter.
     * @return Retorna un valor booleano para indicar si es o no una cadena con
     * formato de contraseña. True equivale a que es una cadena con formato
     * contraseña, False equivale a que no es una cadena con formato contraseña.
     */
    public static boolean isPassword(String string) {

        if (string.length() < 7) {
            return false;
        }

        for (int i = 0; i < string.length(); i++) {

            char character = string.charAt(i);
            int characterValueASCII = (int) character;

            if (characterValueASCII == 32) {
                return false;
            }

        }

        return true;

    }

}
