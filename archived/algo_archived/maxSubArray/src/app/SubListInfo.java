package app;

public class SubListInfo implements Comparable<SubListInfo> {
	int minIndex;
	int maxIndex;
	int sum;

	public SubListInfo() {
		super();
	}

	public SubListInfo(int minIndex, int maxIndex, int sum) {
		super();
		this.minIndex = minIndex;
		this.maxIndex = maxIndex;
		this.sum = sum;
	}


	public void addToSum(int extra) {
	   sum += extra;
	}
	
	public int getMinIndex() {
		return minIndex;
	}

	public void setMinIndex(int minIndex) {
		this.minIndex = minIndex;
	}

	public int getMaxIndex() {
		return maxIndex;
	}

	public void setMaxIndex(int maxIndex) {
		this.maxIndex = maxIndex;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public int compareTo(SubListInfo other) {
		if (other == null ) {
			return -1;
		}

		int otherSum = ((SubListInfo) other).getSum();
	
		if (sum > otherSum) {
			return  1;
		} else if (sum == otherSum) {
			return 0;
		} else {
			return -1;
		}
	}

   @Override
   public String toString() {
      return "SubListInfo [minIndex=" + minIndex + ", sum=" + sum + "]";
   }
}