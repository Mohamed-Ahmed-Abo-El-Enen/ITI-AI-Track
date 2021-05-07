public class main
{
    public static void main(String[] args) {

        Delegation egyptDelegation = new Delegation("Egypt");
        Delegation usaDelegation = new Delegation("USA");

        Coach egyCoach1 = new Coach(egyptDelegation, "game1","egyCoach1Name", "egyCoach1Address");
        Coach usaCoach1 = new Coach(usaDelegation, "game1", "usaCoach1Name", "usaCoach1Address");

        Player egyPlayer1 = new Player(egyptDelegation, "game1", "egyPlayer1Name",
                "egyPlayer1Address");
        Player egyPlayer2 = new Player(egyptDelegation, "game1", "egyPlayer2Name",
                "egyPlayer2Address");
        Player egyPlayer3 = new Player(egyptDelegation, "game2", "egyPlayer3Name",
                "egyPlayer3Address");

        Player usaPlayer1 = new Player(usaDelegation, "game1", "usaPlayer1Name",
                "usaPlayer1Address");
        Player usaPlayer2 = new Player(usaDelegation, "game2", "usaPlayer2Name",
                "usaPlayer2Address");

        IParticipant egyTeam = new Team(egyptDelegation, "game1", new Player[]{egyPlayer1, egyPlayer2},
                new Coach[]{egyCoach1});
        IParticipant usaTeam = new Team(usaDelegation, "game1", new Player[]{usaPlayer1, usaPlayer2},
                new Coach[]{usaCoach1});
        
        IParticipant[] egyptParticipant = new IParticipant[]{egyTeam, egyPlayer3};
        egyptDelegation.setDelegationParticipant(egyptParticipant);
        egyptDelegation.PrintParticipant();

        usaPlayer2.setMedal(Medal.Second);
        System.out.println(usaPlayer2.Name + " get " + usaPlayer2.getMedal());
        
        System.out.println(egyTeam.getGameRepresentName());
        System.out.println(egyTeam.getDelegation().countryName);
        
        
        System.out.println(usaCoach1.Name + " lead " + usaCoach1.getDelegation().countryName);
        
        usaCoach1.setCoachManage(new Player[]{usaPlayer1, usaPlayer2});
        usaCoach1.PrintCochLead();
    }
}
