package edu.prahlad.educativeio2.patternsForCodingQuestions.modifiedBinarySearch;


/**
 * Given an array of lowercase letters sorted in ascending order,
 * find the smallest letter in the given array greater than a given ‘key’.
 * <p>
 * Assume the given array is a circular list,
 * which means that the last letter is assumed to be connected with the first letter.
 * This also means that the smallest letter in the given array,
 * is greater than the last letter of the array and is also the first letter of the array.
 * <p>
 * Write a function to return the next letter of the given ‘key’.
 * <p>
 * Time: O(log(n))
 * Space: O(1)
 */
public class NextLetter {

    public static char searchNextLetter(char[] letters, char key) {
        int n = letters.length;

        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return letters[start % n];
    }

    public static void main(String[] args) {
        System.out.println(NextLetter.searchNextLetter(new char[]{'a', 'c', 'f', 'h'}, 'f'));
        System.out.println(NextLetter.searchNextLetter(new char[]{'a', 'c', 'f', 'h'}, 'b'));
        System.out.println(NextLetter.searchNextLetter(new char[]{'a', 'c', 'f', 'h'}, 'm'));
        System.out.println(NextLetter.searchNextLetter(new char[]{'a', 'c', 'f', 'h'}, 'h'));
    }
}
