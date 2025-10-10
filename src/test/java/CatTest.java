import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CatTest {
    @Mock
    private Feline mockFeline;

    // Проверка getSound();
    @Test
    public void GetSoundMeow() {
        Feline mockFeline = mock(Feline.class);
        Cat cat = new Cat(mockFeline);
        assertEquals("Мяу", cat.getSound());
    }

    // Проверка getFood();
    @Test
    public void GetFoodPredatorFoodList() throws Exception {
        Cat cat = new Cat(mockFeline);
        Mockito.when(mockFeline.eatMeat()).thenReturn(List.of("Хищник"));
        assertEquals(List.of("Хищник"), cat.getFood());
        Mockito.verify(mockFeline, Mockito.times(1)).eatMeat();
    }
}