package pl.threds;


import javax.swing.*;

public class Animal extends Thread {
    private final int numberOfAnimal;
    private int stamina;
    private int amountOfNourishment;
    private final JLabel nLabel;
    private final JLabel sLabel;
    private boolean isAlive;


    public Animal(int i) {
        this.isAlive = true;
        this.numberOfAnimal = i;
        this.stamina = 5;
        this.amountOfNourishment = (int) ((Math.random() * (10 - 1)) + 1);
        this.nLabel = MyFrame.nourishmentContainers.get(numberOfAnimal);
        nLabel.setText(("     |  " + amountOfNourishment + "  |"));
        this.sLabel = MyFrame.staminaContainers.get(numberOfAnimal);
        sLabel.setText("     | " +  stamina + " |");
    }

    @Override
    public void run() {
        int eatingBufor = 0;
        int counter = 0;
        int deadcounter = 0;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while(isAlive){
            if(stamina < 5){
                while (eatingBufor != 3) {
                    amountOfNourishment = Integer.parseInt(MyFrame.nourishmentContainers.get(numberOfAnimal).getText().replaceAll("\\D+",""));
                    if(amountOfNourishment > 0){
                        amountOfNourishment = amountOfNourishment - 1;
                        nLabel.setText(("     |  " + amountOfNourishment + "  |"));
                        eatingBufor++;
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else{
                        break;
                    }
                }
                if(eatingBufor == 3){
                    stamina++;
                    sLabel.setText("     | " +  stamina + " |");
                    eatingBufor = 0;
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter++;
            if(counter == 5){
                if(stamina>0){
                    stamina--;
                    sLabel.setText("     | " +  stamina + " |");
                }
                counter = 0;
            }
            if(stamina == 0){
                if(deadcounter == 5){
                    isAlive = false;
                    sLabel.setText("     | " +  "dead" + " |");
                }
                deadcounter++;
            }
        }
    }


}