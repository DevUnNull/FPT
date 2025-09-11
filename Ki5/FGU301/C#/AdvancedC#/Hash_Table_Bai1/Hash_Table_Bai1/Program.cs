using System.Collections;

namespace Hash_Table_Bai1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int chose=0;
            bool our = true;
            
            Hashtable ht = new Hashtable();

            ht["An"] = new NumberPhone("An", 123456);
            ht["Bình"] = new NumberPhone("Bình", 234567);
            ht["Chi"] = new NumberPhone("Chi", 345678);
            ht["Dương"] = new NumberPhone("Dương", 456789);
            ht["Em"] = new NumberPhone("Em", 567890);

            while (our)
            {
                
                Console.WriteLine("-----Menu-----");
                Console.WriteLine("1:Add new contact");
                Console.WriteLine("2:Find a number phone");
                Console.WriteLine("3:Update number phone");
                Console.WriteLine("4:Delete contact");
                Console.WriteLine("5:Show all");
                Console.WriteLine("6:Our");
                Console.Write("Enter your choice (1–6): ");
                string input = Console.ReadLine();
                bool valid = int.TryParse(input, out chose);
                if (!valid)
                {
                    Console.WriteLine("Invalid input. Please enter a number.");
                    continue;
                }
                
                
                switch (chose)
                {
                    case 1:
                        Console.WriteLine("Enter name: ");
                        string aName = Console.ReadLine();
                        Console.WriteLine("Enter phone number:");
                        if (int.TryParse(Console.ReadLine(), out int number))
                        {
                            ht[aName] = new NumberPhone(aName, number);
                            Console.WriteLine(" Contact added.");
                        }
                        else 
                        {
                            Console.WriteLine("Invalid phone number.");
                        }
                        break;
                    case 2:
                        Console.WriteLine("Enter name you want find:");
                        string fName = Console.ReadLine();
                        if (ht.ContainsKey(fName))
                        {
                            Console.WriteLine(ht[fName]);
                        }
                        else 
                        {
                            Console.WriteLine("Contact not found.");
                        }
                        break;
                    case 3:
                        Console.WriteLine("Enter name u want to update");
                        string uName = Console.ReadLine();
                        if (ht.ContainsKey(uName))
                        {
                            Console.WriteLine("Enter new phone number:");
                            if (int.TryParse(Console.ReadLine(), out int uNumber))
                            {
                                ht[uName] = new NumberPhone(uName, uNumber);
                                Console.WriteLine("Contact updated.");
                            }
                            else 
                            {
                                Console.WriteLine("Invalid phone number.");
                            }
                        }
                        break;
                    case 4:
                        Console.WriteLine("Enter name u want to delete:");
                        string dName = Console.ReadLine();
                        if (ht.ContainsKey(dName))
                        {
                            ht.Remove(dName);
                            Console.WriteLine("Contact deleted");
                        }
                        else 
                        { 
                            Console.WriteLine("Contact not found");
                        }
                        break;
                    case 5:
                        Console.WriteLine("📋 All contacts:");
                        foreach (DictionaryEntry entry in ht)
                        {
                            Console.WriteLine(entry.Value);   
                        }
                            
                        break;
                    case 6:
                        our = false;
                        break;
                    default:
                        // code to execute if variable doesn't match any case
                        break;
                }
            }

            Console.WriteLine("see you agen");
            

        }
    }

    internal class NumberPhone
    {
        public int number;
        public string name;

        public NumberPhone(string name, int number)
        {
            this.name = name;
            this.number = number;
        }
        
        public override string ToString()
        {
            return "Name:" + name + "Number Phone:" + number;
        }
    }
}
