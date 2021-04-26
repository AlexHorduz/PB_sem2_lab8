package lab8;

import lab8.interfaces.IView;

import java.io.IOException;

public class ConsoleView implements IView {
    public void update(long done, long toDo)  {
        clearScreen();
        System.out.println("Loading... Please, wait");
        System.out.print("[");
        int numOfLines = (int)((done+0.0)*30/toDo);
        for (int i = 0; i < numOfLines; i++) {
            System.out.print("|");
        }

        for (int i = 0; i < 30 - numOfLines; i++) {
            System.out.print(" ");
        }
        System.out.println("]");
    }

    public void update(long done, long toDo, String job)  {
        clearScreen();
        System.out.println(job + "... Please, wait");
        System.out.print("[");
        int numOfLines = (int)((done+0.0)*30/toDo);
        for (int i = 0; i < numOfLines; i++) {
            System.out.print("|");
        }

        for (int i = 0; i < 30 - numOfLines; i++) {
            System.out.print(" ");
        }
        System.out.println("]");
    }

    private void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
