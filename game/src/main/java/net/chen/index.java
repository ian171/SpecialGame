package net.chen;



import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;


public class index {
    public static int fxp;
    public static int odp;

    public static void main(String[] args) throws InterruptedException {
        //System.out.println("Hello world!");
        Fighter f = new Fighter();
        Mosters ms = new Mosters();
        functions functions = new functions();//functions imported
        gameBody gameBody = new gameBody();//gameBody imported
        Scanner s = new Scanner(System.in);//Scanner imported
        functions.clearS();//clear the screen
        gameBody.Screen(0);
        gameBody.Screen(1);
        boolean sex;
        String sexs = s.nextLine();
        //性别咨询
        if(Objects.equals(sexs, "1")){
                sex= true;
        }else if (Objects.equals(sexs, "0")){
                sex = false;
        }


        System.out.println("当前武器："+gameBody.Sword("ironS"));
        String mainTools = gameBody.Sword("ironS");
        fxp = 1;
        gameBody.Screen(3);
        while (true){
        //循环开始
            int choose = s.nextInt();
            //选项一
            if (choose == 1){
                ArrayList<String> mslist = new ArrayList<>();
                mslist.add("ikuuu");
                mslist.add("qkunn");
                mslist.add("equuu");
                System.out.println(mslist);
                System.out.println("输入决斗的monsterID");
                int monsterChoice = s.nextInt();
                if(f.compare(monsterChoice) == 1){
                    System.out.println("玩家赢");
                    odp = odp + 1;
                    Thread.currentThread().sleep(1000);
                    functions.clearS();
                    gameBody.Screen(3);
                }else if (f.compare(monsterChoice)== 0){
                    System.out.println("怪物赢!");
                    odp = odp - 1;
                    Thread.currentThread().sleep(1000);
                    functions.clearS();
                    gameBody.Screen(3);
                }else {
                    System.out.println("平手...");
                    Thread.currentThread().sleep(1000);
                    functions.clearS();
                    gameBody.Screen(3);
                }
            }else if(choose == 2){//选项2
                gameBody.Screen(4);
                choose = s.nextInt();
                if (choose == 1){
                    System.out.println(fxp);
                }else if (choose == 2){
                    System.out.println(odp);
                }
                gameBody.Screen(3);
            }else if(choose == 3){//选项3
                functions.clearS();
                System.err.println("正在退出");
                System.exit(1);
            }else if (choose == 4){//选项4
                choose = 0;//reset choose
                functions.clearS();
                gameBody.Screen(5);
                choose = s.nextInt();
                if (choose == 1){//4.1
                    System.out.println(gameBody.ch_crafting);
                    choose = s.nextInt();
                    if (choose == 1){//4.1.1
                        choose = 0;//reset choose
                        if(fxp<30){
                            System.out.println(gameBody.ch_failed_crafting);
                        }else if(fxp>=30){
                            fxp =fxp - 30;
                            mainTools = gameBody.Sword("WSword");
                            System.out.println("合成"+gameBody.Sword("WSword")+"剩余fxp"+fxp);
                        }
                    }else if(choose == 2){//4.1.2
                        choose = 0;//reset choose
                        if(fxp<60){
                            System.out.println(gameBody.ch_failed_crafting);
                        }else if(fxp>=60){
                            fxp =fxp - 60;
                            mainTools = gameBody.Sword("mixIngotSword");
                            System.out.println("合成"+gameBody.Sword("mixIngotSwordd")+"剩余fxp"+fxp);
                        }
                    }
                }else if(choose == 2){//4.2
                    choose = 0;//reset choose
                    System.out.println(mainTools);
                }
            }
        }
    }

}
class functions{
    public void clearS(){
        try{
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
class gameBody{
    //Languages
    private final String ch_start = "你好，请完成首次注册";
    private final String ch_manOrwoman = "冒险者，你是男/女？输入1为男 0为女";
    private final String ch_slot = "物品栏";
    private final String ch_ironSword = "铁剑";
    private final String ch_WSword = "钨钢剑";
    public final String ch_crafting = "可合成以下武器 \n1.钨钢刀（30fxp）\n2.合金刀(60fxp)";
    public final String ch_failed_crafting = "fxp不足，无法合成";
    private final String ch_mixIngotSword="合金剑";
    private final String ch_main ="1.决斗"+"\n"+"2.属性"+"\n"+"3.退出"+"\n"+"4.合成"+"\n";

    public void Screen(int c){
        if(c == 0){
            System.out.println(ch_start);
        }else if (c == 1){
            System.out.println(ch_manOrwoman);
        }else if(c == 2){
            System.out.println(ch_slot);
        }else if(c == 3){
            //Main asking
            System.out.print(ch_main);
        }else if (c==4){
            System.out.print("1.战斗力"+"\n"+"2.opd"+"\n");
        }else if (c==5){
            System.out.print("1.合成武器"+"\n"+"2.检查主武器");
        }
    }
    public String Sword(String s){
        ArrayList<String> Swords = new ArrayList<String>();
        Swords.add(ch_ironSword);
        Swords.add(ch_WSword);
        Swords.add(ch_mixIngotSword);
        if (s == "ironS"){
            return Swords.get(0);
        }else if(s == "WSword"){
            return Swords.get(1);
        }else if (s == "mixIngotSword"){
            return Swords.get(2);
        }else{
            return "0";
        }

    }
}