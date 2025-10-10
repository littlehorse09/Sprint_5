import com.example.Lion;
import com.example.Predator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    private Predator predator;

    @Test
    public void getKittensExpectedCount() throws Exception {
        Mockito.when(predator.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самка", predator);
        int kittens = lion.getKittens();
        assertEquals(3, kittens);
    }

    @Test
    public void getFoodPredatorFoodList() throws Exception {
        Mockito.when(predator.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самка", predator);
        assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void conctructorExceptionWithMessage() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("НекорректныйПол", predator);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
