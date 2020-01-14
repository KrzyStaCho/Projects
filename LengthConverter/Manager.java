import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Podaj jaką wartość chcesz zmienić: ");
        String fromUnit = in.next();
        System.out.print("Podaj na jaką wartość chcesz zmienić: ");
        String toUnit = in.next();

        LengthConverter from = new LengthConverter(fromUnit);
        LengthConverter to = new LengthConverter(toUnit);

        System.out.print("Wartość: ");
        try
        {
            double value = in.nextDouble();

            double meters = from.toMeters(value);
            double converted = to.fromMeters(meters);

            System.out.println("Wynik: " + converted);
        }
        catch(InputMismatchException e)
        {
            System.out.println("Nie wpisano cyfry.");
        }
    }
}
