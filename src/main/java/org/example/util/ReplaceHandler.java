package org.example.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceHandler implements HandleStrategy {
    // REGEXP matching 3 or more consecutive chars
    private static final Pattern CONSECUTIVE_CHAR = Pattern.compile("([a-z])\\1{2,}", Pattern.CASE_INSENSITIVE);

    /**
     * replace consecutive chars that appears 3 or more times with a
     * single character that comes before it alphabetically
     *
     * @param str
     * @return
     */
    @Override
    public String StringHandle(String str) {
        Matcher matcher = CONSECUTIVE_CHAR.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            // find current matched character
            char matchedChar = matcher.group(1).charAt(0);
            // replace consecutive char with previous char and with ' ' for 'a'
            char replacedChar = matchedChar == 'a' ? ' ' : (char) (matchedChar - 1);
            matcher.appendReplacement(stringBuffer, replacedChar == ' ' ? "" : String.valueOf(replacedChar));
        }
        matcher.appendTail(stringBuffer);

        return stringBuffer.toString();
    }
}
