package org.thymeleaf.expression;

import java.util.Locale;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/25 11:51
 */
public class NumbersTest {
    public static void main(String[] args) {
        Numbers numbers = new Numbers(Locale.CHINESE);
        System.out.println(numbers.formatDecimal(200.0000, 4, 3));;
    }
}
