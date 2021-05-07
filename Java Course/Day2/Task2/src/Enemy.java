import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Enemy implements Runnable
{
    private int idNum;
    private boolean Cover;
    private boolean Alive;
    private int Ammo;
    private Player player;

    Enemy(int idNum)
    {
        this.idNum = idNum;
        this.Cover = this.Alive = true;
        this.Ammo = 100;
    }

    public int getIdNum()
    {
        return idNum;
    }

    public boolean GetCoverState()
    {
        return this.Cover;
    }

    public void SetIsHit()
    {
        this.Alive = false;
    }

    public boolean GetIsAlive()
    {
        return this.Alive;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    private int FirePlayer()
    {
        int damage = 0;
        if (!player.GetCoverState()) {
            damage = ThreadLocalRandom.current().nextInt(0, 100);
            this.player.GetHit(damage);
        }
       return damage;
    }

    @Override
    public void run()
    {
        while (this.Alive && this.Ammo > 0)
        {
            int numBullets = 0;
            if(this.Ammo > 0)
            {
                int maxBullets = Math.min(10, this.Ammo);
                numBullets = ThreadLocalRandom.current().nextInt(0, maxBullets);
                this.Ammo -= numBullets;
            }

            int playerDamage = FirePlayer();
            if(playerDamage != 0 && numBullets > 0)
                System.out.println("Enemy num "+this.idNum+" fire "+ numBullets +" bullets whit damage : "+playerDamage);

            if(this.player.getLiveBar() <= 0)
            {
                System.out.println("Enemy "+this.idNum+" kill the player");
                break;
            }

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
