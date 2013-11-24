/**
 * The class {@code Review} represents a review of a {@link Document}.
 * 
 * @see Document
 * @see Author
 *
 */
public class Review {
	/**
	 * the {@link Author} of the review
	 * @see Author
	 */
	private Author author;
	
	/**
	 * the reviewed {@link Document}
	 * @see Document
	 */
	private Document reviewedDocument;
	
	/**
	 * the language of the review
	 */
	private String language;
	
	/**
	 * the release date of the review
	 * @see Date
	 */
	private Date releaseDate;
	
	/**
	 * the rating of the document, ranging from 0 to 10
	 */
	private int rating;
	
	
	/**
	 * Constructs a review with the given values
	 * 
	 * @param author the author of the review
	 * @param reviewedDocument the document that has been reviewed
	 * @param language the language the review is written in
	 * @param releaseDate the release date of the review
	 * @param rating the rating of the reviewed document
	 */
	public Review(Author author, Document reviewedDocument, String language,
			Date releaseDate, int rating) {
		this.author = author;
		this.reviewedDocument = reviewedDocument;
		this.language = language;
		this.releaseDate = releaseDate;
		this.rating = rating;
	}
	
	
	public void setAuthor (Author author) {
		if (author == null) {
			System.out.println("Fehler");
			return;
		}
		this.author = author;
	}
	
	
	public void setReviewedDocument (Document reviewedDocument) {
		if (reviewedDocument == null) {
			System.out.println("Fehler");
			return;
		}
		this.reviewedDocument = reviewedDocument;
	}
	
	
	
	public void setLanguage (String language) {
		if (language == null && language == "") {
			System.out.println("Fehler");
			return;
		}
		this.language = language;
	}
	
	
	public void setReleaseDate (Date releaseDate) {
		if (releaseDate.getAgeInDays(new Date()) <0 ) {
			System.out.println("Fehler");
			return;
		}
		this.releaseDate = releaseDate;
	}
	
	
	public void setRating (int rating) {
		if (rating >= 0 && rating <= 10) {
			this.rating = rating;
		}
		else {
			System.out.println("Keine gueltige Bewertung");
			return;
		}
	}
	
	
	
	
	
	/**
	 * Returns the author of the review.
	 * @return the author of the review
	 * @see Author
	 */
	public Author getAuthor() {
		return author;
	}

	/**
	 * Returns the reviewed document.
	 * @return the reviewed document
	 * @see Document
	 */
	public Document getReviewedDocument() {
		return reviewedDocument;
	}

	
	/**
	 * Returns the language the review is written in.
	 * @return the language the review is written in
	 */
	public String getLanguage() {
		return language;
	}
	

	/**
	 * Returns the release date of the review.
	 * @return the release date of the review
	 * @see Date
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}

	
	/**
	 * Returns how the reviewed document has been rated.
	 * @return how the reviewed document has been rated
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * Returns a brief string representation of this review.
	 */
	public String toString() {
		return this.reviewedDocument.toString() + " is rated " + this.rating + " by " + this.author.toString();
	}
	
	
	/**
	 * Returns the age of this review at the specified date in days.
	 * 
	 * @param today the specified date
	 * @return the age of this review at the specified date:
	 */
	public int getAge(Date today) {
		return this.releaseDate.getAgeInDays(today);
	}
}
