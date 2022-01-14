import java.io.*;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int circleRadius = 0;
        int circlePosition[] = { 0, 0 };

        try (FileReader reader = new FileReader("src\\circle.txt")) {
            BufferedReader bufReader = new BufferedReader(reader);
            String circlePosStr = bufReader.readLine();
            circleRadius = Integer.parseInt(bufReader.readLine());

            String strArray[] = circlePosStr.split(" ");
            circlePosition[0] = Integer.parseInt(strArray[0]);
            circlePosition[1] = Integer.parseInt(strArray[1]);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (FileReader reader = new FileReader("src\\coord.txt")) {
            BufferedReader bufReader = new BufferedReader(reader);
            int i = 0;

            while (true) {
                String line = bufReader.readLine();

                if (line == null) {
                    break;
                }

                String strArray[] = line.split(" ");
                int x = Integer.parseInt(strArray[0]);
                int y = Integer.parseInt(strArray[1]);

                double funcValue = Math.pow((x - circlePosition[0]), 2) + Math.pow((y - circlePosition[1]), 2);

                if (funcValue < Math.pow(circleRadius, 2)) {
                    System.out.println(i + " - точка внутри");
                } else {
                    if (funcValue == Math.pow(circleRadius, 2)) {
                        System.out.println(i + " - точка лежит на окружности");
                    } else {
                        System.out.println(i + " - точка снаружи");
                    }
                }

                i++;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
