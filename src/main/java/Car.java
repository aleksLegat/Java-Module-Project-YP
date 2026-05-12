public class Car {
    final String name;
    final int speed;

    Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    int getDistance(int time) {
        return time * speed;
    }
}