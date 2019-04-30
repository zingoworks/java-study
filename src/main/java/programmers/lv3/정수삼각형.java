package programmers.lv3;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 정수삼각형 {

    public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if(j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if(j == triangle[i].length - 1) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }

        return Arrays.stream(triangle[triangle.length - 1]).max().orElse(-1);
    }
    
    @Test
    public void test() {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        assertThat(solution(triangle)).isEqualTo(30);
    }

}
