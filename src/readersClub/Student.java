
package readersClub;

/**
 *
 * @author Wilson Omokoro
 */
public class Student extends Members implements Readers {
    
    public String subjectOfInterest;
    
    public Student(String name, String sex, int age) {
        super(name, sex, age);
    }
    
    public String getSubjectOfInterest(){
       return this.subjectOfInterest; 
    }
    
    public boolean setSubjectOfInterest(String subject){
        this.subjectOfInterest = subject;
        
        return this.subjectOfInterest.equalsIgnoreCase(subject);
    }
    
    @Override
    public boolean requestForBook(){
        return true;
    }
}
