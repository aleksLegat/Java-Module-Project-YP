import java.util.HashMap;
import java.util.Scanner;

public class Main {
    // Вынес что возможно в константы
    public static final int minSpeed = 0;
    public static final int maxSpeed = 250;
    public static final int racingTime = 24;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // При регистрации участников сразу вычисдяем победителя гонок
        Car leader = null;
        int maxDistance = 0;

        for (int i = 0; i < 3; i++) {
            int numberOfParticipant = i + 1;
            System.out.println(String.format("Введите имя %d участника", numberOfParticipant));
            String currentName = scanner.next();
            int currentSpeed = inputSpeed(scanner, numberOfParticipant);

            Car currentCar = new Car(currentName, currentSpeed);
            int currentDistance = currentCar.getDistance(racingTime);

            if (leader == null) {
                leader = currentCar;
                maxDistance = currentDistance;
            } else {
                if (maxDistance < currentDistance) {
                    leader = currentCar;
                    maxDistance = currentDistance;
                }
            }
        }

        System.out.println("В гонке победил автомобиль " + leader.name);
    }

    // Вынес код ввода скорости в отдельную функцию
    public static int inputSpeed(Scanner scanner, int numberOfParticipant) {
        int currentSpeed = -1;
        while (currentSpeed < minSpeed || currentSpeed > maxSpeed) {
            System.out.println(String.format("Введите скорость автомобиля %d участника в диапазоне от %d до %d км/ч", numberOfParticipant, minSpeed, maxSpeed));
            currentSpeed = scanner.nextInt();
        }
        return currentSpeed;
    }
}

