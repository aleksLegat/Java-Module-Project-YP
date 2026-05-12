import java.util.HashMap;
import java.util.Scanner;

public class Main {
    // директиву final и константы мы еще в рамках курса не проходили
    // но не могу не воспользоваться советом куратора )
    // вообще весь код можно было сделать гораздо проще, но хочется
    // попробовать разные возможности языка
    public static final int minSpeed = 1;
    public static final int maxSpeed = 250;
    public static final int racingTime = 24;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Создадим переменную для регистрации участников гонки
        Car[] listOfParticipants = new Car[3];

        // Регистрация участников
        // Можно сразу при регистрации участников определить победителя,
        // как советует Artur, но тогда пропадает необходимость в классе Race
        // который вроде как нужен по условиям задачи
        for (int i = 0; i < 3; i++) {
            int numberOfParticipant = i + 1;
            System.out.println(String.format("Введите имя %d участника", numberOfParticipant));
            String currentName = scanner.next();

            listOfParticipants[i] = new Car(currentName, inputSpeed(scanner, numberOfParticipant));
        }

        Race race24 = new Race(listOfParticipants, racingTime);
        Car leader = race24.getLader();
        System.out.println("В гонке победил автомобиль " + leader.name);
    }

    // Вынес код ввода скорости в отдельную функцию
    public static int inputSpeed(Scanner scanner, int numberOfParticipant) {
        int currentSpeed = 0;
        while (currentSpeed < minSpeed || currentSpeed > maxSpeed) {
            System.out.println(String.format("Введите скорость автомобиля %d участника в диапазоне от %d до %d км/ч", numberOfParticipant, minSpeed, maxSpeed));
            currentSpeed = scanner.nextInt();
        }
        return currentSpeed;
    }
}

