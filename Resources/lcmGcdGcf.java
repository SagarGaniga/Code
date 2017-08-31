static int lcm(int a, int b)
{
    return a * (b / gcd(a, b));
}

static int gcd(int a, int b)
{
    while (b > 0)
    {
        int temp = b;
        b = a % b; // % is remainder
        a = temp;
    }
    return a;
}

static int greatestCommonFactor(int a, int b, int c)
{
    int limit = (int)Math.min(a, b);
    limit = Math.min(limit, c);
    for(int n = limit; n >= 2; n--)
    {
        if ( (a % n == 0) && (b % n == 0) && (c % n == 0) ) {
            return n;
        }
    }

    return 1;
}