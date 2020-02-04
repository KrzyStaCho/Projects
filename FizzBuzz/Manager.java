import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager
{
    private int m_N;
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        Manager manager = new Manager();
        manager.Start();
    }
    public void Start()
    {
        Choice();
        Count();
    }
    private void Choice()
    {
        try
        {
            System.out.print("Podaj liczbe: ");
            m_N = scanner.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Podana niepoprawny znak, prosze sprobowac jeszcze raz");
            scanner.next();
            Choice();
        }
        catch (Exception e)
        {
            System.out.println(e);
            scanner.next();
            Choice();
        }
    }
    private void Count()
    {
        for(int i=1; i<=m_N;i++)
        {
            if(i%3==0)
            {
                System.out.print("Fizz");
            }
            if(i%5==0)
            {
                System.out.println("Buzz");
            }
            else if(i%3!=0 && i%5!=0)
            {
                System.out.println(i);
            }
            else
            {
                System.out.println();
            }
        }
    }
}
