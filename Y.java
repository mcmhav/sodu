package z;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.util.*;

public class Y extends JApplet {
	
	private JTextField in;
	private JTextField out;
	private JTextField sc;
	private JTextField info;
	private JTextField ratio;
	private JTextField miss;
	private JTextField hit;
	private JTextField pr;
	private JTextField st;
	
	double t;
	double tot;
	int c;
	double mc;
	double hc;
	
	private String ty = "";
	
	Timer time;
	
	public Y(){
		JPanel p = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		in = new JTextField("");
		in.setPreferredSize(new Dimension(100,26));
		out = new JTextField("");
		sc = new JTextField("");
		info = new JTextField("");
		ratio = new JTextField("");
		ratio.setPreferredSize(new Dimension(200,26));
		miss = new JTextField("");
		hit = new JTextField("");
		pr = new JTextField("");
		pr.setPreferredSize(new Dimension(200,26));
		st = new JTextField("");
		st.setPreferredSize(new Dimension(200,26));

		
		out.setEditable(false);
		in.addActionListener(new AL());
		in.addKeyListener(new KL());
		sc.setEditable(false);
		info.setEditable(false);
		ratio.setEditable(false);
		miss.setEditable(false);
		hit.setEditable(false);
		pr.setEditable(false);
		st.setEditable(false);
		
		t = 1;
		
		time = new Timer(1, new TL());
		
		
		c.gridx = 0;
		c.gridy = 0;
		c.fill = 1;
		p.add(in,c);
		c.gridx = 1;
		c.gridy = 0;
		p.add(out,c);
		c.gridx = 0;
		c.gridy = 1;
		p.add(info,c);
		c.gridx = 1;
		c.gridy = 1;
		p.add(sc,c);
		c.gridx = 0;
		c.gridy = 2;
		p.add(hit,c);
		c.gridx = 1;
		c.gridy = 2;
		p.add(miss,c);
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		p.add(ratio,c);
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
		p.add(pr,c);
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 2;
		p.add(st,c);
		
		add(p);
	}
	
	public void setCurrentTime() {
		t++;
	}
	
	private class TL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setCurrentTime();
			repaint();
		}
	}
	
	private class KL implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			if(out.getText().equals("")){
				for(int i = 0; i < 7; i++){
					int e  = (int) (Math.random()*26+97);
					char ch = Character.toChars(e)[0];
					ty += ch + " ";
				}
				out.setText(ty);
				time.start();
			}else{
				if(in.getText().charAt(0) == (out.getText().charAt(0))){
					int e  = (int) (Math.random()*26+97);
					char ch = Character.toChars(e)[0];
					ty += ch + " ";
					ty = ty.substring(2);
					clear();
					info.setText("Hit");
					info.setBackground(Color.GREEN);
					sc.setText(""+getTime());
					time.stop();
					tot += t;
					t=0;
					time.restart();
					out.setText(ty);
					hc++;
				}else{
					in.setText("");
					info.setText("Miss");
					info.setBackground(Color.RED);
					mc++;
				}
				c++;
				double r = hc/mc;
				hit.setText(hc+"");
				miss.setText(mc+"");
				ratio.setText(r+"");
				pr.setText(""+hc/c);
				st.setText(tot/hc+"");
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
	}
	
	private class AL implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
	
	private void clear(){
		in.setText("");
		sc.setText("");
		info.setText("");
	}
	
	private String getTime(){
		return t+"";
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		Y y = new Y();
		f.add(y);
		f.setAlwaysOnTop(true);
		f.setVisible(true);
		f.setSize(200, 165);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
