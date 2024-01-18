public class Player {
    private String playerName;
    private int wagerAmount;
    private int chipAmount;
    public Player(String name) {
        playerName = name;
        chipAmount = 100;
    }
    public String getName() {
        return playerName;
    }
    public void wager(int amount) {
        wagerAmount = amount;
    }

    public boolean myTurn() {
        return false;
    }



}
