import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.LinkedList;

public class PersonTest {

	public static void main(String[] args) throws FileNotFoundException {

		Person me = new Person("Selma", "Tabakovic");
		Person you = new Person("Haris", "Arifovic");
		Person one = new Person("Niko", "Nikic");
		Person two = new Person("Buba", "Bubica");
		Person baby = new Person("Lala", "Moja");
		Person babyBoy = new Person("Jusuf", "Nurk");
		me.addChildren(baby);
		me.addChildren(babyBoy);

		System.out.println(me.toString());
		System.out.println(you.toString());
		System.out.println(one.toString());
		System.out.println(two.toString());

		LinkedList<Person> people = new LinkedList<Person>();
		people.add(me);
		people.add(you);
		people.add(one);
		people.add(two);
		System.out.println(people.toString());
		OutputStream os = new FileOutputStream("./toxml/people.xml");
		Person.persontoXML(people, os);

	}
}
