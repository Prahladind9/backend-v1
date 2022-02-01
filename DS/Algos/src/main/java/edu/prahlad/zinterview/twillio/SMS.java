package edu.prahlad.zinterview.twillio;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SMS {

    /*
     * Complete the 'segments' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING message as parameter.
     */

    public static List<String> segments(String message) {
        return getSplits(message);
    }

    public static List<String> getSplits(String message) {
        List<String> result = new ArrayList<>();
        if (message.length() < 160) {
            result.add(message);
            return result;
        }

        int maxlen = 154;
        int s = 0, e = s + maxlen;

        while (e < message.length()) {
            if (message.charAt(e) != ' ' && message.charAt(e + 1) != ' ') {
                while (e >= s && message.charAt(e) != ' ') {
                    e--;
                }
            }

            result.add(message.substring(s, e + 1));
            s = e + 1;
            e = s + maxlen;
        }


        result.add(message.substring(s, message.length()));


        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i) + "(" + (i + 1) + "/" + (result.size()) + ")");
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.asList(segments("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis partu sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore ver rup. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa.")));
    }
}
