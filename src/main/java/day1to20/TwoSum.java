package day1to20;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSum {
    public static void main(String[] args) {
        /*
        * Write a function that takes an array of numbers (integers for the tests) and a target number.
        * It should find two different items in the array that, when added together, give the target value.
        * The indices of these items should then be returned in a tuple like so: (index1, index2).
        * For the purposes of this kata, some tests may have multiple answers; any valid solutions
        * will be accepted.
        * The input will always be valid (numbers will be an array of length 2 or greater, and all of
        * the items will be numbers; target will always be the sum of two different items from that array).
        * Based on: http://oj.leetcode.com/problems/two-sum/
        * twoSum [1, 2, 3] 4 === (0, 2)
        */

        int [] input = new int[]{1, 2, 3};

        System.out.println(twoSum(input, 4)[0]);
        System.out.println(twoSum1(input, 4)[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] output = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = numbers.length - 1; j > 0; j--) {
                if (numbers[i] == numbers[j]) {
                    continue;
                } else if (numbers[i] + numbers[j] == target) {
                    output[0] = i;
                    output[1] = j;
                }
            }
        }

        return output;
    }

    // using streams
    public static int[] twoSum1(int[] numbers, int target)
    {
        // Store each number of the array in a List.
        List<Integer> numbersList = Arrays.stream(numbers).boxed().collect(Collectors.toList());

        /*
         Parse the list in order to check every number and look if there is the other
         number (difference between the first number and the target).
        */
        for(final Integer number : numbersList) {
            if (numbersList.contains(target - number)) {
                return new int[]{numbersList.indexOf(number), numbersList.indexOf(target - number)};
            }
        }
        return null;
    }

}
