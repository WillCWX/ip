import java.util.Scanner;

public class Duke {
    private static Task[] dukeList = new Task[100];
    private static int end = 0;

    public static void main(String[] args) {
        greet();
        dukeLoop();
    }

    /**
     * Prints Duke's greetings
     */
    private static void greet() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?");
        System.out.println("---------------------\n");
    }

    /**
     * Runs the core, repeating functions of Duke
     */
    private static void dukeLoop() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();

            switch (input) {
                case "list":
                    printDukeList();
                    break;
                case "bye":
                    sc.close();
                    exit();
                    return;
                default:
                    interpretCommand(input);
                    ;
                    break;
            }
        }
    }

    private static void interpretCommand(String w) {
        if (w.startsWith("echo ", 0)) {
            echo(w.substring(5));
        } else if (w.startsWith("mark ")) {
            int index = Integer.parseInt(w.substring(5)) - 1;
            dukeList[index].markDone();
            printWithPartition("\tNice! I've marked this task as done:\n\t  " +
                    dukeList[index].toString() + "\n");
        } else if (w.startsWith("unmark ")) {
            int index = Integer.parseInt(w.substring(7)) - 1;
            dukeList[index].unmarkDone();
            printWithPartition("\tOK, I've marked this task as not done yet:" +
                    "\n\t  " + dukeList[index].toString() + "\n");
        } else {
            addToList(w);
        }
    }

    /**
     * Prints the partitions, ----,
     * then prints the string in-between with a tab spacing
     * 
     * @param w - The string in between the ---- partitions
     */
    private static void printWithPartition(String w) {
        System.out.println("---------------------");
        System.out.print(w);
        System.out.println("---------------------");
    }

    private static void echo(String w) {
        printWithPartition("\tDuke: " + w + "\n");
    }

    /**
     * Adds an item to Duke's list and notifies the user in print
     * 
     * @param w - The item to add to the list
     */
    private static void addToList(String w) {
        if (end < 100) {
            dukeList[end] = new Task(w);
            end += 1;
            printWithPartition("\tadded: " + w + "\n");
        } else {
            printWithPartition("\tfailed to add: " + w + "\n");
        }
    }

    private static void printDukeList() {
        String ls = "\tHere are the tasks in your list:\n";
        for (int i = 0; i < end; i++) {
            ls = ls + "\t" + Integer.toString(i + 1) + "." +
                    dukeList[i].toString() + "\n";
        }
        printWithPartition(ls);
    }

    private static void exit() {
        printWithPartition("\tGoodbye!\n");
    }

}
