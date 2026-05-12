import java.lang.reflect.Array;
import java.util.HashMap;

public class Race {
    final Car[] participants;
    final int racingTime;
    Race(Car[] participants, int racingTime) {
        this.participants = participants;
        this.racingTime = racingTime;
    }

    Car getLader() {
        //HashMap<Car, Integer> currentRace = new HashMap<>();
        // Рассчитаем растояние, которое пройдет каждый автомобиль за 24 часа
        // и засунем все это в ассоциативный массив, где ключ - автомобиль а значение - пройденное расстояние за 24 часа
        // в принципе можно было и не рассчитывать расстояние, а отсортировать просто по скорости
        //for (Car ourCar : participants) {
        //    currentRace.put(ourCar, ourCar.getDistance(24));
        //}
        // тут бы просто отсортировать по значению, но сортировку вроде как не проходили
        Car leader = participants[0];
        //int maxDistance = currentRace.get(leader);
        int maxDistance = leader.getDistance(racingTime);
        for (int i = 1; i < 3; i++) {
            Car currentCar = participants[i];
            //int currentDistance = currentRace.get(currentCar);
            int currentDistance = currentCar.getDistance(racingTime);
            if (maxDistance < currentDistance) {
                maxDistance = currentDistance;
                leader = currentCar;
            }
        }
        return leader;
    }
}