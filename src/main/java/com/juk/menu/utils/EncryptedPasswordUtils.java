package com.juk.menu.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Создаём класс EncryptedPasswordUtils для того чтобы можно было декодировать наш пароль
 *
 * @author Shakhov Yevhen
 */

public class EncryptedPasswordUtils {
    /**
     * Создаём метод encryptedPassword в который приходит наш пароль,а потом мы его декодируем.
     *
     * @param password
     * @return
     */
    public static String encryptedPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode( password );
    }

    /**
     * Делаем метод main для того чтобы задекодировать пароль
     *
     * @param args
     */
    public static void main(String[] args) {
        String password = "1992"; //вводим наш пароль
        String encryptedPassword = encryptedPassword( password ); //с помощью метода который написан выше
        // декодируем пароль и выводим его на экран

        System.out.println( "Encrypted Password: " + encryptedPassword );
    }
}
