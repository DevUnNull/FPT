using System.Linq;
using System.Xml.Serialization;

namespace leet_code2
{
    internal class Program
    {
        static List<Product> list = new List<Product>();
        static void Main(string[] args)
        {
            while (true)
            {
                Console.WriteLine("\n--- MENU ---");
                Console.WriteLine("1. Thêm sản phẩm");
                Console.WriteLine("2. In tất cả sản phẩm");
                Console.WriteLine("3. Tìm sản phẩm theo tên");
                Console.WriteLine("0. Thoát");
                Console.Write("Chọn chức năng: ");

                string choice = Console.ReadLine();
                switch (choice)
                {
                    case "1":
                        addProduct();
                        break;
                    case "2":
                        PrintAllProducts();
                        break;
                    case "3":
                        FindProduct();
                        break;
                    case "0":
                        return;
                    default:
                        Console.WriteLine("Lựa chọn không hợp lệ.");
                        break;
                }
            }
        }
        static void addProduct()
        {
            Console.Write("Nhập ID: ");
            int id = int.Parse(Console.ReadLine());

            Console.Write("Nhập tên sản phẩm: ");
            string name = Console.ReadLine();

            Console.Write("Nhập giá: ");
            int price = int.Parse(Console.ReadLine());
            Product product = new Product(id,name,price);

            list.Add(product);
        }
        static void FindProduct()
        {
            int id;
            Console.Write("Nhap Id San Pham Muon Tim: ");
            id = int.Parse(Console.ReadLine());
            Product found = list.Find(p => p.Id == id);
            if (found != null)
            {
                Console.WriteLine($"Tim thay: Id = {found.Id}, Name = {found.Name}, Price = {found.Price}");
            }
            else
            {
                Console.WriteLine("Khong tim thay san pham.");
            }
        }
        static void PrintAllProducts()
        {
            Console.WriteLine("\n📋 Danh sách sản phẩm:");
            if (list.Count == 0)
            {
                Console.WriteLine("Không có sản phẩm nào.");
                return;
            }

            foreach (var product in list)
            {
                Console.WriteLine(product.ToString());
            }
        }
    }

    class Product
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public int Price { get; set; }
        
        public Product(int id,string name , int price) 
        { 
            this.Id = id;
            this.Name = name;
            this.Price = price;
        }

        public override string ToString()
        {
            return "ID:" + this.Id + " Name:" + this.Name + " Price:" + this.Price;
        }
    }
}
