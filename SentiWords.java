import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class SentiWords 
{
	
	public static HashMap<String,Character> map = new HashMap<String,Character>(); 
    public static void setmap ()
    {
    	int count=0;
    	try
    	{
    	   BufferedReader br =new BufferedReader(new FileReader("SentiWordNet.txt"));
    	   File file = new File("Senti Words.txt");
    	   
    	   BufferedWriter bw =new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
    	   String line="";
    	  
    	  
    	  while(((line=br.readLine())!=null)&&(line=br.readLine()).length()>10 )
    	   {   
    		   String word[] = line.split("\t");
    		   count++;
    	 	  float a=Float.parseFloat(word[2]);
    		  float b=Float.parseFloat(word[3]);
    		  
    		  if(a>b)
    		  {
    		    if(word[4].contains(" "))
    		   {
    			String s1[] = word[4].split(" ");
    		//	System.out.println(s1.length);
    			int i=0;
    			while(i<s1.length)
    			{
    				//System.out.println(s1[i]);
    				String newword[]=s1[i].split("#");
    				//System.out.println(newword[0]);
    				map.put(newword[0], '+');
    				bw.write(newword[0]+"\t"+"+");
					bw.newLine();
    				i++;
    			}
    		   }
    		    else
    		     {
    			   String newword1[]=word[4].split("#");
    			   map.put(newword1[0], '+');
				   bw.write(newword1[0]+"\t"+"+");
				   bw.newLine();
    		     }
    		  }
    		  
    		  if(a<b)
    		  {
    			  if(word[4].contains(" "))
       		   {
       			String s2[] = word[4].split(" ");
       			//System.out.println(s2.length);
       			int i=0;
       			while(i<s2.length)
       			{
       				//System.out.println(s2[i]);
       				String nw1[]=s2[i].split("#");
       				//System.out.println(nw1[0]);
       				map.put(nw1[0], '-');
       				bw.write(nw1[0]+"\t"+"-");
   					bw.newLine();
       				i++;
       			}
       		   }
       		    else
       		     {
       			   String nw2[]=word[4].split("#");
       			   map.put(nw2[0], '-');
   				   bw.write(nw2[0]+"\t"+"-");
   				   bw.newLine();
       		     }
    		  }
    		  
    		  
    	   }
    	  br.close();
    	  bw.close();
    	}
    	  catch(Exception e)
    	  {
    		System.err.println();
      		e.printStackTrace();
    		}
    	
    	if(map.containsKey('a'))
    	{
    		System.out.println("It Contains");
    	}
    	
    	  }
    }

