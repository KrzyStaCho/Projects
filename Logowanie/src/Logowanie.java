import java.util.InputMismatchException;
import java.util.Scanner;

public class Logowanie
{
    boolean isFinish;
    Scanner scanner = new Scanner(System.in);
    DataBase dataBase = new DataBase();
    public static void main (String[] args)
    {
        Logowanie manager = new Logowanie();
        while (!manager.isFinish)
        {
            manager.Menu();
            manager.Wybor();
        }
    }
    public void Menu()
    {
        System.out.println("-----------------------");
        System.out.println("1.Logowanie");
        System.out.println("2.Zamknij Aplikacje");
        System.out.println("-----------------------");
    }
    public void Wybor()
    {
        System.out.print("Twój Wybór: ");
        switch(scanner.nextInt())
        {
            case 1:
            {
                if(Logowanie())
                {
                    GoodLogin();
                }
                break;
            }
            case 2:
            {
                isFinish=true;
                break;
            }
            default:
            {
                System.out.println("Niewłaściwa opcja!");
                break;
            }
        }
    }
    private boolean Logowanie()
    {
        System.out.println("==========================");
        System.out.print("Podaj Login: ");
        String login = scanner.next();
        System.out.print("Podaj Hasło: ");
        String password = scanner.next();
        System.out.println("==========================");
        Account tmp = new Account(login,password);
        if(dataBase.CompareAccount(tmp))
        {
            System.out.println("Prawidłowe hasło i login!");
            return true;
        }
        else
        {
            System.out.println("Nieprawidłowe hasło lub login");
            return false;
        }
    }
    private void GoodLogin()
    {
        boolean isGood=false;
        while(!isGood)
        {
            System.out.println("--------------------");
            System.out.println("Menu Użytkownika");
            System.out.println("=====================");
            System.out.println("1.Wyloguj");
            if (Account.UsingAccount.Type == TypeOfAccount.ADMINISTRATOR) {
                System.out.println("2.Utwórz konto");
                System.out.println("3.Usuń konto");
                System.out.println("4.Edytuj konto");
            }
            System.out.print("Twój Wybór: ");
            switch (scanner.nextInt()) {
                case 1:
                {
                    isGood = true;
                    break;
                }
                case 2:
                {
                    if (Account.UsingAccount.Type == TypeOfAccount.ADMINISTRATOR)
                    {
                        dataBase.list.add(Account.Create());
                    }
                    else
                    {
                        System.out.println("Niepoprawna opcja");
                        isGood=false;
                    }
                    break;
                }
                case 3:
                {
                    if (Account.UsingAccount.Type == TypeOfAccount.ADMINISTRATOR)
                    {
                        System.out.print("Podaj Login konta: ");
                        String login = scanner.next();
                        boolean isDelete=false;
                        Account deletedAccount=null;
                        for(Account account : dataBase.list)
                        {
                            if(account.Login.equals(login))
                            {
                                deletedAccount=account;
                                isDelete=true;
                                System.out.println("Pomyślnie usunięto!");
                            }
                        }
                        if(isDelete)
                        {
                            dataBase.list.remove(deletedAccount);
                        }
                        if(!isDelete)
                        {
                            System.out.println("Nie odnaleziono takiego konta");
                        }
                    }
                    else
                    {
                        System.out.println("Niepoprawna opcja");
                        isGood=false;
                    }
                    break;
                }
                case 4:
                {
                    if (Account.UsingAccount.Type == TypeOfAccount.ADMINISTRATOR)
                    {
                        System.out.print("Podaj Login konta: ");
                        String login = scanner.next();
                        boolean isEdit=false;
                        for(Account account : dataBase.list)
                        {
                            if(account.Login.equals(login))
                            {
                                dataBase.list.remove(account);
                                dataBase.list.add(Account.Create());
                                isEdit=true;
                                System.out.println("Zapisano zmiany!");
                            }
                        }
                        if(!isEdit)
                        {
                            System.out.println("Nie odnaleziono takiego konta");
                        }
                    }
                    else
                    {
                        System.out.println("Niepoprawna opcja");
                        isGood=false;
                    }
                    break;
                }
                default:
                {
                    System.out.println("Niepoprawna opcja");
                    isGood=false;
                    break;
                }
            }
        }
    }
}