using System.Collections;

namespace Hash_Table
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Hashtable ht = new Hashtable();
            ht["name"] = "Hai";
            ht["age"] = 24;

            foreach (string key in ht.Keys) 
            {
                Console.WriteLine(ht[key]);
            }
        }
    }
}
