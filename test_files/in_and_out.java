import java.util.*;
class in_and_out
{
    public static void main(String[] arg)
    {
	//	Scanner in = new Scanner(System.in);
	read_from_cmd();
       

        
    }

    private static void read_from_cmd()
    {
	Scanner in = new Scanner(System.in);
	System.out.print("Hi I am SpongeBob, whats your name?\n");
	String name = in.nextLine();
	System.out.print("whats your age?\n");
	int age = in.nextInt();
	System.out.println("your name is "+name+" and you are a gay");
    }
}




