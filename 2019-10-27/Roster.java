import java.util.Iterator;
import java.util.NoSuchElementException;

public class Roster implements Iterable<Student> {
	private int MAX_STUDENTS = 10;
	private Student[] theStudents;
	private int size;

	public Roster() {
		theStudents = new Student[MAX_STUDENTS];
		size = 0;
	}

	public int size() {
		return this.size;
	}
	
	public void add(Student s) {
		if (size < MAX_STUDENTS) {
			theStudents[size++] = s;
		}
	}

	public Student get(int idx) {
		if (idx < MAX_STUDENTS) {
			return theStudents[idx];
		} else {
			return null;
		}
	}
	
	public class RosterIterator implements Iterator<Student> {
		private int cur = 0;

		@Override
		public boolean hasNext() {
			return (cur < size);
		}

		@Override
		public Student next() {
			if (hasNext()) {
				return theStudents[cur++];
			}
			else {
				throw new NoSuchElementException();
			}
		}
		
	}

	@Override
	public Iterator<Student> iterator() {
		return new RosterIterator();
	}
}
