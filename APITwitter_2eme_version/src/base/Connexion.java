package base;

import twitter4j.conf.ConfigurationBuilder;

public class Connexion {
	
	public static ConfigurationBuilder config(){
	    
		String token = "2520760050-SBFcnIu1pKUh84cECBbqD497SIhuLFqrLdiR7oI";
	    String tokenSecret = "uvmp2QGk0Ybq1HU9DXr4I8i3o0eo7c2tlVzpjZ3FOjxhv";
	    String consumerKey="1x6rJqqIZM96yNhfC8Fm6xzDh";
	    String consumerSecret="5AUhnkfCnfj9ObXutEtkx52fTNvTJqkLCmJifGujNUdgHiJ4eZ";
	    
	    ConfigurationBuilder cb = new ConfigurationBuilder();
		  cb.setDebugEnabled(true)
		    .setOAuthConsumerKey(consumerKey)
		    .setOAuthConsumerSecret(consumerSecret)
		    .setOAuthAccessToken(token)
		    .setOAuthAccessTokenSecret(tokenSecret);
		  
		  return cb;
	}
}
