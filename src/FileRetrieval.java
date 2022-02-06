import java.io.*;
import java.util.ArrayList;

public class FileRetrieval {
    public static ArrayList<Subscriber> readSubscriberFile() {
        ArrayList<Subscriber> subscribers = new ArrayList<>();
        try{
            FileInputStream readData = new FileInputStream("subscriberdata.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);
            ArrayList<Subscriber> subscribers2 = (ArrayList<Subscriber>) readStream.readObject();
            readStream.close();
            subscribers.addAll(subscribers2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return subscribers;
    }

    public static void saveSubscriberFile (ArrayList<Subscriber> subscribers){
        try{
            FileOutputStream writeData = new FileOutputStream("subscriberdata.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(subscribers);
            writeStream.flush();
            writeStream.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
