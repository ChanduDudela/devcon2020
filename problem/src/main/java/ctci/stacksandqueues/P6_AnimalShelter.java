package ctci.stacksandqueues;

import java.util.LinkedList;

public class P6_AnimalShelter {
    LinkedList<Animal> dogs = new LinkedList<>();
    LinkedList<Animal> cats = new LinkedList<>();

    private int order = 0;

    public void enqueue (Animal a) {
        a.setOrder(order);
        order++;

        if (a instanceof Cat) {
            cats.addLast(a);
        } else if (a instanceof Dog) {
            dogs.addLast(a);
        }
    }

    public Animal dequeueAny () {
        if (dogs.size() == 0) {
            return dequeueCat();
        } else if (cats.size() == 0) {
            return dequeueDog();
        }


        Animal a = dogs.peek();
        Animal b = cats.peek();

        if(a.isOlder(b)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Animal dequeueCat () {
        return cats.poll();
    }

    public Animal dequeueDog () {
        return dogs.poll();
    }
}

abstract class Animal {
    int order;
    String name;

    public Animal(String name) {
        name = name;
    }

    public void setOrder(int n) {
        order = n;
    }

    public int getOrder() {
        return order;
    }

    public boolean isOlder(Animal other) {
        return this.order < other.getOrder();
    }
}

class Cat extends Animal {
    Cat (String name) {
        super(name);
    }
}

class Dog extends Animal {
    Dog (String name) {
        super(name);
    }
}

