public class Animal()
{
    static void Main(string[] args) 
    {
        Cat cat = new Cat();
        cat.canNang();
    }
}

public class Cat()
{
    public void canNang() 
    {
        Console.WriteLine("con meo nang 20kg");
    }
}