public class Account
{
    protected String Numer;
    protected long Pesel;
    protected String Imie;
    protected String Nazwisko;
    protected float Balance = 0.0f;
    protected static int LastNumber;
    protected String Type;

    protected static String GetNumber(int lastNumber)
    {
        String numer="94";
        int k = 11 - Integer.toString(lastNumber).length() - 2;
        for(int i=0;i<k;i++)
        {
            numer += "0";
        }
        numer += ++lastNumber;
        return numer;
    }

    public static void Print(Account account)
    {
        System.out.println("Konto " + account.Type);
        System.out.println("Numer: " + account.Numer);
        System.out.println("Imie: " + account.Imie);
        System.out.println("Nazwisko: " + account.Nazwisko);
        System.out.println("Pesel: " + account.Pesel);
        System.out.println("Stan Konta: " + account.Balance);
        System.out.println();
    }

    public static void ChangeBalance(Account account, float balance)
    {
        account.Balance += balance;
    }

    public static void TransferBalance(Account fromAccount, Account toAccount, float balance)
    {
        fromAccount.Balance -= balance;
        toAccount.Balance += balance;
    }
}
