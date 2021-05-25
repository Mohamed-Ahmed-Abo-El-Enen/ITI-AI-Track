public class main
{
    public static boolean IsOnlyChars(String line)
    {
        return line!=null && !line.equals("") && line.chars().allMatch(Character::isLetter);
    }

    static public void main(String args[])
    {
        String[] arrayStrings = {"string1", "$tring" ,"str ing", "", null, "string"};
        for (String  val: arrayStrings)
        {
            System.out.println(IsOnlyChars(val));
        }
    }
}
