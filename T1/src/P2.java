import java.io.IOException;

public class P2 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder(args);
        try {
            pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
