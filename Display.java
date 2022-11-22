import java.awt.*;
import javax.swing.*;

public class Display extends JPanel {
	private static final long serialVersionUID = 1L;
	private Digit digit0, digit1, digit2;
	private int value;

	public Display(int value) {
		setPreferredSize(new Dimension(53, 37));
		setBackground(Color.lightGray);
		this.value = value;
		digit0 = new Digit(0, 7, 7);
		digit1 = new Digit(0, 20, 7);
		digit2 = new Digit(0, 33, 7);
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void paint(Graphics g) {
		super.paint(g);

		digit0.setDigit(0);
		digit1.setDigit(0);
		digit2.setDigit(0);

		int temp = value;
		if (temp >= 0) {
			if (temp / 100 > 0) {
				digit0.setDigit(temp / 100);
				temp %= 100;
			}
			if (temp / 10 > 0) {
				digit1.setDigit(temp / 10);
				temp %= 10;
			}
			digit2.setDigit(temp);
		} else {
			temp = -temp % 100;
			if (temp / 10 > 0) {
				digit0.setDigit(-1);
				digit1.setDigit(temp / 10);
				temp %= 10;
			} else {
				digit0.setDigit(-2);
				digit1.setDigit(-1);
			}
			digit2.setDigit(temp);
		}

		digit0.paint(g);
		digit1.paint(g);
		digit2.paint(g);
	}
}