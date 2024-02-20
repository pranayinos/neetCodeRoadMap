import java.util.HashMap;
import java.util.Map;

public class FruitInToBasket {
    /*You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

    You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
    Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
    Once you reach a tree with fruit that cannot fit in your baskets, you must stop.

Given the integer array fruits, return the maximum number of fruits you can pick. */
    public static void main(String[] args) {
        int[] fruits = {1,2,3,2,2};
        System.out.println(totalFruit(fruits));
    }
    public static int totalFruit(int[] fruits) { 
        int left = 0;
        int right = 0;
        int maxFruits = 0;
        int fruitTypeCount = 0;
        Map<Integer, Integer> fruitCountMap = new HashMap<>();
        while (right < fruits.length) {
            fruitCountMap.put(fruits[right], fruitCountMap.getOrDefault(fruits[right], 0) + 1);
            if (fruitCountMap.size() > 2) {
                fruitCountMap.put(fruits[left], fruitCountMap.get(fruits[left]) - 1);
                if (fruitCountMap.get(fruits[left]) == 0) {
                    fruitCountMap.remove(fruits[left]);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
            right++;
        }
        return maxFruits;
    }
}
