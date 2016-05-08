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


	private void addLesson(Lesson l) throws UnknownException, OccupiedRoomException {
		if (!(nbScheduledLessons==MAX_LESSONS)){

			// Check if course and room exist (throws UnknownException if not)
			getCourse(l.getCourseId());
			getRoom(l.getRoomNumber());

			// Check if room is full
			for (Lesson it : scheduledLessons){
				if (it == null) continue;

				if (it.getStartTime() == l.getStartTime() && it.getRoomNumber() == l.getRoomNumber())
					throw new OccupiedRoomException("There is no room for you in this place ! (room " + l.getRoomNumber() + " at " + l.getStartTime());
			}

			scheduledLessons[nbScheduledLessons]= l;
			nbScheduledLessons++;
		}
	}

	private void addRoom(Room r) {
		if (!(nbExistingRooms==MAX_ROOMS)){
			existingRooms[nbExistingRooms]= r;
			nbExistingRooms++;
		}
	}

	private Course getCourse(int id) throws UnknownCourseException {
		for(int i=0; i<nbExistingCourses; i++){
			if (existingCourses[i].getId()==id){
				return existingCourses[i];
			}
		}

		throw new UnknownCourseException("Course " + id + " not found");
	}

	private Room getRoom(int num) throws UnknownRoomException {
		for(int i=0; i<nbExistingRooms; i++){
			if (existingRooms[i].getNumber()==num){
				return existingRooms[i];
			}
		}

		throw new UnknownRoomException("Room " + num + " not found");
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
			br = new BufferedReader(new FileReader(path));

			int lineNum = 0;
			
			while(br.ready()){
				String line = br.readLine();
				String[] split = line.split(",");

				lineNum++;
				
				if (split.length < 1) continue;

				switch(split[0]){
				case "Room":
					if (split.length != 3) continue;
					Room r = new Room(Integer.parseInt(split[1]), Integer.parseInt(split[2]));					
					addRoom(r);
					break;
				case "Course":
					if (split.length != 4) continue;
					Course c = new Course(Integer.parseInt(split[1]), split[2], split[3]);
					addCourse(c);
					break;
				case "Lesson":
					if (split.length != 4) continue;

					try{
						Lesson l = new Lesson(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
						addLesson(l);
					}catch(UnknownRoomException | OccupiedRoomException e){
						Lesson l = null;
						
						for (int i = 0; i < nbExistingRooms; i++){
							if (!roomUsed(existingRooms[i], Integer.parseInt(split[1]))){
								l = new Lesson(Integer.parseInt(split[1]), Integer.parseInt(split[2]), existingRooms[i].getNumber());
								try{
									addLesson(l);

									System.out.println("Line #" + lineNum + " : Lesson " + l.getCourseId() + " at " + l.getStartTime() + "h was moved from room #" + Integer.parseInt(split[3]) + " to room #" + l.getRoomNumber());
									break;
								}catch(UnknownException | OccupiedRoomException ee){
									System.out.println("Line #" + lineNum + " : Cannot add Lesson after moving it to room #" + existingRooms[i].getNumber() + " : " + ee.getMessage());
								}
							}
						}
						
						if (l == null){
							System.out.println("Line #" + lineNum + " : Not empty room found for Lesson " + Integer.parseInt(split[2]) + " at " + Integer.parseInt(split[1]) + "h");
						}
					}catch(UnknownException e){
						System.out.println("Line #" + lineNum + " : Cannot add Lesson : " + e.getMessage());
					}

					break;
				default:
					System.out.println("WUT R U DOING ?!");
				}
			}

			br.close();
			
			return true;
		}catch(IOException e){
			System.out.println(e.getMessage());
		}

		return false;
	}
	
	public boolean roomUsed(Room r, int time){
		if (r == null)
			return false;
		
		for (int i = 0; i < nbScheduledLessons; ++i)
			if (scheduledLessons[i].getRoomNumber() == r.getNumber() && scheduledLessons[i].getStartTime() == time)
				return true;
		
		return false;
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
