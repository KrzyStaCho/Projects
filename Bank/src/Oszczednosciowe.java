import java.util.Scanner;

public class Oszczednosciowe extends Account
{
    public Oszczednosciowe(long pesel, String imie, String nazwisko)
    {
        Type = "Oszczednosciowe";
        Numer = GetNumber(Account.LastNumber);
        Account.LastNumber++;
        Pesel = pesel;
        Imie = imie;
        Nazwisko = nazwisko;
    }

    public static Oszczednosciowe CreateAccount()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj Imie: ");
        String imie = scanner.next();
        System.out.print("Podaj Nazwisko: ");
        String nazwisko = scanner.next();
        System.out.print("Podaj Pesel: ");
        long pesel = scanner.nextLong();
        System.out.println();

        Oszczednosciowe account = new Oszczednosciowe(pesel,imie,nazwisko);
        return account;
    }
}
