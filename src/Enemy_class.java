public class Enemy_class extends Character
{
    Enemy_class(String[] info, int lv, boolean have_wing,  Accessory[] equipment, Weapon[] weapon_have, float[] stat, String[] word)
    {
        super(info, lv, have_wing, equipment, weapon_have, stat, word);
    }

    private int current_dialog = 0;

    @Override
    public void listen(int dialog_index, Character target)
    {
        if(dialog_index <= 13)
        {
            current_dialog  = dialog_index;
            talk(target);
        }
    }

    @Override
    public void talk(Character target) 
    {
        System.out.print("Monika : ");
        if(current_dialog <= 13)
        {
            System.out.println(word[0]+'\n');
            target.listen(0, this);
        }
        else
        {
            System.out.println(word[1]+'\n');
            target.listen(0, this);
        }
    }

    private float love_effect(float dmg)
    {
        return (float) (dmg/1000000);
    }

    @Override
    public float skill() 
    {
        return 0;
    }

    public float normal_attack() 
    {
        float dmg = (weapon.return_atk() + stat2[2]);
        return  love_effect(dmg);
    }

    public boolean is_lost()
    {
        System.out.println("She can't lost in this game\n");
        
        return false;
    }
}
