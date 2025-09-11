namespace Dictionary_
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, string> playerScores = new Dictionary<string, string>();
            playerScores.Add("Player", "Hai");
            playerScores.Add("Player", "Huy");
            playerScores.Add("Player", "Hoang");
            playerScores.Add("Player", "Hung");
            // other way to create new Key
            playerScores["Enemy"] = "Hac Long";

            //🔹 Ví dụ 1: Inventory trong game (inventory : kho do)
            Dictionary<string, int> inventory = new Dictionary<string, int>();

            void AddItem(string itemName)
            {
                if (!inventory.ContainsKey(itemName))
                    inventory[itemName] = 0;

                inventory[itemName]++;
            }

            //🔹 Ví dụ 2: Quản lý enemy theo ID
            /*Dictionary<int, GameObject> enemies = new Dictionary<int, GameObject>();

            void SpawnEnemy(int id, GameObject prefab)
            {
                GameObject enemy = Instantiate(prefab);
                enemies[id] = enemy;
            }*/



        }
    }
}

/*
| Tiêu chí                               | `Dictionary<TKey, TValue>`                              | `Hashtable`                                 |
| -------------------------------------- | ------------------------------------------------------- | ------------------------------------------- |
| **Nơi khai báo**                       | `System.Collections.Generic`                            | `System.Collections`                        |
| **Kiểu dữ liệu**                       | **Generic** (có kiểu cụ thể: `Dictionary<string, int>`) | **Non-generic** (key/value đều là `object`) |
| **Hiệu suất**                          | 🟢 **Nhanh hơn** vì có kiểm tra kiểu tại compile time   | 🟡 Chậm hơn (phải boxing/unboxing)          |
| **An toàn kiểu (type safety)**         | ✅ Có (compile-time check)                               | ❌ Không (runtime cast)                      |
| **Lỗi khi truy cập key không tồn tại** | ❌ Lỗi `KeyNotFoundException`                            | ✅ Không lỗi, trả về `null`                  |
| **Duyệt (foreach)**                    | Duyệt bằng `KeyValuePair<TKey, TValue>`                 | Duyệt bằng `DictionaryEntry` hoặc `object`  |
| **Thêm key mới**                       | `dict["key"] = value;` hoặc `dict.Add()`                | `ht["key"] = value;` hoặc `ht.Add()`        |
| **Xoá key**                            | `dict.Remove("key")`                                    | `ht.Remove("key")`                          |
| **Dùng phổ biến trong...**             | 🔥 Unity, .NET Core, mọi C# hiện đại                    | ❌ Hầu như chỉ dùng trong các app .NET cũ    |
| **Hỗ trợ LINQ**                        | ✅ Có                                                    | ❌ Không                                     |


❌ Trường hợp KHÔNG nên dùng Dictionary:
Khi thứ bạn cần là danh sách có thứ tự, nên dùng List.
Khi có quá nhiều Add/Remove liên tục (performance-critical), hãy cân nhắc cấu trúc khác như HashSet, Queue, Pool.
 */