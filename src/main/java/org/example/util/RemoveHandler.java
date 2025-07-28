package org.example.util;

import java.util.regex.Pattern;

public class RemoveHandler implements HandleStrategy {
    // REGEXP matching 3 or more consecutive chars
    private static final Pattern CONSECUTIVE_CHAR = Pattern.compile("([a-z])\\1{2,}", Pattern.CASE_INSENSITIVE);

    /**
     * remove consecutive chars that appears 3 or more times
     *
     * @param str
     * @return
     */
    @Override
    public String StringHandle(String str) {
        return CONSECUTIVE_CHAR.matcher(str).replaceAll("");
    }
}
