package app;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solver {

   // 1. get maximum sublist from  1st half
   // 2. get maximum sublist from  2nd half
   // 3. get maximum sublist crossing the middle
   // return the max of 1, 2, 3
	public SubListInfo getMaximumSubList(final List<Integer> bigList) {
		
	   if (bigList.isEmpty()) {
	      throw new IllegalArgumentException("empty list.");
	   }
	   
		if (bigList.size() == 1) {
			return new SubListInfo(0, 0, bigList.get(0));
		}
		
		int firstHalfMaxIndex, secondHalfMaxIndex;
		
		final int listSize  = bigList.size();
		if (listSize % 2 == 0) { // even size list

		   firstHalfMaxIndex = (bigList.size() / 2) - 1;
		   secondHalfMaxIndex = bigList.size() - 1;
		   
		   final SubListInfo firstHalfInfo = getMaximumSubList(bigList.subList(0, firstHalfMaxIndex + 1));
		   final SubListInfo laterHalfInfo = getMaximumSubList(bigList.subList(firstHalfMaxIndex + 1, secondHalfMaxIndex + 1));
		   final SubListInfo middleCrossingInfo = getMaximumSubListThroughCenter(bigList);

		   return Collections.max(Arrays.asList(firstHalfInfo, laterHalfInfo, middleCrossingInfo));
		   
      } else {  // odd size list

         final int middleElementIndex =  (listSize - 1) / 2;
         firstHalfMaxIndex = middleElementIndex - 1;
         final int secondHalfStartIndex = middleElementIndex + 1;
         secondHalfMaxIndex = listSize - 1;
         
         final SubListInfo firstHalfInfo = getMaximumSubList(bigList.subList(0, firstHalfMaxIndex + 1));
         final SubListInfo laterHalfInfo = getMaximumSubList(bigList.subList(secondHalfStartIndex, secondHalfMaxIndex + 1));
         final SubListInfo middleCrossingInfo = getMaximumSubListThroughCenter(bigList);         
         return Collections.max(Arrays.asList(firstHalfInfo, laterHalfInfo, middleCrossingInfo));
      }
	}

	private SubListInfo getMaximumSubListThroughCenter(final List<Integer> bigList) {
	   
	   if (bigList == null || bigList.isEmpty()) {
	      throw new IllegalArgumentException("null or empty list");
	   }
	   
	   final int listSize  = bigList.size();
	   if (listSize % 2 == 0) {

	      final int firstHalfMaxIndex = (listSize / 2) - 1;
	      final int secondHalfMaxIndex = listSize - 1;

	      final SubListInfo firstHalfSubList = getMaxSubListFromEnd(bigList.subList(0, firstHalfMaxIndex + 1));
	      final SubListInfo secondHalfSubList =
	           getMaxSubListFromStart(firstHalfMaxIndex, bigList.subList(firstHalfMaxIndex + 1, secondHalfMaxIndex + 1));
	      
	      return merge(firstHalfSubList, secondHalfSubList);
	   
	   } else { // odd
	      
	      final int middleElementIndex =  (listSize - 1) / 2;
	      final int firstHalfMaxIndex =  middleElementIndex; // inclusive of middle
	      final int secondHalfStartIndex =  middleElementIndex;// inclusive of middle
	      final int secondHalfLastIndex = listSize - 1;
	   
	      final SubListInfo firstHalfSubList = getMaxSubListFromEnd(bigList.subList(0, firstHalfMaxIndex + 1));
         final SubListInfo secondHalfSubList =
              getMaxSubListFromStart(middleElementIndex, bigList.subList(secondHalfStartIndex, secondHalfLastIndex + 1));
         
         return merge(firstHalfSubList, bigList.get(middleElementIndex), secondHalfSubList);
	   }
	}
	
	private SubListInfo getMaxSubListFromEnd(final List<Integer> bigList) {
		
	   if (bigList == null || bigList.isEmpty()) {
         throw new IllegalArgumentException("null or empty list");
      }
	   
		final int lastIndex = bigList.size() - 1;
		int currentSum = bigList.get(lastIndex);

		int maxSumIndexTillNow = lastIndex;
		int maxSumTillNow = currentSum;

		for (int  currentIndex = lastIndex - 1; currentIndex >= 0; currentIndex--) {
			
			currentSum += bigList.get(currentIndex);
			
			if (currentSum > maxSumTillNow) {
				maxSumIndexTillNow = currentIndex;
				maxSumTillNow = currentSum;
			}
		}
		
		return new SubListInfo(maxSumIndexTillNow, lastIndex, maxSumTillNow);
	}
	
	private SubListInfo getMaxSubListFromStart(final int midIndex, final List<Integer> bigList) {
		
	   if (bigList == null || bigList.isEmpty()) {
         throw new IllegalArgumentException("null or empty list");
      }
	   
		int currentSum = bigList.get(0);
		int maxSumIndexTillNow = 0;
		int maxSumTillNow = currentSum;

		for (int  currentIndex = 1; currentIndex < bigList.size(); currentIndex++) {

		   currentSum += bigList.get(currentIndex);
			
		   if (currentSum > maxSumTillNow) {
				maxSumIndexTillNow = currentIndex;
				maxSumTillNow = currentSum;
			}
		}
		
		return new SubListInfo(midIndex, midIndex + maxSumIndexTillNow, maxSumTillNow);
	}

	private SubListInfo merge(final SubListInfo lowerHalfInfo, final SubListInfo upperHalfInfo) {
		
	   if (lowerHalfInfo.getMaxIndex() > upperHalfInfo.getMinIndex()
	        || lowerHalfInfo.getMinIndex() > upperHalfInfo.getMinIndex()) {
	           throw new IllegalArgumentException("invalid limits");
	   }
	   
		final SubListInfo result = new SubListInfo();
		
		result.setMinIndex(lowerHalfInfo.getMinIndex());
		result.setMaxIndex(upperHalfInfo.getMaxIndex());
		result.setSum(lowerHalfInfo.getSum() + upperHalfInfo.getSum());
		
		return result;
	}
	
	private SubListInfo merge(final SubListInfo lowerHalfInfo, final int middleNumber, final SubListInfo upperHalfInfo) {
      
	   if (lowerHalfInfo.getMaxIndex() > upperHalfInfo.getMinIndex()
	        || lowerHalfInfo.getMinIndex() > upperHalfInfo.getMinIndex()) {
	           throw new IllegalArgumentException("invalid limits");
      }
	   
      final SubListInfo result = new SubListInfo();
      
      result.setMinIndex(lowerHalfInfo.getMinIndex());
      result.setMaxIndex(upperHalfInfo.getMaxIndex());
      
      result.setSum(upperHalfInfo.getSum() + middleNumber + lowerHalfInfo.getSum());
      
      return result;
   }
}