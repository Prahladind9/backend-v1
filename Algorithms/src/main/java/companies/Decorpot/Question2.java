package companies.Decorpot;

public class Question2 {
    /*
    public static void main(String[] args) {
        Question2 question2 = new Question2();

        question2.getUsernames();
//        System.out.println(question2.solution());
        System.out.println();
    }

    public List<String> getUsernames(int threshold) {
        //Not sure on the Java Part .. Spring Boot is quite easy to fetch the data
        //Json Data format to an Object
        //Retrieve the UserNames from that objects as per the pages call
        //URL Call

        int totalPages = 0;
        List<String> usersBasedOnSubmissionCount = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        for(int page = 0; page <= totalPages; page++){
            //URL Call
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .build();

            HttpResponse<String> response =
                    client.send(request, BodyHandlers.ofString());
            MostActiveUsers mostActiveUsersList = new MostActiveUsers();
            usersBasedOnSubmissionCount.addAll(mostActiveUsersList.getUserDetailsList().stream()
                    .filter(userDetails -> userDetails.getSubmission_count() >= threshold)
                    .map(UserDetails::getUsername)
                    .collect(Collectors.toList()))
            ;

        }

        return usersBasedOnSubmissionCount;

    }

    class MostActiveUsers{
        int page;
        int per_page;
        int total;
        int total_pages;
        List<UserDetails> userDetailsList;

        public List<UserDetails> getUserDetailsList(){
            return userDetailsList;
        }
    }

    class UserDetails {
        int id;
        String username;
        String about;
        int submitted;
        LocalDateTime updated_at;
        int submission_count;
        int comment_count;
        Instant created_at;

        public String getUsername(){
            return username;
        }
        public int getSubmission_count(){
            return submission_count;
        }

    }*/
}
