public class WorkWithMass {
    public  int[] chekAndSumAfterFor(int[] MassChek){
        int flagWereIsFor = 0;
        int[] newMassVerified;
        int i2=0;
        for(int i=MassChek.length-1;i>=0;i--){

            String  a="d";
            if(MassChek[i]==4){
                flagWereIsFor=i2;
                break;
            }
            i2++;
        }
        if(flagWereIsFor==0){
            throw new RuntimeException("ss");
        }else{
            newMassVerified=new int[flagWereIsFor];
            int FlagMirrow=MassChek.length-flagWereIsFor;
            for(int i3=0;i3<flagWereIsFor;i3++){
                newMassVerified[i3]=MassChek[FlagMirrow+i3];
            }
        }



        //int[] newMassVerified=new int[4];
        return newMassVerified;
    }
    public  boolean checkOnOneOreTwo(int[] input){
        boolean Flag=false;
        for(int i=0;i<input.length;i++){
            if(input[i]==1 || input[i]==4){
                Flag=true;
            }
        }


        return Flag;
    }
}
