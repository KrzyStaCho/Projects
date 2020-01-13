import java.util.Scanner;

public class Account
{
    String Login;
    String Password;
    String Tip;
    TypeOfAccount Type;
    public static Account UsingAccount;

    public Account(String login, String password, String tip, TypeOfAccount type)
    {
        Login = login;
        Password = password;
        Tip = tip;
        Type = type;
    }
    public Account(String login, String password)
    {
        Login = login;
        Password = password;
    }
    public static Account Create()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj Login: ");
        String login = scanner.next();
        System.out.print("Podaj Hasło: ");
        String password = scanner.next();
        System.out.print("Podaj Wskazówkę: ");
        String tip = scanner.next();
        System.out.print("Podaj Typ Konta (Admin/Standart): ");
        String tmp = scanner.next();
        TypeOfAccount type = TypeOfAccount.STANDART;
        if(tmp.toLowerCase().equals("admin"))
        {
            type = TypeOfAccount.ADMINISTRATOR;
        }
        else if(tmp.toLowerCase().equals("standart"))
        {
            type = TypeOfAccount.STANDART;
        }
        else
        {
            boolean isGood=false;
            while(!isGood)
            {
                System.out.println("Zła opcja! Prosze powtorzyc");
                tmp = scanner.next();
                if(tmp.toLowerCase().equals("admin"))
                {
                    type = TypeOfAccount.ADMINISTRATOR;
                    isGood = true;
                }
                else if(tmp.toLowerCase().equals("standart"))
                {
                    type = TypeOfAccount.STANDART;
                    isGood = true;
                }
            }
        }
        return new Account(login,password,tip,type);
    }
    public static boolean CompareAccount(Account firstAccount, Account secondAccount)
    {
        boolean isGood=true;
        isGood = (firstAccount.Login.equals(secondAccount.Login)) ? true : false;
        if(!isGood)
            return false;
        isGood = (firstAccount.Password.equals(secondAccount.Password)) ? true : false;
        if(!isGood)
            return false;
        UsingAccount = firstAccount;
        return true;
    }
}
