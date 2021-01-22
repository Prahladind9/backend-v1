package companies.Decorpot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Question1 {
    private static final String USER_AGENT = "Mozilla/5.0";

    private static final String GET_URL = "https://jsonmock.hackerrank.com/api/article_users?page=0";

    private static final String POST_URL = "https://localhost:9090/SpringMVCExample/home";

    private static final String POST_PARAMS = "userName=Pankaj";

    public static void main(String[] args) throws IOException {

        sendGET();
        System.out.println("GET DONE");

    }

    private static String sendGET() throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        StringBuffer response = new StringBuffer();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                System.out.println(inputLine);
            }
            in.close();


            // print result



        } else {
            System.out.println("GET request not worked");
        }

        return response.toString();
    }


}
