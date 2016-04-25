import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class containing the characteristics of a timetable.
 * 
 * @author kdesnos
 */
public class Timetable {
	static final int MAX_LESSONS = 100;
	static final int MAX_ROOMS = 30;
	static final int MAX_COURSES = 30;

	public static void main(String[] args) {
		String path = "timetable.txt";
		Timetable EDT = new Timetable();
		System.out.println(EDT.parseFile(path));
		EDT.print();
	}

	private Lesson[] scheduledLessons;
	private int nbScheduledLessons;

	private Room[] existingRooms;
	private int nbExistingRooms;

	private Course[] existingCourses;
	private int nbExistingCourses;

	public Timetable() {
		scheduledLessons = new Lesson[MAX_LESSONS];
		nbScheduledLessons = 0;
		existingRooms = new Room[MAX_ROOMS];
		nbExistingRooms = 0;
		existingCourses = new Course[MAX_COURSES];
		nbExistingCourses = 0;
	}

	private void addCourse(Course c) {
		if (!(nbExistingCourses==MAX_COURSES)){
			existingCourses[nbExistingCourses]= c;
			nbExistingCourses++;
		}
	}


	private void addLesson(Lesson l) throws UnknownException{
		if (!(nbScheduledLessons==MAX_LESSONS)){
			
			//TODO occupiedRoomException
			
			
			
			if (!(getCourse(l.getCourseId())== null)& !(getRoom(l.getRoomNumber())== null)){
				scheduledLessons[nbScheduledLessons]= l;
				nbScheduledLessons++;
			}
			else if ((getRoom(l.getRoomNumber())== null)){
				throw new UnknownException("Room inconnue");
			}
			else if ((getCourse(l.getCourseId())== null)){
				throw new UnknownException("Course inconnue");
			}
		}
	}

	private void addRoom(Room r) {
		if (!(nbExistingRooms==MAX_ROOMS)){
			existingRooms[nbExistingRooms]= r;
			nbExistingRooms++;
		}
	}

	private Course getCourse(int id) {
		for(int i=0; i<nbExistingCourses; i++){
			if (existingCourses[i].getId()==id){
				return existingCourses[i];
			}
		}
		return null;
	}

	private Room getRoom(int num) {
		for(int i=0; i<nbExistingRooms; i++){
			if (existingRooms[i].getNumber()==num){
				return existingRooms[i];
			}
		}
		return null;
	}

	/**
	 * Parse the content of the {@link File} designated by the given path. <br>
	 * If the path is not valid display an error message and return false. In
	 * this method, we assume that the format of the parsed file is always
	 * correct. (i.e. do not verify it in your code !)
	 * 
	 * @param path
	 *            the path of the parsed {@link File}.
	 * @return <code>true</code> if the {@link File} was successfully opened and
	 *         its information were readable, <code>false</code> otherwise.
	 */
	public boolean parseFile(String path) {
		BufferedReader br;
		try{
			br=new BufferedReader(new FileReader(path));
			int erreur =0;
			while (br.ready()){
				try{
				String s = br.readLine();
				String[] seg = s.split(",");
				if (seg[0].equals("Room")){
					
					Room R = new Room(Integer.parseInt(seg[1]), Integer.parseInt( seg[2]));
					addRoom(R);
				}else if (seg[0].equals("Lesson")){
					
					Lesson L = new Lesson(Integer.parseInt(seg[1]), Integer.parseInt( seg[2]),Integer.parseInt( seg[3]));
					addLesson(L);
				}else if (seg[0].equals("Course")){
					
					Course C = new Course(Integer.parseInt(seg[1]),  seg[2], seg[3]);
					addCourse(C);
				}
				else {
					br.close();
					return false;
				}
				}
				catch (UnknownException e) {
					System.out.println(e.getMessage());
					erreur++;
				}
			}
			if(!(erreur==0)) System.out.println("Il y a eu "+ erreur +" problèmes!");
			br.close();
			return true;
		}catch (IOException e) {
			System.out.println(e.getMessage());
			
			return false;
		}
		catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			
			return false;
		}

		
	}

	public void print() {
		System.out.println("Timetable");

		// Print list of Rooms
		System.out.print(nbExistingRooms + " Room(s): ");
		for (int i = 0; i < nbExistingRooms; i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			System.out.print(existingRooms[i]);
		}
		System.out.println("");

		// Print list of Courses
		System.out.println(nbExistingCourses + " Course(s): ");
		for (int i = 0; i < nbExistingCourses; i++) {
			System.out.println("\t" + existingCourses[i]);
		}

		// Print the scheduled lessons
		System.out.println(nbScheduledLessons + " Lessons are scheduled:");
		for (int i = 0; i < nbScheduledLessons; i++) {
			System.out.println("\t" + scheduledLessons[i]);
		}
	}
}
