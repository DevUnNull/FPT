using System;
using System.Collections.Generic;

class Program
{
    static void PrintCollection(ICollection<string> collection)
    {
        Console.WriteLine($"Number of element: {collection.Count}");
        foreach (var item in collection)
        {
            Console.WriteLine("- " + item);
        }
    }

    static void Main()
    {
        // List implement ICollection
        ICollection<string> names = new List<string>();

        names.Add("Nam");
        names.Add("Mai");
        names.Add("Lan");

        names.Remove("Lan");

        PrintCollection(names);  // In ra danh sách còn Nam và Mai
    }
}

/*
"Bên trái" (trước dấu =) là:
✅ Hợp đồng (interface) – tức là bạn chỉ quan tâm:
“Tôi cần một cái gì đó có thể Add, Remove, Count,...”
Chưa quan tâm cụ thể nó làm bằng cách nào.

->> ICollection<string> // Nghĩa là: tôi chỉ cần dùng các phương thức như Add, Remove, Count,...

 "Bên phải" (sau dấu =) là:
✅ Hiện thực cụ thể (object, nội dung thực tế) – nghĩa là:
“Đây là cách cụ thể mà tôi dùng để thực hiện hợp đồng trên”
Ở đây là List<string> – một danh sách cụ thể, có sẵn logic đầy đủ để chạy các hàm Add, Remove,...

->> new List<string>() // Là nội dung cụ thể, thực tế bạn sẽ dùng

 */


/*
    public interface IVehicle
    {
        void StartEngine();
    }

    public class Car : IVehicle
    {
        public void StartEngine()
        {
            Console.WriteLine("🚗 Car engine started!");
        }
    }

    public class Motorcycle : IVehicle
    {
        public void StartEngine()
        {
            Console.WriteLine("🏍️ Motorcycle engine started!");
        }
    }

    // Gọi:
    IVehicle myVehicle = new Car(); // Có thể thay bằng new Motorcycle()
    myVehicle.StartEngine(); // 🚗 Car engine started!
 */


/*
 * So sánh ICollection<T> với các kiểu khác
| Giao diện/Lớp    | Có thể lặp `foreach`  | Có thể thêm/xóa   | Có thể đếm  | Có chỉ số `[i]`  | Đặc biệt gì?                |
| ---------------- | --------------------  | ---------------   | ----------  | ---------------  | --------------------------- |
| `IEnumerable<T>` | ✅ Có                 | ❌ Không         | ❌ Không    | ❌ Không         | Chỉ để lặp                  |
| `ICollection<T>` | ✅ Có                 | ✅ Có            | ✅ Có       | ❌ Không         | Mạnh hơn IEnumerable        |
| `IList<T>`       | ✅ Có                 | ✅ Có            | ✅ Có       | ✅ Có            | Có thể truy cập theo chỉ số |
| `List<T>`        | ✅ Có                 | ✅ Có            | ✅ Có       | ✅ Có            | Là class cụ thể, phổ biến   |
| `Array`          | ✅ Có                 | ❌ (cố định)     | ✅ Có       | ✅ Có            | Dung lượng cố định          |

 */