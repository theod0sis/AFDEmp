
public class Counter {
	private int mCnt = 0;

    public int increment() {
        return ++mCnt;
    }

    public int getCounter() {
        return mCnt;
    }
    
    public boolean ifprime(Counter c){
    	for (int i=2;i<c.getCounter();i++){
    		if ((c.getCounter()%i)==0){
    			return true;
    		}
    	}
    	return false;
    }
}


