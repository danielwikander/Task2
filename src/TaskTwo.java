import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TaskTwo {

    public static void main(String[] args) {
        // Print man page if requested in args.
        if (args.length > 0 && (args[0].equals("-h") || args[0].equals("-help") || args[0].equals("help"))) {
            printManPage();
            return;
        }

        // Check if argument has been provided, else prompt user to look at docs.
        if (args.length < 1) {
            System.out.println("TaskTwo requires at least 1 argument.");
            System.out.println("Execute 'TaskTwo -h' for help.");
            return;
        }

        // Parse arguments, in order: filepath, order (order defaults to ascending if no argument is given)
        String filePath = args[0];
        String order = "asc";
        if (args.length > 1) {
            if (args[1].equals("desc")) {
                order = args[1];
            } else if (!args[1].equals("asc")) {
                System.out.println("Invalid argument: " + args[1]);
                System.out.println("TaskTwos second argument can be 'desc' or 'asc' only.");
                System.out.println("Execute 'TaskTwo -h' for help.");
            }
        }

        // Read numbers from file into List.
        List<Long> linesList = readFileIntoList(filePath);

        // If order is set to ascending, sort list ascending.
        if (order.equals("asc")) {
            Collections.sort(linesList);
            System.out.println("Numbers from: " + filePath + " - sorted in ascending order:");

        // If order is set to descending, sort list descending.
        } else {
            Comparator<Long> comparator = Collections.reverseOrder();
            linesList.sort(comparator);
            System.out.println("Numbers from: " + filePath + " - sorted in descending order:");
        }

        // Print sorted list.
        System.out.println(linesList);
    }

    /**
     * Reads numbers from a file and stores in an ArrayList.
     * @param file  The file to read the numbers from.
     * @return      An ArrayList filled with numbers from the file.
     */
    public static List<Long> readFileIntoList(String file)  {
        ArrayList<Long> linesList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            // Try to parse each line into long and add to list - ignore line if not parsable
            String line = reader.readLine();
            long nbrFromLine;
            while (line != null) {
                try {
                    nbrFromLine = Long.parseLong(line);
                    linesList.add(nbrFromLine);
                } catch (Exception ignored) {}
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Could not read from file:" + file);
            e.printStackTrace();
        }
        return linesList;
    }

    /**
     * Prints the programs manpage.
     */
    public static void printManPage() {
        System.out.println(
            "NAME\n" +
            "    TaskTwo - Reads numbers from a file and prints them in order.\n\n" +
            "SYNOPSIS \n" +
            "    TaskTwo [filepath] [order] \n\n" +
            "DESCRIPTION\n" +
            "    Reads numbers from a file and prints them in order.\n" +
            "    Requires one argument to run (filepath).\n" +
            "    The second argument selects the order to sort in.\n" +
            "    If no order is given, it will be sorted in ascending order.\n" +
            "    Arguments must be written in the order: filepath, sorting order.\n\n" +
            "ARGUMENTS\n" +
            "    filepath:         The path the the file to create/overwrite. Must be a valid filepath.\n" +
            "    order [OPTIONAL]: The order that the numbers will be printed in.\n" +
            "                      Order can be 'asc' (ascending) or 'desc' (descending).\n\n" +
            "EXAMPLES\n" +
            "    TaskTwo testFile desc\n" +
            "        The file 'testFile' will be read and its numbers will be printed in descending order.\n" +
            "    TaskTwo testFile \n" +
            "        The file 'testFile' will be read and its numbers will be printed in ascending order. \n");
    }
}
