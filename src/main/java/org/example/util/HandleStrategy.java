package org.example.util;

/**
 * Strategy pattern implements the control of handle type
 */
public interface HandleStrategy {
    /**
     * Process str with different methods
     *
     * @param str
     * @return
     */
    String StringHandle(String str);
}
