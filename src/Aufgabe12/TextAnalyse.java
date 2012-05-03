package Aufgabe12;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import StringWriter.Persistence;
import StringWriter.Interface.FileSystem;


public class TextAnalyse {

	TreeMap<Character, Integer> chars=new TreeMap<Character, Integer>();
	FileInputStream fis;
	BufferedReader in;
	String title;
	
	TreeMap<Character, Float> percent=null;
	
	private int allChars;
	


	TextAnalyse(String path) throws Exception{
		title=path;
		InputStream fis = new FileInputStream(path);
        Reader isr = new InputStreamReader(fis, "8859_1");
        in=new BufferedReader(isr);
		String str;
		while ((str = in.readLine()) != null) {
			this.process(str);
		}
		in.close();
		initPercentMap();

	}


	void initPercentMap(){
		this.percent=new TreeMap<Character, Float>();
		for(Entry<Character,Integer> e: chars.entrySet()){
			percent.put(e.getKey(), (float) e.getValue()/(allChars) );
		}
		
		
	}
	
	
	/**
	 * @param input,output
	 * 
	 */
	public static void main(String[] args) {
	

		String output=args[1];
		try {
			
				TextAnalyse textAna;

				textAna = new TextAnalyse(args[0]);
				
				FileSystem f=Persistence.file(output);
				
				f.concatLine("Buchstabenhaeufigkeiten im Text");
				
				f.concatLine(textAna.toString());
				TreeMap<Character, Integer> sorted=textAna.sortedByNumber();
				
			
				f.concatLine("Amount of Chars: "+textAna.allChars);
				
				f.concatLine("char\ttotal\tpercent");
				for(Entry<Character,Integer> e:sorted.entrySet()){
					f.concatLine(e.getKey() + "\t"+e.getValue()+"\t"+textAna.percent.get(e.getKey()));
			
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


			

		




	}


	//putting chars into treemap
	void process(String string){
		//String str=string.toLowerCase();

		for(char c:string.toCharArray()){
		//	if(Character.isLetter(c) ){

				if(chars.containsKey(c)){
					int amount=chars.get(c);	
					chars.put(c, amount+1);
					allChars++;

				}else{
					chars.put(c, 1);
				}

		//	}
		}
	}

	public String toString(){
		String str="Titel: "+this.title;

		return str;

	}

	TreeMap<Character, Integer> sortedByNumber(){
		ValueComparator vc=new ValueComparator(chars);
		TreeMap<Character, Integer> map=new TreeMap<Character, Integer>(vc);
		map.putAll(chars);
		
		return map;
	}



	
	
	//comparator for value ordering
	class ValueComparator implements Comparator {

		Map<Character, Integer> base;
		public ValueComparator(Map base) {
			this.base = base;
		}

		public int compare(Object a, Object b) {
			Integer aa=(Integer)base.get(a);
			Integer bb=(Integer)base.get(b);
			return bb.compareTo(aa);

		}

	}
	
	
	
	//getters, setters
	public int getAllChars() {
		return allChars;
	}

}
