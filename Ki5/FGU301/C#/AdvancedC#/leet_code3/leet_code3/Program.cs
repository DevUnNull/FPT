using System;

namespace leet_code3
{
    internal class Program
    {
        // 1. Định nghĩa delegate
        public delegate void OnDamaged(int damage);

        // 2. Khai báo event
        public static event OnDamaged onDamaged;
        public static event OnDamaged onHealed;
        
        static void Main(string[] args)
        {
            Console.OutputEncoding = System.Text.Encoding.UTF8;
            Player player = new Player();
            // 3. Đăng ký sự kiện (gán method TakeDamage vào event)
            onDamaged += player.TakeDamage;
            onHealed += player.Heal;

            while (true)
            {
                Console.WriteLine("Nhấn 'a' để gây sát thương, 'b' để hồi máu hoặc 'x' để thoát:");
                string input = Console.ReadLine();

                if (input == "a")
                {
                    // 4. Gọi sự kiện => gọi hàm TakeDamage
                    onDamaged?.Invoke(10); // Gây sát thương 10
                }
                else if (input == "b") 
                {
                    onHealed?.Invoke(20);                
                }
                else if (input == "x")
                {
                    break;
                }
            }
        }
    }

    class Player
    {
        public int MaxHp { get; set; }
        
        public int hp { get; set; }

        public Player()
        {
            MaxHp = 100;
            hp = MaxHp;
        }
        // Hàm xử lý khi bị sát thương
        public void TakeDamage(int damage)
        {
            hp -= damage;
            Console.WriteLine($"HP còn lại: {hp}");

            if (hp < 30)
            {
                Console.WriteLine("⚠️ Cảnh báo! HP thấp!");
            }
        }
        public void Heal(int hpheal)
        {
            hp += hpheal;
            if (hp > MaxHp)
            {
                hp = MaxHp;
            }

            Console.WriteLine($"HP sau khi hồi: {hp}");
        }

    }
}
