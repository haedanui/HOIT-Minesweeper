import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MinesweeperPanel extends JPanel implements MouseListener {
	private int countX, countY, fieldsLeft;
	private Field[][] fields;
	private Difficulty difficulty;
	private Random random;
	private boolean gameOver;
	private Minesweeper minesweeper;
	public JFrame f;

	public MinesweeperPanel(Minesweeper minesweeper, Difficulty difficulty) {
		super();
		this.setBackground(Color.LIGHT_GRAY);
		addMouseListener(this);
		this.minesweeper = minesweeper;
		this.difficulty = difficulty;
		random = new Random();
		setFields();
	}

	public void setMinesweeper(Difficulty difficulty) {
		this.difficulty = difficulty;
		gameOver = false;
		setFields();
		repaint();
	}

	private void setFields() {
		int mines = 0;

		switch (difficulty) {
			case Easy:
				countX = countY = 9;
				mines = 10;
				break;
			case Normal:
				countX = countY = 16;
				mines = 40;
				break;
			case Hard:
				countX = 30;
				countY = 16;
				mines = 99;
				break;
		}
		fieldsLeft = countX * countY - mines;

		setPreferredSize(new Dimension(countX * 16, countY * 16));

		fields = new Field[countY][countX];
		for (int y = 0; y < countY; y++) {
			for (int x = 0; x < countX; x++)
				fields[y][x] = new Field(x, y);
		}

		Set<Integer> minePositions = new HashSet<Integer>();
		while (minePositions.size() < mines)
			minePositions.add(random.nextInt(countX * countY));
		Iterator<Integer> i = minePositions.iterator();
		while (i.hasNext()) {
			int minePosition = i.next();
			int y = minePosition / countX;
			int x = minePosition % countX;
			fields[y][x].setMine(true);
			for (int yy = y > 0 ? y - 1 : y; yy <= (y < countY - 1 ? y + 1 : y); yy++) {
				for (int xx = x > 0 ? x - 1 : x; xx <= (x < countX - 1 ? x + 1 : x); xx++)
					fields[yy][xx].incrementNeighbourMines();
			}
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		for (int y = 0; y < fields.length; y++) {
			for (int x = 0; x < fields[y].length; x++)
				fields[y][x].paint(g);
		}
	}

	private void setGameOver() {
		gameOver = true;
		for (int y = 0; y < countY; y++) {
			for (int x = 0; x < countX; x++)
				fields[y][x].setGameOver();
		}
	}

	private void setWon() {
		gameOver = true;
		minesweeper.setMines(0, true);

		for (int y = 0; y < countY; y++) {
			for (int x = 0; x < countX; x++)
				fields[y][x].setWon();
		}
		f = new JFrame();
		f.setTitle("이겼습니다");
		JLabel g = new JLabel("이겼습니다.");
		f.setLocation(900, 340);
		f.add(g);
		f.pack();
		f.setVisible(true);
	}

	private void performFieldClick(int x, int y) {
		if (fields[y][x].isClicked())
			return;
		if (!fields[y][x].setClicked()) {
			setGameOver();
			return;
		}
		fieldsLeft--;
		if (fields[y][x].getNeighbourMines() == 0) {
			for (int yy = y > 0 ? y - 1 : y; yy <= (y < countY - 1 ? y + 1 : y); yy++) {
				for (int xx = x > 0 ? x - 1 : x; xx <= (x < countX - 1 ? x + 1 : x); xx++)
					performFieldClick(xx, yy);
			}
		}
	}

	private void performFieldClickFlagged(int x, int y) {
		for (int yy = y > 0 ? y - 1 : y; yy <= (y < countY - 1 ? y + 1 : y); yy++) {
			for (int xx = x > 0 ? x - 1 : x; xx <= (x < countX - 1 ? x + 1 : x); xx++) {
				if (fields[yy][xx].getNeighbourMines() == 0)
					performFieldClick(xx, yy);

				if (fields[yy][xx].isClicked() || fields[yy][xx].isFlag())
					continue;

				if (!fields[yy][xx].setClicked()) {
					setGameOver();
					return;
				}

				fieldsLeft--;
			}
		}
	}

	private boolean isNeighbourMinesFlagged(int x, int y) {
		if (fields[y][x].getNeighbourMines() == 0)
			return false;

		int flags = 0;
		for (int yy = y > 0 ? y - 1 : y; yy <= (y < countY - 1 ? y + 1 : y); yy++) {
			for (int xx = x > 0 ? x - 1 : x; xx <= (x < countX - 1 ? x + 1 : x); xx++) {
				if (fields[yy][xx].isFlag())
					flags++;
			}
		}
		return flags == fields[y][x].getNeighbourMines();
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX() / 16;
		int y = e.getY() / 16;

		if (gameOver || x > fields[0].length - 1 || y > fields.length - 1)
			return;

		if (e.getButton() == MouseEvent.BUTTON1) {
			if (fields[y][x].isClicked() && isNeighbourMinesFlagged(x, y))
				performFieldClickFlagged(x, y);
			else
				performFieldClick(x, y);

			if (fieldsLeft == 0)
				setWon();
		} else
			minesweeper.setMines(fields[y][x].setFlag());
		repaint();
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}
}