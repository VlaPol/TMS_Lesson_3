package atm;

import java.util.Scanner;

/**
 * Создать класс, описывающий банкомат.
 *    Набор купюр, находящихся в банкомате, должен задаваться тремя
 *    свойствами:
 *    количеством купюр номиналом 20, 50 и 100.
 *    Сделать метод для добавления денег в банкомат.
 *    Сделать функцию, снимающую деньги, которая принимает сумму денег, а
 *    возвращает булевое значение - успешность выполнения операции.
 *    При снятии денег функция должна распечатывать каким количеством
 *    купюр какого номинала выдаётся сумма.
 *    Создать конструктор с тремя параметрами - количеством купюр каждого
 *    номинала.
 */
public class AtmTest {

    public static void main(String[] args) {

        int key = 0;
        Scanner scanner = new Scanner(System.in);
        Atm atm = new Atm(2,3,5);

        System.out.println("В банкомате в текущий момент имеются следующие купюры");
        System.out.println(atm);
        System.out.println("*****************************************************\n");

        do {
            System.out.println("В банкомате в текущий момент имеются следующие купюры");
            System.out.println(atm);
            System.out.println("*****************************************************\n");
            System.out.println("Выберите действие: ");
            System.out.println("[1] Разместить банкноты в банкомате");
            System.out.println("[2] Изъять банкноты из банкомата");
            System.out.println("[0] Выход");

            key = scanner.nextInt();

            switch (key){
                case 1:
                    System.out.print("Введите количество 20-единичных купюр: ");
                    double tmpTwenty = scanner.nextDouble();
                    System.out.print("Введите количество 50-единичных купюр: ");
                    double tmpFifthy = scanner.nextDouble();
                    System.out.print("Введите количество 100-единичных купюр: ");
                    double tmpHundred = scanner.nextDouble();
                    atm.putMoney(tmpTwenty,tmpFifthy,tmpHundred);
                    break;
                case 2:
                    System.out.print("В настоящий момент в банкомате имеется сумма: " + Atm.currentSum);
                    System.out.print("\nУкажите необходимую для снятия сумму: ");

                    double tmpSum = scanner.nextDouble();

                    if(atm.getMoney(tmpSum)){
                        atm.returnedMoney(tmpSum);
                    }else{
                        System.out.println("В банкомате недостаточно денег!");
                    }
                    break;
                default:
                    System.out.println("Нет такой опции!");
                    break;
            }

        }while(key != 0);

    }

    private void accepyMoney(){

    }
}
