package edu.prahlad.zinterview.amazon;

public class DecodingString {

    /**
     * 1) Validate S
     *
     */
    public static String decodeString(int numberOfRows, String encodedString){
        String result = "";
        if(encodedString.length() <= numberOfRows || numberOfRows ==1) return result;

        for (int i = 0; i < encodedString.length()/numberOfRows; i++) {
            int next = i;
            while (next < encodedString.length()){
                if(encodedString.charAt(next)=='_'){
                    if(result.charAt(result.length() - 1)!= ' ')
                        result = result + " ";
                }else {
                    result = result + encodedString.charAt(next);
                }

                int step = (encodedString.length()/numberOfRows) + 1;
                next += step;
            }
        }

        result = result.trim();
        return result;
    }
}
