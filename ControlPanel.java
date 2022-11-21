import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ControlPanel extends JPanel implements ActionListener
{
	private Minesweeper minesweeper;
	private Display mineDisplay;
	private long begin;
	
	public ControlPanel(Minesweeper minesweeper, Difficulty difficulty)
	{
		super(new BorderLayout());
		setBackground(Color.LIGHT_GRAY);
		this.minesweeper = minesweeper;
		
		if(difficulty == Difficulty.Easy){
			mineDisplay = new Display(10);
		}
		else if (difficulty == Difficulty.Normal) {
			mineDisplay = new Display(40);
		}
		else if (difficulty == Difficulty.Hard) {
			mineDisplay = new Display(99);
		}
		add(mineDisplay, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		JButton btnNew = new JButton("새 게임");
		btnNew.setFocusable(false);
		btnNew.addActionListener(this);
		panel.add(btnNew);
		add(panel, BorderLayout.CENTER);
		
		
		begin = -1;
	}
	
	public void setMinesweeper(Difficulty difficulty)
	{
		mineDisplay.setValue(difficulty == Difficulty.Easy ? 10 : difficulty == Difficulty.Normal ? 40 : 99);
		begin = -1;
		repaint();
	}
	
	public void setMines(int value, boolean real)
	{
		if (real)
			mineDisplay.setValue(value);
		else
			mineDisplay.setValue(mineDisplay.getValue() + value);
		mineDisplay.repaint();
	}
	
	public void startTime()
	{
		if (begin != -1)
			return;
		begin = new Date().getTime();
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand() != null && e.getActionCommand().equals("새 게임"))
			minesweeper.actionPerformed(e);
	}
}