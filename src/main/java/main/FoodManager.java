package main;

import exceptions.FoodStackEmptyException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FoodManager {

    public static Deque<Food> foodStack = new ArrayDeque<>();
    public static List<Food> foodHistory = new ArrayList<>();


    public static void pushFood(Food food) {
        foodStack.push(food);
        foodHistory.add(food);
    }

    public static Food popFood() throws FoodStackEmptyException {
        if(foodStack.peek() == null) {
            throw new FoodStackEmptyException();
        }
        return foodStack.pop();
    }
}
