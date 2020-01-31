import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class OutputFile
{
    String FilePath;
    String Line;
    BufferedReader FileReader;
    Scanner scanner = new Scanner(System.in);
    int NumberOfWord=0;

    public OutputFile()
    {
        System.out.print("Podaj sciezke pliku: ");
        try
        {
            FilePath = scanner.next();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void Start()
    {
        try
        {
            FileReader = new BufferedReader(new FileReader(FilePath));
            while((Line = FileReader.readLine()) != null)
            {
                CountWordInLine();
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void CountWordInLine()
    {
        boolean i=false;
        for(char a : Line.toCharArray())
        {
            if(a!=' ')
            {
                i=true;
            }
            else if(a==' ' && i==true)
            {
                i=false;
                NumberOfWord++;
            }
        }
        if(i==true)
        {
            NumberOfWord++;
        }
    }

    public int getNumberOfWord() {
        return NumberOfWord;
    }
}
