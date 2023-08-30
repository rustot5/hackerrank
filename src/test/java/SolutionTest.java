import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testMain() {
        PrintStream saveStdout = System.out;
        InputStream saveStdin = System.in;
        Scanner result;
        try {
            ByteArrayOutputStream stdout = new ByteArrayOutputStream();
            System.setOut(new PrintStream(stdout));
            System.setIn(getClass().getResourceAsStream("/sample.txt"));
            Solution.main(null);
            result = new Scanner(stdout.toString());
        } finally {
            System.setOut(saveStdout);
            System.setIn(saveStdin);
        }
        Scanner expected = new Scanner(getClass().getResourceAsStream("/expected.txt"));
        for (int idx = 1; result.hasNext() && expected.hasNext(); ++idx) {
            assertEquals(expected.next(), result.next(), "Item at postition " + idx);
        }
        assertEquals(!expected.hasNext(), !result.hasNext(), "EOF");
    }
}
