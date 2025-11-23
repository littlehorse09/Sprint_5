import com.example.Lion;
import com.example.Feline;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LionParameterizedTest {

    @Mock
    private Feline feline;

    static Stream<Object[]> data() {
        return Stream.of(
                new Object[]{"Самка", false},
                new Object[]{"Самец", true}
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void DoesHaveManeParameterizedTest(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}