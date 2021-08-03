import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BullsAndCows {
        public static void main(String[] args) throws IOException {
            creategame();
        }

        public static boolean stepBool(String step, ArrayList<Integer> strings1) throws IOException {
            int numCows = 0;
            int numBulls = 0;
            String[] strings = step.split("");
            for (int i =0; i < strings.length; i++){
                for (int j =0; j < strings.length; j++){
                    if(Integer.parseInt(strings[i]) == strings1.get(j) && i == j) {
                        numBulls ++;
                        if (numBulls == 4) {
                            System.out.println("Вы победили!");
                            System.out.println("Еще играть будем? (Y/N)");
                            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                            String equestion = reader.readLine();
                            boolean vopr = true;
                            while (vopr){
                                if(equestion.equals("Y") || equestion.equals("y") || equestion.equals("N") || equestion.equals("n")) {
                                    if (equestion.equals("Y") || equestion.equals("y")) creategame();
                                    vopr = false;
                                }
                                else {
                                    System.out.println("Вы ввели неверную букву, попробуйте еще раз");
                                    equestion = reader.readLine();
                                }
                            }
                            return true;
                        }
                    }
                    else if(strings[i].equals(Integer.toString(strings1.get(j)))) numCows ++;
                }
            }
            System.out.println("Быков: " + numBulls + " Коров: " + numCows + "  ");
            return false;
        }
        public static void creategame() throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int numStep = 1;
            String bk = "";
            ArrayList<Integer> arrayList = new ArrayList<>(4);
            Random random = new Random();

            while (arrayList.size() < 4) {
                int i = random.nextInt(10);
                if (!arrayList.contains(i)) {
                    arrayList.add(i);
                    bk += Integer.toString(i);
                }
            }
            boolean isWin = false;
            while (!isWin){
                System.out.print("Попытка № " + numStep + ". Введите  число: ");
                String step = reader.readLine();
                try{
                    int isNum = Integer.parseInt(step);
                    numStep ++;
                    isWin = stepBool(step, arrayList);
                }catch (Exception e){
                    System.out.println("Вы ввели не число, введите число");
                }
            }
        }
}

