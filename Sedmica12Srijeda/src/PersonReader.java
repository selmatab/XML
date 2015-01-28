import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PersonReader {
	public static void main(String[] args) throws SAXException, IOException,
			ParserConfigurationException {

		DocumentBuilder docReader = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document xmldoc = docReader.parse(new File("./toxml/people.xml"));
		NodeList xmlPeople = xmldoc.getElementsByTagName("person");
		LinkedList people = new LinkedList<Person>();

		for (int i = 0; i < xmlPeople.getLength(); i++) {
			xmlPeople.item(i);
			Node current = xmlPeople.item(i);
			if (current instanceof Element) {
				Element currentElement = (Element) current;
				String name = currentElement.getAttribute("name");
				String lastName = currentElement.getAttribute("surname");

				Person temp = new Person(name, lastName);
				NodeList xmlChildren = current.getChildNodes();
				for (int j = 0; j < xmlChildren.getLength(); j++) {
					Node child = xmlChildren.item(j);
					if (child instanceof Element) {
						Element currentElement1 = (Element) child;
						String nameChild = currentElement1.getAttribute("name");
						String lastNameChild = currentElement1
								.getAttribute("lastName");
						Person tempChild = new Person(nameChild, lastNameChild);
						temp.addChildren(tempChild);
					}
				}
				people.add(temp);

			}
		}

		Iterator<Person> it = people.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());

		}
	}
}
