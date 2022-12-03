package pl.threds;


import javax.swing.*;

public class Assistant extends Thread {

	private String numberOfAssistant;
	private int amountOfNourishment;
	private int positionOfAssistant;
	private JLabel aLabel;
	private String direction;
	public Assistant(int j) {
		if(j == 1){
			this.numberOfAssistant = "a";
		}
		if(j == 2){
			this.numberOfAssistant = "b";
		}
		if(j == 3){
			this.numberOfAssistant = "c";
		}
		if(j == 4){
			this.numberOfAssistant = "d";
		}
		if(j == 5){
			this.numberOfAssistant = "e";
		}
		if(j == 6){
			this.numberOfAssistant = "f";
		}
		if(j == 7){
			this.numberOfAssistant = "g";
		}
		if(j == 8){
			this.numberOfAssistant = "h";
		}
		this.positionOfAssistant = j;
		this.amountOfNourishment = (int) ((Math.random() * (50 - 1)) + 1);
		MyFrame.assistantsPositions.put(positionOfAssistant,numberOfAssistant);
		aLabel = MyFrame.assistantContainers.get(positionOfAssistant);
		aLabel.setText("  |" + numberOfAssistant + "_" + amountOfNourishment + "|");

		if(positionOfAssistant == 1){
			this.direction = "down";
		}
		else if (positionOfAssistant == MyFrame.numberOfAnimals){
			this.direction = "up";
		}
		else{
			int rand = (int) ((Math.random() * (2 - 1)) + 1);
			if(rand == 1){
				this.direction = "down";
			}
			if(rand == 2){
				this.direction = "up";
			}
		}
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		while(true){
			JLabel sLabel = MyFrame.staminaContainers.get(positionOfAssistant);
			if(amountOfNourishment > 0){
				if(!sLabel.getText().equals("     | " +  "dead" + " |")){
					JLabel nLabel = MyFrame.nourishmentContainers.get(positionOfAssistant);
					int animalNourishment = Integer.parseInt(nLabel.getText().replaceAll("\\D+", ""));
					if(animalNourishment < 5){
						aLabel = MyFrame.assistantContainers.get(positionOfAssistant);
						while(!(animalNourishment == 10 || amountOfNourishment == 0)){
							amountOfNourishment--;
							animalNourishment++;
							aLabel.setText("  |" + numberOfAssistant + "_" + amountOfNourishment + "|");
							nLabel.setText(("     |  " + animalNourishment + "  |"));
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								throw new RuntimeException(e);
							}
						}
					}
					if(animalNourishment > 4){
						move();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
					}
				}
				else{
					move();
				}
			}
			if(amountOfNourishment == 0){
				distributor();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	private void distributor(){
		synchronized (Assistant.class){
			MyFrame.distributorPlaceHolder.setText("     | "+ numberOfAssistant + " |");
			while(amountOfNourishment != 50){
				amountOfNourishment++;
				aLabel.setText("  |" + numberOfAssistant + "_" + amountOfNourishment + "|");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			MyFrame.distributorPlaceHolder.setText("     |___|");
		}
	}

	private void move(){
		if(positionOfAssistant == 1){
			direction = "down";
			moveDownOrUp();
		}
		else if (positionOfAssistant == MyFrame.numberOfAnimals){
			direction = "up";
			moveDownOrUp();
		}
		else{
			if(!moveDownOrUp()){
				changeDirection();
			}
		}
	}

	private void changeDirection(){
		if(direction.equals("up")){
			direction = "down";
		}
		if(direction.equals("down")){
			direction = "up";
		}
	}

	private boolean moveDownOrUp(){
		if(direction.equals("up")){
			if(MyFrame.assistantsPositions.get(positionOfAssistant - 1) == null){
				aLabel.setText("  |____|");
				MyFrame.assistantsPositions.remove(positionOfAssistant);
				positionOfAssistant--;
				MyFrame.assistantsPositions.put(positionOfAssistant,numberOfAssistant);
				aLabel = MyFrame.assistantContainers.get(positionOfAssistant);
				aLabel.setText("  |" + numberOfAssistant + "_" + amountOfNourishment + "|");
				return true;
			}
		}
		if(direction.equals("down")){
			if(MyFrame.assistantsPositions.get(positionOfAssistant + 1) == null){
				aLabel.setText("  |____|");
				MyFrame.assistantsPositions.remove(positionOfAssistant);
				positionOfAssistant++;
				MyFrame.assistantsPositions.put(positionOfAssistant,numberOfAssistant);
				aLabel = MyFrame.assistantContainers.get(positionOfAssistant);
				aLabel.setText("  |" + numberOfAssistant + "_" + amountOfNourishment + "|");
				return true;
			}
		}
		return false;
	}
}
