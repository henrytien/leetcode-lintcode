public class MyCalendar {
   java.util.BitSet bitSet;
	public MyCalendar() {
        this.bitSet = new java.util.BitSet(1000000000); //1 with 9 zero
	}

	public boolean book(int start, int end) {
		int n = bitSet.nextSetBit(start); //查找下一个true
		if (n >= end || n == -1) { 
			bitSet.set(start, end);
			return true;
		}
		return false;
	}
}


