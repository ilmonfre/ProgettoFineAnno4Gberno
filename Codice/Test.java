import java.io.IOException;

import javax.swing.JFrame;

public class Test {

    static JFrame frame;
    public static void main(String[] args) throws IOException {
        try {
            new FrameRegistrazione2(frame);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
