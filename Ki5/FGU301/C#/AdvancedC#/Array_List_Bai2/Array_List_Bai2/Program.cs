using System.Collections;

namespace Array_List_Bai2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            ArrayList employees = new ArrayList();

            employees.Add(new Employee(1, "Nam", 800));
            employees.Add(new Employee(2, "An", 1000));
            employees.Add(new Employee(3, "Bình", 1000));
            employees.Add(new Employee(4, "Cường", 900));
            employees.Add(new Employee(5, "Dũng", 800));

            Console.WriteLine("📋 Trước khi sắp xếp:");
            foreach (Employee e in employees)
            {
                Console.WriteLine(e);
            }

            Console.WriteLine("\n🔃 Bắt đầu sắp xếp (lương ↓, tên ↑ nếu bằng):");
            employees.Sort();

            Console.WriteLine("\n✅ Sau khi sắp xếp:");
            foreach (Employee e in employees)
            {
                Console.WriteLine(e);
            }
        }
    }

    internal class Employee : IComparable
    {
        public int id { get; set; }
        public string name { get; set; }
        public double salary { get; set; }

        public int CompareTo(object? obj)
        {
            Employee employee = obj as Employee;
            if (obj == null) return 1; // 1 la du nguyen
            int SalaryCompare = employee.salary.CompareTo(this.salary);
            Console.WriteLine($"🔍 So sánh: this.salary = {this.salary} với other.salary = {employee.salary}");
            if (SalaryCompare !=0 ) return SalaryCompare;
            Console.WriteLine($"⚖️ Lương bằng nhau → So sánh tên: {this.name} với {employee.name}");
            return this.name.CompareTo(employee.name);
        }
        public Employee(int id, string name, double salary)
        {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public override string ToString()
        {
            return "ID:" + this.id +  " Name:" + this.name + " Salary:" + this.salary;
        }
    }
}

/*
| Kết quả của `a.CompareTo(b)` | Hành động của `Sort()`                    |
| ---------------------------- | ----------------------------------------- |
| `< 0` (a < b)                | **Giữ nguyên** vị trí: `a` đứng trước `b` |
| `> 0` (a > b)                | **Đổi chỗ**: `a` phải đứng **sau** `b`    |
| `== 0`                       | Giữ nguyên vì bằng nhau                   |

 */
