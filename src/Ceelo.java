import java.util.Scanner;
public class Ceelo {
    private int round;
    Banker b;
    Player player1;
    Player player2;
    Player player3;
    Die die1;
    Die die2;
    Die die3;
    int highScore;
    int won;
    int lost;
    String scoreName;
    // constructor
    public Ceelo() {
        round = 0;
        highScore = 0;
    }
    // runs game
    public void start() {
        intro();
    }
    // beginning lore
    public void intro() {
        Scanner scan = new Scanner(System.in);
        String intro = ConsoleUtility.RESET + "  You and two friends are broke. \nYou all want to become filthy rich. \nAfter a failed bank robbery, you all \ncome up with another elaborate scheme... ";
        blurbSpitter(intro,10);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
        intro = "  After evading security, you three \nsuccessfully break into a casino. \nWith the remains of your life savings, \nyou all plan on swindling as much \ncash as possible. ";
        blurbSpitter(intro,10);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
        intro = "  One of you see a rich, loaded \nguy sitting at a table. You all \ndecide to approach him. ";
        blurbSpitter(intro,10);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
        String bob = "  \"Hey, kids,\" he says. \"wanna \nplay a game?\" ";
        blurbSpitter(bob,10);
        try {
            Thread.sleep(1500);
        } catch (Exception e) {}
        intro = "  You all stand awkwardly at \nthe foot of the table before \nnodding your heads. ";
        blurbSpitter(intro,10);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
        bob = "  \"Don't be so shy.\" he says. \"What \nare your names?\" ";
        blurbSpitter(bob,10);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
        String name1 = scan.nextLine();
        bob = "  \"Okay, Player 1. How 'bout Player 2?\" ";
        blurbSpitter(bob, 30);
        String name2 = scan.nextLine();
        bob = "  \"...and Player 3?\" ";
        blurbSpitter(bob, 30);
        String name3 = scan.nextLine();
        Player.setName(name1, name2, name3);
        bob = "  \"Nice meeting y'all...\" he says. ";
        blurbSpitter(bob, 30);
        try {
            Thread.sleep(1500);
        } catch (Exception e) {}
        Banker.setName("Bob");
        intro = "  The rich guy distributes a \nhundred chips for each player. \nHe plops a thousand of them in \nfront of himself. ";
        blurbSpitter(intro, 30);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        String you = "  \"Wait- why the heck do you \nhave so much?!\" one of you ask. ";
        blurbSpitter(you, 30);
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
        }
        bob = "  \"Well, kids,\" he says. \"Those are \nthe rules. After all... \nI AM BOB THE BANKER!\"";
        blurbSpitter(bob, 30);
        try {
            Thread.sleep(1500);
        } catch (Exception e) {}
        String bobby = "Bob";
        Banker.setName(bobby);
        intro = "  You all wonder if Bob has \ncompletely lost it. ";
        blurbSpitter(intro, 30);
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
        }
        bob = "  Bob continues to ramble. \"AND \nTODAY, WE ARE GOING TO PLAY...\" ";
        blurbSpitter(bob, 30);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
        System.out.println();
        gameScreen();
    }
    // home game screen
    public void gameScreen() {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            System.out.print(ConsoleUtility.RED + "- ");
            System.out.print(ConsoleUtility.WHITE + "- ");
        }
        System.out.print(ConsoleUtility.RED + "- ");
        System.out.println(ConsoleUtility.WHITE + "- ");
        String[] begin = {"             The             ", "       CEE-LO DICE GAME      "};
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
        String rmvScreen = scan.nextLine();
        if (rmvScreen.equals("x")) {
            ConsoleUtility.clearScreen();
            round(b, player1, player2, player3);
        }
    }
    // round manager
    public void round(Banker bob, Player one, Player two, Player three) {
        Scanner scan = new Scanner(System.in);
        String nameB = bob.getName();
        String name1 = one.getName();
        String name2 = two.getName();
        String name3 = three.getName();
        String[] betTurns = {name1, name2, name3};
        String[] turns = {nameB, name1, name2, name3};
        int chips1 = one.getChips();
        int chips2 = two.getChips();
        int chips3 = three.getChips();
        int[] betChips = {chips1, chips2, chips3};
        int scoreB = bob.getScore();
        int score1 = one.getScore();
        int score2 = two.getScore();
        int score3 = three.getScore();
        while (!(bob.getChips() <= 0 || one.getChips() <= 0 && two.getChips() <= 0 && three.getChips() <= 0)) {
            // round set up
            round++;
            System.out.println(ConsoleUtility.RED + "ROUND " + round + ": ");
            // betting
            for (int i = 0; i < betTurns.length; i++) {
                System.out.println(ConsoleUtility.RESET + "Enter your bet, " + betTurns[i]);
                int bet = scan.nextInt();
                while (!(bet > 0 && bet <= betChips[i])) {
                    if (bet > 0 && bet <= betChips[i]) {
                        one.setWager(bet);
                    } else {
                        System.out.println("Invalid amount");
                    }
                }
                bet = 0;
            }
            // rolling and other options
            for (int i = 0; i < turns.length + 1; i++) {
                String turn = "It's " + turns[i] + " turn!";
                blurbSpitter(turn, 10);
                // Bob's options
                if (turns[i].equals(nameB) && !(bob.getChips() <= 0)) {
                    bob.myTurn(die1, die2, die3);
                    if (!(bob.info().equals("N/A"))) {
                        System.out.println(bob.info());
                    }

                } else {
                    System.out.println("Bob the Banker is too broke to play!");
                }
                // Player one's options
                if (turns[i].equals(name1)) {
                    System.out.println();
                    System.out.println(ConsoleUtility.RED + "OPTIONS:");
                    System.out.println(ConsoleUtility.RESET + "R) Roll");
                    System.out.println("C) Chip Balance");
                    System.out.println("M) Main Menu");
                    String choice = scan.nextLine();
                    if (choice.equals("r") || choice.equals("R")) {
                        Die.createDice();
                        one.myTurn(die1, die2, die3);
                        System.out.println(one.getScore());
                        if (!(one.info().equals("N/A"))) {
                            System.out.println(one.info());
                        }
                    } else if (choice.equals("c") || choice.equals("C")) {
                        System.out.println(one.getChips());
                    } else if (choice.equals("m") || choice.equals("M")) {
                        // main menu
                        System.out.println();
                        System.out.println(ConsoleUtility.RED + "MAIN MENU:");
                        System.out.println(ConsoleUtility.RESET + "S) Top Score");
                        System.out.println("R) Restart Game");
                        System.out.println("Q) Quit");
                        String option = scan.nextLine();
                        if (option.equals("s") || option.equals("S")) {
                            topScore();
                        } else if (option.equals("b") || option.equals("B")) {
                            System.out.println();
                            System.out.println(ConsoleUtility.RED + "OPTIONS:");
                            System.out.println(ConsoleUtility.RESET + "R) Roll");
                            System.out.println("C) Chip Balance");
                            System.out.println("M) Main Menu");
                            choice = scan.nextLine();
                        } else if (option.equals("r") || option.equals("R")) {
                            restart(player1, player2, player3);
                        } else if (option.equals("q") || option.equals("Q")) {
                            break;
                        } else {
                            System.out.println("Invalid option");
                        }
                    } else {
                        System.out.println("Invalid option");
                    }
                } else {
                    System.out.println(name1 + " is too broke to play!");
                }
                // player two's options
                if (turns[i].equals(name2)) {
                    System.out.println();
                    System.out.println(ConsoleUtility.RED + "OPTIONS:");
                    System.out.println(ConsoleUtility.RESET + "R) Roll");
                    System.out.println("C) Chip Balance");
                    System.out.println("M) Main Menu");
                    String choice = scan.nextLine();
                    if (choice.equals("r") || choice.equals("R")) {
                        Die.createDice();
                        two.myTurn(die1, die2, die3);
                        System.out.println(two.getScore());
                        if (!(two.info().equals("N/A"))) {
                            System.out.println(two.info());
                        }
                    } else if (choice.equals("c") || choice.equals("C")) {
                        System.out.println(two.getChips());
                    } else if (choice.equals("m") || choice.equals("M")) {
                        // main menu
                        System.out.println();
                        System.out.println(ConsoleUtility.RED + "MAIN MENU:");
                        System.out.println(ConsoleUtility.RESET + "S) Top Score");
                        System.out.println("R) Restart Game");
                        System.out.println("Q) Quit");
                        String option = scan.nextLine();
                        if (option.equals("s") || option.equals("S")) {
                            topScore();
                        } else if (option.equals("b") || option.equals("B")) {
                            System.out.println();
                            System.out.println(ConsoleUtility.RED + "OPTIONS:");
                            System.out.println(ConsoleUtility.RESET + "R) Roll");
                            System.out.println("C) Chip Balance");
                            System.out.println("M) Main Menu");
                            choice = scan.nextLine();
                        } else if (option.equals("r") || option.equals("R")) {
                            restart(player1, player2, player3);
                        } else if (option.equals("q") || option.equals("Q")) {
                            break;
                        } else {
                            System.out.println("Invalid option");
                        }
                    } else {
                        System.out.println("Invalid option");
                    }
                } else {
                    System.out.println(name2 + " is too broke to play!");
                }
                // player three's options
                if (turns[i].equals(name3)) {
                    System.out.println();
                    System.out.println(ConsoleUtility.RED + "OPTIONS:");
                    System.out.println(ConsoleUtility.RESET + "R) Roll");
                    System.out.println("C) Chip Balance");
                    System.out.println("M) Main Menu");
                    String choice = scan.nextLine();
                    if (choice.equals("r") || choice.equals("R")) {
                        Die.createDice();
                        three.myTurn(die1, die2, die3);
                        System.out.println(three.getScore());
                        if (!(three.info().equals("N/A"))) {
                            System.out.println(three.info());
                        }
                    } else if (choice.equals("c") || choice.equals("C")) {
                        System.out.println(three.getChips());
                    } else if (choice.equals("m") || choice.equals("M")) {
                        // main menu
                        System.out.println();
                        System.out.println(ConsoleUtility.RED + "MAIN MENU:");
                        System.out.println(ConsoleUtility.RESET + "S) Top Score");
                        System.out.println("B) Go Back");
                        System.out.println("R) Restart Game");
                        System.out.println("Q) Quit");
                        String option = scan.nextLine();
                        if (option.equals("s") || option.equals("S")) {
                            topScore();
                        } else if (option.equals("b") || option.equals("B")) {
                            System.out.println();
                            System.out.println(ConsoleUtility.RED + "OPTIONS:");
                            System.out.println(ConsoleUtility.RESET + "R) Roll");
                            System.out.println("C) Chip Balance");
                            System.out.println("M) Main Menu");
                            choice = scan.nextLine();
                        } else if (option.equals("r") || option.equals("R")) {
                            restart(player1, player2, player3);
                        } else if (option.equals("q") || option.equals("Q")) {
                            break;
                        } else {
                            System.out.println("Invalid option");
                        }
                    } else {
                        System.out.println("Invalid option");
                    }
                } else {
                    System.out.println(name3 + " is too broke to play!");
                }
            }
            // score comparing
            if (scoreB > score1 && scoreB > score2 && scoreB > score3) {
                System.out.println(nameB + " has " + ConsoleUtility.CYAN + "won" + ConsoleUtility.RESET + " this round!");
                bob.gainChips(one.getWager() + two.getWager() + three.getWager());
                one.loseChips(one.getWager());
                two.loseChips(two.getWager());
                three.loseChips(three.getWager());
                System.out.println(nameB + ConsoleUtility.GREEN + " gained " + ConsoleUtility.YELLOW + (one.getWager() + two.getWager() + three.getWager()) + " chips.");
                System.out.println(name1 + ConsoleUtility.RED + " lost " + ConsoleUtility.YELLOW + one.getWager() + ConsoleUtility.RESET + " chips.");
                System.out.println(name2 + ConsoleUtility.RED + " lost " + ConsoleUtility.YELLOW + two.getWager() + ConsoleUtility.RESET + " chips.");
                System.out.println(name3 + ConsoleUtility.RED + " lost " + ConsoleUtility.YELLOW + three.getWager() + ConsoleUtility.RESET + " chips.");
            } else if (score1 > scoreB && score1 > score2 && score1 > score3) {
                System.out.println(name1 + " has " + ConsoleUtility.CYAN + "won" + ConsoleUtility.RESET + " this round!");
                one.gainChips(one.getWager());
                bob.loseChips(one.getWager());
                System.out.println(name1 + ConsoleUtility.GREEN + " gained " + ConsoleUtility.YELLOW + one.getWager() + ConsoleUtility.RESET + " chips.");
                System.out.println(nameB + ConsoleUtility.RED + " lost " + ConsoleUtility.YELLOW + one.getWager() + ConsoleUtility.RESET + " chips.");
            } else if (score2 > score1 && score2 > scoreB && score2 > score3) {
                System.out.println(name2 + " has " + ConsoleUtility.CYAN + "won" + ConsoleUtility.RESET + " this round!");
                two.gainChips(two.getWager());
                bob.loseChips(two.getWager());
                System.out.println(name2 + ConsoleUtility.GREEN + " gained " + ConsoleUtility.YELLOW + two.getWager() + ConsoleUtility.RESET + " chips.");
                System.out.println(nameB + ConsoleUtility.RED + " lost " + ConsoleUtility.YELLOW + two.getWager() + ConsoleUtility.RESET + " chips.");
            } else if (score3 > score1 && score3 > score2 && score3 > scoreB) {
                System.out.println(name3 + " has " + ConsoleUtility.CYAN + "won" + ConsoleUtility.RESET + " this round!");
                three.gainChips(three.getWager());
                bob.loseChips(three.getWager());
                System.out.println(name3 + ConsoleUtility.GREEN + " gained " + ConsoleUtility.YELLOW + three.getWager() + ConsoleUtility.RESET + " chips.");
                System.out.println(nameB + ConsoleUtility.RED + " lost " + ConsoleUtility.YELLOW + three.getWager() + ConsoleUtility.RESET + " chips.");
            } else if (scoreB == score1) {
                System.out.println(name1 + " has " + ConsoleUtility.CYAN + "won" + ConsoleUtility.RESET + " this round!");
                one.gainChips(one.getWager());
                bob.loseChips(one.getWager());
                System.out.println(name1 + ConsoleUtility.GREEN + " gained " + ConsoleUtility.YELLOW + one.getWager() + " chips.");
                System.out.println(nameB + ConsoleUtility.RED + " lost " + ConsoleUtility.YELLOW + one.getWager() + ConsoleUtility.RESET + " chips.");
            } else if (scoreB == score2) {
                System.out.println(name2 + " has " + ConsoleUtility.CYAN + "won" + ConsoleUtility.RESET + " this round!");
                two.gainChips(two.getWager());
                bob.loseChips(two.getWager());
                System.out.println(name2 + ConsoleUtility.GREEN + " gained " + ConsoleUtility.YELLOW + two.getWager() + " chips.");
                System.out.println(nameB + ConsoleUtility.RED + " lost " + ConsoleUtility.YELLOW + two.getWager() + ConsoleUtility.RESET + " chips.");
            } else if (scoreB == score3) {
                System.out.println(name3 + " has " + ConsoleUtility.CYAN + "won" + ConsoleUtility.RESET + " this round!");
                three.gainChips(three.getWager());
                bob.loseChips(three.getWager());
                System.out.println(name3 + ConsoleUtility.GREEN + " gained " + ConsoleUtility.YELLOW + three.getWager() + " chips.");
                System.out.println(nameB + ConsoleUtility.RED + " lost " + ConsoleUtility.YELLOW + three.getWager() + ConsoleUtility.RESET + " chips.");
            } else {
                System.out.println("There is a " + ConsoleUtility.BLUE + "tie" + ConsoleUtility.RESET + " between players! \nChip balances will remain unaffected.");
            }
        }
        theEnd(bob, one, two, three);
    }
    // returns highest score
    public void topScore() {
        System.out.println("The highest score was " + highScore + " and was made by " + scoreName);
    }
    // starts new game
    public void restart(Player one, Player two, Player three) {
        String name1 = one.getName();
        String name2 = two.getName();
        String name3 = three.getName();
        round = 0;
        Player.setName(name1, name2, name3);
        Banker.setName("Bob");
        round(b, player1, player2, player3);
    }
    // game results
    public void theEnd(Banker bob, Player one, Player two, Player three) {
        Scanner scan = new Scanner(System.in);
        int chipsB = b.getChips();
        int chips1 = one.getChips();
        int chips2 = two.getChips();
        int chips3 = three.getChips();
        String nameB = bob.getName();
        String name1 = one.getName();
        String name2 = two.getName();
        String name3 = three.getName();
        if (chipsB <= 0) {
            System.out.println("What a splendidly-dumptious game!");
            System.out.println("You " + ConsoleUtility.GREEN + " BEAT " + ConsoleUtility.RESET + " Bob the Banker.");
            if (chips1 > chips2 && chips1 > chips3) {
                System.out.println(name1 + ConsoleUtility.CYAN + " WON " + ConsoleUtility.RESET + " with " + ConsoleUtility.YELLOW + chips1 + ConsoleUtility.RESET + " chips!");
                if (chips1 > highScore) {
                    highScore = chips1;
                }
            } else if (chips2 > chips1 && chips2 > chips3) {
                System.out.println(name2 + ConsoleUtility.CYAN + " WON " + ConsoleUtility.RESET + " with " + ConsoleUtility.YELLOW + chips2 + ConsoleUtility.RESET + " chips!");
                if (chips2 > highScore) {
                    highScore = chips2;
                }
            } else if (chips3 > chips2 && chips3 > chips1) {
                System.out.println(name3 + ConsoleUtility.CYAN + " WON " + ConsoleUtility.RESET + " with " + ConsoleUtility.YELLOW + chips3 + ConsoleUtility.RESET + " chips!");
                if (chips3 > highScore) {
                    highScore = chips3;
                }
            } else if (chips1 == chips2) {
                System.out.println("There was a " + ConsoleUtility.BLUE + "tie" + ConsoleUtility.RESET + " of " + ConsoleUtility.YELLOW + chips1 + ConsoleUtility.RESET + " chips!");
                if (chips1 > highScore) {
                    highScore = chips1;
                }
            } else if (chips2 == chips3) {
                System.out.println("There was a " + ConsoleUtility.BLUE + "tie" + ConsoleUtility.RESET + " of " + ConsoleUtility.YELLOW + chips2 + ConsoleUtility.RESET + " chips!");
                if (chips2 > highScore) {
                    highScore = chips2;
                }
            } else if (chips3 == chips1) {
                System.out.println("There was a " + ConsoleUtility.BLUE + "tie" + ConsoleUtility.RESET + " of " + ConsoleUtility.YELLOW + chips3 + ConsoleUtility.RESET + " chips!");
                if (chips3 > highScore) {
                    highScore = chips3;
                }
            }
            won++;
        } else {
            System.out.println("What an unsplendidly-dumptious game!");
            System.out.println("You " + ConsoleUtility.RED + " LOST " + ConsoleUtility.RESET + " to Bob the Banker.");
            lost++;
        }
        System.out.println();
        System.out.println("Would you like to play another game? yay/nay");
        String again = scan.nextLine();
        if (again.equals("yay")) {
            restart(player1, player2, player3);
        } else if (again.equals("nay")){
            bobBabbles();
        } else {
            System.out.println("Invalid option");
        }
    }
    // bob's farewell
    public void bobBabbles() {
        String bob = "";
        if (won > 0 && lost > 0) {
            bob = "  \"It was nice playing with you kids.\" says Bob. ";
            blurbSpitter(bob, 30);
        } else if (won > 0 && lost == 0) {
            bob = "  \"NOOo!!\" screamed Bob. \"MY mONEYYY!!!\" ";
            blurbSpitter(bob, 30);
        } else if (won == 0 && lost > 0) {
            bob = "  \"hAHAhAHAha!!!\" says Bob. ";
            blurbSpitter(bob, 30);
        }
    }
    // not really fancy word effect
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
}

