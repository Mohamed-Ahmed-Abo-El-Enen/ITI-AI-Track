public class Team implements IParticipant
{
    private Medal Medals;
    private Delegation countryDelegation;
    private String gameRepresent = "";
    private Player[] teamPlayers;
    private Coach[] teamCoach;

    Team(Delegation countryDelegation, String gameRepresent, Player[] teamPlayers, Coach[] teamCoach)
    {
        setGameRepresentName(gameRepresent);
        setDelegation(countryDelegation);
        this.teamPlayers = teamPlayers;
        this.teamCoach = teamCoach;
    }

    @Override
    public void setGameRepresentName(String gameRepresent) {
        this.gameRepresent = gameRepresent;
    }

    @Override
    public String getGameRepresentName() {
        return gameRepresent;
    }

    @Override
    public void setDelegation(Delegation countryDelegation) {
        this.countryDelegation = countryDelegation;
    }

    @Override
    public Delegation getDelegation() {
        return this.countryDelegation;
    }

    @Override
    public void setMedal(Medal Medals) {

    }

    @Override
    public Medal getMedal() {
        return null;
    }

    public void PrintTeamInfo()
    {
        for (Coach item: this.teamCoach) {
            System.out.println("Coach Name : "+ item.Name);
        }

        for (Player item: this.teamPlayers) {
            System.out.println("Player Name : "+ item.Name);
        }
    }
}
