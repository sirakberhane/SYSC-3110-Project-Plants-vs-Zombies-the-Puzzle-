package run;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CreateAction implements MouseListener {
	//Reference to the GameGUI
	private GameGUI game;
	private ArrayList<Integer> waveSizes;
	private WriteFile writeFile;

	//Create a new PeashooterSelectController with the reference to the GameGUI
	public CreateAction(GameGUI game) {
		this.game = game;
		waveSizes = new ArrayList<Integer>();
		writeFile = new WriteFile();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int numWaves = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of waves"));
		
		int i = 0;
		while (i < numWaves) {
			int numZombies = Integer.parseInt(JOptionPane.showInputDialog(
					"Enter the number of zombies for Wave " + (i + 1)));
			i ++;
			waveSizes.add(numZombies);
		}
		
		String levelName = JOptionPane.showInputDialog("Enter the name of the level: ");
		
		writeFile.writeXmlFile(waveSizes, levelName);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}