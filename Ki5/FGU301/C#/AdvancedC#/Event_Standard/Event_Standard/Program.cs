
namespace Event_Standard
{
    internal class Program
    {
        static public int count = 1;
        static void Main(string[] args)
        {
            Button button = new Button();
            string input;

            button.OnClick += ButtonClicked;

            while (true)
            {
                input = Console.ReadLine();
                if (input == "a")
                {
                    button.Click();
                }
            }
        }
        static void ButtonClicked()
        {
            Console.WriteLine("bam nut lan :"+count);
            count++;
        }
    }

    public class Button
    {
        public delegate void ClickHandler();
        public event ClickHandler OnClick;
        public void Click() 
        {
            OnClick?.Invoke();
        }
    }
}
