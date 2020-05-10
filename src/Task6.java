/*
Имеется набор вещей, которые необходимо поместить в рюкзак. Рюкзак обладает заданной грузоподъемностью.
Вещи в свою очередь обладают двумя параметрами — весом и стоимостью.
Цель задачи заполнить рюкзак не превысив его грузоподъемность и максимизировать суммарную ценность груза.
*/

import java.util.ArrayList;
import java.util.List;

public class Task6 {

    private List<InventoryItem> bestItems = null;
    private final double maxWeight;
    private double bestPrice;

    public Task6(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void solve() {
        List<InventoryItem> items = new ArrayList<>();
        //Список предметов для рюкзака
        items.add(new InventoryItem("Очки", 1, 1));
        items.add(new InventoryItem("Книга", 2, 3));
        items.add(new InventoryItem("Электронная книга", 5, 2));
        items.add(new InventoryItem("Планшет", 4, 3));
        items.add(new InventoryItem("Кошелек", 3, 2));
        items.add(new InventoryItem("USB - переходник", 1, 1));
        //конец списка

        makeAllSets(items);
        List<InventoryItem> solve = bestItems;
        System.out.println("Результат");
        for (InventoryItem item : solve) {
            System.out.println(item);
        }
    }

    private void checkItemSet(List<InventoryItem> items) {
        if (bestItems == null) {
            if (calcWeight(items) < maxWeight) {
                bestItems = items;
                bestPrice = calcPrice(items);
            }
        } else {
            if (calcWeight(items) <= maxWeight && calcPrice(items) > bestPrice) {
                bestItems = items;
                bestPrice = calcPrice(items);
            }
        }
    }

    private void makeAllSets(List<InventoryItem> items) {
        if (items.size() > 0) {
            checkItemSet(items);
        }
        for (int i = 0; i < items.size(); i++) {
            List<InventoryItem> tmpItemSet = new ArrayList<InventoryItem>(items);
            tmpItemSet.remove(i);
            makeAllSets(tmpItemSet);
        }
    }

    private double calcWeight(List<InventoryItem> items) {
        double sumWeight = 0;
        for (InventoryItem item : items) {
            sumWeight += item.weight;
        }
        return sumWeight;
    }

    private double calcPrice(List<InventoryItem> items) {
        double sumPrice = 0;
        for (InventoryItem item : items) {
            sumPrice += item.cost;
        }
        return sumPrice;
    }
}


class InventoryItem {
    protected String name;
    protected double cost;
    protected double weight;

    public InventoryItem(String name, double cost, double weight) {
        this.name = name;
        this.cost = cost;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                "(cost=" + cost +
                ", weight=" + weight +
                ')';
    }
}

