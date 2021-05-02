
import java.util.*;

public class CustomSalary {
    public static void main(String[] args) {
        int Customer_Item;
        int salary ;
        double tax ,sl;

        do{     
            Scanner sc = new Scanner(System.in);
            System.out.print("input Custom_Item : ");
            Customer_Item = sc.nextInt();
            System.out.print("input Salary: ");
            salary = sc.nextInt();
                 //                               true                  false
           sl = (double) ((salary > 2000) ? (tax = 0.20 * salary) : (tax = 0.30 * salary));
/*
     if(salary > 2000){
                tax = 0.20;
           }
           else{
               tax = 0.30;
           }*/
        }while(Customer_Item != 10);
       
       System.out.print("Show Result : " +  Math.round(sl)  + "\n");
       System.out.print("___________________________" );
       System.out.print("\n" );
    }
}
