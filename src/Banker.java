public class Banker {
    private String name;
    private int chips;
    private int diceScore;
    private String results;
    // constructor
    public Banker(String name, int chips, int score) {
        this.name = name;
        this.chips = chips;
        this.diceScore = score;
    }
    // object creator
    public static void setName(String name) {
        Banker b = new Banker(name, 1000, 0);
    }
    // returns name
    public String getName() {
        return name;
    }
    // returns chip amount
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
