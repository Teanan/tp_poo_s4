package library;


import java.util.Comparator;

public class TitleComparator implements Comparator<Document> {

	@Override
	public int compare(Document o1, Document o2) {
		return(o1.getTitle().toLowerCase().compareTo(o2.getTitle().toLowerCase()));
	}
		

}
