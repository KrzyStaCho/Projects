import java.util.Scanner;

public class Rozliczeniowe extends Account
{
    public Rozliczeniowe(long pesel, String imie, String nazwisko)
    {
        Type = "Rozliczeniowe";
        Numer = GetNumber(Account.LastNumber);
        Account.LastNumber++;
        Pesel = pesel;
        Imie = imie;
        Nazwisko = nazwisko;
    }

    public static Rozliczeniowe CreateAccount()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj Imie: ");
        String imie = scanner.next();
        System.out.print("Podaj Nazwisko: ");
        String nazwisko = scanner.next();
        System.out.print("Podaj Pesel: ");
        long pesel = scanner.nextLong();
        System.out.println();

        Rozliczeniowe account = new Rozliczeniowe(pesel,imie,nazwisko);
        return account;
    }
}
