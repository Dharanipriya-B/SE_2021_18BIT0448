import java.util.*;
public class Main
{
		static String[][] board = new String[5][5];
		static HashMap<String,String> coins = new HashMap<>();
		
		public static void main(String[] args)
		{
		    Scanner sc = new Scanner(System.in);
		    System.out.print("Enter the value for A: ");
		    String p1 = sc.nextLine();
		    init(p1,1);
		    
		    System.out.print("Enter the value for B: ");
		    String p2 = sc.nextLine();
		    init(p2,2);
		    
		    showBoard();
		    
		    int n=1;
		    String move="";
		    while(coins.size()>1)
		    {
		        if(n==1)
		        {
		            while(true)
		            {
		                System.out.print("Player A's move: ");
		                move = sc.nextLine();
		                if(canMove("A",move))
		                break;
		            }
		            n=2;
		        }
		        else{
		            System.out.print("Player B's move: ");
		            move = sc.nextLine();
		            canMove("B",move);
		            n=1;
		        }
		    }
		}
		public static boolean canMove(String name, String move)
		{
		    char mp = move.charAt(move.length()-1);
		    name = name+move.substring(0,2);
		    if(!coins.Contains(name))
		    {
		        return false;
		    }
		    else if(!canMove1(name,mp))
		    {
		        return false;
		    }
		}
		public static boolean canMove1(String name, char p)
		{
		    String pos = coins.get(name);
		    int row = pos.charAt(0)-45;
		    int col = pos.charAt(1)-45;
		}
		public static void init(String s,int n)
		{
		    int i;
		    String name;
		    if(n==1)
		    {
		        i=0;
		        name = "A-";
		    }
		    else 
		    {
		        i=4;
		        name = "B-";
		    }
		    String[] arr = s.split(" ");
		    for(int j=0;j<5;j++)
		    {
		        board[i][j]="A-"+arr[j];
		        coins.add(board[i][j],(String.valueOf(i)+String.valueOf(j)));
		    }
		}
		public static void showBoard()
		{
		    for(int i=0;i<5;i++)
		    {
		        for(int j=0;j<5;j++)
		        {
		            if(board[i][j]==null)
		            System.out.print("-\t");
		            else
		            System.out.print(board[i][j]+"\t");
		        }
		        System.out.println();
		    }
		}
	}
