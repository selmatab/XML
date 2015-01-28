import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Person {

	@Override
	public String toString() {
		return "Person [name=" + name + ", lastName=" + lastName + ", child="
				+ child + "]";
	}

	public LinkedList<Person> getChild() {
		return child;
	}

	private String name;
	private String lastName;
	private LinkedList<Person> child;

	public Person(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
		child = new LinkedList<Person>();
	}

	public void addChildren(Person p) {
		child.add(p);
	}


	

	public static void persontoXML(List people, OutputStream os) {
		PrintWriter pw = new PrintWriter(os);
		pw.println("<?xml version=\"1.0\"?>");
		pw.println("<people>");
		Iterator<Person> it = people.iterator();
		Person temp = null;
		while (it.hasNext()) {
			temp = it.next();
			pw.println(" <person name='" + temp.name + "' lastName='"
					+ temp.lastName + "'>");

			Iterator<Person> it1 = temp.child.iterator();
			while (it1.hasNext()) {
				Person temp1 = it1.next();
				pw.println("  <child name='" + temp1.name + "' lastName='"
						+ temp1.lastName + "' />");
			}
			pw.println("</person>");

			System.out.println();
		}
		pw.println("</people>");
		pw.flush();

	}
}
