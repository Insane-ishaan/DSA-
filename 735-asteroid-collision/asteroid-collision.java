class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int a : asteroids) {
            while (!st.isEmpty() && st.peek() > 0 && a < 0) {
                int collision = st.peek() + a;

                if (collision < 0) {
                    st.pop();
                } else if (collision > 0) {
                    a = 0;
                } else {
                    st.pop();
                    a = 0;
                }
            }

            if (a != 0) {
                st.push(a);
            }
        }

        int result[] = new int[st.size()];
        int idx = result.length - 1;
        while (!st.isEmpty()) {
            result[idx--] = st.pop();
        }

        return result;
    }
}