import javax.swing.*;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Choice;
import java.awt.Panel;
import java.awt.Component;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.util.List;
import java.awt.TextArea;

public class Arvind implements Runnable
	{  
	public static String consumerKey ="WWeMr81ZpYFxmgmXdoJoG7pX1";
	public static String consumerSecret = "0L8FKm1SX874nCwK6RyMOL2b4ZZAl6oDWzdojiVJGleQS9bDT3";
	public static String token ="3008978864-9LgDrVKHTs11eAA6R6eZPU9ZgZoLLesPdgFMWPE";
	public static String tokenSecret ="IGTTdVJgzZlDroW0XVwRPuRmZoBEKgc1GfFDxNlIZ0maE";
	
		public void run()
		{
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true);
			cb.setOAuthConsumerKey(consumerKey);
			cb.setOAuthConsumerSecret(consumerSecret);
			cb.setOAuthAccessToken(token);
			cb.setOAuthAccessTokenSecret(tokenSecret);

			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter1 =tf.getInstance();

			try
			{
				Query query1 = new Query("(Arvind Kejriwal)");
				query1.setCount(1000);
				QueryResult result1;
				result1 =twitter1.search(query1);
				List<Status> tweets1 =result1.getTweets();

				for (Status tweet : tweets1)
				{
					if((tweet.getText())!=null)
					{
						try
						{
						  GUI_Test.Arvind.setText(tweet.getText()+"\n"+GUI_Test.Arvind.getText());
						  System.out.println("@"+tweet.getUser().getScreenName()+" - "+tweet.getText().replaceAll("\n",""));
					    }
						catch (Exception e)
						{
							
						}
						}
				}
			}
			catch(TwitterException te)
			{
				te.printStackTrace();
				System.out.println("Failed to Search Tweets");
				System.exit(-1);
			
		     }    
	}
}
