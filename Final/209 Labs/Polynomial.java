import java.util.Arrays;


public class Polynomial implements Comparable<Polynomial> {
	private int[] polyArray;

	public Polynomial (int[] coeffecients) {
		this.polyArray = coeffecients.clone();
		int[] empty = {0};
		int zeroIdx = -1;
		for(int idx = coeffecients.length -1; idx > -1; idx--) {
			if (coeffecients[idx] == 0) {
				zeroIdx = idx;
				if (idx == 0) {
					this.polyArray = empty;
					return;
				}else {
					continue;
				}
			}else {
				break;
			}
		}
		
		int[] newArray;
		if (zeroIdx < 0) {
			zeroIdx = coeffecients.length;
			newArray = new int[zeroIdx];
		} else {
			newArray = new int[zeroIdx];
		}
		
		for (int idx = 0; idx < zeroIdx; idx++) {
			newArray[idx] = coeffecients[idx];
		}
		this.polyArray = newArray;
	}
	
	@Override public String toString() {
		StringBuilder polyText = new StringBuilder();
		int degree = 0;
		int zeroCount = 0;
		boolean countZeroFlg = false;

		for (int idx = 0 ; idx < polyArray.length; idx++) {
			int coeffecient = polyArray[idx];

			if (coeffecient != 0) {
				if (idx == 0) {
					polyText.append(coeffecient);
				} else if (idx == 1) {
					if (coeffecient > 0) {
						polyText.append("+" + coeffecient + "x");
					} else {
						polyText.append(coeffecient + "x");
					}
				} else {
					if (coeffecient > 0) {
						polyText.append("+" + coeffecient + "x^" + idx); 
					} else {
						polyText.append(coeffecient + "x^" + idx);
					}
				}
			}
		}	
		return polyText.toString();
	}
	
	public int getDegree() {
		for (int idx = polyArray.length - 1; idx > 0; idx--) {
			int coeffecient = polyArray[idx];
			if (coeffecient != 0) {
				return idx;
			}
		}
		return 0;
	}
	
	public int getCoefficient(int k) {
		if (k < 0 || k > polyArray.length -1) {
			return 0;
		}
		return polyArray[k];
	}
	
	public int evaluate(int x) {
		int result = polyArray[0];
		
		for (int idx = 1; idx < polyArray.length ; idx++) {
			result += polyArray[idx] * Math.pow(x, idx);
		}
		return result;
	}
	
	public Polynomial add(Polynomial other) {
		int[] newCoeffecientArray;
		int compareArrays = Integer.valueOf(polyArray.length).compareTo(Integer.valueOf(other.polyArray.length));
		
		if (compareArrays == 0) {
			newCoeffecientArray = new int[polyArray.length];
			for (int idx =0 ; idx < polyArray.length; idx++) {
				newCoeffecientArray[idx] = other.polyArray[idx] + polyArray[idx];
			}
		} else if (compareArrays > 0) {
			newCoeffecientArray = new int[polyArray.length];
			for (int idx =0 ; idx < other.polyArray.length; idx++) {
				newCoeffecientArray[idx] = other.polyArray[idx] + polyArray[idx];
			}
			int counter = 0;
			for (int idx = other.polyArray.length ; idx < polyArray.length; idx++) {
				newCoeffecientArray[other.polyArray.length + counter] = polyArray[idx];
				counter++;
			}
		} else {
			newCoeffecientArray = new int[other.polyArray.length];
			for (int idx =0 ; idx < polyArray.length; idx++) {
				newCoeffecientArray[idx] = other.polyArray[idx] + polyArray[idx];
			}
			int counter = 0;
			for (int idx = polyArray.length; idx < other.polyArray.length; idx++) {
				newCoeffecientArray[polyArray.length + counter] = other.polyArray[idx];
				counter++;
			}
		}
		return new Polynomial(newCoeffecientArray);	
	}
	
	public Polynomial multiply (Polynomial other) {
		int compareArrays = Integer.valueOf(polyArray.length)
				.compareTo(Integer.valueOf(other.polyArray.length));
		
		if (compareArrays > 0) {
			return new Polynomial(multiplyArrays(polyArray, other.polyArray));
		}else {
			return new Polynomial(multiplyArrays(other.polyArray, polyArray));
		}
	}
	 
	 public int[] multiplyArrays(int[] largeList, int[] smallList) {
		 int[] newMultiplcationList = new int[largeList.length + smallList.length];
		 for (int smIdx = 0; smIdx < smallList.length; smIdx++) {
			 for (int lgIdx = 0; lgIdx < largeList.length; lgIdx++) {
				 int idxToInsert = smIdx + lgIdx;
				 newMultiplcationList[idxToInsert] = (smallList[smIdx] * largeList[lgIdx]) + (newMultiplcationList[idxToInsert]);					 
			 }
		 }
		 return newMultiplcationList;
	 }
	 
	 public int compareTo(Polynomial other) { 
		 int[] largerArray;
		 int[] smallerArray;
		 int isThisLarger = Integer.valueOf(polyArray.length).compareTo(other.polyArray.length);
		 if (isThisLarger >= 0) {
			 largerArray = polyArray;
			 smallerArray = other.polyArray;
		 } else {
			 largerArray = other.polyArray;
			 smallerArray = polyArray;
		 }
		 for (int idx = largerArray.length -1 ; idx > -1; idx--) {
			 if (idx <= smallerArray.length -1) {
				 if (largerArray[idx] > smallerArray[idx]) {
					 return 1;
				 } else if (largerArray[idx] == smallerArray[idx]) {
					 continue;
				 } else {
					 return -1;
				 }
			 } else {
				 if (largerArray[idx] != 0) {
					 return (largerArray == polyArray) ? 1 : -1;
				 } else {
					 return (largerArray == polyArray) ? -1 : 1;
				 }
			 }
		 }
		 return 0;
	 }
	 
	 @Override public int hashCode() {
		 return Arrays.hashCode(polyArray);
	 }
	 
	 @Override public boolean equals(Object other) {
		if (other instanceof Polynomial) {
			Polynomial otherPoly = (Polynomial) other;
			if (this.compareTo(otherPoly) == 0) {
				return true;
			}
		}
		return false;
	 }
	
}
