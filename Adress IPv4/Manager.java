import java.util.Scanner;

public class Manager
{
    NetworkAddressCalculation NAC;
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        Manager manager = new Manager();
        manager.Start();
    }
    public void Start()
    {
        try
        {
            System.out.print("Podaj Adres Hosta np.:(192.168.10.30): ");
            String AddressIP = scanner.next();
            System.out.print("Podaj Maske Sieci np.:(255.255.255.0): ");
            String NetMask = scanner.next();
            NAC = new NetworkAddressCalculation(AddressIP,NetMask);
            NAC.Start();
        }
        catch (Exception e)
        {
            System.err.println("Został wykryty błąd prosze powtórzyć!");
            System.out.println(e);
            Start();
        }
    }
}
