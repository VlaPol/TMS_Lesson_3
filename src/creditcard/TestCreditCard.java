package creditcard;

/**
 * Создать класс CreditCard c полями номер счета, текущая сумма на счету.
 * Добавьте метод, который позволяет начислять сумму на кредитную карточку.
 * Добавьте метод, который позволяет снимать с карточки некоторую сумму.
 * Добавьте метод, который выводит текущую информацию о карточке.
 * Напишите программу, которая создает три объекта класса CreditCard у
 * которых заданы номер счета и начальная сумма
 * Тестовый сценарий для проверки:
 * Положите деньги на первые две карточки и снимите с третьей.
 * Выведите на экран текущее состояние всех трех карточек.
 */
public class TestCreditCard {

    public static void main(String[] args) {

        try {
            CreditCard c1 = new CreditCard(111111111, 100);
            CreditCard c2 = new CreditCard(222222221, 200);
            CreditCard c3 = new CreditCard(331111259, 550.50);

            // Critical situations
            // CreditCard c4 = new CreditCard(111111111, 100); // some as c1 accountId
            // c4.addMoney(456);
            // c1.printAccount(99999);                         // if wrong account id

            c1.addMoney(120.20);
            c2.addMoney(150.33);
            c3.getMoney(50.25);

            c1.printAccount(111111111);
            c2.printAccount(222222221);
            c3.printAccount(331111259);

        }catch (Exception e){
            System.out.println("Something goes wrong: " + e.getMessage());
        }

    }
}
