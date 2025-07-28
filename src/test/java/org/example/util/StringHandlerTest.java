package org.example.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringHandlerTest {

    @Test
    public void testRemoveConsecutiveChar() {
        // Test empty string input case
        Assert.assertEquals("", StringHandler.handleConsecutiveChar("", new RemoveHandler()));

        // Test capital letter input case
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> StringHandler.handleConsecutiveChar("AAACCCbbb", new RemoveHandler()));
        assertTrue(exception.getMessage().contains("Illegal input: Only lowercase letters a-z are allowed"));

        // Test null handler case
        exception = assertThrows(IllegalArgumentException.class, () -> StringHandler.handleConsecutiveChar(
                "aabcccbbad", null));
        assertTrue(exception.getMessage().contains("Illegal process strategy"));

        // Test normal input case
        Assert.assertEquals("d", StringHandler.handleConsecutiveChar("aabcccbbad", new RemoveHandler()));
        Assert.assertEquals("bad", StringHandler.handleConsecutiveChar("aaaabccccccbbbbbad", new RemoveHandler()));
        Assert.assertEquals("aabccbbad", StringHandler.handleConsecutiveChar("aabccbbad", new RemoveHandler()));
        Assert.assertEquals("aa", StringHandler.handleConsecutiveChar("aa", new RemoveHandler()));
    }

    @Test
    public void testReplaceConsecutiveChar() {
        // Test empty string input case
        Assert.assertEquals("", StringHandler.handleConsecutiveChar("", new ReplaceHandler()));

        // Test capital letter input case
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> StringHandler.handleConsecutiveChar("AAACCCbbb", new ReplaceHandler()));
        assertTrue(exception.getMessage().contains("Illegal input: Only lowercase letters a-z are allowed"));

        // Test null handler case
        exception = assertThrows(IllegalArgumentException.class, () -> StringHandler.handleConsecutiveChar(
                "aabcccbbad", null));
        assertTrue(exception.getMessage().contains("Illegal process strategy"));

        // Test normal input case
        Assert.assertEquals("d", StringHandler.handleConsecutiveChar("aabcccbbad", new ReplaceHandler()));
        Assert.assertEquals("bbaad", StringHandler.handleConsecutiveChar("aaaabccccccbbbbbad", new ReplaceHandler()));
        Assert.assertEquals("aabccbbad", StringHandler.handleConsecutiveChar("aabccbbad", new ReplaceHandler()));
        Assert.assertEquals("aa", StringHandler.handleConsecutiveChar("aa", new ReplaceHandler()));
    }
}
// bbaad