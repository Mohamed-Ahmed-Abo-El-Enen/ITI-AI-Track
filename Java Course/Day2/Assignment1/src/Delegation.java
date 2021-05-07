public class Delegation
{
    public String countryName;
    private IParticipant[] Participant;

    public Delegation(String countryName)
    {
        this.countryName = countryName;
    }

    public void setDelegationParticipant(IParticipant[] Participant)
    {
        this.Participant = Participant;
    }

    public IParticipant[] getDelegationParticipant()
    {
        return Participant;
    }

    public void PrintParticipant()
    {
        for (IParticipant item:this.Participant)
        {
            if(item instanceof Player)
            {
                System.out.println("Player : " + item.getGameRepresentName());
            }
            else if(item instanceof Team)
            {
                System.out.println("Team : " + item.getGameRepresentName());
                ((Team) item).PrintTeamInfo();
            }                
        }
    }
}
