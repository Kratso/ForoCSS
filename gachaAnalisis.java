
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;

public class MyClass {
    public static void main(String args[]) {
      IntStream indexes = IntStream.range(1,91);
      
      Stream<A> values = getValues(indexes);
      
      values.forEach((e)->{
          double probBase = (double)e.value / 100;
          
          System.out.printf("%02d - %02.5f - %02.5f - %02.5f - %02.5f - %02.6f - %02.7f - %02.8f\n",
                            e.value,
                            probBase * 100,
                            (probBase) * (probBase / 2) * 100,
                            (probBase) * (probBase / 2) * (probBase / 4) * 100,
                            (probBase) * (probBase / 2) * (probBase / 4) * (probBase / 8) * 100,
                            (probBase) * (probBase / 2) * (probBase / 4) * (probBase / 8) * (probBase / 16) * 100,
                            (probBase) * (probBase / 2) * (probBase / 4) * (probBase / 8) * (probBase / 16) * (probBase / 32) * 100,
                            (probBase) * (probBase / 2) * (probBase / 4) * (probBase / 8) * (probBase / 16) * (probBase / 32) * (probBase / 64) * 100,
                            (probBase) * (probBase / 2) * (probBase / 4) * (probBase / 8) * (probBase / 16) * (probBase / 32) * (probBase / 64) * (probBase / 128) * 100
                            );
      });
    }
    
    private static Stream<A> getValues(IntStream indexes) {
        List<A> values = new ArrayList<A>();
        
        indexes.forEach((e)->values.add(new A(e)));
        
        values.stream().map((e)->{
            int value = e.value;
            
            while(value > 0) {
                e.count++;
                value /= 2;
            }
            
            return e;
        });
        
        return values.stream();
    }
    
    static class A {
        public int value;
        public int count;
        
        public A(int value) {
            this.value = value;
            this.count = 0;
        }
    }
}
