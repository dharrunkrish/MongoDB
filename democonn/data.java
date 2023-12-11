
package democonn;

import org.bson.Document;


public class data {

    static void add(Document doc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private String name;
    private int age;
    private String city;   

   
    
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public data(String name,int age ,String city){
        this.name=name;
        this.age=age;
        this.city=city;
    }
    
    
}









//        String name = JOptionPane.showInputDialog("Enter your name");
//        String age = JOptionPane.showInputDialog("age");
//
//        mydata.delete(new data("dharrun", 23, "madurai"));
//        mydata.delete(new data("shyam", 21, "cbe"));
