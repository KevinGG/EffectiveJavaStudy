package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtility {
	/**
	 * Serializes and stores an object into a file.
	 * 
	 * @param object
	 *            to be serialized and stored
	 * @param fileName
	 *            of the storage file
	 * @throws IOException
	 *             if the object fails to be serialized or any output io
	 *             exception occurs
	 */
	public static void serialize(Object object, String fileName) throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(object);
		oos.close();
		fos.close();
	}

	/**
	 * Deserializes and restores an object from a file
	 * 
	 * @param fileName
	 *            of the file storing the object to be read and deserialized
	 * @return object deserialized from file
	 * @throws IOException
	 *             when any input io exception occurs
	 * @throws ClassNotFoundException
	 *             when class of the object to be deserialized cannot be found.
	 */
	public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object object = ois.readObject();
		ois.close();
		fis.close();
		return object;
	}
}
