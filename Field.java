import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Field
{
	private int x, y, neighbourMines;
	private boolean clicked, mine, flag, mineClicked;
	private Color color1, color2, color3, color4, color5, color6, color7, color8;
	
	public Field(int x, int y)
	{
		this.x = x;
		this.y = y;
		neighbourMines = 0;
		color1 = new Color(0, 0, 255);
		color2 = new Color(0, 128, 0);
		color3 = new Color(255, 0, 0);
		color4 = new Color(0, 0, 128);
		color5 = new Color(128, 0, 0);
		color6 = new Color(0, 128, 128);
		color7 = new Color(0, 0, 0);
		color8 = new Color(128, 128, 128);
		flag = mineClicked = false;
	}
	
	public boolean setClicked()
	{
		if (!flag)
		{
			clicked = true;
			mineClicked = mine;
			return !mine;
		}
		return true;
	}
	
	public boolean isClicked()
	{
		return clicked;
	}
	
	public void setMine(boolean mine)
	{
		this.mine = mine;
	}
	
	public void incrementNeighbourMines()
	{
		neighbourMines++;
	}
	
	public int getNeighbourMines()
	{
		return neighbourMines;
	}
	
	public int setFlag()
	{
		if (clicked)
			return 0;
		flag = !flag;
		return flag ? -1 : 1;
	}
	
	public boolean isFlag()
	{
		return flag;
	}
	
	public void setGameOver()
	{
		if (mine && !flag || !mine && flag)
			clicked = true;
	}
	
	public void setWon()
	{
		if (mine)
			flag = true;
	}
	
	public void paint(Graphics g)
	{
		Color back = mineClicked ? Color.RED : Color.lightGray;
		g.setColor(back);
		g.fillRect(x * 16, y * 16, 16, 16);
		
		if (clicked)
		{
			g.setColor(Color.GRAY);
			g.fillRect(x * 16, y * 16, 16, 1);
			g.fillRect(x * 16, y * 16 + 1, 1, 15);
			
			if (mine || !mine && flag)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x * 16 + 4, y * 16 + 4, 9, 9);
				g.fillRect(x * 16 + 2, y * 16 + 8, 13, 1);
				g.fillRect(x * 16 + 8, y * 16 + 2, 1, 13);

				g.setColor(Color.WHITE);
				g.fillRect(x * 16 + 6, y * 16 + 6, 2, 2);
				
				if (!mine && flag)
				{
					g.setColor(Color.green);
					g.fillRect(x * 16 + 1, y * 16 + 1, 15, 15);
					g.setColor(Color.RED);
					g.drawLine(x * 16 + 2, y * 16 + 2, x * 16 + 14, y * 16 + 14);
					g.drawLine(x * 16 + 2, y * 16 + 14, x * 16 + 14, y * 16 + 2);
				}
				
				return;
			}
			
			switch (neighbourMines)
			{
				case 1:
					g.setFont(new Font("굴림", Font.BOLD, 14));
					g.setColor(color1);
					g.drawString("1", x*16+5, y*16+13);
					break;
				case 2:
					g.setColor(color2);
					g.drawString("2", x * 16 + 5, y * 16 + 13);
					break;
				case 3:
					g.setColor(color3);
					g.drawString("3", x * 16 + 5, y * 16 + 13);
					break;
				case 4:
					g.setColor(color4);
					g.drawString("4", x * 16 + 5, y * 16 + 13);
					break;
				case 5:
					g.setColor(color5);
					g.drawString("5", x * 16 + 5, y * 16 + 13);
					break;
				case 6:
					g.setColor(color6);
					g.drawString("6", x * 16 + 5, y * 16 + 13);
					break;
				case 7:
					g.setColor(color7);
					g.drawString("7", x * 16 + 5, y * 16 + 13);
					break;
				case 8:
					g.setColor(color8);
					g.drawString("8", x * 16 + 5, y * 16 + 13);
					break;
			}
		}
		else
		{
			g.setColor(Color.WHITE);
			g.fillRect(x * 16, y * 16, 16, 1);
			//g.fillRect(x * 16, y * 16 + 1, 14, 1);
			g.fillRect(x * 16, y * 16, 1, 16);
			// g.fillRect(x * 16 + 1, y * 16 + 2, 1, 12);
			g.setColor(Color.GRAY);
			//g.fillRect(x * 16 + 2, y * 16 + 14, 14, 1);
			//g.fillRect(x * 16 + 1, y * 16 + 15, 15, 1);
			//g.fillRect(x * 16 + 14, y * 16 + 2, 1, 12);
			//g.fillRect(x * 16 + 15, y * 16 + 1, 1, 13);
			
			if (flag)
			{
				g.setColor(Color.green);
				g.fillRect(x * 16+1, y * 16+1, 14, 14);

			}
		}
	}
}