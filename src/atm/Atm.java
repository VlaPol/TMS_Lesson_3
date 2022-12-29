package atm;

import java.math.BigDecimal;
import java.util.Arrays;

public class Atm {

    private double countTwentyNote;
    private double countFiftyNote;
    private double countOneHundredNote;

    private BigDecimal curentTwentyNote;
    private BigDecimal curentFiftyNote;
    private BigDecimal curentOneHundredNote;

    public static BigDecimal currentSum;

    public Atm(double quantTwentyNote, double quantFiftyNote, double quantOneHundredNote) {
        countTwentyNote = quantTwentyNote;
        countFiftyNote = quantFiftyNote;
        countOneHundredNote = quantOneHundredNote;

        curentTwentyNote = BigDecimal.valueOf(countTwentyNote*20);
        curentFiftyNote = BigDecimal.valueOf(countFiftyNote*50);
        curentOneHundredNote = BigDecimal.valueOf(countOneHundredNote*100);

        currentSum = currentMoney();
    }

    public void putMoney(double addTwentyNote, double addFiftyNote, double addOneHundredNote){

        countTwentyNote += addTwentyNote;
        countFiftyNote += addFiftyNote;
        countOneHundredNote += addOneHundredNote;

        curentTwentyNote = curentTwentyNote.add((BigDecimal.valueOf(addTwentyNote * 20)));
        curentFiftyNote = curentFiftyNote.add(BigDecimal.valueOf(addFiftyNote * 50));
        curentOneHundredNote = curentOneHundredNote.add(BigDecimal.valueOf(addOneHundredNote * 100));
        currentSum = currentMoney();

    }

    public boolean getMoney(double neededMoney){
        return (currentSum.subtract(BigDecimal.valueOf(neededMoney))).compareTo(BigDecimal.ZERO) >= 0;
    }

    private BigDecimal currentMoney(){
        return curentTwentyNote.add(curentFiftyNote).add(curentOneHundredNote);
    }

    @Override
    public String toString() {
        return "\t20-единичных купюр: \t" + (int)countTwentyNote + "\n" +
                "\t50-единичных купюр: \t" + (int)countFiftyNote + "\n" +
                "\t100-единичных купюр:\t" + (int)countOneHundredNote + "\n";
    }

    public void returnedMoney(double neededMoney) {

        int digits = (int)Math.ceil(Math.log10(neededMoney));
        int [] digitArray = new int[digits-1];
        double tmpNeededMoney = neededMoney;

        if(neededMoney < 100 && neededMoney != 50){
            if(neededMoney % 20 == 0 && neededMoney / 20 <= countTwentyNote) {
                System.out.println("Сумма будет выдана " + (int)(neededMoney / 20) + " 20-единичными купюрами");
            }else{
                System.out.println("Нет нужных купюр!");
            }
        }else if(neededMoney == 50){
            System.out.println("Сумма будет выдана " + (int)(neededMoney / 50) + " 50-единичной купюрой");
        }else if(neededMoney == 100 && countOneHundredNote > 1){
            System.out.println("Сумма будет выдана " + (int)(neededMoney / 50) + " 50-единичными купюрами");
        }else {

            for(int i = digits - 2; i >= 0; i--){
                digitArray[i] = (int)neededMoney % 100;
                neededMoney = (int)neededMoney / 100;
            }

            int i = 0;

            if(digitArray[i] <= countOneHundredNote && (digitArray[i+1] % 20 == 0)) {
                if(digitArray[i+1] / 20 <= countTwentyNote) {
                    System.out.println("Сумма будет выдана " + digitArray[i] + " 100-единичными купюрами и " +
                            (int) digitArray[i + 1] / 20 + " 20-единичными купюрами");
                }else{
                    System.out.println("Нет возможности выдать сумму");
                }
            }else if(digitArray[i] > countOneHundredNote &&
                    (tmpNeededMoney - countOneHundredNote * 100) / 50 <= countFiftyNote &&
                    (digitArray[i+1] % 20 == 0 )){
                System.out.println("Сумма будет выдана " + (int)countOneHundredNote + " 100-единичными купюрами и "
                        + (int)(tmpNeededMoney - countOneHundredNote * 100) / 50 + " 50-единичными купюрами и " +
                        (int) digitArray[i + 1] / 20 + " 20-единичными купюрами");
            }else if(digitArray[i] > countOneHundredNote &&
                    digitArray[i] / 50 > countFiftyNote &&
                    tmpNeededMoney/20 <= countTwentyNote){
                System.out.println("Сумма будет выдана " + tmpNeededMoney / 20 + " 20-единичными купюрами");
            }else {
                System.out.println("Нет возможности выдать сумму");
            }
        }






        System.out.println(Arrays.toString(digitArray));


    }
}
