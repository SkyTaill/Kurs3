import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class MainTest {
    private static WorkWithMass workWithMass;
    @BeforeClass
    public static void initTest(){
       workWithMass=new WorkWithMass();
        System.out.println("init");
    }
    @AfterClass
    public static void destroy(){
        workWithMass=null;
    }
    @Test
    public void testChekAndSumAfterFor(){
        int [] testArr={1,2,4,5,6};
        int [] testArr2={1,2,4,2,1,5};
        int [] answerOnTest={5,6};
        int [] answerOnTest2={2,1,5};
     int [] arr=workWithMass.chekAndSumAfterFor(testArr);
        int [] arr2=workWithMass.chekAndSumAfterFor(testArr2);
        Assert.assertArrayEquals(answerOnTest,arr);
        Assert.assertArrayEquals(answerOnTest2,arr2);

    }
    @Test(expected = RuntimeException.class)
    public void test() throws RuntimeException {
        int [] testArr={1,2,5,6};

        Assert.assertEquals("ss",workWithMass.chekAndSumAfterFor(testArr));
    }
    @Test
    public void testCheckOnOneOreTwo(){
        int [] testArr={1,4,5,8,6,5};
        int [] testArr2={5,8,6,5};
        Assert.assertEquals(true,workWithMass.checkOnOneOreTwo(testArr));
        Assert.assertEquals(false,workWithMass.checkOnOneOreTwo(testArr2));
    }



}
