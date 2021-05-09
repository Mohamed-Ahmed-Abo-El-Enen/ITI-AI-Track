public class main
{
    public static void main(String args[])
    {
        ConsoleRead consoleRead = new ConsoleRead();
        consoleRead.PrintStoppingKeyword();
        while (!consoleRead.Reading())
        { }

        if(consoleRead.getLines().size() > 0)
        {
            FileHandler fileHandler = new FileHandler();
            fileHandler.WriteLines(consoleRead.getLines());
        }
    }
}
