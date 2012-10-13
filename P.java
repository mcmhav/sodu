package z;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.CellEditor;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

public class P extends JApplet {

	private JTextField[][] b = new JTextField[9][9];
	private JTextField[][] u = new JTextField[9][9];
	private JTextField found = new JTextField();
	private JTextField miss = new JTextField();
	private JTextField count = new JTextField();

	private JTextField h1 = new JTextField(1);
	private JTextField h2 = new JTextField(1);
	private JTextField h3 = new JTextField(1);
	private JTextField info = new JTextField();

	private JButton comp = new JButton("Compute");
	private JButton next = new JButton("->");
	private JButton reset = new JButton("Reset");

	// M m = new M();

	public P() {
		JPanel p = new JPanel(new GridLayout(1, 2));
		JPanel p1 = new JPanel(new GridLayout(9, 9));
		JPanel p2 = new JPanel(new GridLayout(9, 9));
		JPanel p3 = new JPanel(new GridLayout(1, 6));
		JPanel p4 = new JPanel(new GridLayout(1, 4));
		JPanel p5 = new JPanel(new GridLayout(1, 2));
		JPanel p6 = new JPanel(new GridLayout(1, 6));
		JPanel p7 = new JPanel(new GridLayout(2, 1));
		JPanel p8 = new JPanel(new GridLayout(2, 1));
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				b[i][j] = new JTextField();
				b[i][j]
						.setToolTipText("Sudokunumbers to be Solved, Enter Number Here");
				b[i][j].setHorizontalAlignment(JTextField.CENTER);
				p1.add(b[i][j]);
				if ((j <= 2 && (i <= 2 || i >= 6))
						|| (j >= 3 && j <= 5 && i >= 3 && i <= 5)
						|| (j >= 6 && (i <= 2 || i >= 6))) {
					b[i][j].setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
				} else {
					b[i][j].setBorder(new LineBorder(Color.gray, 3));
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				u[i][j] = new JTextField();
				u[i][j].setHorizontalAlignment(JTextField.CENTER);
				u[i][j].setEditable(false);
				p2.add(u[i][j]);
				u[i][j].setToolTipText("Solved Sudoku");
				if ((j <= 2 && (i <= 2 || i >= 6))
						|| (j >= 3 && j <= 5 && i >= 3 && i <= 5)
						|| (j >= 6 && (i <= 2 || i >= 6))) {
					u[i][j].setBorder(new LineBorder(Color.lightGray, 3));
				} else {
					u[i][j].setBorder(new LineBorder(Color.gray, 3));
				}
			}
		}
		p.setBorder(new TitledBorder("Sudoku Solver"));
		p.add(p1);
		p.add(p2);
		p3.add(new JLabel("Found: "));
		p3.add(found);
		p3.add(new JLabel("Missing: "));
		p3.add(miss);
		p3.add(new JLabel("Count: "));
		p3.add(count);

		p6.add(new JLabel("Hard"));
		p6.add(h1);
		p6.add(new JLabel("Harder"));
		p6.add(h2);
		p6.add(new JLabel("Super!"));
		p6.add(h3);

		h1.setToolTipText("Hardness");
		h2.setToolTipText("Hardness");
		h3.setToolTipText("Hardness");

		p7.add(p6);
		p7.add(p3);

		h1.setEditable(false);
		h2.setEditable(false);
		h3.setEditable(false);
		found.setEditable(false);
		found.setToolTipText("Found Element(s)");
		found.setHorizontalAlignment(JTextField.CENTER);
		miss.setEditable(false);
		miss.setToolTipText("Missing Element(s)");
		miss.setHorizontalAlignment(JTextField.CENTER);
		count.setEditable(false);
		count.setToolTipText("Iterations");
		count.setHorizontalAlignment(JTextField.CENTER);
		info.setEditable(false);
		info.setToolTipText("Info");
		info.setText("The Hamsters Are Waiting!");

		h1.setBackground(Color.LIGHT_GRAY);
		h2.setBackground(Color.LIGHT_GRAY);
		h3.setBackground(Color.LIGHT_GRAY);

		comp.setToolTipText("Solve Sudoku!");
		next.setToolTipText("Solve Sudoku Step By Step");
		reset.setToolTipText("Reset SudokuBoard");
		p1.setToolTipText("Sudokuboard to be Solved");
		p2.setToolTipText("Solved Sudoku");

		p4.add(comp);
		p4.add(next);
		p4.add(reset);

		p8.add(info);
		p8.add(p4);

		add(p8, BorderLayout.EAST);
		add(p7, BorderLayout.WEST);

		p5.add(p7);
		p5.add(p8);
		add(p, BorderLayout.CENTER);
		add(p5, BorderLayout.SOUTH);
		comp.addActionListener(new BL(1));
		next.addActionListener(new BL(2));
		reset.addActionListener(new BR());
		// m.stop();
	}

	private class BL implements ActionListener {
		int[][] r = new int[9][9];
		boolean y = false;
		int g = 0;
		int[][] e16 = { { 2, 0, 0, 0, 0, 6, 0, 0, 0 },
				{ 0, 0, 0, 0, 9, 0, 0, 0, 2 }, { 0, 0, 0, 4, 8, 0, 9, 0, 1 },
				{ 1, 2, 0, 0, 0, 7, 0, 5, 0 }, { 0, 0, 5, 0, 0, 0, 7, 0, 0 },
				{ 0, 3, 0, 2, 0, 0, 0, 1, 9 }, { 5, 0, 2, 0, 7, 3, 0, 0, 0 },
				{ 6, 0, 0, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 8, 0, 0, 0, 0, 4 } };

		public BL(int a) {
			if (a == 1) {
				g = a;
				y = false;
			} else if (a == 2) {
				y = true;
				g = a;
			} else if (a == 9) {
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						b[i][j].setText("" + e16[i][j]);
					}
				}
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			boolean ur = true;
			if (g == 1) {
				y = false;
				info.setText("The Hamseters Are Thinking");
				int op = JOptionPane.showConfirmDialog(null, "Sure!?", "!!", 2);
				h1.setBackground(Color.LIGHT_GRAY);
				h2.setBackground(Color.LIGHT_GRAY);
				h3.setBackground(Color.LIGHT_GRAY);
				if (op == 2) {
					ur = false;
					info.setText("The Hamsters Are Waiting!");
				}
			} else if (g == 2) {
				y = true;
				h1.setBackground(Color.LIGHT_GRAY);
				h2.setBackground(Color.LIGHT_GRAY);
				h3.setBackground(Color.LIGHT_GRAY);
				// m.stop();
			}
			if (ur) {
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						if (b[i][j].getText().equals("")
								|| b[i][j].getText().length() > 1) {
							b[i][j].setText("0");
						} else if (b[i][j].getText().matches("[^1-9]")) {
							b[i][j].setText("0");
						}
						r[i][j] = Integer.parseInt(b[i][j].getText());
						if (!b[i][j].getText().equals("" + 0)) {
							b[i][j].setBackground(Color.yellow);
						}
					}
				}
			}
			A t = new A(r);
			while (ur && t.r4()) {
				t.r1();
				int option = 1;
				if (!t.geta6() && !t.geta7()) {
					h1.setBackground(Color.green);
					info.setText("Simple Algorithm");
				} else if (!t.geta6() && t.geta7()) {
					h1.setBackground(Color.yellow);
					h2.setBackground(Color.green);
					info.setText("Tougher Algorithm");
				} else if (t.geta6() && t.geta7()) {
					h1.setBackground(Color.red);
					h2.setBackground(Color.yellow);
					h3.setBackground(Color.green);
					info.setText("Über Algorithm");
				}
				while (y && option != JOptionPane.YES_NO_OPTION) {
					option = JOptionPane.showConfirmDialog(null, "Continue!?",
							"!!", 2);
					if (option == 2) {
						y = false;
					}
					for (int i = 0; i < 9; i++) {
						for (int j = 0; j < 9; j++) {
							if (b[i][j].getText().equals("" + r[i][j])
									&& r[i][j] != 0) {
								u[i][j].setText("" + t.getb(i, j));
								u[i][j].setBackground(Color.yellow);
							} else if ((!u[i][j].getText().equals(
									"" + t.getb(i, j)))
									&& t.getb(i, j) != 0) {
								u[i][j].setText("" + t.getb(i, j));
								u[i][j].setBackground(Color.green);
							} else if (t.getb(i, j) != 0) {
								u[i][j].setText("" + t.getb(i, j));
								u[i][j].setBackground(Color.white);
							} else if (t.getb(i, j) == 0) {
								u[i][j].setBackground(Color.black);
							}
						}
					}
					found.setText("" + t.getf());
					miss.setText("" + t.getm());
					count.setText("" + t.getc());
				}
				t.r2();
				int option2 = 1;
				while (y && option2 != JOptionPane.YES_NO_OPTION) {
					option2 = JOptionPane.showConfirmDialog(null, "Continue!?",
							"!!", 2);
					if (option2 == 2) {
						y = false;
					}
					for (int i = 0; i < 9; i++) {
						for (int j = 0; j < 9; j++) {
							if (b[i][j].getText().equals("" + r[i][j])
									&& r[i][j] != 0) {
								u[i][j].setText("" + t.getb(i, j));
								u[i][j].setBackground(Color.yellow);
							} else if ((!u[i][j].getText().equals(
									"" + t.getb(i, j)))
									&& t.getb(i, j) != 0) {
								u[i][j].setText("" + t.getb(i, j));
								u[i][j].setBackground(Color.green);
							} else if (t.getb(i, j) != 0) {
								u[i][j].setText("" + t.getb(i, j));
								u[i][j].setBackground(Color.white);
							} else if (t.getb(i, j) == 0) {
								u[i][j].setBackground(Color.black);
							}
						}
					}
					found.setText("" + t.getf());
					miss.setText("" + t.getm());
					count.setText("" + t.getc());
				}
				t.r3();
				t.r5();
			}
			y = true;
			if (t.getm() == 0 && ur) {
				// m.start();
				info.setText("Solved");
			}
			if (t.getm() != 0 && ur) {
				if (t.getm() < 15) {
					info.setText("Check your input?");
				} else {
					info.setText("Too Special Board!");
				}
				h1.setBackground(Color.red);
				h2.setBackground(Color.red);
				h3.setBackground(Color.red);
			}
			if (ur) {
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						u[i][j].setText("" + t.getb(i, j));
						if (b[i][j].getText().equals("" + r[i][j])
								&& r[i][j] != 0) {
							u[i][j].setBackground(Color.yellow);
						} else {
							u[i][j].setBackground(Color.white);
						}
						b[i][j].setBackground(Color.white);
					}
				}
				found.setText("" + t.getf());
				miss.setText("" + t.getm());
				count.setText("" + t.getc());
			}
		}
	}

	private class BR implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					b[i][j].setText("");
					u[i][j].setText("");
					b[i][j].setBackground(Color.white);
					u[i][j].setBackground(new Color(15658734));
				}
			}
			found.setText("");
			miss.setText("");
			count.setText("");
			h1.setBackground(Color.LIGHT_GRAY);
			h2.setBackground(Color.LIGHT_GRAY);
			h3.setBackground(Color.LIGHT_GRAY);
			// m.stop();
			info.setText("The Hamsters Are Waiting!");
		}

	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		P p = new P();
		f.add(p);
		f.setSize(800, 480);
		f.setVisible(true);
		// f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
