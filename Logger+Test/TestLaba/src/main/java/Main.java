import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  {
        WorkWithMass workWithMass=new WorkWithMass();
        int[] a={1,2,4,5,6,7,8,6,7};
        int b[]=workWithMass.chekAndSumAfterFor(a);

        System.out.println(workWithMass.checkOnOneOreTwo(a));
    }


}
