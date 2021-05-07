import java.util.ArrayList;
import java.util.List;

public class Game
{
    private Player player;
    private Enemy[] enemies;
    private List<Thread> enemyThreads;

    Game(Enemy[] enemies)
    {
        setEnemies(enemies);
        this.player = new Player("Fuhrer", this.enemies, this.enemyThreads);
    }

    void setEnemies(Enemy[] enemies)
    {
        this.enemies = enemies;
        this.enemyThreads = new ArrayList<Thread>();

        for (Enemy en: this.enemies)
        {
            Thread enemyThread = new Thread(en);
            this.enemyThreads.add(enemyThread);
        }
    }

    public void StartGame()
    {
        Thread playerThread = new Thread(this.player);
        playerThread.start();

        for (Enemy en: this.enemies)
        {
            en.setPlayer(this.player);
        }

        for (Thread en: this.enemyThreads)
        {
            en.start();
        }
    }
}
