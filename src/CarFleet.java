import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class CarFleet {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] position = { 10, 8, 0, 5, 3 };
        int[] speed = { 2, 4, 1, 1, 3 };
        int[] position2 = { 3 };
        int[] speed2 = { 3 };
        int[] position3 = { 6, 8 };
        int[] speed3 = { 3, 2 };
        System.out.println(solution.carFleet(10, position3, speed3));
    }

    static class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            List<Car> list = new ArrayList<>();
            Stack<Car> stack = new Stack<>();
            for (int i = 0; i < position.length; i++) {
                list.add(new Car(position[i], speed[i]));
            }
            Comparator<Car> comparator = Comparator.comparing(Car::getPos);
            Collections.sort(
                    list, comparator.reversed());

            for (Car c : list) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    Car lastCar = stack.peek();
                    stack.push(c);
                    float lastCarT = (float) (target - lastCar.pos) / lastCar.speed;
                    float currentCarT = (float) (target - c.pos) / c.speed;
                    if (lastCarT >= currentCarT) {
                        stack.pop();
                    }
                }
            }
            return stack.size();
        }

        class Car {
            int pos, speed;

            public Car(int pos, int speed) {
                this.pos = pos;
                this.speed = speed;
            }

            public int getPos() {
                return pos;
            }
        }
    }

}
