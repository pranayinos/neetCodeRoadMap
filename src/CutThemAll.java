import java.util.Arrays;
import java.util.List;

public class CutThemAll {
    public static void main(String[] args) {
        // Long[] array = {4L,3L,2L};
        // Long[] array = {4L, 2L, 3L};
        // Long[] array = {3L,5L,4L,3L};
        Long[] array = {5L,6L,2L};
        List<Long> lengths = Arrays.asList(array);
        System.out.println(cutThemAll(lengths, 12));
    }
    /*
     * An automated cutting machine is used to cut rods
into segments. The cutting machine can only hold a
rod of minLength or more. A rod is marked with the
necessary cuts and their lengths are given as an array
in the order they are marked. Determine if it is
possible to plan the cuts so the last cut is from a rod
at least minLength units long.

Example
n= 3
lengths = [4, 3, 2]
minLength = 7

The rod is initially sum(lengths) = 4 + 3 + 2 = 9 units
long. First cut off the segment of length 4 + 3 = 7
leaving a rod 9 - 7 = 2. Then check that the length 7
rod can be cut into segments of lengths 4 and 3. Since
7 is greater than or equal to minLength = 7, the final
cut can be made. Return "Possible".
     */
    public static String cutThemAll(List<Long> lengths, long minLength) {
        
        long sum = 0;
        for (long l : lengths) {
            sum += l;
        }
        
        if (sum < minLength) {
            return "Impossible";
        }
        
        int l = 0;
        int r = lengths.size() - 1;
        while (r - l > 1) {
            int flag = 0;
            sum = sum - lengths.get(l);
            if (sum < minLength ) {
                sum = sum + lengths.get(l);
                flag++;
            } else {
                l++;
            }
            sum = sum - lengths.get(r);
            if (sum < minLength) {
                sum = sum + lengths.get(r);
                flag++;
            } else {
                r--;
            }
            if (flag == 2) {
                sum = sum - lengths.get(l);
                l++;

            }
        }
        if (sum < minLength) {
            return "Impossible";        
        }else {
            return "Possible";
        }
        
    }

}
