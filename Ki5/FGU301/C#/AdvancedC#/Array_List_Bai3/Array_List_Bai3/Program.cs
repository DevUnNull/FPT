using System.Collections;

namespace Array_List_Bai3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            List<Student> students = new List<Student>
            {
                new Student(1, "Nam"),
                new Student(2, "An"),
                new Student(3, "Bình"),
                new Student(4, "Cường"),
                new Student(5, "Dũng")
            };

            Console.WriteLine("📋 Trước khi sắp xếp:");
            foreach (Student s in students)
            {
                Console.WriteLine(s);
            }

            Console.WriteLine("\n🔃 Bắt đầu sắp xếp theo tên (dùng IComparer):");
            students.Sort(new StudentComparerByName());

            Console.WriteLine("\n✅ Sau khi sắp xếp:");
            foreach (Student s in students)
            {
                Console.WriteLine(s);
            }
        }
    }

    internal class Student 
    {
        public int id;
        public string name;

        public Student(int id, string name)
        {
            this.id = id;
            this.name = name;
        }

        public override string ToString()
        {
            return $"ID: {id}, Name: {name}";
        }
    }

    internal class StudentComparerByName : IComparer<Student>
    {
        public int Compare(Student? x, Student? y)
        {
            if (x == null || y == null) return 0;

            Console.WriteLine($"🔍 So sánh: {x.name} với {y.name}");
            return x.name.CompareTo(y.name); // Tăng dần theo tên
        }
    }
}
