import java.text.DecimalFormat;
import java.util.HashMap;

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.HTML;


import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterStreamThread implements Runnable {
	
	public static HashMap<String,Character> hm = SentiWords.map;

	public static int ArvindScore = 0;
	public static int ArvindTotal = 0;
	public static int Arvindpos = 0;
	public static int Arvindneg = 0;
	public static int Arvindnet = 0;
	public static int KiranScore = 0;
	public static int KiranTotal = 0;
	public static int Kiranpos = 0;
	public static int Kiranneg = 0;
	public static int Kirannet = 0;
	public static int AjayScore = 0;
	public static int AjayTotal = 0;
	public static int Ajaypos = 0;
	public static int Ajayneg = 0;
	public static int Ajaynet = 0;

	public static StringBuilder sb1 = new StringBuilder("<html>  ");
	public static StringBuilder sb2 = new StringBuilder("<html>  ");
	public static StringBuilder sb3 = new StringBuilder("<html> ");
	@Override
	public void run() {
		System.out.println(hm);
		
		// TODO Auto-generated method stub

		String consumerKey = "hP4uTnbb4EUjvfrFOmkzkQi35";
		String consumerSecret = "pJgGmVwz5Tl2UTMc2nRPQwMbrIMGkqgRJnaP5G1vUVAPafnwmd";
		String token = "3008979254-lH6jimexO8od5QjLy76i7Tf052L6YGggLuBBorm";
		String tokenSecret = "yNqcY9uGhXaERBg57IFSMl7yImBKakPj5GaXUle0J16dM";

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey)
				.setOAuthConsumerSecret(consumerSecret)
				.setOAuthAccessToken(token)
				.setOAuthAccessTokenSecret(tokenSecret);

		StatusListener listener = new StatusListener() {
			public void onStatus(Status status) {
				if (status.getLang().equals("en")) {

					String tweet = status.getText().replaceAll("\n", "");
					int score = 0;
					
					String str;
										
					String TU="\uD83D\uDC4D";
					String TD="\uD83D\uDC4E";
					DecimalFormat df = new DecimalFormat("#.##");

					if (tweet.contains("Arvind Kejriwal")|| tweet.contains("Kejriwal")|| tweet.contains("AAP"))
					{
						str = tweet;
						String sw[] =str.split(" ");
						score = SentimentAnalysis.findSentiment(tweet);
						
						GUI_Test.Arvind.setEditorKit(new HTMLEditorKit());
						
						 int i=0;
						    while(i<sw.length)
						    {
						    	if(hm.containsKey(sw[i]))
						    	{
						    		char ch = hm.get(sw[i]);
						    		
						    		if(ch=='+')
						    		{
						    			System.out.println("***********"+hm.get(sw[i])+"****************");
						    		    sw[i]="<font color=\"green\">"+sw[i]+"</font>";
						    		}
						    		else
						    			if(ch=='-')
						    			{
						    			   sw[i]="<font color=\"red\">"+sw[i]+"</font>";
						    			}
						    				    		
						    	}
						    	else
				    			{
				    			   sw[i]="<font >"+sw[i]+"</font>";
				    			}
						    	
						    	if(sw[i].contains("Arvind Kejriwal")||(sw[i].contains("Kejriwal"))||sw[i].contains("AAP"))
						    	{
						    		sw[i]="<b>"+sw[i]+"</b>";
						    	}
						    	sb1.append(sw[i]+" ");
						    	i++;
						      }
						    
						 //   sb1.append("<br/> <br/>");
						   //  String p =sb1.toString();
						     System.out.println(sb1);
						     
						     
						     
						if (score < 2 && score >= 0) 
						{
							Arvindneg++;
							try{
								   sb1.append(TD+"<br/> <br/>");
								     String p =sb1.toString();
								 
								String App =GUI_Test.Arvind.getText();
							GUI_Test.Arvind.setText(p+App);// GUI_Test.Arvind.getText());
							System.out.println("#########"+App+"############");
							}
							catch(Exception e)
							{}
						} 
						else
							if (score >= 2 && score <= 4) 
						{
							Arvindpos++;
							try{
								sb1.append(TU+"<br/> <br/>");
							     String p =sb1.toString();
								String App =GUI_Test.Arvind.getText();
								GUI_Test.Arvind.setText(p +  App);//GUI_Test.Arvind.getText());
								System.out.println("#########"+App+"############");
							}
							catch(Exception e)
							{
								
							}
						}
						else 
							if (score == 2) 
						{
							Arvindpos++;
							try{
								sb1.append(TU+"<br/> <br/>");
							     String p =sb1.toString();
								String App =GUI_Test.Arvind.getText();
								GUI_Test.Arvind.setText(p + App);// GUI_Test.Arvind.getText());
								System.out.println("#########"+App+"############");
							//	GUI_Test.Arvind.setText( "\n"+ p + "  "+"\n"+ App);//GUI_Test.Arvind.getText());
								}
								catch(Exception e)
								{
									
								}
						}
											
						ArvindScore += score;
						ArvindTotal++;
						float arvindPerpos = (float)Arvindpos / (float)(ArvindTotal+KiranTotal+AjayTotal);
						arvindPerpos *= 100.0;
						float arvindPerneg = (float)Arvindneg / (float)(ArvindTotal+KiranTotal+AjayTotal);
						arvindPerneg *= 100.0;
						float arvindPernet = (float)Arvindnet / (float)(ArvindTotal+KiranTotal+AjayTotal);
						arvindPernet *= 100.0;
						
						GUI_Test.ArvindN.setText("     "+df.format(arvindPerneg) + " %");// + " ("+ score + ") " );//+ ArvindTotal);
						GUI_Test.ArvindP.setText("     "+df.format(arvindPerpos) + " %" );//+" ("+ score + ") ");// + ArvindTotal);
                        GUI_Test.ArvindT.setText("        "+ArvindTotal);
                        
						//GUI_Test.Arvind.setText(str + "\n"+ GUI_Test.Arvind.getText());
						//System.out.println(str);
					}
					if (tweet.contains("Kiran Bedi") || tweet.contains("Bedi")||tweet.contains("BJP"))
					{
						
						str = tweet;
                        String sw[] =str.split(" ");
                        score = SentimentAnalysis.findSentiment(tweet);
						
						GUI_Test.Kiran.setEditorKit(new HTMLEditorKit());
					
                        
						 int i=0;
						    while(i<sw.length)
						    {
						    	if(hm.containsKey(sw[i]))
						    	{
						    		char ch = hm.get(sw[i]);
						    		
						    		if(ch=='+')
						    		{
						    			System.out.println("***********"+hm.get(sw[i])+"****************");
						    			sw[i]="<font color=\"green\">"+sw[i]+"</font>";
						    		}
						    		else
						    			if(ch=='-')
						    			{
						    			   sw[i]="<font color=\"red\">"+sw[i]+"</font>";
						    			}
						    					    			
						    		
						    	}
						    	else
				    			{
				    			   sw[i]="<font >"+sw[i]+"</font>";
				    			}
				    		
						    	if((sw[i].contains("Kiran Bedi"))||(sw[i].contains("Bedi"))||(sw[i].contains("BJP")))
						    	{
						    		sw[i]="<b>"+sw[i]+"</b>";
						    	}
				    		sb2.append(sw[i]+" ");
						    	i++;
						      }
						    
						    // String p =sb2.toString();
							 //System.out.println(p);			
                        
						if (score < 2 && score >= 0) {
							
							sb2.append(TD+"<br/> <br/>");
							   String p =sb2.toString();
							
							String app = GUI_Test.Kiran.getText();
							GUI_Test.Kiran.setText(p+app);
							
							Kiranneg++;
						} else if (score > 2 && score <= 4) {
							
							sb2.append(TU+"<br/> <br/>");
							   String p =sb2.toString();
							String app = GUI_Test.Kiran.getText();
							GUI_Test.Kiran.setText(p+app);
							//GUI_Test.Kiran.setText("\n"+ p + "  "+TU +"\n"+GUI_Test.Kiran.getText());
							
							Kiranpos++;
						} else if (score == 2) {
							sb2.append(TU+"<br/> <br/>");
							String p=sb2.toString();
							String app = GUI_Test.Kiran.getText();
							GUI_Test.Kiran.setText(p+app );
							//GUI_Test.Kiran.setText("\n"+p + "  " +"\n"+GUI_Test.Kiran.getText());
							Kiranpos++;
						}
						KiranScore += score;
						KiranTotal++;
						float kiranPerpos = (float)Kiranpos / (float)(ArvindTotal+KiranTotal+AjayTotal);
						kiranPerpos *= 100.0;
						float kiranPerneg = (float)Kiranneg / (float)(ArvindTotal+KiranTotal+AjayTotal);
						kiranPerneg *= 100.0;
						float kiranPernet = (float)Kirannet / (float)(ArvindTotal+KiranTotal+AjayTotal);
						kiranPernet *= 100.0;
						
						GUI_Test.KiranN.setText("     "+df.format(kiranPerneg) + " %");//+ " ("+ score + ") " );//+ KiranTotal);
						GUI_Test.KiranP.setText("   "+df.format(kiranPerpos) + " %" );//+ " ("+ score + ") " );//+ KiranTotal);
						GUI_Test.KiranT.setText("       "+KiranTotal);
						
					}
					if (tweet.contains("Ajay Maken") || tweet.contains("Maken")|| tweet.contains("Congress")) {
						
						str = tweet;
                        String sw[] =str.split(" ");
                        score = SentimentAnalysis.findSentiment(tweet);
						
						GUI_Test.Ajay.setEditorKit(new HTMLEditorKit());
						                        
						 int i=0;
						    while(i<sw.length)
						    {
						    	if(hm.containsKey(sw[i]))
						    	{
						    		char ch = hm.get(sw[i]);
						    		
						    		if(ch=='+')
						    		{
						    			System.out.println("***********"+hm.get(sw[i])+"****************");
						    			sw[i]="<font color=\"green\">"+sw[i]+"</font>";
						    		}
						    		else
						    			if(ch=='-')
						    			{
						    			   sw[i]="<font color=\"red\">"+sw[i]+"</font>";
						    			}
						    	
						    	}

				    			else
				    			{
				    			   sw[i]="<font >"+sw[i]+"</font>";
				    			}
						    	
						    	if(sw[i].contains("Ajay Maken")||(sw[i].contains("Maken"))||(sw[i].contains("Congress")))
						    	{
						    		sw[i]="<b>"+sw[i]+"</b>";
						    	}
				    		
				    		sb3.append(sw[i]+" ");
				    		
						    	i++;
						      }
						    
						    // sb3.append(TD+"<br/><br/>");
						     //String p =sb3.toString();
					        // System.out.println(p);
					         
						if (score < 2 && score >= 0) {
							
							 sb3.append(TD+"<br/><br/>");
						     String p =sb3.toString();
							String app = GUI_Test.Ajay.getText();
							GUI_Test.Ajay.setText(p +app);
							Ajayneg++;
						} else if (score > 2 && score <= 4) {
							
							 sb3.append(TU+"<br/><br/>");
						     String p =sb3.toString();
							String app = GUI_Test.Ajay.getText();
							GUI_Test.Ajay.setText(p+app);
							//GUI_Test.Ajay.setText("\n"+str + "  "+TU+"\n"+ GUI_Test.Ajay.getText());
							Ajaypos++;
						} else if (score == 2) {
							
							sb3.append(TD+"<br/><br/>");
							String p = sb3.toString();
							String app = GUI_Test.Ajay.getText();
							GUI_Test.Ajay.setText(p +app);
							//GUI_Test.Ajay.setText("\n"+str + "  "+"\n"+ GUI_Test.Ajay.getText());
							Ajaypos++;
						}
						
						AjayScore += score;
						AjayTotal++;
						float ajayPerpos = (float)Ajaypos / (float)(ArvindTotal+KiranTotal+AjayTotal);
						ajayPerpos *= 100.0;
						float ajayPerneg = (float)Ajayneg / (float)(ArvindTotal+KiranTotal+AjayTotal);
						ajayPerneg *= 100.0;
						float ajayPernet = (float)Ajaynet / (float)(ArvindTotal+KiranTotal+AjayTotal);
						ajayPernet *= 100.0;

						GUI_Test.AjayN.setText("     "+df.format(ajayPerneg) + " %" );//+ "("+ score + ") ");// + AjayTotal);
						GUI_Test.AjayP.setText("     "+df.format(ajayPerpos) + " %" );//+ "("+ score + ")") ; //+ AjayTotal);
						GUI_Test.AjayT.setText("        "+AjayTotal);
						
						//GUI_Test.Ajay.setText(str + "\n"+ GUI_Test.Ajay.getText());
						//System.out.println(str);
					}
				}
			}

			public void onDeletionNotice(
					StatusDeletionNotice statusDeletionNotice) {
				// System.out.println("Got a status deletion notice id:"
				// + statusDeletionNotice.getStatusId());
			}

			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
				// System.out.println("Got track limitation notice:"
				// + numberOfLimitedStatuses);
			}

			public void onScrubGeo(long userId, long upToStatusId) {
				// System.out.println("Got scrub_geo event userId:" + userId
				// + " upToStatusId:" + upToStatusId);

			}

			public void onStallWarning(StallWarning warning) {
				// System.out.println("Got stall warning:" + warning);
			}

			public void onException(Exception ex) {
				// ex.printStackTrace();
			}
		};
		TwitterStream twitterStream = new TwitterStreamFactory(cb.build())
				.getInstance();
		twitterStream.addListener(listener);
		// FilterQuery query = new FilterQuery();
		// String keywords[] = {"Arvind Kejriwal","Kejriwal","AAP"};
		// query.track(keywords);
		// twitterStream.filter(query);
		twitterStream.sample();
	}
}
