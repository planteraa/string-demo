package org.example;

import org.example.util.RemoveHandler;
import org.example.util.ReplaceHandler;
import org.example.util.StringHandler;

public class Main {
    public static void main(String[] args) {
        StringHandler.handleConsecutiveChar("aabcccbbad", new RemoveHandler());
        StringHandler.handleConsecutiveChar("aaaabccccccbbbbbad", new ReplaceHandler());
    }
}