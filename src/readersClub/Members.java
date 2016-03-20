
package readersClub;

import java.util.Date;
/**
 *
 * @author Wilson Omokoro
 */
public abstract class Members {
    
    public String name;
    public String sex;
    public int age;
    public Date regDate;
    
    public Members(String name, String sex, int age){
       System.out.println("Creating a new member...");
       this.name = name;
       this.sex = sex;
       this.age = age;
       this.regDate = new Date();
    }
    
    public String getName(){
        return name;
    }
    
    public String getSex(){
        return sex;
    }
    
    public int getAge(){
        return age;
    }
}