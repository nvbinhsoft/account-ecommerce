package com.ecommerce.account.configuration.security;

import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;

/**
 * The PasswordHasher provides methods for hashing passwords and verifying input passwords.
 * <p>
 * This class utilizes the bcrypt algorithm to hash passwords, enhancing security before storing
 * them in a database. The hashPassword method should be used during user registration,
 * and the checkPassword method should be employed during user login.
 * </p>
 *
 * @author [Binh Nguyen Van]
 * @since 2023-09-24
 */
@Slf4j
public class PasswordHasher {

    /**
     * Hash password using BCrypt
     *
     * @param plainPassword password need to hash
     * @return password has been hashed
     */
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    /**
     * Verify the password that user input matches the hashed password stored in the database.
     *
     * @param plainPassword password user input.
     * @param hashedPassword hashed password.
     * @return true if matches, false if not matches.
     */
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    public static void main(String[] args) {
        String password = "mySecretPassword";
        String hashed = hashPassword(password);

        log.info("Original Password: " + password);
        log.info("Hashed Password: " + hashed);

        if (checkPassword("mySecretPassword", hashed)) {
            log.info("Password matches!");
        } else {
            log.info("Password does not match!");
        }
    }
}
