package hackerrank.array;

import java.util.Scanner;

//https://stackoverflow.com/questions/53543089/new-year-chaos-hackerrank-code-optimization
public class New_Year_Chaos {
    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int bribe = 0;

        for (int i = 0; i < q.length; i++) {
            //기준 자릿수보다 3이상 크다 -> 2번 넘게 bribing해서 앞으로 왔다는 뜻
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            //because it's impossible for any number greater than
            // q[i] reach position q[i] - 2 as only allow two bribes.
            /**
             * Math.max(0, q[i] - 2)의 의미
             * 현재 q[i] 앞에 나를 앞질러간(bribing)한 수를 찾아서 bribe를 increment하는 작업
             * q[q[i] - 2] 부터 q[i - 1] 까지를 검증 범위로 두는 이유는
             * q[i] - 2가 나보다 큰 수가 나를 앞질러 갔을 때 가장 멀리 갈 수 있는 인덱스라서!!!
             */

            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                if (q[j] > q[i]) {
                    bribe++;
                }
            }
        }

        System.out.println(bribe);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}