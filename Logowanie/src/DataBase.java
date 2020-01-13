import java.util.ArrayList;

public class DataBase
{
    public ArrayList<Account> list = new ArrayList<>();
    public DataBase()
    {
        list.add(new Account("Admin","admin", "Brak", TypeOfAccount.ADMINISTRATOR));
    }
    public boolean CompareAccount(Account account)
    {
        for(Account trueAccount : list)
        {
            if(Account.CompareAccount(trueAccount,account))
            {
                return true;
            }
        }
        return false;
    }
}
