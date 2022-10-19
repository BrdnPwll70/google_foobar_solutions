public class Solution {
    public static int[] solution(int[] pegs) {
        // Your code here
        int numeratorPrimaryGear = 2 * fPRecursion(pegs, pegs.length);
		int denominatorPrimaryGear = 1 + 2 * (int)Math.pow(-1, pegs.length);
		// If denominatorPrimaryGear is -1, invert numeratorPrimaryGear & denominatorPrimaryGear
		if (denominatorPrimaryGear == -1) {
			numeratorPrimaryGear *= -1;
			denominatorPrimaryGear *= -1;
		}
		// If numeratorPrimaryGear & denominatorPrimaryGear are both factors of 3, reduce each by factor of 3
		if (numeratorPrimaryGear % 3 == 0 && denominatorPrimaryGear % 3 == 0) {
			numeratorPrimaryGear /= 3;
			denominatorPrimaryGear /= 3;
		}
		// Checks if all gear sizes are feasible. Gears should have radius greater than one, and less than distance between pegs minus one
		double nextGear = numeratorPrimaryGear/denominatorPrimaryGear;
		boolean isFeasible = true;
		for (int i = 0; i < pegs.length - 1; i++) {
			if (nextGear < 1 || pegs[i+1] - pegs[i] -1 < nextGear) {
				isFeasible = false;
			}	
			nextGear = pegs[i + 1] - pegs[i] - nextGear;
		}
		// If numeratorPrimaryGear & denominatorPrimaryGear are feasible, return values in array primaryGearSize. If not feasible, return {-1, -1}
		int[] primaryGearSize = {numeratorPrimaryGear, denominatorPrimaryGear};
		if (isFeasible) {
			return primaryGearSize;
		}
		int[] fail = {-1, -1};
		return fail;		
	}
	// Recursive calculation for fP(i)
	static int fPRecursion(int[] pegs, int i) {
		i--;
		if (i == 0) 
			return 0;
		return (pegs[i] - pegs[i-1] - fPRecursion(pegs, i));
    }
}
