import javax.swing.*;

public class Calculator {
    public static void main(String[] args)
    {
        if(args.length!=2)
        {
            System.out.println("Prosze podać prawidłowe parametry:");
            System.out.println("Waga (kg)");
            System.out.println("Wzrost (metry)");
        }
        else
        {
            double waga = Double.parseDouble(args[0]);
            double wzrost = Double.parseDouble(args[1]);
            double BodyMassIndex = waga/(wzrost*wzrost);
            System.out.print("Twój wskażnik masy ciała (BMI) to ");
            System.out.println(BodyMassIndex);
            if(BodyMassIndex<18.5)
            {
                System.out.println("Niestety jesteś niedożywiony!");
            }
            else if(BodyMassIndex>25)
            {
                System.out.println("Niestety masz nadwagę!");
            }
            else
            {
                System.out.println("Raduj się, jesteś całkowicie zdrowy!");
            }
        }
    }
}
