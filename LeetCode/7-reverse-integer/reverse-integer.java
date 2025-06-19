class Solution {
    public int reverse(int x) {
        Queue<Integer> st = new LinkedList<>();
        boolean neg = false;
        if(x < 0) {
            neg = true;
            x *= (-1);
        }
        while(x > 0) {
            int digitPlace = x % 10;
            st.add(digitPlace);
            x /= 10;
        }

        int ans = 0;
        while(!st.isEmpty()){
            int digit = st.remove();
            if(ans > (Integer.MAX_VALUE - digit) / 10){
                return 0;
            }
            ans *= 10;
            ans += digit;
        }

        return (neg==true)? (-1)*ans : ans;
    }

    void printQueue(Queue<Integer> queue){
        Queue<Integer> q1 = new LinkedList(queue);
        while(!q1.isEmpty()){
            System.out.println(q1.peek());
            q1.remove();
        }
    }

    boolean checkIfOverflow(boolean neg, int ans) {
        return ans < 0;
    }
}