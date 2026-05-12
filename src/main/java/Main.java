import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Создадим переменную для регистрации участников гонки
        Car[] listOfParticipants = new Car[3];

        // Регистрация участников
        for (int i = 0; i < 3; i++) {
            int numberOfParticipant = i + 1;
            System.out.println(String.format("Введите имя %d участника", numberOfParticipant));
            String currentName = scanner.next();

            // Наверное нужно как то учесть уникальность имен участников
            // но вроде нет такого в условиях задачи

            int currentSpeed = 0;
            while (currentSpeed <= 0 || currentSpeed > 250) {
                System.out.println(String.format("Введите скорость автомобиля %d участника в диапазоне от 1 до 250 км/ч", numberOfParticipant));
                currentSpeed = scanner.nextInt();
            }
            listOfParticipants[i] = new Car(currentName, currentSpeed);
        }

        Race race24 = new Race(listOfParticipants);
        Car leader = race24.getLader();
        System.out.println("В гонке победил автомобиль " + leader.name);
    }
}