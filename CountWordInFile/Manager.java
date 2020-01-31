public class Manager
{
    public static void main(String[] args)
    {
        OutputFile outputFile = new OutputFile();
        outputFile.Start();
        System.out.println(outputFile.getNumberOfWord());
    }
}
