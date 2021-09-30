public class ArraySum {
	public int sumOfArray(Integer[]a, int i)
	{
		if (i == 0)
		{
			return a[i];
		}
		else
		{
			return a[i] + sumOfArray(a, i -1);
		}
	}

}