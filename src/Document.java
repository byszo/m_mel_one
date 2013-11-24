/**
 * The class {@code Document} represents a document.
 * 
 * @see Date
 * @see Author
 *
 */
public class Document {
	/**
	 * the title of the document
	 */
	private String title;

	/**
	 * the language of the document
	 */
	private String language;

	/**
	 * description of the document
	 */
	private String description;

	/**
	 * the release date of the document
	 * @see Date
	 */
	private Date releaseDate;

	/**
	 * the {@link Author} of the document
	 * @see Author
	 */
	private Author author;
	
	/**
	 * the {@ link WordCountArray} of the document
	 * @see WordCountArray
	 */
	private WordCountArray wordCounts; 

	/**
	 * Constructs a document with the given values.
	 * 
	 * @param title the document's title
	 * @param language the language the document is written in
	 * @param description a short description of the document 
	 * @param releaseDate the release date of the document 
	 * @param author the author of the document
	 */
	public Document(String title, String language, String description,
			Date releaseDate, Author author) {
		this.title = title;
		this.language = language;
		this.description = description;
		this.releaseDate = releaseDate;
		this.author = author;
	}

	/**
	 * set title of a document
	 * @param title
	 */
	public void setTitle (String title) {
		if (title == null || title == "") {
			System.out.println("Fehler");
			return;
		}
		this.title = title;
	}

	/**
	 * set language of a document
	 * @param language
	 */
	public void setLanguage (String language) {
		if (language == null || language == "") {
			System.out.println("Fehler");
			return;
		}
		this.language = language;
	}

	/**
	 * set description of a document 
	 * @param description
	 */
	public void setDescription (String description) {
		if (description != null && description.length() < 1000) {
			System.out.println("Die Beschreibung ist zu kurz.");
			return;
		}
		this.description = description;
	}

	/**
	 * set release date of a document
	 * @param releaseDate
	 */
	public void setReleaseDate (Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * set author of a document 
	 * @param author
	 */
	public void setAuthor (Author author) {
		if (author == null) {
			System.out.println("Fehler");
			return;
		}
		this.author = author;
	}



	/**
	 * Returns the title of the document.
	 * @return the title of the document
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * Returns the language the document is written in.
	 * @return the language the document is written in
	 */
	public String getLanguage() {
		return language;
	}


	/**
	 * Returns a short description of the document.
	 * @return a short description of the document
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * Returns the release date of the document.
	 * @return the release date of the document
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}


	/**
	 * Returns the author of the document.
	 * @return the author of the document
	 * @see Author
	 */
	public Author getAuthor() {
		return author;
	}


	/**
	 * Returns a brief string representation of this document.
	 */
	public String toString() {
		return this.title + " by " + this.author.toString();
	}

	/**
	 * Returns the age of this document at the specified date in days.
	 * 
	 * @param today the specified date
	 * @return the age of this document at the specified date:
	 */
	public int getAge(Date today) {
		return this.releaseDate.getAgeInDays(today);
	}

	/**
	 * array with the most frequent german suffices
	 */
	public static final String[] SUFFICES = {"ab", "al", "ant", "artig", "bar", "chen", "ei",
		"eln", "en", "end", "ent", "er", "fach", "fikation", "fizieren", "faehig", "gemaess", 
		"gerecht", "haft", "haltig", "heit", "ieren", "ig", "in", "ion", "iren", "isch", 
		"isieren", "isierung", "ismus", "ist", "itaet", "iv", "keit", "kunde", "legen", "lein", "lich",
		"ling", "logie", "los", "mal", "meter", "mut", "nis", "or", "sam", "schaft", "tum",
		"ung", "voll", "wert", "wuerdig"};


	/**
	 * returns the wordCounts- array of a document 
	 * @return
	 */
	public WordCountArray getWordCounts() {
		return wordCounts; 
	}

	/**
	 * defines number of spaces in an array 
	 * @param text
	 * @return
	 */
	private static int numberOfSpaces(String text) {
		int counter = 0;
		for (int i = 0; i< text.length(); i++) {
			if(text.charAt(i)== ' ') {
				counter ++;
			}
		}
		return counter;
	}

	/**
	 * splits a text in words and adds this text to the array
	 * @param text
	 * @return
	 */
	private static String[] tokenize(String text) {
		String [] textArray = new String[numberOfSpaces(text)+1];
		for (int b= 0; b < textArray.length; b++) {
			textArray[b] = "";
		}
		int a = 0;
		int b = 0;
		while (a < text.length()) {
			if (text.charAt(a) == ' ') {
				b++;
			} else {
				textArray[b] += text.charAt(a);
			}
			a++;
		}
		return textArray;
	}
	
	/**
	 * check if suffix of the word1 and suffix of the word2 are equal
	 * @param word1
	 * @param word2
	 * @param n
	 * @return
	 */
	private static boolean suffixEqual (String word1, String word2, int n) {		
		if ( word1.length() < n ||  word2.length() < n ) {
			return false;
		}
			
		String sufixOne = word1.substring(word1.length() - n);
		String sufixTwo = word2.substring(word2.length() - n);
			
		if (sufixOne.equals(sufixTwo)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * check if the word has a suffix and returns it 
	 * @param word
	 * @return
	 */
	private static String findSuffix(String word) {
		String suffix = "";
		for (int i=0; i<SUFFICES.length; i++) {
			if (suffixEqual(SUFFICES[i],word,SUFFICES[i].length()) == true) {
				suffix = SUFFICES[i];
			}
		}
		return suffix;
	}


	private static String cutSuffix (String word,String suffix) {
		if (suffixEqual(suffix,word,suffix.length())) {
			String tmp = "";
			for (int i= 0; i < (word.length() - suffix.length()); i++) {
				tmp += word.charAt(i);
			}
			return tmp;
		}
		return word;
	}


	private void addText(String text) {
		String [] tmp = tokenize(text);
		// mistake probably here 
		wordCounts=new WordCountArray(tmp.length);
		for (int i=0; i<tmp.length; i++) {
			wordCounts.add(cutSuffix(tmp[i],findSuffix(tmp[i])), 1);
		}
	}


	public Document (String title, String language, String description, Date releaseDate, 
			Author author, String text) {
		this.title = title;
		this.language = language;
		this.description = description;
		this.releaseDate = releaseDate;
		this.author = author;
		this.addText(text);
	}
}
