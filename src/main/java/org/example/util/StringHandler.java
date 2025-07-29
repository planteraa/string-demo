package org.example.util;

import com.sun.javafx.binding.StringConstant;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

/**
 * UtilClass for String processing
 */
@Slf4j
public class StringHandler {
    // REGEXP matching lowercase letter a-z
    private static final Pattern LOWERCASE_LETTER = Pattern.compile("[a-z]*");

    /**
     * Handle consecutive chars that appears 3 or more times
     * @param str targetString
     * @param handleStrategy handle strategy
     * @return
     */
    public static String handleConsecutiveChar(String str, HandleStrategy handleStrategy) {
        // params check
        if (str == null || str.isEmpty()) {
            return str;
        }

        if (!LOWERCASE_LETTER.matcher(str).matches()) {
            log.error("Illegal input: Only lowercase letters a-z are allowed");
            throw new IllegalArgumentException("Illegal input: Only lowercase letters a-z are allowed");
        }
        if (handleStrategy == null) {
            log.error("Illegal process strategy");
            throw new IllegalArgumentException("Illegal process strategy");
        }

        String curString = str;
        String lastString = "";
        // Loop processing until the result remains unchanged
        while (!curString.equals(lastString)) {
            lastString = curString;
            curString = handleStrategy.StringHandle(curString);
            // print current string process result
            log.info("Current string process result: {}", curString);
        }

        return curString;
    }
}
