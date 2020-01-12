import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank
{
    ArrayList<Account> tab =new ArrayList<>();
    int lastNumber = 0;
    public boolean isWork=true;
    public static void main(String[] args)
    {
        Bank manager = new Bank();
        while(manager.isWork)
        {
            manager.Menu();
            manager.Wybor();
        }
    }

    public void Menu()
    {
        System.out.println("---------------------------");
        System.out.println("1.Zalóż konto Rozliczeniowe");
        System.out.println("2.Załóż konto Oszczednosciowe");
        System.out.println("3. Pokaż konta Bankowe");
        System.out.println("4. Przelewy na/z konta Bankowego");
        System.out.println("5. Zakoncz miesiac");
        System.out.println("6. Zamknij Aplikacje");
        System.out.println("---------------------------");
    }

    public void Wybor()
    {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt())
        {
            case 1:
            {
                tab.add(Rozliczeniowe.CreateAccount());
                lastNumber++;
                break;
            }
            case 2:
            {
                tab.add(Oszczednosciowe.CreateAccount());
                lastNumber++;
                break;
            }
            case 3:
            {
                System.out.print("Podaj Imie: ");
                String imie = scanner.next();
                System.out.print("Podaj Nazwisko: ");
                String nazwisko = scanner.next();
                System.out.print("Podaj Pesel: ");
                long pesel = scanner.nextLong();
                for(Account account : tab)
                {
                    if(account.Imie.equals(imie) && account.Nazwisko.equals(nazwisko) && account.Pesel == pesel)
                    {
                        Account.Print(account);
                    }
                }
                break;
            }
            case 4:
            {
                Option4();
                break;
            }
            case 5:
            {
                for(Account account : tab)
                {
                    if(account.Type.equals("Rozliczeniowe"))
                    {
                        Account.ChangeBalance(account,-10);
                    }
                    else
                    {
                        float balance = account.Balance;
                        balance = balance/50;
                        balance *= 100;
                        balance = Math.round(balance);
                        balance /= 100;
                        Account.ChangeBalance(account,balance);
                    }
                }
                break;
            }
            case 6:
            {
                isWork = false;
                break;
            }
            default:
            {
                System.out.println("Nieprawidłowa liczba");
                isWork = false;
                break;
            }
        }
    }

    public void Option4()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj Numer Konta Bankowego: ");
        String numer = scanner.next();
        for(Account account : tab)
        {
            if(account.Numer.equals(numer))
            {
                System.out.println("-------------------------");
                System.out.println("1.Przelew na Konto");
                System.out.println("2.Przelew z Konta");
                System.out.println("--------------------------");

                switch(scanner.nextInt())
                {
                    case 1:
                    {
                        System.out.print("Podaj ile chcesz przelać na konto: ");
                        Account.ChangeBalance(account,scanner.nextInt());
                        break;
                    }
                    case 2:
                    {
                        System.out.println("-----------------------");
                        System.out.println("1.Przelew na konto");
                        System.out.println("2. Wyciagnij pieniadze");
                        System.out.println("--------------------------");

                        switch(scanner.nextInt())
                        {
                            case 1:
                            {
                                System.out.print("Podaj Numer konta: ");
                                String iNumer = scanner.next();
                                for(Account account1 : tab)
                                {
                                    if(account1.Numer.equals(iNumer))
                                    {
                                        System.out.print("Ile chcesz przesłać: ");
                                        Account.TransferBalance(account,account1,scanner.nextInt());
                                    }
                                }
                                break;
                            }
                            case 2:
                            {
                                System.out.print("Ile chcesz wypłacic: ");
                                int balance = scanner.nextInt();
                                Account.ChangeBalance(account,-balance);
                                break;
                            }
                            default:
                            {
                                System.out.println("Nieprawidłowa liczba");
                                isWork = false;
                                break;
                            }
                        }
                        break;
                    }
                    default:
                    {
                        System.out.println("Nieprawidłowa liczba");
                        isWork = false;
                        break;
                    }
                }
            }
        }
    }
}
