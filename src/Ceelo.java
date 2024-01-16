import java.util.Scanner;
public class Ceelo {
    private String[] turns;
    public Ceelo() {
    }
    public void start() {
        screen();
    }
    private void blurbSpitter(String blurb, int time) {
        for (int i = 0; i < blurb.length(); i++) {
            ConsoleUtility.clearScreen();
            System.out.println(blurb.substring(0, i));
            try {
                Thread.sleep(time);
            } catch (Exception e) {

            }
        }
    }
    public void screen() {
        Scanner scan = new Scanner(System.in);
        String rmvMenu = "";
        rmvMenu = scan.nextLine();
        int tracker = 0;
        while (!(rmvMenu.equals("x"))) {
            if (rmvMenu.equals("x")) {
                ConsoleUtility.clearScreen();
                objective();
            } else {
                tracker++;
                try {
                    Thread.sleep(250);
                } catch (Exception e) {

                }
                ConsoleUtility.clearScreen();
                if (tracker % 2 == 0) {
                    for (int i = 0; i < 7; i++) {
                        System.out.print(ConsoleUtility.RED + "- ");
                        System.out.print(ConsoleUtility.WHITE + "- ");
                    }
                    System.out.print(ConsoleUtility.RED + "- ");
                    System.out.println(ConsoleUtility.WHITE + "- ");
                    String[] begin = {"  \uD83C\uDFB2           The         \uD83C\uDFB2  ", "      CEE-LO DICE GAME       "};
                    System.out.print(ConsoleUtility.WHITE + "|");
                    System.out.print(ConsoleUtility.RESET + begin[0]);
                    System.out.println(ConsoleUtility.RED + "|");
                    System.out.print(ConsoleUtility.RED + "|");
                    System.out.print(ConsoleUtility.RESET + begin[1]);
                    System.out.println(ConsoleUtility.WHITE + "|");
                    for (int i = 0; i < 7; i++) {
                        System.out.print(ConsoleUtility.RED + "- ");
                        System.out.print(ConsoleUtility.WHITE + "- ");
                    }
                    System.out.print(ConsoleUtility.RED + "- ");
                    System.out.println(ConsoleUtility.WHITE + "- ");
                    System.out.println();
                    System.out.println(ConsoleUtility.WHITE + "       {Enter x to play}");
                } else {
                    for (int i = 0; i < 7; i++) {
                        System.out.print(ConsoleUtility.WHITE + "- ");
                        System.out.print(ConsoleUtility.RED + "- ");
                    }
                    System.out.print(ConsoleUtility.WHITE + "- ");
                    System.out.println(ConsoleUtility.RED + "- ");
                    String[] begin = {"  \uD83C\uDFB2           The         \uD83C\uDFB2  ", "      CEE-LO DICE GAME       "};
                    System.out.print(ConsoleUtility.RED + "|");
                    System.out.print(ConsoleUtility.RESET + begin[0]);
                    System.out.println(ConsoleUtility.WHITE + "|");
                    System.out.print(ConsoleUtility.WHITE + "|");
                    System.out.print(ConsoleUtility.RESET + begin[1]);
                    System.out.println(ConsoleUtility.RED + "|");
                    for (int i = 0; i < 7; i++) {
                        System.out.print(ConsoleUtility.WHITE + "- ");
                        System.out.print(ConsoleUtility.RED + "- ");
                    }
                    System.out.print(ConsoleUtility.WHITE + "- ");
                    System.out.println(ConsoleUtility.RED + "- ");
                    System.out.println();
                    System.out.println(ConsoleUtility.WHITE + "       {Enter x to play}");
                }
            }
        }
        rmvMenu = "x";
    }
    public void objective() {
        Scanner scan = new Scanner(System.in);
        String objective = "You and your friends are a bunch of broke little lads. You all decide to break into a casino. You spot a "; //message to be implemented
        blurbSpitter(objective, 100);
        System.out.println();
        System.out.println("{Enter k when done}");
        String rmvMenu = scan.nextLine();
        if (rmvMenu.equals("k")) {
            ConsoleUtility.clearScreen();
            setUp();
        }
    }
    public void setUp() {
        Scanner scan = new Scanner(System.in);
        String banker = "G'day to y'all...I am BOB The Banker!\nI see you three little lads want to challenge me. ";
        blurbSpitter(banker, 75);

        String message = "Player 1, what's your name? ";
        blurbSpitter(message, 75);
        String name = scan.nextLine();
        Player player1 = new Player(name);
        message = "It's " + name + ", sir.";
        blurbSpitter(message, 75);
        banker = "Nice to meet you, " + name + ". \nHow about Player 2? ";
        blurbSpitter(banker, 75);
        name = scan.nextLine();
        Player player2 = new Player(name);
        message = "I am " + name + ". ";
        blurbSpitter(message, 75);
        banker = "Good to know, " + name + ". \nAnd lastly, Player 3? ";
        blurbSpitter(banker, 75);
        name = scan.nextLine();
        Player player3 = new Player(name);
        message = "My name is " + name + ". ";
        blurbSpitter(message, 75);
        banker = "So it's " + name + "... ";
        blurbSpitter(banker, 75);
    }
    public void timeToDie() {
        Die.createDice();


    }
}

