import org.junit.Test;
import view.CommandsRegexp;

import static org.junit.Assert.*;

public class RegexpTest {

    @Test
    public void testInRange() {
        assertEquals(true, "-show train 1".matches(CommandsRegexp.SHOW_TRAIN_REGEX));
        assertEquals(true, "-count in range (3,5)".matches(CommandsRegexp.COUNT_IN_RANGE_REGEX));
    }

}
