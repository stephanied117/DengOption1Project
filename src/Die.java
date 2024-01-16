public class Die {
    public int die;
    private int[] dice;
    public Die() {
        die = 0;
    }
    public static void createDice() {
        Die die1 = new Die();
        Die die2 = new Die();
        Die die3 = new Die();
        Die[] dice = {die1, die2, die3};
    }
    public void roll() {
        die = (int)(Math.random() * 6 + 1);
    }
    public int getDie() {
        return die;
    }
    public boolean automaticWin() {
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

    public int score() {
        if (dice[1] != dice[2] && dice[1] != dice[3] && dice[2] == dice[3]) {
            return dice[1];
        } else if (dice[2] != dice[1] && dice[2] != dice[3] && dice[1] == dice[3]) {
            return dice[2];
        } else if (dice[3] != dice[2] && dice[3] != dice[1] && dice[2] == dice[1]) {
            return dice[3];
        } else {
            return 0;
        }
    }
}
