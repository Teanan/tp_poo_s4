/**
 * TP5 : Collections
 */
package library;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;


/**
 * Library consisting of a collection of documents
 * @author ? ?
 * @author ? ?
 * @version 2015.02.27
 */
public class Library{

	/**
	 * The document collection
	 */
	private HashMap<Integer,Document> documents;

	/**
	 * Constructor
	 */
	public Library(){
		documents = new HashMap<Integer,Document>();
	}

	/**
	 * Constructor
	 */
	public Library(Collection<Document> c){
		documents = new HashMap<Integer,Document>();
		
		for(Document o : c){
			documents.put(o.getBarCode(), o);
		}
	}
	
	/**
	 * Gives the size of the library
	 * @return the number of documents in the library
	 */
	public int size(){
		return documents.size();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String temp = new String();
		
		for (Integer o : documents.keySet()){
			temp+= documents.get(o).toString()+"\n";
		}
		return temp;
	}

        public String toString(Comparator<Document> c) {
                String res = new String();

                LinkedList<Document> sortedList = new LinkedList<Document>(documents.values());

                Collections.sort(sortedList, c);

                for (Document d : sortedList){
                        res += d.toString() + "\n";
                }

                return res;
        }

	/**
	 * Add a document to the library
	 * @param doc the document to add
	 */
	public void add(Document doc){
		documents.put(doc.getBarCode(),doc);
	}

	/**
	 * Borrow a document from the library
	 * @param barCode the bar code of the document to borrow
	 * @return the borrowed document
	 * @version 1
	 */
	public Document borrow(int barCode){
		/*for (Document o : documents){
			if ( (o.getBarCode()== barCode)&o.isAvailable()){
				 o.setAvailable(false);
				return o;
			}
		}
		return null;*/
		if(documents.containsKey(barCode)){
			if(documents.get(barCode).isAvailable()){
				documents.get(barCode).setAvailable(false);
				return documents.get(barCode);
			}
		}
		return null;
	}

	/**
	 * Return a document to the library
	 * @param barCode the bar code of the document to return
	 * @version 1
	 */
	public void takeBack(int barCode){
		/*for (Document o : documents){
			if ( o.getBarCode()== barCode&o.isAvailable()){
				 o.setAvailable(true);
			}
		}*/
		if(documents.containsKey(barCode)){
		documents.get(barCode).setAvailable(true);
		}
	}

	public Collection<Document> getDocumentByAuthor(String author) {
		Collection<Document> ret = new HashSet<>();
		for (Document d : documents.values()){
			if (d.getTitle().contains(author)){
				ret.add(d);
			}
		}
		return ret;
	}


	
}
