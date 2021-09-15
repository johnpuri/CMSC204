public class DataSetGen<T>
{
   private double sum;
   private Measurable maximum;
   private int count;

   public double getAverage()
   {
       return (count == 0 ? count : sum / count);
   }
   
   public void add(Measurable x)
   {
      sum = sum + x.getMeasure();     
      if (count == 0 || maximum.getMeasure() < x.getMeasure()) {
         maximum = x; 
      }      
      count++;
   }
   
   public DataSetGen()
   {
      sum = 0;
      count = 0;
      maximum = null;
   }

   public T getMaximum()
   {
      return (T) maximum;
   }
}