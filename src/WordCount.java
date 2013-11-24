public class WordCount {

	private String word;
	private int count;
	
	public WordCount (String word, int count) {
		this.word = word;
		this.count = count;
	}

	public String getWord() {
		return word;
	}

	public int getCount() {
		return count;
	}

	public void setCount (int count) {
		this.count = count;
	}
	
	public int incrementCount() {
		//count ++;
		return ++count;
	} 
	
	public int incrementCount(int n) {
		if (n>0) count += n; 
		return count;
	}
}