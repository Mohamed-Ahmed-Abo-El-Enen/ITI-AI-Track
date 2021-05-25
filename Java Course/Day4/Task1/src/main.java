public class main
{
    public static void main(String args[])
    {
        String s1 = "val1";
        String s2 = "val2";
        BetterString bt = new BetterString();

        String res1 = bt.FindBetterString(s1, s2, (val1, val2) -> val1.length() > val2.length());
        System.out.println(res1);

        String res2 = bt.FindBetterString(s1, s2, BetterString::getBetterString);
        System.out.println(res2);

        String res3 = bt.FindBetterString(s1, s2, (val1, val2)->true);
        System.out.println(res3);
    }
}
