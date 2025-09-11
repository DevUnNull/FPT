namespace Event_Delegate
{
    internal class Program
    {
        public delegate void Notify(string message); // Khai báo delegate

        public static event Notify OnNotify; // Khai báo event dựa trên delegate

        static void Main()
        {
            OnNotify += ShowMessage1;
            OnNotify += ShowMessage2;
            
            OnNotify?.Invoke("Hello Delegate and Event!"); // Gọi event
        }

        static void ShowMessage1(string msg)
        {
            Console.WriteLine("Message 1: " + msg);
        }

        static void ShowMessage2(string msg)
        {
            Console.WriteLine("Message 2: " + msg);
        }
    }
}


/*
| Đặc điểm                                  | Delegate thuần                    | Event (dựa trên delegate)               |
| -----------------------------             | --------------------------------  | -------------------------------------   |
| Có thể gọi từ bên ngoài                   | ✅ Có                             | ❌ Không                               |
| Có thể gán (`=`) từ bên ngoài class khác  | ✅ Có                             | ❌ Không                               |
| Có thể thêm/xóa subscriber                | ✅ Có (`+=`, `-=`)                | ✅ Có (`+=`, `-=`)                     |
| Tính đóng gói (encapsulation)             | ❌ Kém                            | ✅ Tốt                                 |
| Dùng cho                                  | Nội bộ logic, callback nội class  | Giao tiếp giữa các class/phát sự kiện   |

 */

/*
| Khái niệm       | Delegate                                      | Event                                                        |
| --------------- | --------------------------------------------- | ------------------------------------------------------------ |
| Là gì?          | Con trỏ đến hàm                               | Delegate an toàn, chỉ cho phép gọi trong lớp                 |
| Dùng để?        | Gọi hàm linh hoạt, truyền callback            | Phát tín hiệu, sự kiện cho các đối tượng                     |
| Unity ứng dụng? | Tạo callback khi animation xong, AI hành động | Báo khi nhân vật chết, hoàn thành nhiệm vụ, nhận sát thương… |

 */

/* ví dụ trong UNITY
 using UnityEngine;

public class Player : MonoBehaviour
{
    // Khai báo delegate
    public delegate void OnDamaged(int currentHP);

    // Khai báo event dựa trên delegate
    public static event OnDamaged Damaged;

    private int hp = 100; 

    public void TakeDamage(int damage)
    {
        hp -= damage;
        if (hp < 0) hp = 0;

        Debug.Log("Player bị mất máu: " + hp);

        // Gọi event nếu có người đăng ký
        Damaged?.Invoke(hp);
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
        Player.Damaged += UpdateHealthBar;
    }

    void OnDisable()
    {
        // Gỡ đăng ký để tránh lỗi khi object bị hủy
        Player.Damaged -= UpdateHealthBar;
    }

    void UpdateHealthBar(int currentHP)
    {
        Debug.Log("🩸 UI cập nhật HP: " + currentHP);
        // Thực tế: cập nhật thanh máu trên màn hình
    }
}

 */