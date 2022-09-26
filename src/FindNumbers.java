// Import IO and Regex libs
import java.io.*;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class FindNumbers {

    public static void main(String[] args) throws Exception {

        // Defining location of textfile
        String file = ("test.txt");

        //Using BufferedReader for large filesize
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            // read each line
            while ((line = br.readLine()) != null) {
                // define the RegEx-Pattern (in this case d+: Digits with one or more occurences)
                Pattern p = Pattern.compile("\\d+");
                Matcher m = p.matcher(line);

                //Iterate through every line until none available (m.find() == false)
                while (m.find()) {
                    // Convert the matching patterns from String to Int for further processing
                    int numbersInLine = Integer.parseInt(m.group());
                    // Check if the found number is 10 or larger.
                    boolean isAtLeastTen = numbersInLine >= 10;

                    // If true, output the line.
                    if (isAtLeastTen) {
                        System.out.println(line);
                        //Break, in case the same String contains two or more matching numbers.
                        break;
                    }
                }
            }
        }
    }
}

