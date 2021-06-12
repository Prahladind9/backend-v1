package edu.prahlad.java.course2.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {

    public static void main(String[] args) {
//        functionalVsDeclarativeExample();
//        createStream();
//        mapping();
//        filtering();
//        slicing();
//        sorting();
//        distinct();
//        peek();
//        reducers();
//        reduce();
//        collectors();
//        grouping();
//        partitioning();
        primitive();
    }

    private static void primitive() {
        //end range not inclusive
        IntStream.range(1, 5)
                .forEach(System.out::println);

        //end range inclusive
        IntStream.rangeClosed(1, 5)
                .forEach(System.out::println);
    }

    private static void partitioning() {
        var result = getMoviesStream()
                .collect(Collectors.partitioningBy(m -> m.getLikes() > 20));
        System.out.println(result);

        var result2 = getMoviesStream()
                .collect(Collectors.partitioningBy(
                        m -> m.getLikes() > 20,
                        Collectors.mapping(
                                Movie::getTitle,
                                Collectors.joining(", ")
                        )));
        System.out.println(result2);
    }

    private static void grouping() {
        var resultList = getMoviesStream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre));
        System.out.println(resultList);

        var resultSet = getMoviesStream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre, Collectors.toSet()));
        System.out.println(resultSet);

        var resultString = getMoviesStream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        Collectors.mapping(
                                Movie::getTitle,
                                Collectors.joining(", "))));
        System.out.println(resultString);
    }

    private static void collectors() {

        var list = getMoviesStream()
                .filter(m -> m.getLikes() > 10).collect(Collectors.toList());
        System.out.println("list: " + list);

        var map = getMoviesStream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.toMap(
                        Movie::getTitle, Movie::getLikes
                ));
        System.out.println("map: " + map);

        var mapOfMovies = getMoviesStream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.toMap(
                        Movie::getTitle, Function.identity()
                ));
        System.out.println("mapOfMovies: " + mapOfMovies);


        var summingInt = getMoviesStream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.summingInt(Movie::getLikes));
        System.out.println("summingInt: " + summingInt);

        var summingDouble = getMoviesStream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.summingDouble(Movie::getLikes));
        System.out.println("summingDouble: " + summingDouble);

        var summarizingInt = getMoviesStream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.summarizingInt(Movie::getLikes));
        System.out.println("summarizingInt: " + summarizingInt);

        var joining = getMoviesStream()
                .filter(m -> m.getLikes() > 10)
                .map(Movie::getTitle)
                .collect(Collectors.joining(", "));
        System.out.println("joining: " + joining);

    }

    private static void reduce() {

        //after map: [10, 20, 30]
        //reduce: [30, 30] > [60]
        var sum = getMoviesStream()
                .map(m -> m.getLikes())
                .reduce((a, b) -> a + b);
        System.out.println(sum.orElse(0));

        var sum2 = getMoviesStream()
                .map(m -> m.getLikes())
                .reduce(0, Integer::sum);
        System.out.println(sum2);
    }

    private static void reducers() {
        System.out.println("count: " + getMoviesStream().count());
        System.out.println("anyMatch: " + getMoviesStream().anyMatch(m -> m.getLikes() > 20));
        System.out.println("allMatch: " + getMoviesStream().allMatch(m -> m.getLikes() > 20));
        System.out.println("noneMatch: " + getMoviesStream().noneMatch(m -> m.getLikes() > 20));

        System.out.println("findFirst: " + getMoviesStream().findFirst().get());
        System.out.println("findAny: " + getMoviesStream().findAny().get());

        System.out.println("max: " + getMoviesStream().max(Comparator.comparing(Movie::getLikes)).get());
        System.out.println("min: " + getMoviesStream().min(Comparator.comparing(Movie::getLikes)).get());


    }

    private static void peek() {
        getMoviesStream()
                .filter(m -> m.getLikes() > 10)
                .peek(m -> System.out.println("filtered: " + m.getTitle()))
                .map(Movie::getTitle)
                .peek(t -> System.out.println("mapped: " + t))
                .forEach(System.out::println);
    }

    private static void distinct() {
        getMoviesStream()
                .map(Movie::getLikes)
                .distinct()
                .forEach(System.out::println);
    }

    private static void sorting() {
        getMoviesStream()
                .sorted((a, b) -> a.getTitle().compareTo(b.getTitle()))
                .forEach(System.out::println);

        getMoviesStream()
                .sorted(Comparator.comparing(Movie::getTitle))
                .forEach(System.out::println);

        getMoviesStream()
                .sorted(Comparator.comparing(Movie::getTitle).reversed())
                .forEach(System.out::println);
    }

    private static void slicing() {
        getMoviesStream()
                .limit(2)
                .forEach(m -> System.out.println(m.getTitle()));

        //1000 movies
        //10 movies per page
        //3rd page
        //skip(20) = skip( (page-1) * pageSize)
        //limit(10)= limit(pageSize)

        getMoviesStream()
                .skip(2)
                .forEach(m -> System.out.println(m.getTitle()));

        getMoviesStream()
                .takeWhile(m -> m.getLikes() < 30)
                .forEach(m -> System.out.println(m.getTitle()));

        getMoviesStream()
                .dropWhile(m -> m.getLikes() < 30)
                .forEach(m -> System.out.println(m.getTitle()));

    }

    private static void filtering() {
        Predicate<Movie> isPopular = movie -> movie.getLikes() > 10;
        getMoviesStream()
                .filter(isPopular)
                .forEach(System.out::println);
    }

    private static void mapping() {
        getMoviesStream()
                .map(movie -> movie.getTitle())
                .forEach(System.out::println);

        getMoviesStream()
                .mapToInt(movie -> movie.getLikes())
                .forEach(System.out::println);

        //A stream of list of integers
        var stream = Stream.of(List.of(1, 2, 3), List.of(4, 5, 6));

        //Flattened Stream: Stream<List<x>> -> Stream<x> : could be list or set or ...
        var flatStream = stream.flatMap(list -> list.stream());
        flatStream.forEach(System.out::println);
    }

    private static void createStream() {
        int[] numbers = {1, 2, 3};
        Arrays.stream(numbers)
                .forEach(n -> System.out.println(n));

        Stream.of(1, 2, 3, 4);
        var infiniteStream = Stream.generate(() -> Math.random()); //LazyEvaluation
//        infiniteStream.forEach(n -> System.out.println(n)); infiniteStream of double gets generated
        infiniteStream
                .limit(3)
                .forEach(n -> System.out.println(n));

        Stream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(System.out::println);
    }

    private static void functionalVsDeclarativeExample() {
        List<Movie> movies = getMovies();

        //Imperative Programming
        int count = 0;
        for (var movie : movies) {
            if (movie.getLikes() > 10)
                count++;
        }

        //Declarative (Functional) Programming
        var count2 = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .count();
    }

    private static Stream<Movie> getMoviesStream() {
        return getMovies().stream();
    }

    private static List<Movie> getMovies() {
        return List.of(
                new Movie("c", 20, Genre.THRILLER),
                new Movie("b", 15, Genre.ACTION),
                new Movie("a", 10, Genre.ACTION),
                new Movie("d", 30, Genre.COMEDY)
        );
    }


}
