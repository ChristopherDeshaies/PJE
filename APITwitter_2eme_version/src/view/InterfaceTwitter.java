package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import base.Recherche;
import controler.RechercheControler;



public class InterfaceTwitter extends JFrame implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private JFrame frame;
	private JPanel panelSujet;
	private JLabel labelSujet;
	public JTextField sujet;
	private JPanel panelNbTweet;
	private JLabel labelNbTweet;
	public JTextField nbTweet;
	private JPanel panelBouton;
	private JButton boutonRecherche;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem proprieties;

	public InterfaceTwitter(){
		
		frame = new JFrame("API Twitter");
		frame.setType(Type.UTILITY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setSize(300,200);
		frame.setLayout(new GridLayout(5,1));
		frame.setResizable(false);
		
		menuBar = new JMenuBar();
		menu = new JMenu("Options");
		proprieties = new JMenuItem("Proprietes");
		/** Controller a implementer **/
		//m.addActionListener(new Controller());
		menu.addSeparator();
		menu.add(proprieties);
		menuBar.add(menu);
		frame.add(menuBar);
		
		//ajout des composants de la fenetre
		JLabel labelSujet= new JLabel("Mot-cle :");
		JLabel labelNbTwitte = new JLabel("Nombre de tweet:");
		JTextField sujet = new JTextField("Equipe de France de rugby");
		JTextField nbTweet = new JTextField("1");
				
		panelSujet = new JPanel();
		panelSujet.add(labelSujet);
		panelSujet.add(sujet);
		panelNbTweet = new JPanel();
		panelNbTweet.add(labelNbTwitte);
		panelNbTweet.add(nbTweet);

		frame.add(panelSujet);
		frame.add(panelNbTweet);
		
		//creation des panels
		panelBouton = new JPanel();
		panelBouton.setBackground(new Color(102,204,255));
		boutonRecherche = new JButton("Rechercher");
		boutonRecherche.addActionListener(new RechercheControler(this, new Recherche()));					

		panelBouton.add(boutonRecherche);
		
		frame.add(panelBouton);
		
		frame.setVisible(true);
		
	}
	
	/***************** getter ***************************/
	public JTextField getMotCleTweet() {return sujet;}
	public JTextField getNbTweet() {return nbTweet;}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	

}
