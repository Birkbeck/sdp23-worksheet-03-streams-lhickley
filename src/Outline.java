import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Outline {

  public static List<String> getList() {
    return List.of("hi", "bat", "ear", "hello", "iguana",
            "beaver", "winterland", "elephant", "eye", "qi");
  }

  // Loop through the words and print each one on a separate line,
  // with two spaces in front of each word.
  public static void question1() {
    List<String> words = getList();
    System.out.println("1: ");
    // YOUR CODE
    words.stream().forEach(n -> System.out.println("  " + n));
  }

  // Repeat this problem but without two spaces in front of each word.
  // This should be trivial if you use the same approach as the previous
  // question; the point here is to make use of a method reference.
  public static void question2() {
    List<String> words = getList();
    System.out.println("2: ");
    // YOUR CODE
    words.stream().forEach(System.out::println);
  }

  // For each of the following lambda expressions (see Question 5 in Worksheet 2),
  // produce the list that contains the elements of the original list
  // that satisfy the predicate defined by the lambda expression
  // (use the filter stream operation):
  //  - s -> s.length() < 4 (strings with no more than 3 characters),
  //  -  s -> s.contains("b") (strings containing "b"),
  // s -> (s.length() % 2) == 0 (strings of even length).

  public static void question3() {
    List<String> words = getList();
    System.out.println("3:");
    // YOUR CODE
    List<String> lessThanFour = words
            .stream()
            .filter(s -> s.length() < 4)
            .toList();
    List<String> containsB = words
            .stream()
            .filter(s -> s.contains("b"))
            .toList();
    List<String> evenStrings = words
            .stream()
            .filter(s -> (s.length() % 2) == 0)
            .toList();
  }


  // For each of the following lambda expressions (see Question 7 in Worksheet 2),
  // produce the list that contains the results of applying the function
  // defined by the lambda expression to each element of the original list
  // (use the map stream operation):
  // - s -> s + "!",
  //  s -> s.replace("i", "eye"),
  //  s -> s.toUpperCase().

  public static void question4() {
    List<String> words = getList();
    System.out.println("4:");
    // YOUR CODE
    List<String> exclaimList = words
            .stream()
            .map(s -> s + "!")
            .toList();
    List<String> replaceList = words
            .stream()
            .map(s -> s.replace("i", "eye"))
            .toList();
    List<String> upperList = words
            .stream()
            .map(s -> s.toUpperCase())
            .toList();
  }


  // (*) Turn the strings in the list into uppercase, keep only the
  // ones that are shorter than four characters, and, of what is remaining,
  // keep only the ones that contain "e", and print the first result.
  // Repeat the process, except checking for a "q" instead of an "e".

  public static void question5() {
    List<String> words = getList();
    System.out.println("5a:");
    // YOUR CODE
    words
            .stream()
            .map(s -> s.toUpperCase())
            .filter(s -> s.length() < 4)
            .filter(s -> s.contains("e"))
            .findFirst()
            .ifPresent(System.out::println);
    List<String> qList = words
            .stream()
            .map(s -> s.toUpperCase())
            .filter(s -> s.length() < 4)
            .filter(s -> s.contains("q"))
            .peek(System.out::println)
            .toList();
  }


  // (** ) The above example uses lazy evaluation, but it is not easy to see
  // that it is doing so. Create a variation of the above example that shows
  // that it is doing lazy evaluation. The simplest way is to track which
  // entries are turned into upper case.

  public static void question6() {
    List<String> words = getList();
    System.out.println("6:");
    // YOUR CODE
    words
            .stream()
            .map(s -> s.toUpperCase())
            .peek(System.out::println)
            .filter(s -> s.length() < 4)
            .peek(System.out::println)
            .filter(s -> s.contains("e"))
            .findFirst()
            .ifPresent(System.out::println);
  }

  // (*) Produce a single String that is the result of concatenating the
  // uppercase versions of all the Strings.
  // For example, the result should be "HIHELLO...".
  // Hint: use a map operation that turns the words into upper case,
  // followed by a reduce operation that concatenates them.

  public static void question7() {
    List<String> words = getList();
    System.out.println("7:");
    // YOUR CODE
    String concat = words
            .stream()
            .map(String::toUpperCase)
            .reduce("", (a, b) -> a+ b);
    System.out.println(concat);
  }


  // (*) Produce a single String that is the result of concatenating the
  // uppercase versions of all the Strings.
  // For example, the result should be "HIHELLO...".
  // Use a single reduce operation, without using map.

  public static void question8() {
    List<String> words = getList();
    System.out.println("8:");
    // YOUR CODE
    String concat = words
            .stream()
            .reduce("", (a, b) -> a+ b.toUpperCase());
    System.out.println(concat);
  }

  // (*) Produce a String that is all the words concatenated together, but
  // with commas in between. For example, the result should be "hi,hello,...".
  // Note that there is no comma at the beginning, before "hi", and also no comma
  // at the end, after the last word.

  public static void question9() {
    List<String> words = getList();
    System.out.println("9:");
    // YOUR CODE
    String concat = words
            .stream()
            .collect(Collectors.joining(","));
    System.out.println(concat);
  }

  public static void question10() {
    List<Dish> dishList = Dish.getMenu();
    List<Dish> meatDishes = dishList
            .stream()
            .filter(d -> d.type() == Dish.Type.MEAT)
            .limit(2)
            .toList();
    System.out.println(meatDishes);
  }

  public static void question11() {
    List<Dish> dishes = Dish.getMenu();
    Integer dishCount = dishes
            .stream()
            .map(x -> 1)
            .reduce(0, (a, b) -> a+b);
  }

  public static Integer[] getIntegerArray() {
    return new Integer[] { 1, 7, 3, 4, 8, 2 };
  }

  public static void question12() {
    Integer[] integers = getIntegerArray();
    List<Integer> ints = Arrays.stream(integers)
            .sequential()
            .map(n -> n * n)
            .toList();
    System.out.println(ints);
  }

  public static void question13() {
    Integer[] integers1 = getIntegerArray();
    Integer[] integers2 = getIntegerArray();
    List<Integer[]> intList = Arrays.stream(integers1)
            .flatMap(i1 -> Arrays.stream(integers2)
                    .map(i2 -> new Integer[] {i1, i2}))
                    .toList();
    for (Integer[] i : intList) {
      System.out.println(i[0] + " " + i[1]);
    }
  }

  public static void question14() {
    Integer[] integers1 = getIntegerArray();
    Integer[] integers2 = getIntegerArray();
    List<Integer[]> intList = Arrays.stream(integers1)
            .flatMap(i1 -> Arrays.stream(integers2)
                    .filter(i2 -> (i1 + i2) % 3 == 0)
                    .map(i2 -> new Integer[] {i1, i2}))
            .toList();
    for (Integer[] i : intList) {
      System.out.println(i[0] + " " + i[1]);
    }
  }

  public static void question15() {
    List<Integer> intList = Arrays.asList(getIntegerArray());
    Integer firstInt = intList
            .stream()
            .reduce(0, (a, b) -> a + b);
    System.out.println(firstInt);
    Integer secondInt = intList
            .stream()
            .reduce(0, Integer::sum);
    System.out.println(secondInt);
    Integer thirdInt = intList
            .stream()
            .mapToInt(n -> n)
            .sum();
    System.out.println(thirdInt);
  }

  public static List<Double> randomNumberList(int size) {
    List<Double> outList = Stream.generate(new Random()::nextDouble)
            .limit(size)
            .toList();
    return outList;
  }

  public static void question16() {
    System.out.println(randomNumberList(5));
  }

  public static List<Integer> orderedNumberList(Integer start, Integer step, Integer size) {
    return Stream.iterate(start, n -> n + step)
            .limit(size)
            .toList();
  }

  public static void question17() {
    System.out.println((orderedNumberList(40, 5, 5)));
  }

  public static void question18() {
    List<Integer> intList = Arrays.asList(getIntegerArray());
    Integer firstInt = intList
            .parallelStream()
            .reduce(0, (a, b) -> a + b);
    System.out.println(firstInt);
    Integer secondInt = intList
            .parallelStream()
            .reduce(0, Integer::sum);
    System.out.println(secondInt);
    Integer thirdInt = intList
            .parallelStream()
            .mapToInt(n -> n)
            .sum();
    System.out.println(thirdInt);
  }

  public static void question19() {
    Double[] doubleArray = { 2.0, 7.0, 3.0, 4.0, 8.0, 2.0, 3.0, 10.0, 11.2, 44.2, 54.1, 1120.1, 2345.6 };
    double productDouble = Stream.of(doubleArray)
            .reduce(1.0, (d1, d2) -> d1 * d2);
    System.out.println(productDouble);

    for (int i = 0; i < 10_000_000; i++) {
      double productDoubleP = Stream.of(doubleArray)
              .parallel()
              .reduce(1.0, (d1, d2) -> d1 * d2);

      if (productDouble != productDoubleP) {
        System.out.println("Not equal (step " + i + "): " + productDouble + " v " + productDoubleP);
        break;
      }
    }
  }

  // CONTINUE WITH THE REST OF THE QUESTIONS

  public static void main(String... args) { // varargs alternative to String[]
    question19();

  }
}