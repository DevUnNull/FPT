using System.Linq.Expressions;

namespace leet_code4
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.OutputEncoding = System.Text.Encoding.UTF8;
            string input;
            PlayerLevel player = new PlayerLevel();
            
            Shop shop = new Shop(100);
            LootDrop lootDrop = new LootDrop(shop);

            PlayerHeal playerHeal = new PlayerHeal(100, 10);
            EnemyHeal enemyHeal = new EnemyHeal(10, 2);

            // Sau khi tạo xong mới gán reference
            playerHeal.SetEnemy(enemyHeal);
            enemyHeal.SetPlayer(playerHeal);

            Quest quest = new Quest("First",2);

            List<Account> leaderboard = new List<Account>();

            TimeGame timeGame = new TimeGame(10);
            
            timeGame.Countdown();

            while (true)
            {
                Console.WriteLine();
                Console.WriteLine("- Press e to pust exp");
                Console.WriteLine("- Press l to roll : 10 god");
                Console.WriteLine("- Press s to go Store");
                Console.WriteLine("- Press P to Play game");
                Console.WriteLine("- Press b to show leaderboard");
                input = Console.ReadLine();
                if (input == "e")
                {
                    player.GainExp(50);
                }else if (input =="l")
                {
                    lootDrop.GetRandomItem(10);
                }else if (input == "s")
                {
                    Console.WriteLine();
                    Console.WriteLine("well come to my store !!!");
                    Console.WriteLine("1, Sword : 10 God ");
                    Console.WriteLine("2, Shield : 20 God ");
                    Console.WriteLine("3, Armor : 30 God");
                    Console.WriteLine("Current my good :"+shop.Gold);
                    string inputStore = Console.ReadLine();
                    switch (inputStore)
                    {
                        case "1":
                            shop.Buy("1");
                            break;
                        case "2":
                            shop.Buy("2");
                            break;
                        case "3":
                            shop.Buy("3");
                            break;
                        default:
                            // lệnh khi không khớp case nào
                            break;
                    }
                }
                else if (input == "p")
                {
                    while (playerHeal.Hp > 0 && enemyHeal.Hp > 0)
                    {
                        Console.WriteLine();
                        Console.WriteLine("FIGHT TIME!!!");
                        Console.WriteLine("1 to attack Player ");
                        Console.WriteLine("2 to attack Enemy ");
                        string inputFight = Console.ReadLine();
                        switch (inputFight)
                        {
                            case "1":
                                playerHeal.CalculateHP();
                                break;
                            case "2":
                                enemyHeal.CalculateHP();
                                break;
                            default:
                                Console.WriteLine("Invalid input");
                                break;
                        }
                    }

                    if (enemyHeal.Hp <= 0)
                    {
                        Console.WriteLine("🎉 You Win!!!");
                        quest.CompleteStep();

                        Console.Write("Press your name: ");
                        string name = Console.ReadLine();

                        var existing = leaderboard.FirstOrDefault(x => x.Name == name);
                        if (existing != null)
                        {
                            existing.Score += 1;
                        }
                        else
                        {
                            leaderboard.Add(new Account(name, 1));
                        }

                        enemyHeal.Hp = 2;
                    }

                    else if (playerHeal.Hp <= 0)
                    {
                        Console.WriteLine("💀 You Lose...");
                    }
                }else if (input == "b")
                {
                    Console.WriteLine("\n🏆 TOP 5 player have high core 🏆");

                    var top5 = leaderboard
                        .OrderByDescending(x => x.Score)
                        .Take(5);

                    int rank = 1;
                    foreach (var acc in top5)
                    {
                        Console.WriteLine($"{rank}. {acc.Name} – {acc.Score} Core");
                        rank++;
                    }

                    if (!top5.Any())
                    {
                        Console.WriteLine("❗ None player.");
                    }
                }

            }
        }
    }
    internal class TimeGame
    {
        public int Time;

        public TimeGame(int Time)
        {
            this.Time = Time;
        }

        public void Countdown()
        {
            Console.Clear();

            string[] dots = { ".", "..", "..." };
            string[] icon = { "🕛", "🕒", "🕕", "🕘" };
            for (int i = 0; i < Time; i++)
            {
                Console.SetCursorPosition(0, 1); // Ghi đè dòng thứ 2
                Console.Write(icon[i%icon.Length] +" Loading game" + dots[i % dots.Length] + "   "); // thêm "   " để xoá dấu cũ
                Thread.Sleep(500);
            }

            Console.SetCursorPosition(0, 2);
            Console.WriteLine("🔥 Start GAME!");
        }
    }


    internal class Account
    {
        public string Name { get; set; }
        public int Score { get; set; }

        public Account(string name, int score)
        {
            Name = name;
            Score = score;
        }
    }


    internal class OnTopCore
    {

    }


    internal class Quest
    {
        public string Description { get; set; }
        public int Goal { get; set; }
        public int Progress { get; set; }
        public bool IsCompleted { get; set; }

        public Quest(string Description, int Goal) 
        { 
            this.Description = Description;
            this.Goal = Goal;   
            this.Progress = 0;
            this.IsCompleted = false;
        }

        public void CompleteStep()
        {
            if (IsCompleted)
            {
                Console.WriteLine($"Mission accomplished");
                return;
            }

            this.Progress++;
            Console.WriteLine($"Progress: {Progress}/{Goal}");
            if (Progress >= Goal)
            {
                IsCompleted = true;
                Console.WriteLine($"✅ Success Quest: {Description}!");
            }
        }
    }

    internal class PlayerLevel
    {
        public int level;
        public int exp;
        public PlayerLevel()
        {

        }

        public void GainExp(int plustExp)
        {
            this.exp += plustExp;
            Console.WriteLine("Current exp: " + this.exp);
            if (this.exp >= 100)
            {
                this.level++;
                this.exp = 0;
                Console.WriteLine("Current level :" + this.level);
            }
        }
    }
    internal class PlayerHeal
    {
        public int Hp;
        public int Damage;
        private EnemyHeal enemy;

        public PlayerHeal(int Hp, int Damage)
        {
            this.Hp = Hp;
            this.Damage = Damage;
        }

        public void SetEnemy(EnemyHeal enemy)
        {
            this.enemy = enemy;
        }

        public void CalculateHP()
        {
            this.Hp -= enemy.Damage;
            if (this.Hp <= 0)
                this.Hp = 0;

            Console.WriteLine("Current Player Hp: " + this.Hp);
        }
    }


    internal class EnemyHeal
    {
        public int Hp;
        public int Damage;
        private PlayerHeal player;

        public EnemyHeal(int Hp, int Damage)
        {
            this.Hp = Hp;
            this.Damage = Damage;
        }

        public void SetPlayer(PlayerHeal player)
        {
            this.player = player;
        }

        public void CalculateHP()
        {
            this.Hp -= player.Damage;
            if (this.Hp <= 0)
                this.Hp = 0;

            Console.WriteLine("Current Enemy Hp: " + this.Hp);
        }
    }



    internal class _Item
    {
        public int GodSword=10;
        public int GodShield=20;
        public int GodArmor=30;
    }
    internal class LootDrop
    {
        private Shop shop;

        public LootDrop(Shop shop)
        {
            this.shop = shop;
        }
        public void GetRandomItem(int gold)
        {
            if (shop.Gold < 10)
            {
                Console.WriteLine("you don't have enough gold");
            }
            else
            {
                Random ran = new Random();
                int Lucky = ran.Next(0, 100);
                if (Lucky <= 50)
                {
                    Console.WriteLine("Congratulation roll out a sword");
                }else if(50 < Lucky || Lucky <= 80)
                {
                    Console.WriteLine("Congratulation roll out a shield");
                }
                else
                {
                    Console.WriteLine("Congratulation roll out a armor");
                }
                shop.Gold -= gold;
                Console.WriteLine("Current your gold :"+ shop.Gold);
            }
            
        }
    }
    internal class Shop
    {
        public int Gold;
        public int GoldOfItem;
        _Item item = new _Item();
        public Shop(int gold)
        {
            this.Gold = gold;
        }
        public Shop()
        {

        }
        public void Buy(string ItemName)
        {
            if(ItemName == "1")
            {
                GoldOfItem = item.GodSword;
                if(Gold >= GoldOfItem)
                {
                    Console.WriteLine("successfully buy sword");
                    Gold -= GoldOfItem;
                    Console.WriteLine("Current god: " + this.Gold);
                }
                else
                {
                    Console.WriteLine("Can't buy this item , because you don't have enough god");
                }
                
            }
            if (ItemName == "2")
            {
                GoldOfItem = item.GodShield;
                if (Gold >= GoldOfItem)
                {
                    Console.WriteLine("successfully buy shield");
                    Gold -= GoldOfItem;
                    Console.WriteLine("Current god: " + this.Gold);
                }
                else
                {
                    Console.WriteLine("Can't buy this item");
                }

            }
            if (ItemName == "3")
            {
                GoldOfItem = item.GodArmor;
                if (Gold >= GoldOfItem)
                {
                    Console.WriteLine("successfully buy armor");
                    Gold -= GoldOfItem;
                    Console.WriteLine("Current god: " + this.Gold);
                }
                else
                {
                    Console.WriteLine("Can't buy this item");
                }

            }
        }
    }
}
