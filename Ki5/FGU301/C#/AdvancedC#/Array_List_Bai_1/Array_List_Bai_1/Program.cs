using System.Collections;

namespace Array_List_Bai_1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            ArrayList arrayList = new ArrayList();
            arrayList.Add(new Student(2,"Khang"));
            arrayList.Add(new Student(4, "Hai"));
            arrayList.Add(new Student(1, "Linh"));
            arrayList.Add(new Student(3, "Tuan"));

            foreach (Student student in arrayList)
            {
                Console.WriteLine(student.ToString());
            }

            arrayList.Sort();
            foreach (Student student in arrayList)
            {
                Console.WriteLine(student.ToString());
            }
        }

    }

    internal class Student : IComparable
    {
        private int id;
        private string name;

        public int CompareTo(object? obj)
        {
            Student other = obj as Student;
            if (other == null) { return 1; }
            Console.WriteLine($"🔍 So sánh: this.id = {this.id} với other.id = {other.id}");
            return this.id.CompareTo(other.id);
            // orther < this -> du nguyen 
            // orther > this -> doi cho 
        }
        public Student(int id, string name)
        {
            this.id = id;
            this.name = name;
        }

        public override string ToString() 
        {
            return "ID:" +id+ "Name:"+name;
        }

    }

    /*
    📌 Câu hỏi tự luận đi kèm & lời giải mẫu
        ❓ 1. So sánh this và other là gì?
        this: Là đối tượng Student đang được xét trong danh sách.

        other: Là đối tượng khác được truyền vào để so sánh với this.

        ❓ 2. Vì sao cần ép kiểu bằng as?
        Vì CompareTo nhận tham số là object, nên cần ép sang kiểu Student.

        Dùng as để ép kiểu an toàn – nếu sai kiểu sẽ trả về null thay vì gây lỗi.
     */
}
