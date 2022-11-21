import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Minesweeper extends JFrame implements ActionListener
{
	private ControlPanel controlPanel;
	private MinesweeperPanel minesweeperPanel;
	private JCheckBoxMenuItem miBeginner, miIntermediate, miExpert;
	private Difficulty difficulty;
	
	public Minesweeper()
	{
		super("지뢰찾기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		difficulty = Difficulty.Easy;
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("파일");
		JMenuItem menuItem = new JMenuItem("새 게임");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menu.addSeparator();
		miBeginner = new JCheckBoxMenuItem("초급", true);
		miBeginner.addActionListener(this);
		menu.add(miBeginner);
		miIntermediate = new JCheckBoxMenuItem("중급");
		miIntermediate.addActionListener(this);
		menu.add(miIntermediate);
		miExpert = new JCheckBoxMenuItem("고급");
		miExpert.addActionListener(this);
		menu.add(miExpert);
		menu.addSeparator();
		menuItem = new JMenuItem("종료");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuBar.add(menu);
		setJMenuBar(menuBar);
		
		controlPanel = new ControlPanel(this, Difficulty.Easy);
		add(controlPanel, BorderLayout.NORTH);
		
		minesweeperPanel = new MinesweeperPanel(this, Difficulty.Easy);
		add(minesweeperPanel, BorderLayout.CENTER);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void setMines(int value)
	{
		setMines(value, false);
	}
	
	public void setMines(int value, boolean real)
	{
		controlPanel.setMines(value, real);
	}
	
	public void setMainMenuDifficulty()
	{
		miBeginner.setSelected(difficulty == Difficulty.Easy);
		miIntermediate.setSelected(difficulty == Difficulty.Normal);
		miExpert.setSelected(difficulty == Difficulty.Hard);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("새 게임"))
		{
			controlPanel.setMinesweeper(difficulty);
			minesweeperPanel.setMinesweeper(difficulty);
		}
		else if(e.getActionCommand().equals("초급")){
			difficulty =Difficulty.Easy;
			setMainMenuDifficulty();
			controlPanel.setMinesweeper(difficulty);
			minesweeperPanel.setMinesweeper(difficulty);
			pack();
		}
		else if (e.getActionCommand().equals("중급")) {
			difficulty = Difficulty.Normal;
			setMainMenuDifficulty();
			controlPanel.setMinesweeper(difficulty);
			minesweeperPanel.setMinesweeper(difficulty);
			pack();
		}
		else if (e.getActionCommand().equals("고급")) {
			difficulty = Difficulty.Hard;
			setMainMenuDifficulty();
			controlPanel.setMinesweeper(difficulty);
			minesweeperPanel.setMinesweeper(difficulty);
			pack();
		}
		else
			System.exit(0);
	}
	
	public static void main(String[] args)
	{
		new Minesweeper();
	}
}