package Aufgabe12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class TextAnalyse {

	TreeMap<Character, Integer> chars=new TreeMap<Character, Integer>();
	FileReader fis;
	BufferedReader in;
	String title;
	
	TreeMap<Character, Double> percent=null;
	
	private int allChars;
	


	TextAnalyse(String path) throws Exception{
		title=path;
		fis = new FileReader(path);
		in=new BufferedReader(fis);
		String str;
		while ((str = in.readLine()) != null) {
			this.process(str);
		}
		in.close();
		initPercentMap();

	}


	void initPercentMap(){
		this.percent=new TreeMap<Character, Double>();
		for(Entry<Character,Integer> e: chars.entrySet()){
			percent.put(e.getKey(), (double) e.getValue()/(allChars) );
		}
		
		
	}
	
	
	/**
	 * @param path to file
	 * 
	 */
	public static void main(String[] args) {
		List<TextAnalyse> list=new LinkedList<TextAnalyse>();

		try {
			for(int i=0; i<args.length; i++){
				TextAnalyse textAna;

				textAna = new TextAnalyse(args[i]);

				list.add(textAna);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		for(TextAnalyse textAna:list){
			System.out.println("Buchstabenhaeufigkeiten im Text");
			System.out.println(textAna.toString());
			TreeMap<Character, Integer> sorted=textAna.sortedByNumber();
			System.out.println("Amount of Chars: "+textAna.allChars);
			System.out.println("char\ttotal\tpercent");
			for(Entry<Character,Integer> e:sorted.entrySet()){
				System.out.println(e.getKey() + "\t"+e.getValue()+"\t"+textAna.percent.get(e.getKey()));
			}

		}




	}


	//putting chars into treemap
	void process(String string){
		String str=string.toLowerCase();

		for(char c:str.toCharArray()){
			if(Character.isLetter(c) ){

				if(chars.containsKey(c)){
					int amount=chars.get(c);	
					chars.put(c, amount+1);
					allChars++;

				}else{
					chars.put(c, 1);
				}

			}
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
