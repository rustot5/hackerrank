import java.util.Locale;
import java.util.Scanner;
import java.util.stream.IntStream;

public final class Solution {
    static void solution(final Scanner in, final StringBuilder out) {
        IntStream stream = IntStream.generate(in::nextInt).limit(in.nextInt());
        out.append(stream.sum());
    }

    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in, "UTF-8").useLocale(Locale.ROOT);
        StringBuilder out = new StringBuilder();
        solution(in, out);
        System.out.println(out);
    }

    private Solution() {
    }
}
