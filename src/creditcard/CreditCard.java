package creditcard;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class CreditCard {

    public static Set<Integer> bankAccountList = null;   // accounts list
    private BigDecimal deposit;

    public CreditCard(int bankAccountId, double firstInn) throws Exception {

        this.deposit = BigDecimal.valueOf(firstInn);
        if(bankAccountList == null){
            bankAccountList = new HashSet<>();
        }
        if(!bankAccountList.contains(bankAccountId)) {
            bankAccountList.add(bankAccountId);
        }else{
            throw new Exception("Existing account !!!");
        }
    }

    public void addMoney(double money){
        deposit = deposit.add(BigDecimal.valueOf(money));
    }

    public void getMoney(double money){
        deposit = deposit.subtract(BigDecimal.valueOf(money));
    }

    public void printAccount(int bankAccount){

        if(bankAccountList.contains(bankAccount)){
            System.out.println("On your account [ " + bankAccount + " ] is: " + deposit);
        }else{
            System.out.println("Not your account!");
        }


    }


}
