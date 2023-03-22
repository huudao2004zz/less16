import java.io.*;
import java.util.Date;

public class ReadWriteObject {

    public static void main(String[] args) {
        Date currentDate = new Date();
        //write object
        ObjectOutputStream oss = null;
        try {
            oss = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("object.dat")));
            //write a String object
            oss.writeObject("The current Date and Time");
            oss.writeObject(new Date());

            System.out.printf("object writed!");
            oss.flush();
            oss.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        //read object
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object obj = ois.readObject();
            if (obj instanceof String) {
                System.out.printf("the string read from file: " + obj);
                Date d = (Date) ois.readObject();
                System.out.printf("the date read from file: " + d);
            } else if (obj instanceof Date) {
                Date d = (Date) obj;
                System.out.printf("the date read from file: " + d);
            }
            ois.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}