public class Main_Character extends Character
{
    Main_Character(String[] info, int lv, boolean have_wing,  Accessory[] equipment, Weapon[] weapon_have, float[] stat, String[] word)
    {
        super(info, lv, have_wing, equipment, weapon_have, stat, word);
    }

    private int word_index = 0;

    @Override
    public void talk(Character target) 
    {
        System.out.print("Selena : ");
        System.out.println('\n'+super.word[word_index]);
        target.listen(word_index++, this);
    }

    @Override
    public void listen(int dialog_index, Character target) 
    {
        if(dialog_index == 1) System.out.println('\n'+super.word[14]+'\n');
        {
            System.out.print("Selena : ");
            System.out.println(word[14]+"\n\n");
            Game.end();
        }
    }

    @Override
    public float normal_attack() 
    {
        System.out.println("\nI can't hit her, not this time\n");
        return 0;    
    }

    @Override
    public float skill() {
        float dmg = weapon.skill(stat2[2]);
        
        if(dmg != 0) System.out.println("Serena didn't want to attack Monika, so she did nothing.\n");

        return 0;
    }

    @Override
    public boolean is_lost() {
        return (stat2[0] < 0);
    }
}
