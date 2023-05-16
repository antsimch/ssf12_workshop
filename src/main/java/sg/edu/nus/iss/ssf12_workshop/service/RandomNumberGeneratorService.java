package sg.edu.nus.iss.ssf12_workshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomNumberGeneratorService {
    
    List<Integer> randomNumbers;
    private int temp;
    private final int MAX_RANGE = 30; 

    public List<Integer> generateRandomNumbersList(int number) {

        this.randomNumbers = new ArrayList<>(number);
        Random random = new Random();
        while (randomNumbers.size() < number) {
            temp = random.nextInt(1, MAX_RANGE);
            if (!randomNumbers.contains(temp)) {
                randomNumbers.add(temp);
            } else {
                continue;
            }
        }

        return randomNumbers;

        // return new Random().ints(1, 31).distinct().limit(number).boxed().collect(Collectors.toList());
    }

    public List<Integer> generateRanNumbers(int number) {
        return null;
    }
}
