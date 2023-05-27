package calculatricePropre;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Bouton extends JButton implements MouseListener {

	/**
	 * ZEUK-APP
	 */

	private static final long serialVersionUID = 1L;

	private Nature nature;
	private Color couleur = Color.blue;




	public Bouton(String text, Nature nature ) {

		super(text);
		this.nature = nature;
		this.setSize(new Dimension(90,90));
		this.addMouseListener(this);


	}

	@Override
	protected void paintComponent(Graphics g) {

		if(this.getNature()==Nature.symbole) {

			Graphics2D g2d = (Graphics2D) g;
			GradientPaint gp = new GradientPaint(0,0,Color.pink,this.getWidth(),this.getHeight(),couleur,true);

			g2d.setPaint(gp);

			g2d.fillRect(0,0,this.getWidth(),this.getHeight());

			g2d.setPaint(Color.black);
			g2d.drawString(this.getText(),this.getWidth()/2, this.getHeight()/2);
		}else {
			
			Graphics2D g2d = (Graphics2D) g;
			GradientPaint gp = new GradientPaint(0,0,couleur,this.getWidth(),this.getHeight(),Color.white);
			
			g2d.setPaint(gp);

			g2d.fillRect(0,0,this.getWidth(),this.getHeight());

			g2d.setPaint(Color.black);
			g2d.drawString(this.getText(),this.getWidth()/2, this.getHeight()/2);

			
		}

	}


	public Nature getNature() {
		return nature;
	}
	public void setNature(Nature nature) {
		this.nature = nature;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		couleur = Color.BLACK;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

		if((e.getX() >0 && e.getX() < this.getWidth()) && (e.getY() >0 && e.getY() < this.getHeight() ))
			couleur = Color.cyan;
		else
			couleur = Color.blue;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		couleur = Color.cyan;
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		couleur = Color.blue;

	}



}
