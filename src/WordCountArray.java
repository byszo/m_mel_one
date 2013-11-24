public class WordCountArray {

	private WordCount[] wordCounts;
	public WordCount[] getWordCounts() {
		return wordCounts;
	}
	
	
	public WordCountArray (int maxSize) {
		wordCounts = new WordCount[maxSize];
	}
	
	
	public void add(String word, int count) {
		if (word.equals("")) return;
		
		WordCount a = new WordCount(word, count);
		for (int i = 0; i < wordCounts.length; i++) {
			if (wordCounts[i] == null) {
				wordCounts[i] = a; 
				break;
			}
		}
	}
	
	
	public int size() {
		int counter = 0;
		for (int i=0; i< wordCounts.length; i++) {
			if(wordCounts[i] != null) {
				counter = counter +1;
			}
		}
		return counter;
	}
	
	
	
	public String getWord(int index) {
		if (index >= 0 && index < wordCounts.length && wordCounts[index] != null) {
			return wordCounts[index].getWord(); 
		}
		else {
			return "";
		}
	}
	
	
	
	public int getCount( int index) {
		if (index >= 0 && index < wordCounts.length && wordCounts[index] != null) {
			return wordCounts[index].getCount();
		}
		else {
			return -1;
		}
	}
	
	
	public void setCount(int index, int count) {
		if (count != 0 && index < wordCounts.length && wordCounts[index] != null) {
			wordCounts[index].setCount(count);
		}
	}
}

