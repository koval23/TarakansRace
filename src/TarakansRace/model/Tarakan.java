package TarakansRace.model;

import java.util.Random;

public class Tarakan implements Runnable {
    private static int winner = 0;
    private static final int MIN = 2;
    private static final int MAX = 5;
    private int numTarakan;
    private final int countItaration;

    private Random random;

    public Tarakan(int numTarakan, int countItaration) {
        this.numTarakan = numTarakan;
        this.random = new Random();
        this.countItaration = countItaration;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < countItaration) {
            count++;
            System.out.println("Tarakan#" + numTarakan);
            try {
                Thread.sleep(MIN + random.nextInt(MAX - MIN + 1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (winner == 0) {
            winner = numTarakan;
            System.out.println("Tarakan#" + numTarakan + " - Победитель!");
        }
    }

    public static int getWinner() {
        return winner;
    }
}
