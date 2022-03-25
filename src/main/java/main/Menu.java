package main;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<Food> foodList;

    public Menu() {
        foodList = new ArrayList<>();
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
