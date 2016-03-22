
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
       System.out.print("Creating a new Readers' club member "+ name+"... ");
       Club.pauseProg(2);
       this.name = name;
       this.sex = sex;
       this.age = age;
       this.regDate = new Date();
       System.out.print("Done.\n");
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
    
    public String getRegistrationDate(){
        return regDate.toString();
    }
}