import javax.swing.*;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

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
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.awt.TextArea;
import java.awt.SystemColor;


public class GUI_Test extends JFrame
{
	public static String consumerKey ="WWeMr81ZpYFxmgmXdoJoG7pX1";
	public static String consumerSecret = "0L8FKm1SX874nCwK6RyMOL2b4ZZAl6oDWzdojiVJGleQS9bDT3";
	public static String token ="3008978864-9LgDrVKHTs11eAA6R6eZPU9ZgZoLLesPdgFMWPE";
	public static String tokenSecret ="IGTTdVJgzZlDroW0XVwRPuRmZoBEKgc1GfFDxNlIZ0maE";
	public static JEditorPane Kiran= new JEditorPane();
	public static JEditorPane Arvind = new JEditorPane();
	public static JEditorPane Ajay = new JEditorPane();
	
	public static JTextField KiranP =new JTextField();
	public static JTextField KiranN = new JTextField();
	public static JTextField ArvindP = new JTextField();
	public static JTextField ArvindN = new JTextField();
	public static JTextField AjayP =new JTextField();
	public static JTextField AjayN = new JTextField();
	public static JTextField KiranT =new JTextField();
	public static JTextField ArvindT =new JTextField();
	public static JTextField AjayT =  new JTextField();
	
	public GUI_Test() 
{
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(UIManager.getColor("Button.disabledText"));
		getContentPane().setLayout(null);
				
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("/home/paresh/Hadoop Projects/ElectionAPI/twitterlogo1.png"));
		lblNewLabel_4.setBounds(827, 0, 140, 110);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("/home/paresh/Hadoop Projects/ElectionAPI/thumbs1.jpg"));
		lblNewLabel_6.setBounds(759, 67, 104, 90);
		getContentPane().add(lblNewLabel_6);

		JLabel lblExitPollsAnalysis = DefaultComponentFactory.getInstance().createTitle(" Exit  Poll  Analysis");
		lblExitPollsAnalysis.setForeground(new Color(51, 0, 51));
		lblExitPollsAnalysis.setFont(new Font("Dialog", Font.BOLD, 36));
		lblExitPollsAnalysis.setBounds(463, 0, 424, 74);
		getContentPane().add(lblExitPollsAnalysis);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 36));
		lblNewLabel.setIcon(new ImageIcon("/home/paresh/Hadoop Projects/ElectionAPI/16362_KIRAN DBDEI.png"));
		lblNewLabel.setBounds(110, 169, 326, 280);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/home/paresh/Hadoop Projects/ElectionAPI/Arvind1.jpg"));
		lblNewLabel_1.setBounds(531, 177, 325, 256);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("/home/paresh/Hadoop Projects/ElectionAPI/AJ_1.JPG"));
		lblNewLabel_2.setBounds(948, 177, 307, 256);
		getContentPane().add(lblNewLabel_2);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/paresh/Hadoop Projects/ElectionAPI/thumbs.jpg"));
		label.setForeground(Color.PINK);
		label.setBackground(Color.WHITE);
		label.setBorder(null);
		label.setBounds(521, 75, 104, 82);
		getContentPane().add(label);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("/home/paresh/Hadoop Projects/ElectionAPI/thumbs1.jpg"));
		lblNewLabel_5.setBounds(345, 78, 91, 74);
		getContentPane().add(lblNewLabel_5);
		lblNewLabel_5.setBorder(null);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("/home/paresh/Hadoop Projects/ElectionAPI/thumbs1.jpg"));
		lblNewLabel_8.setBounds(1162, 59, 104, 98);
		getContentPane().add(lblNewLabel_8);
		lblNewLabel_8.setBorder(null);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("/home/paresh/Hadoop Projects/ElectionAPI/thumbs.jpg"));
		lblNewLabel_7.setBounds(948, 67, 113, 90);
		getContentPane().add(lblNewLabel_7);
		lblNewLabel_7.setBorder(null);
	
		KiranP.setForeground(new Color(30, 144, 255));
		KiranP.setFont(new Font("Dialog", Font.BOLD, 15));
		KiranP.setBounds(96, 154, 89, 26);
		KiranP.setColumns(10);
		KiranP.setBorder(null);
		getContentPane().add(KiranP);
		
		KiranN.setForeground(new Color(128, 0, 0));
		KiranN.setFont(new Font("Dialog", Font.BOLD, 15));
		KiranN.setColumns(10);
		KiranN.setBounds(323, 154, 93, 26);
		KiranN.setBorder(null);
		getContentPane().add(KiranN);
		
		ArvindP.setForeground(new Color(100, 149, 237));
		ArvindP.setFont(new Font("Dialog", Font.BOLD, 15));
		ArvindP.setColumns(10);
		ArvindP.setBounds(514, 150, 91, 26);
		ArvindP.setBorder(null);
		getContentPane().add(ArvindP);
		
		ArvindN.setForeground(new Color(128, 0, 0));
		ArvindN.setFont(new Font("Dialog", Font.BOLD, 15));
		ArvindN.setColumns(10);
		ArvindN.setBounds(746, 147, 91, 26);
		ArvindN.setBorder(null);
		getContentPane().add(ArvindN);

		AjayP.setForeground(new Color(30, 144, 255));
		AjayP.setFont(new Font("Dialog", Font.BOLD, 15));
		AjayP.setColumns(10);
		AjayP.setBounds(948, 147, 97, 33);
		AjayP.setBorder(null);
		getContentPane().add(AjayP);
		
		AjayN.setForeground(new Color(128, 0, 0));
		AjayN.setFont(new Font("Dialog", Font.BOLD, 15));
		AjayN.setColumns(10);
		AjayN.setBounds(1151, 147, 91, 33);
		AjayN.setBorder(null);
		getContentPane().add(AjayN);
		
		JScrollPane scrollPane = new JScrollPane(Kiran);
		scrollPane.setBounds(84, 448, 372, 284);
		getContentPane().add(scrollPane);
		
		//JEditorPane Kiran= new JEditorPane();
		Kiran.setText("Kiran Bedi\n");
		//scrollPane.setViewportView(Kiran);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(505, 448, 372, 284);
		getContentPane().add(scrollPane_1);
		
		//JEditorPane Arvind = new JEditorPane();
		Arvind.setText("Arvind Kejriwal");
		scrollPane_1.setViewportView(Arvind);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(917, 448, 372, 284);
		getContentPane().add(scrollPane_2);
		
		//JEditorPane Ajay = new JEditorPane();
		Ajay.setText("Ajay Maken");
		scrollPane_2.setViewportView(Ajay);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("/home/paresh/Hadoop Projects/ElectionAPI/thumbs.jpg"));
		lblNewLabel_3.setBounds(105, 83, 113, 74);
	    getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("/home/paresh/Hadoop Projects/ElectionAPI/TweetPost.png"));
		lblNewLabel_9.setBounds(241, 79, 60, 56);
		getContentPane().add(lblNewLabel_9);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("/home/paresh/Hadoop Projects/ElectionAPI/TweetPost.png"));
		label_1.setBounds(664, 79, 60, 56);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("/home/paresh/Hadoop Projects/ElectionAPI/TweetPost.png"));
		label_2.setBounds(1073, 67, 60, 56);
		getContentPane().add(label_2);
		
		KiranT.setFont(new Font("Dialog", Font.BOLD, 15));
		KiranT.setForeground(new Color(0, 128, 128));
		KiranT.setBounds(213, 134, 114, 19);
		KiranT.setColumns(10);
		KiranT.setBorder(null);
		getContentPane().add(KiranT);
		ArvindT.setForeground(new Color(0, 128, 128));
		ArvindT.setFont(new Font("Dialog", Font.BOLD, 15));
		ArvindT.setColumns(10);
		ArvindT.setBounds(634, 134, 91, 19);
		ArvindT.setBorder(null);
		getContentPane().add(ArvindT);
		AjayT.setForeground(new Color(0, 128, 128));
		AjayT.setFont(new Font("Dialog", Font.BOLD, 15));
		AjayT.setColumns(10);
		AjayT.setBounds(1042, 124, 114, 19);
		AjayT.setBorder(null);
		getContentPane().add(AjayT);
		
		
	//	JScrollPane scroll2 = new JScrollPane(Arvind ,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
		//		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				
		this.setSize(512,256);
		this.show();
	}


	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//GUI_Test gu = new GUI_Test();
		//gu.gettweets();
	new GUI_Test();
		SentiWords sw = new SentiWords();
		sw.setmap();
		HashMap hm1 = new HashMap(sw.map);
		System.out.println(hm1);
	    System.out.println(hm1.get("false"));
		
		 Thread k = new Thread(new Kiran());
	     Thread ar = new Thread(new Arvind());
	     Thread aj = new Thread(new Ajay());
	     
	   //  k.start();
//	     ar.start();
//	     aj.start();

       SentimentAnalysis.initialize();
		TwitterStreamThread thrd=new TwitterStreamThread();
		thrd.run();
	     
	     float a = (float)(56.232);
	     DecimalFormat df = new DecimalFormat("#.##");
	     
	     String  b = df.format(a);
	     System.out.println(b);
	     
	    System.out.println();
	   //  Kiran.setEditorKit(new HTMLEditorKit());
	    
	   //  String ch = "<html><font color=\"blue\">"+s+"</font></html>";
	    // 
	      
//	     StringBuilder str = new StringBuilder();
//	     String s ="Java Is Awsome";
//	     String word[] = s.split(" ");
//	     
//	     word[0]="<html><font color=\"blue\">"+word[0]+"</font>";
//	     word[1]="<font >"+word[1]+"</font>";
//	     word[2]="<font >"+word[2]+"</font></html>";
//	     for(int i=0 ;i<word.length;i++)
//	     {
//	    	str.append(word[i]+" ");
//	    	
//	     }
//	     
//	     
//	     String p =str.toString();
//	     System.out.println(p);
//	     
//	 //    Kiran.setText(p+Kiran.getText());
//	    // Kiran.setText("Java"+"Program");
//	     Kiran.setText(p);	    
//	     
//	     
	   //  System.out.println(s.toUpperCase());
	     
		
        

	}
}
	
	





