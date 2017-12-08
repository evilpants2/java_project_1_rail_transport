import org.junit.Test;
import view.Regexp;
import view.ViewText;

import static org.junit.Assert.*;

public class RegexpTest {

    @Test
    public void testInRange() {
        assertEquals(true, "-show train 1".matches(Regexp.CMD_SHOW_TRAIN));
    }

}
