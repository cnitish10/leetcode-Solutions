//Leetcode 135 (candy)
import java.util.Arrays;
//Java Solution 
public int candy(int[] ratings) {
    int n = ratings.length;
    int[] candies = new int[n];
    //fill all candies with atleast 1
    Arrays.fill(candies, 1);

    //traverse from left and check whther the rating of previous child is less 
    //if less then add 1 more to the candy given to the previous child
    for (int i = 1; i < n; i++) {
        if (ratings[i] > ratings[i - 1]) {
            candies[i] = candies[i - 1] + 1;
        }
    }

    //traverse from right and check whther the rating of next child is less 
    //if less then add 1 more to the candy given to the next child
    for (int i = n - 2; i >= 0; i--) {
        if (ratings[i] > ratings[i + 1]) {
            candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }
    }
    //traverse whole candy array and get the desired the result by adding
    int totalCandies = 0;
    for (int candy : candies) {
        totalCandies += candy;
    }

    return totalCandies;
}