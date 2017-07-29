//Efficient as it runs in O(n)
//just iterate the array
//better than sorting

int index = 0;
int max = array[index];

for(int i=1; i<array.length; i++)
{
    if(array[i] > max)
    {
        index = i;
        max = array[i]
    }
}