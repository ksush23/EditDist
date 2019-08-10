import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lineA = scanner.nextLine();
        String lineB = scanner.nextLine();

        System.out.println(EditDistBU(lineA, lineB));
    }

    public static int EditDistBU(String lineA, String lineB){
        int n = lineA.length();
        int m = lineB.length();

        int[][]Dist = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++){
            Dist[i][0] = i;
        }

        for (int j = 0; j <= m; j++){
            Dist[0][j] = j;
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                int c = Diff(lineA.charAt(i - 1), lineB.charAt(j - 1));
                Dist[i][j] = min(Dist[i][j - 1] + 1, Dist[i - 1][j] + 1, Dist[i - 1][j - 1] + c);
            }
        }

        return Dist[n][m];
    }

    public static int Diff(char a, char b){
        return a != b ? 1 : 0;
    }

    public static int min(int a, int b){
        return a <= b ? a : b;
    }

    public static int min(int a, int b, int c){
        int minAB = min(a, b);
        return minAB <= c ? minAB : c;
    }
}
