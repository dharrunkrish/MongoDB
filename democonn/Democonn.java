package democonn;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.awt.Component;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import org.bson.Document;
import java.util.ArrayList;

class Database {

    MongoDatabase db;
    MongoCollection<Document> col;

    public Database(String dbname, String colname) {
        try {

            MongoClient con = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            System.out.println("Database Connected");
            db = con.getDatabase(dbname);
            col = db.getCollection(colname);

        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Not connected");

        }
    }

    public void delete(data dt) {
        try {
            Document doc = new Document("name", dt.getName());
            col.deleteOne(doc);
            System.out.println("Deleted");
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println(" Not Deleted");
        }
    }

    public void add(data dt) {
        try {
            Document doc = new Document("name", dt.getName())
                    .append("age", dt.getAge())
                    .append("city", dt.getCity());
            col.insertOne(doc);
            System.out.println("Inserted");
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Not Inserted");

        }

    }

    public void addMany(ArrayList<data> dataList) {
        try {
            ArrayList<Document> data = new ArrayList<>();

            for (data dt : dataList) {
                Document doc = new Document("name", dt.getName())
                        .append("age", dt.getAge())
                        .append("city", dt.getCity());
                data.add(doc);
            }
            col.insertMany(data);
            System.out.println("Inserted many");
        } catch(Exception ex)  {
            System.out.println(ex);
            System.out.println("Not Inserted");
        }
    }   
}
public class Democonn {

    public static void main(String[] args) {
        Database mydata = new Database("Demo07", "incog");
        String input = JOptionPane.showInputDialog("Enter 1 to insert & 2 to Delete :");
        try {
            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1 -> {
                    String name = JOptionPane.showInputDialog("Enter your name");
                    int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
                    String city = JOptionPane.showInputDialog("Enter your city");
                    mydata.add(new data(name, age, city));
                    Component parentComponent = null;
                    JOptionPane.showMessageDialog(parentComponent, "Data Inserted");
                    break;
                }

                case 2 -> {
                    String name = JOptionPane.showInputDialog("Enter your name");
                    int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
                    String city = JOptionPane.showInputDialog("Enter you city");
                    mydata.delete(new data(name, age, city));
                    Component parentComponent = null;
                    JOptionPane.showMessageDialog(parentComponent, "Data Deleted");
                    break;
                }
                case 3->{
                    ArrayList<data> dataList=new ArrayList<>();
                    while(true){
                    String name = JOptionPane.showInputDialog("Enter your name");
                    int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
                    String city = JOptionPane.showInputDialog("Enter you city");                
                    dataList.add(new data(name, age, city));
                    mydata.addMany(dataList);
                    Component parentComponent = null;
                    JOptionPane.showMessageDialog(parentComponent, "Inserted Many");
                   
                    }

                }
                default ->
                    throw new AssertionError();
            }
        } catch (HeadlessException | NumberFormatException ex) {
            Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent, ex);
            JOptionPane.showInputDialog("Invalid input. please correct it.");
        }

    }
}
