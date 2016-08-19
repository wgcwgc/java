import java.util.Random;

public class Try
{
    public static void main(String args[])
    {
        int b;
        int c;
        int a = b = c = 1;
        Random rdm = new Random();
        int t = 0;
        while(a + b != c)
        {
            t++;
            a = rdm.nextInt(100);
            b = rdm.nextInt(100);
            c = rdm.nextInt(100);
            System.out.printf("%d+%d=%d\n", a,b,c);//new Object[] {Integer.valueOf(a), Integer.valueOf(b), Integer.valueOf(c)});
        }
        System.out.println(t);
    }
}
