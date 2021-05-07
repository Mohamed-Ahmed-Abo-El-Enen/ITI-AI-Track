public interface IParticipant
{
    public void setGameRepresentName(String gameRepresent);
    public String getGameRepresentName();

    public void setDelegation(Delegation countryDelegation);
    public Delegation getDelegation();

    public void setMedal(Medal Medals);
    public Medal getMedal();
}
