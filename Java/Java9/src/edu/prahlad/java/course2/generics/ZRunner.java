package edu.prahlad.java.course2.generics;

public class ZRunner {
    public static void main(String[] args) {
        /*var list = new List();
        list.add(1);*/
        var  list = new ListGeneric<Integer>();
        list.add(1);
        int number = list.get(0);

        var user1 = new User(10);
        var user2 = new User(20);
        System.out.println("CompareImpl: " + user1.compareTo(user2));
        //User1 less than User2

        System.out.println("Max: " + Utils.max(user1, user2));

        Utils.print("One", 1);
        System.out.println(new KeyValuePair<>("One", 1));

        User user = new Instructor(10);
        Utils.printUser(user);
        Utils.printUsers(new ListGeneric<User>());

        //Utils.printUsers(new ListGeneric<Instructor>()); //not allowed
        Utils.printUsersWC(new ListGeneric<Integer>());
        Utils.printUsersWC(new ListGeneric<Instructor>());
    }
}
