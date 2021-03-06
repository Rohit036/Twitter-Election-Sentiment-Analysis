	import java.io.*;
	import java.util.Properties;
	import edu.stanford.nlp.ling.CoreAnnotations;
	import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
	import edu.stanford.nlp.pipeline.StanfordCoreNLP;
	import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
	import edu.stanford.nlp.trees.Tree;
	import edu.stanford.nlp.util.CoreMap;

	public class SentimentAnalysis {

	    static StanfordCoreNLP pipeline;

	    public static void initialize() {
	        Properties props = new Properties();
	        props.setProperty("annotators","tokenize, ssplit, parse, pos, sentiment");
	        pipeline = new StanfordCoreNLP(props);
	    }

	    public static int findSentiment(String tweet) {

	        int mainSentiment = -1;
	        if (tweet != null && tweet.length() > 0) {
	            int longest = 0;
	            edu.stanford.nlp.pipeline.Annotation annotation = pipeline
	                    .process(tweet);
	            for (CoreMap sentence : annotation
	                    .get(CoreAnnotations.SentencesAnnotation.class)) {
	                Tree tree = sentence
	                        .get(SentimentCoreAnnotations.AnnotatedTree.class);
	                int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
	                String partText = sentence.toString();
	                if (partText.length() > longest) {
	                    mainSentiment = sentiment;
	                    longest = partText.length();
	                }

	            }
	        }
	        return mainSentiment;
	    }
	}
