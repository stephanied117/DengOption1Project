public class Die {
    private int die;
    private int[] dice;
    public Die(int num) {
        die = num;
    }
    public static void createDice() {
        Die die1 = new Die(0);
        Die die2 = new Die(0);
        Die die3 = new Die(0);
        Die[] dice = {die1, die2, die3};
        int one = dice[1].getDie();
        int two = dice[2].getDie();
        int three = dice[3].getDie();
    }
    public void roll() {
        die = (int)(Math.random() * 6 + 1);
    }
    public int getDie() {
        return die;
    }
}
