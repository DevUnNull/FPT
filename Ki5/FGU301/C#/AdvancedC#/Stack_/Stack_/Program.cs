
using System;
using System.Collections;

namespace Stack_
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Stack stack = new Stack();

            stack.Push(1);
            stack.Push(2);
            stack.Push(3);
            stack.Push(4);

            Console.WriteLine("Here i do nothing any thing , i just Push elements in to stack");
            Console.WriteLine("Initial stack:");
            foreach (var item in stack) 
            {
                Console.WriteLine(item);
            }
            Console.WriteLine("Current element number is : " + stack.Count);

            Console.WriteLine();

            Console.Write("Now we will use Peek: ");
            Console.WriteLine(stack.Peek());
            Console.WriteLine("Initial stack:");
            foreach (var item in stack)
            {
                Console.WriteLine(item);
            }
            Console.WriteLine("Current element number is : " + stack.Count);

            Console.WriteLine();

            Console.WriteLine("Now we will use Pop: "+stack.Pop());
            Console.WriteLine("Initial stack:");
            foreach (var item in stack)
            {
                Console.WriteLine(item);
            }
            Console.WriteLine("Current element number is : " + stack.Count);
            
        }
    }
}


// Peek : return value of object on top Stack (element added in to last but not removed element  from the stack) that like we look at top value from stack
// Pop : return value of object on top stack (element added in to last and removed element from the stack ) that like we take out a top value from stack
// Push : add an element with value in to top from stack