import java.util.*;
import static java.lang.Math.sqrt;
class Class1
{
    static void simpleSieve(int limit, Vector<Integer> prime)//6,
    {
        boolean mark[] = new boolean[limit+1];
        for (int i = 0; i < mark.length; i++) {
            mark[i] = true;
            }
        for (int p=2; p*p<limit; p++)
        {
            if (mark[p] == true)
            {
                for (int i=p*p; i<limit; i+=p) {
                    mark[i] = false;
                }
            }
	    }
        for (int p=2; p<limit; p++)
        {
            if (mark[p] == true)
            {
                prime.add(p);
                System.out.print(p + " ");
            }
        }
    }
    static void segmentedSieve(int n)
    {
        int limit = (int)(sqrt(n)+1);
        Vector<Integer> prime = new Vector<>();
        simpleSieve(limit, prime);
        int low = limit;
        int high = 2*limit;
        while (low < n)
        {
            if (high >= n)
                high = n;
            boolean mark[] = new boolean[limit+1];
            for (int i = 0; i < mark.length; i++)
                mark[i] = true;
            for (int i = 0; i < prime.size(); i++)
            {
                int loLim = (int) (low/prime.get(i) * prime.get(i));
                if (loLim < low)
                    loLim += prime.get(i);
                for (int j=loLim; j<high; j+=prime.get(i))
                    mark[j-low] = false;
            }
            for (int i = low; i<high; i++)
                if (mark[i - low] == true)
                    System.out.print(i + " ");
            low = low + limit;
            high = high + limit;
        }
    }
    public static void main(String args[])
    {
        int n = 1000000;
        System.out.println("Primes smaller than " + n + ":");
        segmentedSieve(n);
    }
}