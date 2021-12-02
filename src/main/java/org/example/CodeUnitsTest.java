package org.example;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/4/28
 **/
public class CodeUnitsTest {


    public static void main(String[] args) {
        // 𝄞
        System.out.println("\uD834\uDD1Easf".length());
        System.out.println("\uD834\uDD1Easf".codePointCount(0, "\uD834\uDD1Easf".length()));
    }
}
