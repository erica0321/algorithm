import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int G = Integer.parseInt(br.readLine());

    long remember= 1;
    long now =2;

    boolean canFind = false;
    while(now < 100000) {
      long p_remember = remember * remember;
      long p_now = now * now;
      long diff = p_now - p_remember;

      if(diff == G) {
        System.out.println(now);
        canFind = true;
      }

      if(diff > G) remember++;
      else now++;
    }
    if(!canFind) {
      System.out.println(-1);
    }
  }
}