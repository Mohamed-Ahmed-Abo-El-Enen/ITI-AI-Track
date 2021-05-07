public class Player extends Person implements IParticipant
{
    private Medal Medals;
    private String gameRepresent;
    private Delegation countryDelegation;

    Player(Delegation countryDelegation, String gameRepresent, String playerName, String playerAddress)
    {
        super(playerName, playerAddress);
        setGameRepresentName(gameRepresent);
        setDelegation(countryDelegation);
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
        this.Medals = Medals;
    }

    @Override
    public Medal getMedal() {
        return this.Medals;
    }
}
