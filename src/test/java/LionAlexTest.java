import com.example.LionAlex;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LionAlexTest {

    private LionAlex lionAlex;

    @BeforeEach
    public void setUp() throws Exception {
        Feline simplePredator = new Feline() {
            @Override
            public List<String> eatMeat() {
                return Arrays.asList("Животные", "Птицы", "Рыба");
            }
            @Override
            public int getKittens() {
                return 0;
            }
        };
        lionAlex = new LionAlex("Самец", simplePredator);
    }

    @Test
    public void GetKittensZeroByDefault() {
        int expectedKittens = 0;
        assertEquals(expectedKittens, lionAlex.getKittens());
    }

    @Test
    public void GetFriendsExpectedFriends() {
        List<String> expectedFriends = Arrays.asList("Марти", "Глория", "Мелман");
        assertEquals(expectedFriends, lionAlex.getFriends());
    }

    @Test
    public void GetPlaceOfLivingZooName() {
        String expectedPlaceOfLiving = "Нью-Йоркский зоопарк";
        assertEquals(expectedPlaceOfLiving, lionAlex.getPlaceOfLiving());
    }

    @Test
    public void GetFoodPredatorFoodList() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Feline simplePredator = new Feline() {
            @Override
            public List<String> eatMeat() {
                return expectedFood;
            }

            @Override
            public int getKittens() {
                return 0; // обязательная реализация абстрактного метода
            }
        };
        LionAlex lionWithSimplePredator = new LionAlex("Самец", simplePredator);
        assertEquals(expectedFood, lionWithSimplePredator.getFood());
    }
}
