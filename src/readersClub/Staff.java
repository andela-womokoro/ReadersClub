
package readersClub;

/**
 *
 * @author Wilson Omokoro
 */
public class Staff extends Members implements Readers {
    
    public int workHours;
    public double salary;
    
    public Staff(String name, String sex, int age) {
        super(name, sex, age);
    }
    
    public boolean setWorkHours(int newWorkHours){
        this.workHours = newWorkHours;
        
        return this.workHours == newWorkHours;
    }
    
    public double getSalary(){
        return 0.0;
    }
    
    @Override
    public boolean requestForBook(){
        return Club.borrowBook(this);
    }
}
