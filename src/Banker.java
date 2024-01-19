public class Banker {
    private String name;
    private int wagerAmount;
    private int chipAmount;
    private int score;
    private int die1;
    private int die2;
    private int die3;
    public Banker(String name, int chips, int score) {
        this.name = name;
        chipAmount = 100;
        this.score = score;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
    public int getWager() {
        return wagerAmount;
    }
    public void setWager() {
        wagerAmount = (int)(Math.random() * 1000 + 1);
    }
    public void penalty(Player other) {
        chipAmount -= other.getWager();
    }
    public void win(Player other) {
        chipAmount += other.getWager();
    }
    public boolean noChips() {
        if (chipAmount <= 0) {
            return true;
        }
        return false;
    }
    public void rolling(Die[] dice) {
        for (Die d : dice) {
            d.roll();
        }

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
