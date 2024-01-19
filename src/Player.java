public class Player {
    private String playerName;
    private int wagerAmount;
    private int chipAmount;
    private int score;
    public Player(String name, int chips, int score, int wager) {
        playerName = name;
        chipAmount = 100;
        this.score = score;
        wagerAmount = wager;
    }
    public String getName() {
        return playerName;
    }
    public int getWager() {
        return wagerAmount;
    }
    public void setWager(int amount) {
        wagerAmount = amount;
    }
    public void penalty() {
        chipAmount -= wagerAmount;
    }
    public void win(Banker bob) {
        chipAmount += wagerAmount;
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



}
