package TarakansRace;

import TarakansRace.model.Tarakan;

public class TarakansRaceAppl {
    public static void main(String[] args) {
        int countTarakans = Integer.parseInt(args[0]);
        int countLaps = Integer.parseInt(args[1]);

        Tarakan[] tarakans = new Tarakan[countTarakans];

        for (int i = 0; i < tarakans.length; i++) {
            tarakans[i] = new Tarakan(i + 1, countLaps);
        }
//        ----------------------------------
        Thread[] treads = new Thread[tarakans.length];
        for (int i = 0; i < treads.length; i++) {
            treads[i] = new Thread(tarakans[i]);
        }
//        ----------------------------------
        for (Thread tread : treads) {
            tread.start();
        }
//        --------------------------------
        for (Thread thread : treads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Гонка завершена. Победитель - Tarakan#" + Tarakan.getWinner());
    }
}
