class Logger {

    HashMap<String, Integer> tracker;
    public Logger() {
        tracker = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(tracker.containsKey(message)){
            if(tracker.get(message) <= timestamp){
                tracker.replace(message, timestamp + 10);
                return true;
            }else{
                return false;
            }
        }else{
            tracker.put(message,timestamp + 10);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
