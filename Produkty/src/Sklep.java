import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Scanner;

public class Sklep
{
    boolean isFinish;
    Scanner scanner;
    ArrayList<Produkty> list;
    public Sklep()
    {
        scanner = new Scanner(System.in);
        list = new ArrayList<>();
    }
    public static void main (String[] args)
    {
        Sklep manager = new Sklep();
        while(!manager.isFinish)
        {
            manager.Menu();
            manager.Wybor();
        }
    }
    public void Menu()
    {
        System.out.println("---------------------");
        System.out.println("1.Dodaj nowy produkt");
        System.out.println("2.Usuń produkt");
        System.out.println("3.Wyszukaj produkt");
        System.out.println("4.Edytuj Produkt");
        System.out.println("5.Złóż zamówienie");
        System.out.println("6.Zamknij Aplikacje");
        System.out.println("---------------------");
    }
    public void Wybor()
    {
        System.out.print("Twój wybór: ");
        switch(scanner.nextInt())
        {
            case 1:
            {
                NowyProdukt();
                break;
            }
            case 2:
            {
                UsunProdukt();
                break;
            }
            case 3:
            {
                WyszukajProdukt();
                break;
            }
            case 4:
            {
                EdytujProdukt();
                break;
            }
            case 5:
            {
                ZlozZamowienie();
                break;
            }
            case 6:
            {
                isFinish=true;
                break;
            }
            default:
            {
                System.out.println("Nieprawidłowa liczba");
                break;
            }
        }
    }
    private void NowyProdukt()
    {
        System.out.print("Podaj Nazwę produktu: ");
        String name = scanner.next();
        System.out.print("Podaj Tag produktu, lub wpisz 'untag' dla jego braku: ");
        String tag = scanner.next();
        System.out.print("Podaj Ilość produktu: ");
        int amount = scanner.nextInt();
        System.out.print("Podaj Cenę produktu: ");
        float price = scanner.nextFloat();
        price *= 100;
        price = Math.round(price);
        price /= 100;
        list.add(Produkty.Create(name,tag,amount,price));
        System.out.println("Produkt dodany pomyślnie!");
        System.out.println();
        Drukuj(list.get(list.size()-1));
    }
    private void Drukuj(Produkty produkt)
    {
        System.out.println("====================================");
        System.out.println("Produkt:");
        System.out.println("Nazwa: "+ produkt.getName());
        System.out.println("Tag: " + produkt.getTag());
        System.out.println("ID: " + produkt.getID());
        System.out.println("Ilość: " + produkt.getAmount() + "szt");
        System.out.println("Cena: " + produkt.getPrice() + "zł");
        System.out.println("====================================");
        System.out.println();
    }
    private void UsunProdukt()
    {
        System.out.print("Podaj ID produktu: ");
        String ID = scanner.next();
        for(Produkty produkty : list)
        {
            if(produkty.getID().equals(ID))
            {
                list.remove(produkty);
                System.out.println("Produkt usunięty!");
                return;
            }
        }
        System.out.println("Nie ma produktu o takim ID!");
    }
    private void WyszukajProdukt()
    {
        System.out.println("========================");
        System.out.println("1.Wyszukaj po tagu");
        System.out.println("2.Wyszukaj po ID");
        System.out.println("3.Pokaż wszystkie produkty");
        System.out.println("========================");
        System.out.print("Twój wybór: ");
        switch (scanner.nextInt())
        {
            case 1:
            {
                System.out.print("Podaj Tag produktu: ");
                String Tag = scanner.next();
                for(Produkty produkty : list)
                {
                    if(produkty.getTag().equals(Tag))
                    {
                        Drukuj(produkty);
                    }
                }
                break;
            }
            case 2:
            {
                System.out.print("Podaj ID produktu: ");
                String ID = scanner.next();
                for(Produkty produkty : list)
                {
                    if(produkty.getID().equals(ID))
                    {
                        Drukuj(produkty);
                        return;
                    }
                }
                System.out.println("Produkt nie znaleziony!");
                break;
            }
            case 3:
            {
                for(Produkty produkty : list)
                {
                    Drukuj(produkty);
                }
                break;
            }
            default:
            {
                System.out.println("Nie ma takiej opcji!");
                break;
            }
        }
    }
    private void EdytujProdukt()
    {
        System.out.print("Podaj ID produktu: ");
        String ID = scanner.next();
        for(Produkty produkty : list)
        {
            if(produkty.getID().equals(ID))
            {
                System.out.print("Podaj Nazwę produktu: ");
                String name = scanner.next();
                System.out.print("Podaj Tag produktu, lub wpisz 'untag' dla jego braku: ");
                String tag = scanner.next();
                System.out.print("Podaj Ilość produktu: ");
                int amount = scanner.nextInt();
                System.out.print("Podaj Cenę produktu: ");
                float price = scanner.nextFloat();
                price *= 100;
                price = Math.round(price);
                price /= 100;
                produkty.setName(name);
                produkty.setAmount(amount);
                produkty.setPrice(price);
                produkty.setTag(tag);
                Drukuj(produkty);
                System.out.println("Zapisano zmiany!");
                return;
            }
        }
        System.out.println("Nie ma produktu o takim ID!");
    }

    private void ZlozZamowienie()
    {
        float price=0f;
        boolean isReady;
        do {
            System.out.print("Podaj ID produktu: ");
            String ID = scanner.next();
            for(Produkty produkty : list)
            {
                if(produkty.getID().equals(ID))
                {
                    System.out.print("Podaj Ilość produktu: ");
                    int amount = scanner.nextInt();
                    if(produkty.getAmount()-amount<0)
                    {
                        System.out.println("Nie mamy takiej ilości! Dodam do zakupów to co mamy! Czyli " + produkty.getAmount() + "szt");
                        price += produkty.getAmount()*produkty.getPrice();
                        produkty.setAmount(0);
                    }
                    else
                    {
                        System.out.println("Dodano pomyślnie!");
                        produkty.setAmount(produkty.getAmount()-amount);
                        price += amount*produkty.getPrice();
                    }
                    break;
                }
            }
            do {
                boolean b = false;
                System.out.print("Czy chcą państwo dalej kontynuować zakupy? (Y/N): ");
                String odp = scanner.next();
                if(odp.equals("Y") || odp.equals("y"))
                {
                    isReady=false;
                    break;
                }
                else if(odp.equals("N") || odp.equals("n"))
                {
                    isReady=true;
                    break;
                }
                else
                {
                    System.out.println("Zła opcja. Prosze sprobowac jeszcze raz.");
                }
            }while(0==0);
        }while(!isReady);
        System.out.println("Twoje zakupy mają wartość " + price + "zł");
    }
}
