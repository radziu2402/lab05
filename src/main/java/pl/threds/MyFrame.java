package pl.threds;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class MyFrame extends JFrame {

	public static int numberOfAnimals;
	public static final List<JLabel> assistantContainers = new ArrayList<>();
	public static final List<JLabel> nourishmentContainers = new ArrayList<>();
	public static final List<JLabel> staminaContainers = new ArrayList<>();
	public static final HashMap<Integer, String> assistantsPositions = new HashMap<>(8);
	public static JLabel distributorPlaceHolder = new JLabel("     |___|");

	public static void main(String[] args) {

		if (args.length != 2){
			throw new RuntimeException();
		}
		numberOfAnimals = Integer.parseInt(args [0]);
		int numberOfAssistants = Integer.parseInt(args [1]);
		if (!((numberOfAnimals > 0 && numberOfAnimals < 9) && (numberOfAssistants > 0 && numberOfAssistants < 9))){
			throw new RuntimeException();
		}

		MyFrame frame = new MyFrame();
		EventQueue.invokeLater(() -> {
			try {
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		for (int i = 1; i < numberOfAnimals + 1; i++) {
			Animal animal = new Animal(i);
			animal.start();
		}
		for (int j = 1; j < numberOfAssistants + 1; j++) {
			Assistant assistant = new Assistant(j);
			assistant.start();
		}

	}

	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 450, 300);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(9, 5, 10, 10));


		JLabel distributorLabel = new JLabel("distributor");
		jPanel.add(distributorLabel);
		JLabel assistantLabel = new JLabel("assistant");
		jPanel.add(assistantLabel);
		JLabel nourishmentLabel = new JLabel("nourishment");
		jPanel.add(nourishmentLabel);
		JLabel staminaLabel = new JLabel(" stamina");
		jPanel.add(staminaLabel);
		JLabel whiteSpaces1 = new JLabel(" ");
		JLabel whiteSpaces2 = new JLabel(" ");
		JLabel whiteSpaces3 = new JLabel(" ");
		JLabel whiteSpaces4 = new JLabel(" ");
		JLabel whiteSpaces5 = new JLabel(" ");
		JLabel whiteSpaces6 = new JLabel(" ");
		JLabel whiteSpaces7 = new JLabel(" ");
		JLabel assistantContainer1 = new JLabel("  |____|");
		JLabel nourishmentContainer1 = new JLabel("     |____|");
		JLabel staminaContainer1 = new JLabel("     |__|");
		JLabel assistantContainer2 = new JLabel("  |____|");
		JLabel nourishmentContainer2 = new JLabel("     |____|");
		JLabel staminaContainer2 = new JLabel("     |__|");
		JLabel assistantContainer3 = new JLabel("  |____|");
		JLabel nourishmentContainer3 = new JLabel("     |____|");
		JLabel staminaContainer3 = new JLabel("     |__|");
		JLabel assistantContainer4 = new JLabel("  |____|");
		JLabel nourishmentContainer4 = new JLabel("     |____|");
		JLabel staminaContainer4 = new JLabel("     |__|");
		JLabel assistantContainer5 = new JLabel("  |____|");
		JLabel nourishmentContainer5 = new JLabel("     |____|");
		JLabel staminaContainer5 = new JLabel("     |__|");
		JLabel assistantContainer6 = new JLabel("  |____|");
		JLabel nourishmentContainer6 = new JLabel("     |____|");
		JLabel staminaContainer6 = new JLabel("     |__|");
		JLabel assistantContainer7 = new JLabel("  |____|");
		JLabel nourishmentContainer7 = new JLabel("     |____|");
		JLabel staminaContainer7 = new JLabel("     |__|");
		JLabel assistantContainer8 = new JLabel("  |____|");
		JLabel nourishmentContainer8 = new JLabel("     |____|");
		JLabel staminaContainer8 = new JLabel("     |__|");

		JLabel empty = new JLabel();
		assistantContainers.add(empty);
		assistantContainers.add(assistantContainer1);
		assistantContainers.add(assistantContainer2);
		assistantContainers.add(assistantContainer3);
		assistantContainers.add(assistantContainer4);
		assistantContainers.add(assistantContainer5);
		assistantContainers.add(assistantContainer6);
		assistantContainers.add(assistantContainer7);
		assistantContainers.add(assistantContainer8);

		nourishmentContainers.add(empty);
		nourishmentContainers.add(nourishmentContainer1);
		nourishmentContainers.add(nourishmentContainer2);
		nourishmentContainers.add(nourishmentContainer3);
		nourishmentContainers.add(nourishmentContainer4);
		nourishmentContainers.add(nourishmentContainer5);
		nourishmentContainers.add(nourishmentContainer6);
		nourishmentContainers.add(nourishmentContainer7);
		nourishmentContainers.add(nourishmentContainer8);

		staminaContainers.add(empty);
		staminaContainers.add(staminaContainer1);
		staminaContainers.add(staminaContainer2);
		staminaContainers.add(staminaContainer3);
		staminaContainers.add(staminaContainer4);
		staminaContainers.add(staminaContainer5);
		staminaContainers.add(staminaContainer6);
		staminaContainers.add(staminaContainer7);
		staminaContainers.add(staminaContainer8);

		jPanel.add(whiteSpaces1);
		jPanel.add(assistantContainer1);
		jPanel.add(nourishmentContainer1);
		jPanel.add(staminaContainer1);

		jPanel.add(whiteSpaces2);
		jPanel.add(assistantContainer2);
		jPanel.add(nourishmentContainer2);
		jPanel.add(staminaContainer2);

		jPanel.add(whiteSpaces3);
		jPanel.add(assistantContainer3);
		jPanel.add(nourishmentContainer3);
		jPanel.add(staminaContainer3);

		jPanel.add(distributorPlaceHolder);

		jPanel.add(assistantContainer4);
		jPanel.add(nourishmentContainer4);
		jPanel.add(staminaContainer4);

		jPanel.add(whiteSpaces4);
		jPanel.add(assistantContainer5);
		jPanel.add(nourishmentContainer5);
		jPanel.add(staminaContainer5);

		jPanel.add(whiteSpaces5);
		jPanel.add(assistantContainer6);
		jPanel.add(nourishmentContainer6);
		jPanel.add(staminaContainer6);

		jPanel.add(whiteSpaces6);
		jPanel.add(assistantContainer7);
		jPanel.add(nourishmentContainer7);
		jPanel.add(staminaContainer7);

		jPanel.add(whiteSpaces7);
		jPanel.add(assistantContainer8);
		jPanel.add(nourishmentContainer8);
		jPanel.add(staminaContainer8);

		contentPane.add(jPanel);

	}

}
