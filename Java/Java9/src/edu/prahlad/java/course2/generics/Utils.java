package edu.prahlad.java.course2.generics;

public class Utils {
    public static <T extends Comparable<T>> T max(T first, T second) {
        return (first.compareTo(second) < 0) ? second : first;
    }

    public static <K, V> void print(K key, V value){
        System.out.println(key + "=" + value);
    }

    public static void printUser(User user){
        System.out.println(user);
    }

    public static void printUsers(ListGeneric<User> users){ }

    //class CAP#1 {}
    public static void printUsersWC(ListGeneric<?> users){
        Object x = users.get(0); //is only allowed
    }

    //class CAP#2 {}
    public static void printUsersWCE(ListGeneric<? extends User> users){
        //User or subType of users are allowed
//        Instructor x = users.get(0);//not allowed
        User x = users.get(0);//allowed
        //users.add(new User(10)); //compiler doesn't understand
    }

    //class CAP#2 {}
    public static void printUsersWCES(ListGeneric<? super User> users){
        //User or subType of users are allowed
//        Instructor x = users.get(0);//not allowed
        //User x = users.get(0);//not allowed

        ListGeneric<Object> temp = new ListGeneric<>();
        users.add(new User(10));
        users.add(new Instructor(100));
    }
}
