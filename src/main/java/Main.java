import java.util.Scanner;

public class Main {
    // Вынес что возможно в константы
    public static final int minSpeed = 0;
    public static final int maxSpeed = 250;
    public static final int racingTime = 24;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // При регистрации участников сразу вычисляем победителя гонок
        Car leader = null;
        int maxDistance = 0;


        for (int i = 0; i < 3; i++) {
            int numberOfParticipant = i + 1;

            System.out.println("Введите имя " + numberOfParticipant + " участника");
            String currentName;
            while ((currentName = scanner.nextLine()).trim().isEmpty()) {
                System.out.println("Вы ввели некорректное имя участника!");
            }
            int currentSpeed = inputSpeed(scanner, numberOfParticipant);
            scanner.nextLine();

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
        scanner.close();
    }

    // Вынес код ввода скорости в отдельную функцию
    public static int inputSpeed(Scanner scanner, int numberOfParticipant) {
        int currentSpeed = -1;
        System.out.println("Введите скорость автомобиля " + numberOfParticipant + " участника в диапазоне от " + minSpeed + " до " + maxSpeed + " км/ч");
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Вы ввели что-то не то!");
                // что-то без этого уходит в бесконечный цикл, наверное нужно ввод как-то прочитать
                scanner.nextLine();
            } else {
                currentSpeed = scanner.nextInt();
                if (currentSpeed <= minSpeed || currentSpeed >= maxSpeed) {
                    System.out.println("Введите значение скорости в диапазоне от " + minSpeed + " до " + maxSpeed + " км/ч");
                    scanner.nextLine();
                } else {
                    break;
                }
            }
        }

        return currentSpeed;
    }
}