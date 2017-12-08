import org.junit.Test;
import view.CommandsRegexp;

import static org.junit.Assert.*;

public class RegexpTest {

    @Test
    public void testInRange() {
        assertEquals(true, "-show train 1".matches(CommandsRegexp.CMD_SHOW_TRAIN));
    }

}
