package calculatricePropre;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fenetre extends JFrame {

	private JTextField saisie = new JTextField("");
	private JLabel resultat = new JLabel("EMPTY");

	private JPanel panelSortie = new JPanel(new FlowLayout());
	private JPanel panelSud = new JPanel(new FlowLayout());

	private JPanel panel = new JPanel(new BorderLayout());
	private JPanel panelNombre = new JPanel(new GridLayout(5, 3));

	private Bouton bouton1 = new Bouton("1", Nature.symbole);
	private Bouton bouton2 = new Bouton("2", Nature.symbole);
	private Bouton bouton3 = new Bouton("3", Nature.symbole);
	private Bouton bouton4 = new Bouton("4", Nature.symbole);
	private Bouton bouton5 = new Bouton("5", Nature.symbole);
	private Bouton bouton6 = new Bouton("6", Nature.symbole);
	private Bouton bouton7 = new Bouton("7", Nature.symbole);
	private Bouton bouton8 = new Bouton("8", Nature.symbole);
	private Bouton bouton9 = new Bouton("9", Nature.symbole);
	private Bouton bouton0 = new Bouton("0", Nature.symbole);
	private Bouton boutonpar1 = new Bouton("(", Nature.symbole);
	private Bouton boutonpar2 = new Bouton(")", Nature.symbole);
	private Bouton boutonClear = new Bouton("clear", Nature.symbole);
	private Bouton boutonAns = new Bouton("Ans", Nature.symbole);
	private Bouton boutonPoint = new Bouton(".", Nature.symbole);

	private JPanel panelOperateur = new JPanel(new GridLayout(9, 1));

	private Bouton op1 = new Bouton("+", Nature.operateur);
	private Bouton op2 = new Bouton("-", Nature.operateur);
	private Bouton op3 = new Bouton("*", Nature.operateur);
	private Bouton op4 = new Bouton("/", Nature.operateur);
	private Bouton op5 = new Bouton("^", Nature.operateur);
	private Bouton op6 = new Bouton("=", Nature.operateur);

	public Fenetre(String title) {
		super(title);

		this.setLayout(new BorderLayout());

		panelNombre.add(bouton1);
		panelNombre.add(bouton2);
		panelNombre.add(bouton3);
		panelNombre.add(bouton4);
		panelNombre.add(bouton5);
		panelNombre.add(bouton6);
		panelNombre.add(bouton7);
		panelNombre.add(bouton8);
		panelNombre.add(bouton9);
		panelNombre.add(bouton0);
		panelNombre.add(boutonPoint);
		panelNombre.add(boutonClear);
		panelNombre.add(boutonpar1);
		panelNombre.add(boutonpar2);
		panelNombre.add(boutonAns);

		bouton1.addActionListener((event) -> ActionClickEventListener(event));
		bouton2.addActionListener(((event) -> ActionClickEventListener(event)));
		bouton3.addActionListener(((event) -> ActionClickEventListener(event)));
		bouton4.addActionListener(((event) -> ActionClickEventListener(event)));
		bouton5.addActionListener(((event) -> ActionClickEventListener(event)));
		bouton6.addActionListener(((event) -> ActionClickEventListener(event)));
		bouton7.addActionListener(((event) -> ActionClickEventListener(event)));
		bouton8.addActionListener(((event) -> ActionClickEventListener(event)));
		bouton9.addActionListener(((event) -> ActionClickEventListener(event)));
		bouton0.addActionListener(((event) -> ActionClickEventListener(event)));
		boutonPoint.addActionListener(((event) -> ActionClickEventListener(event)));
		boutonpar1.addActionListener(((event) -> ActionClickEventListener(event)));
		boutonpar2.addActionListener(((event) -> ActionClickEventListener(event)));
		boutonClear.addActionListener(((event) -> ActionClearEventListener(event)));

		boutonpar1.setEnabled(false);
		boutonpar2.setEnabled(false);
		boutonAns.setEnabled(false);

		panelOperateur.add(op1);
		panelOperateur.add(op2);
		panelOperateur.add(op3);
		panelOperateur.add(op4);
		panelOperateur.add(op5);
		panelOperateur.add(op6);

		op1.addActionListener((event) -> ActionClickEventListener(event));
		op2.addActionListener((event) -> ActionClickEventListener(event));
		op3.addActionListener((event) -> ActionClickEventListener(event));
		op4.addActionListener((event) -> ActionClickEventListener(event));
		op5.addActionListener((event) -> ActionClickEventListener(event));
		op6.addActionListener((event) -> ActionEgalEventListener(event));

		saisie.setPreferredSize(new Dimension(350, 50));
		saisie.addKeyListener(new ClavierListener());
		panelSortie.add(saisie);
		panelSortie.add(resultat);
		panelSud.add(new JLabel("Calculatrice pro-Max-11"));

		panelOperateur.setPreferredSize(new Dimension(100, 0));
		panel.add(panelOperateur, BorderLayout.WEST);
		panel.add(panelNombre, BorderLayout.CENTER);
		panelSortie.setPreferredSize(new Dimension(0, 100));
		panel.add(panelSortie, BorderLayout.NORTH);
		panel.add(panelSud, BorderLayout.SOUTH);

		this.setContentPane(panel);
		this.setUndecorated(true);
		this.setOpacity(0.9f);

		this.setVisible(true);
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void ActionClearEventListener(ActionEvent event) {
		this.saisie.setText("");
	}

	public void ActionClickEventListener(ActionEvent e) {
		String nouvelSaisie = this.saisie.getText() + ((Bouton) e.getSource()).getText();
		System.out.print(((Bouton) e.getSource()).getText());
		this.saisie.setText(nouvelSaisie);

	}

	public void ActionEgalEventListener(ActionEvent e) {

		String expression = "0" + this.saisie.getText();
		char[] tab = new char[expression.length()];
		char[] op = new char[2 * expression.length()];
		String nbre = "", cop = "";

		ArrayList<Double> listeDouble = new ArrayList<Double>();
		ArrayList<String> listeOp = new ArrayList<String>();

		int j = 0;
		int k = 0;

		System.out.println(" = " + this.saisie.getText());
		this.resultat.setText("resultat du calcul");

		for (int i = 0; i < expression.length(); i++) {

			tab[j] = expression.charAt(i);
			j++;

		}

		for (int i = 0; i < tab.length; i++) {

			if (tab[i] == '+' || tab[i] == '-' || tab[i] == '*' || tab[i] == '/' || tab[i] == '^') {

				op[k] = tab[i];
				op[k + 1] = ',';
				k = k + 2;
				tab[i] = ',';

			}
		}

		for (char c : tab) {
			nbre = "" + nbre + c;
		}

		for (char c : op) {
			cop = "" + cop + c;
		}

		System.out.println("nombree = " + nbre);
		System.out.println("operateur = " + cop);

		String[] splitNbre = nbre.split(",");
		String[] splitCop = cop.split(",");

		System.out.println("slipt nbre");

		for (String c : splitNbre) {
			System.out.println(".." + c);
		}

		System.out.println("slipt cop");

		for (String c : splitCop) {

			if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("^"))
				listeOp.add(c);
			System.out.println(".." + c);

		}

		double[] tableVal = new double[splitNbre.length];

		for (int i = 0; i < splitNbre.length; i++) {
			tableVal[i] = Double.parseDouble(splitNbre[i]);
			listeDouble.add(Double.parseDouble(splitNbre[i]));
		}

		System.out.println("liste Double " + listeDouble.toString());
		System.out.println("liste operateur " + listeOp.toString());

		String o;

		int indexePow;

		if (listeOp.contains("^")) {
			System.out.println("dans");

			for (int iPow = 0; iPow < listeOp.size(); iPow++) {

				o = listeOp.get(iPow);

				if (o.equals("^")) {

					indexePow = listeOp.indexOf(o);

					listeDouble.add(indexePow, Math.pow(listeDouble.get(indexePow), listeDouble.get(indexePow + 1)));

					System.out.println("ici");

					listeDouble.remove(indexePow + 1);
					listeDouble.remove(indexePow + 1);
					listeOp.remove(listeOp.get(indexePow));

					iPow = iPow - 1;

				}
			}
		}

		int indexe;

		if (listeOp.contains("*")) {
			System.out.println("dans");

			for (int i = 0; i < listeOp.size(); i++) {

				o = listeOp.get(i);

				if (o.equals("*")) {

					indexe = listeOp.indexOf(o);

					listeDouble.add(indexe, listeDouble.get(indexe) * listeDouble.get(indexe + 1));

					System.out.println("ici");

					listeDouble.remove(indexe + 1);
					listeDouble.remove(indexe + 1);
					listeOp.remove(listeOp.get(indexe));

					i = i - 1;

				}
			}
		}

		int indexeDiv;

		if (listeOp.contains("/")) {
			System.out.println("dans");

			for (int iDiv = 0; iDiv < listeOp.size(); iDiv++) {

				o = listeOp.get(iDiv);

				if (o.equals("/")) {

					indexeDiv = listeOp.indexOf(o);

					listeDouble.add(indexeDiv, listeDouble.get(indexeDiv) / listeDouble.get(indexeDiv + 1));

					System.out.println("ici");

					listeDouble.remove(indexeDiv + 1);
					listeDouble.remove(indexeDiv + 1);
					listeOp.remove(listeOp.get(indexeDiv));

					iDiv = iDiv - 1;

				}
			}
		}

		int indexeMoins;
		if (listeOp.contains("-")) {
			System.out.println("dans");

			for (int iMoins = 0; iMoins < listeOp.size(); iMoins++) {

				o = listeOp.get(iMoins);

				if (o.equals("-")) {

					indexeMoins = listeOp.indexOf(o);

					listeDouble.add(indexeMoins, listeDouble.get(indexeMoins) - listeDouble.get(indexeMoins + 1));

					System.out.println("ici");

					listeDouble.remove(indexeMoins + 1);
					listeDouble.remove(indexeMoins + 1);
					listeOp.remove(listeOp.get(indexeMoins));

					iMoins = iMoins - 1;

				}
			}
		}

		int indexePlus;
		if (listeOp.contains("+")) {
			System.out.println("dans");

			for (int iPlus = 0; iPlus < listeOp.size(); iPlus++) {

				o = listeOp.get(iPlus);

				if (o.equals("+")) {

					indexePlus = listeOp.indexOf(o);

					listeDouble.add(indexePlus, listeDouble.get(indexePlus) + listeDouble.get(indexePlus + 1));

					System.out.println("ici");

					listeDouble.remove(indexePlus + 1);
					listeDouble.remove(indexePlus + 1);
					listeOp.remove(listeOp.get(indexePlus));

					iPlus = iPlus - 1;

				}
			}
		}

		System.out.println("apres operation  " + listeDouble.toString() + "    " + listeOp.toString());

		this.resultat.setText(expression + " = " + listeDouble.get(0) + "");
		ActionClearEventListener(e);

	}

	class ClavierListener implements KeyListener {
		public void keyReleased(KeyEvent event) {
			if (!isNumeric(event.getKeyChar()))
				saisie.setText(saisie.getText().replace(String.valueOf(event.getKeyChar()), ""));
		}
		// Inutile de redéfinir ces méthodes, ous n'en avons plus l'utilité !

		public void keyPressed(KeyEvent event) {
		}

		public void keyTyped(KeyEvent event) {
		}

		// Retourne true si le paramètre est numérique, false dans le cas contraire
		private boolean isNumeric(char carac) {
			try {
				Integer.parseInt(String.valueOf(carac));
			} catch (NumberFormatException e) {
				if (carac == '+' || carac == '-' || carac == '/' || carac == '^' || carac == '*')
					return true;
				else
					return false;
			}
			return true;
		}
	}

}
