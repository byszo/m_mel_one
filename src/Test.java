public class Test {

	public static void main (String[] args) {
		
		String titile = "Java ist auch eine Insel";
		String language = "Deutsch";
		Date releaseDate = new Date(1,1,2009);
		String descripton = "Lorem ipsum dolor sit amet consetetur sadipscing elitr sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat sed diam voluptua At vero eos et accusam et justo duo dolores et ea rebum Stet clita kasd gubergren no sea takimata sanctus est Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet consetetur sadipscing elitr sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat sed diam voluptua At vero eos et accusam et justo duo dolores et ea rebum Stet clita kasd gubergren no sea takimata sanctus est Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet consetetur sadipscing elitr sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat sed diam voluptua At vero eos et accusam et justo duo dolores et ea rebum Stet clita kasd gubergren no sea takimata sanctus est Lorem ipsum dolor sit amet Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi Lorem ipsum dolor sit amet Test test1";
		Author author =  new Author("Christian", "Ullenboom", new Date(1,11,1989), "Berlin", "christian.ulleboom@gmail.de");
		
		Document document = new Document(title, language, description, releaseDate, author);
		

		WordCount b = new WordCount("Java", 6);
		System.out.println(b.incrementCount());
		System.out.println(b.incrementCount(3));
	
		return;
	}
}
