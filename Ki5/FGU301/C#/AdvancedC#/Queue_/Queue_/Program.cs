using System.Collections;

namespace Queue_
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Queue queue = new Queue();
            queue.Enqueue(1);
            queue.Enqueue(2);
            queue.Enqueue(3);
            queue.Enqueue(4);

            Console.WriteLine("1.i do not anything here , i just add 4 element in to String: ");
            Console.WriteLine("this here is array present"); //(Present : hien tai )
            foreach (var item in queue)
            {
                Console.WriteLine(item);
            }
            Console.WriteLine("present array are having: "+queue.Count+" element");
            Console.WriteLine();

            Console.WriteLine("2.this here i will use peek: "+queue.Peek());
            Console.WriteLine("this here is array present"); //(Present : hien tai )
            foreach (var item in queue)
            {
                Console.WriteLine(item);
            }
            Console.WriteLine("present array are having: " + queue.Count + " element");
            Console.WriteLine();

            Console.WriteLine("3.this here i will use Dequeue: "+queue.Dequeue());
            Console.WriteLine("this here is array present"); //(Present : hien tai )
            foreach (var item in queue)
            {
                Console.WriteLine(item);
            }
            Console.WriteLine("present array are having: " + queue.Count + " element");
            Console.WriteLine();

        }
    }
}

// Queue very similar stack , but stack is first in last out , still Queue is first in first out
// peek (that like we look a top element , it not delete this element) (Peek : nhìn trộm)
// Dequeue like pop (that like we take out element from string and it will delete element )
// Enqueue like push (add new element)