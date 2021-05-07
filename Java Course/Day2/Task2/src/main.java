public class main
{
    public static void main(String[] args)
    {
        Enemy[] enemies = new Enemy[] {new Enemy(1), new Enemy(2), new Enemy(3)};
        Game game = new Game(enemies);
        game.StartGame();
    }
}
