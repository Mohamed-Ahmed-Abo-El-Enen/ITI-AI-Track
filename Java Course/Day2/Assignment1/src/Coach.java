public class Coach extends Person
{
    private IParticipant[] Participant;
    private Delegation _Delegation;
    private String gameRepresent;
    Coach(Delegation delegation, String gameRepresent, String coachName, String coachAddress)
    {
        super(coachName, coachAddress);
        this._Delegation = delegation;
        this.gameRepresent = gameRepresent;
    }
    
    void setCoachManage(IParticipant[] participant)
    {
        this.Participant = participant;
    }
    
    public Delegation getDelegation()
    {
        return this._Delegation;
    }
    
    public void PrintCochLead()
    {
        System.out.println(Name + " Lead "+this.gameRepresent + " Game");
        for (IParticipant item:this.Participant)
        {
            if(item instanceof Player)
            {
                System.out.println("Lead Player : " + ((Player) item).Name);
            }
            else if(item instanceof Team)
            {
                System.out.println("Lead Team : " + item.getGameRepresentName());
                ((Team) item).PrintTeamInfo();
            }                
        }
    }
    
}
