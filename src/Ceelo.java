import java.util.Scanner;
public class Ceelo {
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
        for (int i = 0; i < 7; i++) {
            System.out.print(ConsoleUtility.RED + "- ");
            System.out.print(ConsoleUtility.WHITE + "- ");
        }
        System.out.print(ConsoleUtility.RED + "- ");
        System.out.println(ConsoleUtility.WHITE + "- ");
        String[] begin = {"  \uD83C\uDFB2          The          \uD83C\uDFB2  ", "       CEE-LO DICE GAME      "};
        System.out.print(ConsoleUtility.WHITE + "|");
        System.out.print(ConsoleUtility.RESET + begin[0]);
        System.out.println(ConsoleUtility.RED + "|");
        System.out.print(ConsoleUtility.RED + "|");
        System.out.print(ConsoleUtility.RESET + begin[1]);
        System.out.println(ConsoleUtility.WHITE + "|");
        for (int i = 0; i < 7; i++) {
            System.out.print(ConsoleUtility.WHITE + "- ");
            System.out.print(ConsoleUtility.RED + "- ");
        }
        System.out.print(ConsoleUtility.WHITE + "- ");
        System.out.println(ConsoleUtility.RED + "- ");
        System.out.println();
        System.out.println(ConsoleUtility.WHITE + "       {Enter x to play}");
        String rmvMenu = "";
        rmvMenu = scan.nextLine();
        if (rmvMenu.equals("x")) {
            ConsoleUtility.clearScreen();
            objective();
        }
    }

    public void objective() {
        Scanner scan = new Scanner(System.in);
        ConsoleUtility.clearScreen();
        String context = "You and your friends are a bunch \nof broke, little lads. The three \nof you decide to break into a \ncasino. You spot a rich, loaded \nguy and decide to approach him... ";
        blurbSpitter(context, 30);
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
        String bob = "\"Hey kids,\" he says, \"Wanna play a game?\" ";
        blurbSpitter(bob, 30);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        String you = "\"Sure.\" one of you say. After all, you all want his money. ";
        blurbSpitter(you, 30);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        bob = "\"What are your names?\" he asks, implying that all three of you tell him.";
        blurbSpitter(bob, 30);
        String name1 = scan.nextLine();
        Player player1 = new Player(name1);
        bob = "\"Okay, Player 1. How 'bout Player 2?\"";
        blurbSpitter(bob, 30);
        String name2 = scan.nextLine();
        Player player2 = new Player(name2);
        bob = "\"And Player 3?\"";
        blurbSpitter(bob, 30);
        String name3 = scan.nextLine();
        Player player3 = new Player(name3);
        bob = "\"Nice meeting y'all, " + name1 + ", " + name2 + ", and " + name3 + ".\"";
        blurbSpitter(bob, 30);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        bob = "The rich guy distributes a hundred chips for each player. He plops a thousand of them in front of himself.";
        blurbSpitter(bob, 30);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }

    }
    public void turns() {
        Scanner scan = new Scanner(System.in);
        String name = Player.getName();
        String bob = "\"As the Banker, I shall go first, then\" " + ;


    }
    public void timeToDie() {
        Die.createDice();


    }
}

