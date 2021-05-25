public class BetterString implements ITest {

    public static Boolean getBetterString(String s1, String s2)
    {
        return s1.length() > s2.length();
    }

    public String FindBetterString(String s1, String s2, ITest test)
    {
       return test.test(s1, s2) ? s1 : s2;
    }

    @Override
    public Boolean test(String s1, String s2)
    {
        return getBetterString(s1, s2);
    }
}
