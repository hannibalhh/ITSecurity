package CharReader.Implementation;

import java.util.Iterator;

import CharReader.Interface.CharReader;

public class EasyCharReader implements CharReader{
		
		final private char s[];
		private int current = 0;
		private final int size;
		
		public static final EasyCharReader NaC = new EasyCharReader("");
		
		private EasyCharReader(String s){
			this.s = s.toCharArray();
			this.size = s.length();
		}
		
		@Override
		public boolean isNaC(){
			return this == NaC;
		}
		
		public static EasyCharReader create(String str){
			if (str == null){
				System.err.println("CharReader is not valid. String can't be null");
				return NaC;
			}
			else{
				return new EasyCharReader(str);
			}
				
		}
		
		public boolean hasNext(){
			return current < (size); 
		}
		
		public char next(){
			if (hasNext()){
				current += 1;
				return s[current-1];
			}
			else{
				return '0';
			}
		}

		@Override
		public Iterator<Character> iterator() {
			return CharacterIterator.valueOf(this);
		}
		
		@Override
		public String toString(){
			String s = "";
			for (char c:this){
				s += c;
			}
			return s;
		}

	}