import java.awt.*;

public class Digit
{
	private int digit, x, y, width, height;
	private Color darkRed;
	
	public Digit(int digit, int x, int y)
	{
		this.digit = digit;
		this.x = x;
		this.y = y;
		width = 13;
		height = 23;
		darkRed = new Color(128, 0, 0);
	}
	
	public void setDigit(int digit)
	{
		this.digit = digit;
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
		
		switch (digit)
		{
			case 0: case 2: case 3: case 5: case 6: case 7: case 8: case 9:
				g.setColor(Color.RED);
				g.drawLine(x + 2, y + 1, x + 10, y + 1);
				g.drawLine(x + 3, y + 2, x + 9, y + 2);
				g.drawLine(x + 4, y + 3, x + 8, y + 3);
				break;
			case -2: case -1: case 1: case 4:
				g.setColor(darkRed);
				g.fillRect(x + 3, y + 1, 1, 1);
				g.fillRect(x + 5, y + 1, 1, 1);
				g.fillRect(x + 7, y + 1, 1, 1);
				g.fillRect(x + 9, y + 1, 1, 1);
				g.fillRect(x + 4, y + 2, 1, 1);
				g.fillRect(x + 6, y + 2, 1, 1);
				g.fillRect(x + 8, y + 2, 1, 1);
				g.fillRect(x + 5, y + 3, 1, 1);
				g.fillRect(x + 7, y + 3, 1, 1);
				break;
		}
		switch (digit)
		{
			case -1: case 2: case 3: case 4: case 5: case 6: case 8: case 9:
				g.setColor(Color.RED);
				g.drawLine(x + 3, y + 10, x + 9, y + 10);
				g.drawLine(x + 2, y + 11, x + 10, y + 11);
				g.drawLine(x + 3, y + 12, x + 9, y + 12);
				break;
			case -2: case 0: case 1: case 7:
				g.setColor(darkRed);
				g.fillRect(x + 4, y + 10, 1, 1);
				g.fillRect(x + 6, y + 10, 1, 1);
				g.fillRect(x + 8, y + 10, 1, 1);
				g.fillRect(x + 3, y + 11, 1, 1);
				g.fillRect(x + 5, y + 11, 1, 1);
				g.fillRect(x + 7, y + 11, 1, 1);
				g.fillRect(x + 9, y + 11, 1, 1);
				g.fillRect(x + 4, y + 12, 1, 1);
				g.fillRect(x + 6, y + 12, 1, 1);
				g.fillRect(x + 8, y + 12, 1, 1);
				break;
		}
		switch (digit)
		{
			case 0: case 2: case 3: case 5: case 6: case 8: case 9:
				g.setColor(Color.RED);
				g.drawLine(x + 4, y + 19, x + 8, y + 19);
				g.drawLine(x + 3, y + 20, x + 9, y + 20);
				g.drawLine(x + 2, y + 21, x + 10, y + 21);
				break;
			case -2: case -1: case 1: case 4: case 7:
				g.setColor(darkRed);
				g.fillRect(x + 5, y + 19, 1, 1);
				g.fillRect(x + 7, y + 19, 1, 1);

				g.fillRect(x + 4, y + 20, 1, 1);
				g.fillRect(x + 6, y + 20, 1, 1);
				g.fillRect(x + 8, y + 20, 1, 1);

				g.fillRect(x + 3, y + 21, 1, 1);
				g.fillRect(x + 5, y + 21, 1, 1);
				g.fillRect(x + 7, y + 21, 1, 1);
				g.fillRect(x + 9, y + 21, 1, 1);
				break;
		}
		
		switch (digit)
		{
			case 0: case 4: case 5: case 6: case 8: case 9:
				g.setColor(Color.RED);
				g.drawLine(x + 1, y + 2, x + 1, y + 10);
				g.drawLine(x + 2, y + 3, x + 2, y + 9);
				g.drawLine(x + 3, y + 4, x + 3, y + 8);
				break;
			case -2: case -1: case 1: case 2: case 3: case 7:
				g.setColor(darkRed);
				g.fillRect(x + 1, y + 2, 1, 1);
				g.fillRect(x + 1, y + 4, 1, 1);
				g.fillRect(x + 1, y + 6, 1, 1);
				g.fillRect(x + 1, y + 8, 1, 1);
				g.fillRect(x + 1, y + 10, 1, 1);
				g.fillRect(x + 2, y + 3, 1, 1);
				g.fillRect(x + 2, y + 5, 1, 1);
				g.fillRect(x + 2, y + 7, 1, 1);
				g.fillRect(x + 2, y + 9, 1, 1);
				g.fillRect(x + 3, y + 4, 1, 1);
				g.fillRect(x + 3, y + 6, 1, 1);
				g.fillRect(x + 3, y + 8, 1, 1);
				break;
		}
		switch (digit)
		{
			case 0: case 2: case 6: case 8:
				g.setColor(Color.RED);
				g.drawLine(x + 1, y + 12, x + 1, y + 20);
				g.drawLine(x + 2, y + 13, x + 2, y + 19);
				g.drawLine(x + 3, y + 14, x + 3, y + 18);
				break;
			case -2: case -1: case 1: case 3: case 4: case 5: case 7: case 9:
				g.setColor(darkRed);
				g.fillRect(x + 1, y + 12, 1, 1);
				g.fillRect(x + 1, y + 14, 1, 1);
				g.fillRect(x + 1, y + 16, 1, 1);
				g.fillRect(x + 1, y + 18, 1, 1);
				g.fillRect(x + 1, y + 20, 1, 1);

				g.fillRect(x + 2, y + 13, 1, 1);
				g.fillRect(x + 2, y + 15, 1, 1);
				g.fillRect(x + 2, y + 17, 1, 1);
				g.fillRect(x + 2, y + 19, 1, 1);

				g.fillRect(x + 3, y + 14, 1, 1);
				g.fillRect(x + 3, y + 16, 1, 1);
				g.fillRect(x + 3, y + 18, 1, 1);
				break;
		}
		
		switch (digit)
		{
			case 0: case 1: case 2: case 3: case 4: case 7: case 8: case 9:
				g.setColor(Color.RED);
				g.drawLine(x + 11, y + 2, x + 11, y + 10);
				g.drawLine(x + 10, y + 3, x + 10, y + 9);
				g.drawLine(x + 9, y + 4, x + 9, y + 8);
				break;
			case -2: case -1: case 5: case 6:
				g.setColor(darkRed);
				g.fillRect(x + 11, y + 2, 1, 1);
				g.fillRect(x + 11, y + 4, 1, 1);
				g.fillRect(x + 11, y + 6, 1, 1);
				g.fillRect(x + 11, y + 8, 1, 1);
				g.fillRect(x + 11, y + 10, 1, 1);
				g.fillRect(x + 10, y + 3, 1, 1);
				g.fillRect(x + 10, y + 5, 1, 1);
				g.fillRect(x + 10, y + 7, 1, 1);
				g.fillRect(x + 10, y + 9, 1, 1);
				g.fillRect(x + 9, y + 4, 1, 1);
				g.fillRect(x + 9, y + 6, 1, 1);
				g.fillRect(x + 9, y + 8, 1, 1);
				break;
		}
		switch (digit)
		{
			case 0: case 1: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
				g.setColor(Color.RED);
				g.drawLine(x + 11, y + 12, x + 11, y + 20);
				g.drawLine(x + 10, y + 13, x + 10, y + 19);
				g.drawLine(x + 9, y + 14, x + 9, y + 18);
				break;
			case -2: case -1: case 2:
				g.setColor(darkRed);
				g.fillRect(x + 11, y + 12, 1, 1);
				g.fillRect(x + 11, y + 14, 1, 1);
				g.fillRect(x + 11, y + 16, 1, 1);
				g.fillRect(x + 11, y + 18, 1, 1);
				g.fillRect(x + 11, y + 20, 1, 1);

				g.fillRect(x + 10, y + 13, 1, 1);
				g.fillRect(x + 10, y + 15, 1, 1);
				g.fillRect(x + 10, y + 17, 1, 1);
				g.fillRect(x + 10, y + 19, 1, 1);

				g.fillRect(x + 9, y + 14, 1, 1);
				g.fillRect(x + 9, y + 16, 1, 1);
				g.fillRect(x + 9, y + 18, 1, 1);
				break;
		}
	}
}