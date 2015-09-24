package base;

import java.util.Date;
import java.util.Observable;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Recherche extends Observable{
	public final static char SEPARATOR = ';';
	public final static char ESPACE = ' ';
	public final static String LANG = "fr_FR";
	
	private Long [] listId;
	private String [] listPseudo;
	private String [] listText;
	private Date [] listDate;
	@SuppressWarnings("unused")
	private String sujet;
	@SuppressWarnings("unused")
	private int nbTweet;
	
	public Recherche(){
		this.sujet="rugby";
		this.nbTweet=1;
	}
	
	
	
	
	public void rechercheTweet(String sujet, int nb)throws Exception{
		    
		  ConfigurationBuilder cb = Connexion.config();
		  
		  TwitterFactory tf = new TwitterFactory(cb.build());
		  Twitter twitter = tf.getInstance();

		      
		  Query query = new Query(sujet);
		  query.setLocale(LANG);
		 
		  /** on ne peut depasser dans l'API des recherches sup � 100 **/
		  if(nb > 100){
		   	query.count(100);
		  }else if(nb<1){
			return;
		  }else{
		   	query.count(nb);
		  }
		  
		  if(sujet==null || nb>=0){
			  QueryResult result = twitter.search(query);
			    
			  int compteur=0;
			  this.listPseudo = new String[nb];
			  this.listText = new String[nb];
	
			  this.listId= new Long[nb];
			  this.listDate = new Date[nb];
			    
			    
			  for (Status status : result.getTweets()) {
				  this.listId[compteur]= status.getId();
				  System.out.println(status.getId());
				  this.listPseudo[compteur]=status.getUser().getScreenName();
				  System.out.println(status.getUser().getScreenName());
				  this.listText[compteur]=status.getText();
				  System.out.println(status.getText());
				  this.listDate[compteur]=status.getCreatedAt();
				  System.out.println(status.getCreatedAt());
				  compteur++;			    	
			  }
				
			  this.sujet = sujet;
			  this.nbTweet = compteur;
			    
			  setChanged();
			  notifyObservers();
		  }
	}
	
}
