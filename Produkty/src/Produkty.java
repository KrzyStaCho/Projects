public class Produkty {
    private String Name;
    private String Tag;
    private int Amount;
    private float Price;
    private String ID;
    private static int lastNumber;

    public Produkty(String name, String tag, int amount, float price) {
        Name = name;
        Tag = tag;
        Amount = amount;
        Price = price;
        ID = GetID();
    }

    public static Produkty Create(String name, String tag, int amount, float price) {
        return new Produkty(name, tag, amount, price);
    }

    private String GetID() {
        String number = "";
        int k = 3 - Integer.toString(lastNumber).length();
        for (int i = 0; i < k; i++) {
            number += "0";
        }
        number += ++lastNumber;
        System.out.println(number);
        return number;
    }

    public String getName() {
        return Name;
    }

    public String getTag() {
        return Tag;
    }

    public int getAmount() {
        return Amount;
    }

    public float getPrice() {
        return Price;
    }

    public String getID() {
        return ID;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public void setTag(String tag) {
        Tag = tag;
    }
}
