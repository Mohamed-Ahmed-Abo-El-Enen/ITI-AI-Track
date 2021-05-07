import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Player implements Runnable{

    public String Name;
    private boolean Cover;
    private boolean Alive;
    private int liveBar;
    private int Ammo;
    private List<Enemy> enemyList;
    private List<Thread> enemyThreads;

    Player(String Name, Enemy[] enemies, List<Thread> enemyThreads)
    {
        this.Name = Name;
        this.Alive = true;
        this.liveBar = 300;
        this.Ammo = 500;
        this.enemyList = Arrays.asList(enemies);
        this.enemyThreads = enemyThreads;
    }

    public boolean GetCoverState()
    {
        return this.Cover;
    }

    private int FireEnemy()
    {
        int numBullets = 0;
        if(this.Ammo > 0)
        {
            int maxBullets = Math.min(10, this.Ammo);
            numBullets = ThreadLocalRandom.current().nextInt(0, maxBullets);
            this.Ammo -= numBullets;
        }

        int enemyNum = 0;
        for(int i=0; i<this.enemyThreads.size(); i++)
        {
            if(this.enemyList.get(i).GetIsAlive() && this.enemyList.get(i).GetCoverState())
            {
                this.enemyList.get(i).SetIsHit();
                enemyNum = this.enemyList.get(i).getIdNum();
                this.enemyThreads.get(i).interrupt();
                this.enemyThreads.remove(i);
                break;
            }
        }
        return enemyNum;
    }

    void GetHit(int damage)
    {
        this.liveBar -= damage;
        if (this.liveBar <= 0)
            this.Alive = false;
    }

    public int getLiveBar()
    {
        return this.liveBar;
    }

    @Override
    public void run()
    {
        while(this.Alive || this.Ammo > 0)
        {
            if(!this.Alive)
                break;

            int enemyNum = FireEnemy();

            if(this.enemyThreads.size() == 0)
            {
                System.out.println("Player win and kill all enemies");
                break ;
            }

            if(enemyNum != 0)
                System.out.println("Player shoot enemy number : "+enemyNum);

            try
            {
                Thread.sleep(ThreadLocalRandom.current().nextInt(0, 1000));
                this.Cover = ThreadLocalRandom.current().nextBoolean();
            }
            catch (InterruptedException e)
            {
                System.out.println("Caught:" + e);
            }
        }
    }
}
