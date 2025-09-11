using System.Collections;

namespace Bit_Array
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //1. Khai báo và gán giá trị declaration and assignment of values
            // Create 5 element bit Array , default is false
            BitArray bits = new BitArray(5);

            // assign value manually
            bits[0] = true;
            bits[1] = false;
            bits[2] = true;
            bits[3] = true;
            bits[4] = false;

            Console.WriteLine("Value of BitArray:");
            for (int i = 0; i < bits.Count; i++)
            {
                Console.WriteLine($"bit[{i}] = {bits[i]}");
            }
            Console.WriteLine();
            

            //2
            BitArray a = new BitArray(new bool[] { true, false, true, false });
            BitArray b = new BitArray(new bool[] { false, false, true, true });

            // làm kiểu này thì a sẽ bị ghi đè liên tục vậy nên ta mới cần làm theo kiểu ** ở dưới
            BitArray andResult = a.And(b);  // a & b
            BitArray orResult = a.Or(b);    // a | b
            BitArray xorResult = a.Xor(b);  // a ^ b
            BitArray notResult = a.Not();   // ~a

            // **  tạo ra các clone để không bị ghi đè lên nhau
            BitArray aandResult = ((BitArray)a.Clone()).And(b); //(BitArray) ép kiểu object về BitArray , vì khi mình clone a mới này sẽ thành kiểu object
            BitArray aorResult = ((BitArray)a.Clone()).Or(b);
            BitArray axorResult = ((BitArray)a.Clone()).Xor(b);
            BitArray anotResult = ((BitArray)a.Clone()).Not();

            void Print(string label, BitArray ba)
            {
                Console.Write(label + ": ");
                foreach (bool bit in ba) Console.Write(bit ? "1 " : "0 ");
                Console.WriteLine();
            }
            // in ra bản lỗi
            Print("AND", andResult);
            Print("OR", orResult);
            Print("XOR", xorResult);
            Print("NOT", notResult);

            Console.WriteLine();
            // in ra bản đúng 
            Print("AND", aandResult);
            Print("OR", aorResult);
            Print("XOR", axorResult);
            Print("NOT", anotResult);

        }
    }
}

// bit array same to bool[] , so why we don't use bool . Because bit array use less space than bool . bool occupy about (1000 bytes) still bit array occupy about (125 bytes)

/*
 * 📦 Thuộc tính (Properties)
| Tên thuộc tính    | Kiểu dữ liệu | Mô tả                                                             |
| ----------------- | ------------ | ----------------------------------------------------------------- |
| `Count`           | `int`        | Số lượng phần tử (bằng `Length`)                                  |
| `Length`          | `int`        | Số lượng phần tử                                                  |
| `Item[int index]` | `bool`       | Truy cập hoặc gán giá trị bit tại chỉ số `index` (giống như `[]`) |
| `IsReadOnly`      | `bool`       | Luôn là `false` (vì `BitArray` có thể ghi)                        |
| `IsSynchronized`  | `bool`       | Cho biết có thread-safe hay không (thường là `false`)             |
| `SyncRoot`        | `object`     | Dùng cho đồng bộ hoá đa luồng                                     |

 * 🔧 Phương thức (Methods)
| Tên hàm               | Trả về     | Mô tả                                           |
| --------------------- | ---------- | ----------------------------------------------- |
| `And(BitArray value)` | `BitArray` | Thực hiện phép AND giữa 2 `BitArray`            |
| `Or(BitArray value)`  | `BitArray` | Thực hiện phép OR giữa 2 `BitArray`             |
| `Xor(BitArray value)` | `BitArray` | Thực hiện phép XOR giữa 2 `BitArray`            |
| `Not()`               | `BitArray` | Đảo ngược từng bit (true → false, false → true) |

 * 2. Gán và sao chép
| Tên hàm                          | Trả về   | Mô tả                                                                    |
| -------------------------------- | -------- | ------------------------------------------------------------------------ |
| `Set(int index, bool value)`     | `void`   | Gán giá trị `value` cho phần tử tại `index`                              |
| `SetAll(bool value)`             | `void`   | Gán toàn bộ phần tử bằng `value`                                         |
| `CopyTo(Array array, int index)` | `void`   | Sao chép dữ liệu sang mảng `bool[]`, `byte[]`, `int[]` từ vị trí `index` |
| `Clone()`                        | `object` | Tạo bản sao `BitArray` mới                                               |

 * 3. Khác
| Tên hàm              | Trả về        | Mô tả                                             |
| -------------------- | ------------- | ------------------------------------------------- |
| `Get(int index)`     | `bool`        | Lấy giá trị tại vị trí `index`                    |
| `Equals(object obj)` | `bool`        | So sánh hai `BitArray` (ghi đè từ `Object`)       |
| `GetEnumerator()`    | `IEnumerator` | Trả về iterator để duyệt mảng                     |
| `ToString()`         | `string`      | Trả về chuỗi tên lớp (ít dùng, không in mảng bit) |

 */

/* how to use in dev game?
 * Giả sử bạn làm một game có 8 cấp độ, bạn cần lưu xem người chơi đã hoàn thành cấp nào chưa.
 
    BitArray levelsCompleted = new BitArray(8);
    // Người chơi hoàn thành cấp 1, 3 và 7
    levelsCompleted[0] = true;
    levelsCompleted[2] = true;
    levelsCompleted[6] = true;
    // Kiểm tra trạng thái
    for (int i = 0; i < levelsCompleted.Count; i++)
    {
        string status = levelsCompleted[i] ? "Hoàn thành" : "Chưa xong";
        Console.WriteLine($"Level {i + 1}: {status}");
    }

 */


/*
 Vocabulary
    occupy about : chiếm khoảng
    assign : chỉ định, gán (hành động) 
    manually : thủ công , bằng tay
    declaration : khai báo
 */