package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.InterfaceTwitter;
import base.Recherche;


public class RechercheControler implements ActionListener{


	public InterfaceTwitter view;
	public Recherche modele;
	
	public RechercheControler(InterfaceTwitter view,Recherche modele){
		this.view = view;
		this.modele = modele;
	}
	
	public void lancerRecherche() throws Exception{
		if(this.view != null)
			modele.rechercheTweet(
					view.getMotCleTweet().getText(), 
					Integer.parseInt(view.getNbTweet().getText())
			);
			
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {	
			lancerRecherche();
		} catch (Exception e) {	e.printStackTrace();}
		
	}
}
