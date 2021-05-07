public class IPCutter
{
    private String IP_str;
    private String[] ipToken;

    IPCutter()
    {
        CutIP("");
    }

    IPCutter(String IP_str)
    {
        CutIP(IP_str);
    }

    private void CutIP(String IP_str)
    {
        this.IP_str = IP_str;
        this.ipToken = IP_str.split("\\.");
    }

    public void setIpToken(String[] ipBlock) { this.ipToken = ipBlock; }

    public String[] getIpToken() { return this.ipToken; }

    public void PrintIPCutter(String IP_str)
    {
        try
        {
            if (this.IP_str.isEmpty())
                CutIP(IP_str);

            if(this.ipToken.length !=4)
                throw new Exception("Not in ip standard length");

            for (String item : this.ipToken)
                System.out.println(item);
        }
        catch (Exception ex)
        {
            System.out.println("Exception:\n"+ex.getMessage());
        }
    }
}
