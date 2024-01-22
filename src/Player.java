public class Player {
    private String name;
    private int chips;
    private int wager;
    private int diceScore;
    private String results;
    // constructor
    public Player(String name, int chips, int score, int wager) {
        this.name = name;
        this.chips = chips;
        this.diceScore = score;
        this.wager = wager;
    }
    // object creator
    public static void setName(String name1, String name2, String name3) {
        Player player1 = new Player(name1, 100, 0, 0);
        Player player2 = new Player(name2, 100, 0, 0);
        Player player3 = new Player(name3, 100, 0, 0);
    }
    // return name
    public String getName() {
        return name;
    }
    // return chips
    public int getChips() {
        return chips;
    }
    // adds chips
    public void gainChips(int more) {
        chips += more;
    }
    // subtracts chips
    public void loseChips(int loss) {
        chips -= loss;
    }
    // sets wager
    public void setWager(int bet) {
        wager = bet;
    }
    // return wager
    public int getWager() {
        return wager;
    }
    // sets chips
    public void setChips(int more) {
        chips += more;
    }
    // turn results
    public String info() {
        return results;
    }
    // return dice score
    public int getScore() {
        return diceScore;
    }
    // rolling
    public void myTurn(Die one, Die two, Die three) {
        results = "N/A";
        one.roll();
        two.roll();
        three.roll();
        if (automaticWin(one, two, three) == false) {
            if (!(score(one, two, three).equals(""))) {
                diceScore = Integer.parseInt(score(one, two, three));
            } else {
                myTurn(one, two, three);
            }
        } else {
            results = name + " has " + ConsoleUtility.CYAN + "won" + ConsoleUtility.RESET + " this round!";
        }
    }
    // determines win
    private boolean automaticWin(Die one, Die two, Die three) {
        int die1 = one.getDie();
        int die2 = two.getDie();
        int die3 = three.getDie();
        int[] dice = {die1, die2, die3};
        if (dice[1] == dice[2] && dice[2] == dice[3] && dice[3] == dice[1]) {
            return true;
        } else if ((dice[1] == 4 && dice[2] == 5 && dice[3] == 6) || (dice[1] == 6 && dice[2] == 4 && dice[3] == 5) || (dice[1] == 5 && dice[2] == 6 && dice[3] == 4)) {
            return true;
        } else if ((dice[1] == 1 && dice[2] == 2 && dice[3] == 3) || (dice[1] == 2 && dice[2] == 3 && dice[3] == 1) || (dice[1] == 3 && dice[2] == 1 && dice[3] == 2)) {
            return false;
        } else {
            return false;
        }
    }
    // determines score
    public String score(Die one, Die two, Die three) {
        int die1 = one.getDie();
        int die2 = two.getDie();
        int die3 = three.getDie();
        int[] dice = {die1, die2, die3};
        if (dice[1] != dice[2] && dice[1] != dice[3] && dice[2] == dice[3]) {
            return "" + dice[2] + "" + dice[3] + "" + dice[1] + "";
        } else if (dice[2] != dice[1] && dice[2] != dice[3] && dice[1] == dice[3]) {
            return "" + dice[3] + "" + dice[1] + "" + dice[2] + "";
        } else if (dice[3] != dice[2] && dice[3] != dice[1] && dice[2] == dice[1]) {
            return "" + dice[1] + "" + dice[2] + "" + dice[3] + "";
        } else {
            return "";
        }
    }
}
