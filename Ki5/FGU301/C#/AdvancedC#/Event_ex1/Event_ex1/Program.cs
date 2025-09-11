using System;

namespace Event_ex1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Player player = new Player();
            UIManager uIManager = new UIManager();

            // Đăng ký sự kiện (không gọi hàm, chỉ trỏ tới hàm)
            player.leverUp += uIManager.PrintfEvent;
            player.leverUp += uIManager.PrintSkill;
            // Test: nhập EXP
            while (true)
            {
                Console.Write("Nhập EXP tăng: ");
                if (int.TryParse(Console.ReadLine(), out int exp))
                {
                    player.GainExp(exp);
                }
            }
        }
    }

    internal class Player
    {
        public int exp = 0;
        public int level = 1;

        public delegate void LeverUp(int newLevel);
        public event LeverUp leverUp;

        public void GainExp(int amount)
        {
            exp += amount;
            if (exp >= 100)
            {
                exp -= 100;
                level++;
                leverUp?.Invoke(level);
            }
        }
    }

    class UIManager
    {
        public void PrintfEvent(int newLevel)
        {
            Console.WriteLine("Player has reached a new level!"+newLevel);
        }
        public void PrintSkill(int newLevel)
        {
            if(newLevel == 3)
            {
                Console.WriteLine("[SKILL UNLICKED] Fireball");
            }
            if(newLevel == 5)
            {
                Console.WriteLine("[SKILL UNLICKED] Teleport");
            }
            
        }
    }
}
