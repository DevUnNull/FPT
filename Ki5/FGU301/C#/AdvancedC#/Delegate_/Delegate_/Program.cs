using System.Text;
namespace Delegate_
{
    internal class Program
    {
        public delegate void MyDelegate(string message);
        public static void Hello(string msg)
        {
            Console.WriteLine("Hello :" + msg);
        }
        public static void Bye(string msg)
        {
            Console.WriteLine("bye :"+msg);
        }

        static void Main(string[] args)
        {
            MyDelegate my = Hello;
            my += Bye;
            my("hai");
        }
    }
}
/*
| Toán tử | Tác dụng                        |
| ------- | ------------------------------- |
| `=`     | Gán hàm mới, ghi đè             |
| `+=`    | Thêm hàm vào danh sách delegate |
| `-=`    | Gỡ hàm khỏi delegate            |
 */

/* tham chieu (reference)
| Loại                                                | Lưu gì?                               | Ví dụ đơn giản                                            |
| --------------------------------------------------- | ------------------------------------- | --------------------------------------------------------- |
| **Kiểu giá trị** (`int`, `float`, `bool`, `struct`) | Lưu **giá trị thật**                  | `int a = 5;` → a chứa giá trị 5                           |
| **Kiểu tham chiếu** (`class`, `array`, `delegate`)  | Lưu **địa chỉ vùng nhớ chứa giá trị** | `MyClass obj = new MyClass();` → obj lưu địa chỉ vùng nhớ |

| Kiểu dữ liệu (value)                     | Mô tả                              |
| ---------------------------------------- | ---------------------------------- |
| `int`, `float`, `double`, `bool`, `char` | Kiểu nguyên thủy (primitive types) |
| `enum`                                   | Kiểu liệt kê                       |
| `struct`                                 | Kiểu cấu trúc                      |
| `DateTime`                               | Cũng là `struct`                   |

| Kiểu dữ liệu (reference)  | Mô tả                                  |
| ------------------------- | -------------------------------------- |
| `class`                   | Lớp                                    |
| `string`                  | Chuỗi (đặc biệt, bất biến - immutable) |
| `array`                   | Mảng                                   |
| `delegate`                | Đại diện (giữ địa chỉ hàm)             |
| `object`                  | Kiểu cơ bản nhất                       |
| `interface`               | Giao diện                              |

 */


/* ví dụ trong UNITY
 using UnityEngine;

public class Player : MonoBehaviour
{
    public delegate void OnDamaged(int currentHP);
    public static OnDamaged onDamaged;

    private int hp = 100;

    public void TakeDamage(int damage)
    {
        hp -= damage;
        if (hp < 0) hp = 0;

        Debug.Log("Player bị mất máu: " + hp);

        // Gọi delegate nếu có người đăng ký
        onDamaged?.Invoke(hp);
    }

    void Update()
    {
        // Nhấn Space để trừ 10 máu
        if (Input.GetKeyDown(KeyCode.Space))
        {
            TakeDamage(10);
        }
    }
}

using UnityEngine;

public class UIManager : MonoBehaviour
{
    void OnEnable()
    {
        // Đăng ký hàm nhận thông báo khi bị mất máu
        Player.onDamaged += UpdateHealthBar;
    }

    void OnDisable()
    {
        // Gỡ đăng ký để tránh lỗi khi object bị hủy
        Player.onDamaged -= UpdateHealthBar;
    }

    void UpdateHealthBar(int currentHP)
    {
        Debug.Log("🩸 UI cập nhật HP: " + currentHP);
        // Thực tế: cập nhật thanh máu trên màn hình
    }
}

 
 */