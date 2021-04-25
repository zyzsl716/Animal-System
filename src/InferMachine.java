import java.util.ArrayList;
import java.util.Scanner;

public class InferMachine {
    public InferMachine() {
        ArrayList<String> discribe = new ArrayList<String>();   //存字
        ArrayList<String> conclu = new ArrayList<String>();
        String conclusion = "";
        int[] a = new int[25];//判断数组

        int temp, curr_index = 0, conclu_index = 0;



        Scanner s = new Scanner(System.in);


        while (true) {
            while (true)                                          //输入判断
            {
                try {                                                        //防止选错
                    temp = s.nextInt();
                } catch (Exception e) {
                    System.out.println("请输入正确的数字编号!请选择：");
                    s.next();
                    continue;
                }

                if (temp < 0 || temp > 24) {
                    System.out.println("请按规定选择序号！请继续选择：");
                    continue;
                }
                if (temp == 0) {
                    System.out.println("选择完毕！选择了[" + curr_index + "]种特征，开始分析...");
                    break;
                }

                if (a[temp] == 1) {
                    System.out.println("已经有该特征，请勿重复选择请选择：");
                    continue;
                }

                a[temp] = 1;

                switch (temp) {
                    case 1:
                        discribe.add("有毛发");
                        break;
                    case 2:
                        discribe.add("有奶");
                        break;
                    case 3:
                        discribe.add("有羽毛");
                        break;
                    case 4:
                        discribe.add("会飞");
                        break;
                    case 5:
                        discribe.add("吃肉");
                        break;
                    case 6:
                        discribe.add("有犬齿");
                        break;
                    case 7:
                        discribe.add("有蹄");
                        break;
                    case 8:
                        discribe.add("反刍动物");
                        break;
                    case 9:
                        discribe.add("黄褐色");
                        break;
                    case 10:
                        discribe.add("长腿");
                        break;
                    case 11:
                        discribe.add("暗斑点");
                        break;
                    case 12:
                        discribe.add("黑条纹");
                        break;
                    case 13:
                        discribe.add("有黑白二色");
                        break;
                    case 14:
                        discribe.add("长脖子");
                        break;
                    case 15:
                        discribe.add("善飞");
                        break;
                    case 16:
                        discribe.add("不会飞");
                        break;
                    case 17:
                        discribe.add("有爪子");
                        break;
                    case 18:
                        discribe.add("目视前方");
                        break;
                    case 19:
                        discribe.add("会下蛋");
                        break;
                    case 20:
                        discribe.add("会游泳");
                        break;
                    case 21:
                        discribe.add("哺乳动物");
                        break;
                    case 22:
                        discribe.add("鸟");
                        break;
                    case 23:
                        discribe.add("食肉动物");
                        break;
                    case 24:
                        discribe.add("蹄类动物");
                        break;
                }

                System.out.print("该动物是" + discribe.get(curr_index) + "的\n请继续选择：");

                curr_index++;
            }
            //收集完条件开始推断
            conclusion="";

            if (curr_index == 0) {
                System.out.println("没有选到特征，退出程序！");
                return;
            }
            //一种特征
            if (curr_index == 1) {
                if (a[1] + a[2]+a[21] >= 1&&a[1] + a[2] +a[21]== 1)
                    conclusion = "哺乳动物";
                if(((a[22]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[3]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[4]+a[19]==2&&a[3]+a[4]+a[19]+a[22]>=2))&&a[3]+a[4]+a[19]+a[22]==1)
                    conclusion="鸟类";
                if((a[5]+a[6]+a[17]+a[18]+a[23]>=1&&a[23]==1)||(a[5]+a[6]+a[17]+a[18]>=1&&a[5]==1)||(a[6]+a[17]+a[18]==3&&a[5]+a[6]+a[17]+a[18]>=1))
                    conclusion="肉食动物";
            }
            //两种特征
            if (curr_index == 2) {
                if (a[1] + a[2]+a[21] >= 1&&a[1] + a[2] +a[21]== 2)
                    conclusion = "哺乳动物";
                if(((a[22]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[3]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[4]+a[19]==2&&a[3]+a[4]+a[19]+a[22]>=2))&&a[3]+a[4]+a[19]+a[22]==2)
                    conclusion="鸟类";
                if(a[5]+a[6]+a[17]+a[18]==2&&a[5]==1)
                    conclusion="肉食动物";
                if (a[1] + a[2]+a[21] >= 1&&a[7]+a[8]>= 1&&a[1]+a[2]+a[7]+a[8]+a[21]==2)
                    conclusion = "蹄类动物";
                if(((a[22]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[3]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[4]+a[19]==2&&a[3]+a[4]+a[19]+a[22]>=2))&&a[3]+a[4]+a[19]+a[22]==1&&a[15]==1)
                    conclusion="信天翁";
            }
            //三种特征
            if (curr_index == 3) {
                if (a[1]+a[2]+a[21] >= 1&&a[1] + a[2] +a[21]== 3)
                    conclusion = "哺乳动物";
                if(((a[22]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[3]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[4]+a[19]==2&&a[3]+a[4]+a[19]+a[22]>=2))&&a[3]+a[4]+a[19]+a[22]==3)
                    conclusion="鸟类";
                if(a[5]+a[6]+a[17]+a[18]==3&&(a[5]==1||a[6]+a[17]+a[18]==3))
                    conclusion="肉食动物";
                if (a[1] + a[2]+a[21] >= 1&&a[7]+a[8]>= 1&&a[1]+a[2]+a[7]+a[8]+a[21]==3)
                    conclusion = "蹄类动物";
                if (a[1] + a[2]+a[21] >= 1&&a[7]+a[8]>= 1&&a[1]+a[2]+a[7]+a[8]+a[21]==2&&a[12]==1)
                    conclusion = "斑马";
                if(((a[22]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[3]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[4]+a[19]==2&&a[3]+a[4]+a[19]+a[22]>=2))&&a[3]+a[4]+a[19]+a[22]==2&&a[15]==1)
                    conclusion="信天翁";
            }
            //四种特征
            if (curr_index == 4) {
                if(a[5]+a[6]+a[17]+a[18]==4&&(a[5]==1||a[6]+a[17]+a[18]==3))
                    conclusion="肉食动物";
                if (a[1] + a[2]+a[21] >= 1&&a[7]+a[8]>= 1&&a[1]+a[2]+a[7]+a[8]+a[21]==4)
                    conclusion = "蹄类动物";
                if(a[1]+a[2]+a[21]>=1&&((a[5]+a[6]+a[17]+a[18]+a[23]>=1&&a[23]==1)||(a[5]+a[6]+a[17]+a[18]>=1&&a[5]==1)||(a[6]+a[17]+a[18]==3&&a[5]+a[6]+a[17]+a[18]>=1))&&a[9]+a[11]==2&&a[1]+a[2]+a[5]+a[6]+a[17]+a[18]+a[21]+a[23]+a[9]+a[11]==4)
                    conclusion="金钱豹";
                if(a[1]+a[2]+a[21]>=1&&((a[5]+a[6]+a[17]+a[18]+a[23]>=1&&a[23]==1)||(a[5]+a[6]+a[17]+a[18]>=1&&a[5]==1)||(a[6]+a[17]+a[18]==3&&a[5]+a[6]+a[17]+a[18]>=1))&&a[9]+a[12]==2&&a[1]+a[2]+a[5]+a[6]+a[17]+a[18]+a[21]+a[23]+a[9]+a[12]==4)
                    conclusion="虎";
                if (a[1] + a[2]+a[21] >= 1&&a[7]+a[8]>= 1&&a[1]+a[2]+a[7]+a[8]+a[21]==3&&a[12]==1)
                    conclusion = "斑马";
                if(((a[22]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[3]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[4]+a[19]==2&&a[3]+a[4]+a[19]+a[22]>=2))&&a[3]+a[4]+a[19]+a[22]==1&&a[20]+a[16]+a[13]==3)
                    conclusion="企鹅";
                if(((a[22]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[3]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[4]+a[19]==2&&a[3]+a[4]+a[19]+a[22]>=2))&&a[3]+a[4]+a[19]+a[22]==3&&a[15]==1)
                    conclusion="信天翁";
            }
            if (curr_index == 5) {
                if(a[1]+a[2]+a[7]+a[8]+a[24]==5)
                    conclusion="蹄类动物";
                if(a[6]+a[17]+a[18]+a[5]+a[23]==5)
                    conclusion="肉食动物";
                if(a[1]+a[2]+a[21]>=1&&((a[5]+a[6]+a[17]+a[18]+a[23]>=1&&a[23]==1)||(a[5]+a[6]+a[17]+a[18]>=1&&a[5]==1)||(a[6]+a[17]+a[18]==3&&a[5]+a[6]+a[17]+a[18]>=1))&&a[9]+a[11]==2&&a[1]+a[2]+a[5]+a[6]+a[17]+a[18]+a[21]+a[23]+a[9]+a[11]==5)
                    conclusion="金钱豹";
                if(a[1]+a[2]+a[21]>=1&&((a[5]+a[6]+a[17]+a[18]+a[23]>=1&&a[23]==1)||(a[5]+a[6]+a[17]+a[18]>=1&&a[5]==1)||(a[6]+a[17]+a[18]==3&&a[5]+a[6]+a[17]+a[18]>=1))&&a[9]+a[12]==2&&a[1]+a[2]+a[5]+a[6]+a[17]+a[18]+a[21]+a[23]+a[9]+a[12]==5)
                    conclusion="虎";
                if (a[1] + a[2]+a[21] >= 1&&a[7]+a[8]>= 1&&a[1]+a[2]+a[7]+a[8]+a[21]==2&&a[14]+a[10]+a[11]==3)
                    conclusion = "长颈鹿";
                if (a[1] + a[2]+a[21] >= 1&&a[7]+a[8]>= 1&&a[1]+a[2]+a[7]+a[8]+a[21]==4&&a[12]==1)
                    conclusion = "斑马";
                if(((a[22]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[3]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[4]+a[19]==2&&a[3]+a[4]+a[19]+a[22]>=2))&&a[3]+a[4]+a[19]+a[22]==1&&a[14]+a[10]+a[16]+a[13]==4)
                    conclusion="鸵鸟";
                if(((a[22]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[3]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[4]+a[19]==2&&a[3]+a[4]+a[19]+a[22]>=2))&&a[3]+a[4]+a[19]+a[22]==2&&a[20]+a[16]+a[13]==3)
                    conclusion="企鹅";
            }
            if(curr_index==6){
                if(a[1]+a[2]+a[21]>=1&&((a[5]+a[6]+a[17]+a[18]+a[23]>=1&&a[23]==1)||(a[5]+a[6]+a[17]+a[18]>=1&&a[5]==1)||(a[6]+a[17]+a[18]==3&&a[5]+a[6]+a[17]+a[18]>=1))&&a[9]+a[11]==2&&a[1]+a[2]+a[5]+a[6]+a[17]+a[18]+a[21]+a[23]+a[9]+a[11]==6)
                    conclusion="金钱豹";
                if(a[1]+a[2]+a[21]>=1&&((a[5]+a[6]+a[17]+a[18]+a[23]>=1&&a[23]==1)||(a[5]+a[6]+a[17]+a[18]>=1&&a[5]==1)||(a[6]+a[17]+a[18]==3&&a[5]+a[6]+a[17]+a[18]>=1))&&a[9]+a[12]==2&&a[1]+a[2]+a[5]+a[6]+a[17]+a[18]+a[21]+a[23]+a[9]+a[12]==6)
                    conclusion="虎";
                if (a[1] + a[2]+a[21] >= 1&&a[7]+a[8]>= 1&&a[1]+a[2]+a[7]+a[8]+a[21]==3&&a[14]+a[10]+a[11]==3)
                    conclusion = "长颈鹿";
                if (a[1] + a[2]+a[21] >= 1&&a[7]+a[8]>= 1&&a[1]+a[2]+a[7]+a[8]+a[21]==5&&a[12]==1)
                    conclusion = "斑马";
                if(((a[22]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[3]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[4]+a[19]==2&&a[3]+a[4]+a[19]+a[22]>=2))&&a[3]+a[4]+a[19]+a[22]==2&&a[14]+a[10]+a[16]+a[13]==4)
                    conclusion="鸵鸟";
                if(a[3]+a[4]+a[19]+a[20]+a[16]+a[13]==6)
                    conclusion="企鹅";
            }
            if(curr_index==7){
                if(a[1]+a[2]+a[21]>=1&&((a[5]+a[6]+a[17]+a[18]+a[23]>=1&&a[23]==1)||(a[5]+a[6]+a[17]+a[18]>=1&&a[5]==1)||(a[6]+a[17]+a[18]==3&&a[5]+a[6]+a[17]+a[18]>=1))&&a[9]+a[11]==2&&a[1]+a[2]+a[5]+a[6]+a[17]+a[18]+a[21]+a[23]+a[9]+a[11]==7)
                    conclusion="金钱豹";
                if(a[1]+a[2]+a[21]>=1&&((a[5]+a[6]+a[17]+a[18]+a[23]>=1&&a[23]==1)||(a[5]+a[6]+a[17]+a[18]>=1&&a[5]==1)||(a[6]+a[17]+a[18]==3&&a[5]+a[6]+a[17]+a[18]>=1))&&a[9]+a[12]==2&&a[1]+a[2]+a[5]+a[6]+a[17]+a[18]+a[21]+a[23]+a[9]+a[12]==7)
                    conclusion="虎";
                if (a[1] + a[2]+a[21] >= 1&&a[7]+a[8]>= 1&&a[1]+a[2]+a[7]+a[8]+a[21]==4&&a[14]+a[10]+a[11]==3)
                    conclusion = "长颈鹿";
                if(((a[22]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[3]==1&&a[3]+a[4]+a[19]+a[22]>=1)||(a[4]+a[19]==2&&a[3]+a[4]+a[19]+a[22]>=2))&&a[3]+a[4]+a[19]+a[22]==3&&a[14]+a[10]+a[16]+a[13]==4)
                    conclusion="鸵鸟";
            }
            if(curr_index==8){
                if(a[1]+a[2]+a[21]>=1&&((a[5]+a[6]+a[17]+a[18]+a[23]>=1&&a[23]==1)||(a[5]+a[6]+a[17]+a[18]>=1&&a[5]==1)||(a[6]+a[17]+a[18]==3&&a[5]+a[6]+a[17]+a[18]>=1))&&a[9]+a[11]==2&&a[1]+a[2]+a[5]+a[6]+a[17]+a[18]+a[21]+a[23]+a[9]+a[11]==8)
                    conclusion="金钱豹";
                if(a[1]+a[2]+a[21]>=1&&((a[5]+a[6]+a[17]+a[18]+a[23]>=1&&a[23]==1)||(a[5]+a[6]+a[17]+a[18]>=1&&a[5]==1)||(a[6]+a[17]+a[18]==3&&a[5]+a[6]+a[17]+a[18]>=1))&&a[9]+a[12]==2&&a[1]+a[2]+a[5]+a[6]+a[17]+a[18]+a[21]+a[23]+a[9]+a[12]==8)
                    conclusion="虎";
                if (a[1]+a[2]+a[7]+a[8]+a[21]+a[14]+a[10]+a[11]==8)
                    conclusion = "长颈鹿";
            }
            if(curr_index==9){
                if(a[1]+a[2]+a[21]>=1&&((a[5]+a[6]+a[17]+a[18]+a[23]>=1&&a[23]==1)||(a[5]+a[6]+a[17]+a[18]>=1&&a[5]==1)||(a[6]+a[17]+a[18]==3&&a[5]+a[6]+a[17]+a[18]>=1))&&a[9]+a[11]==2&&a[1]+a[2]+a[5]+a[6]+a[17]+a[18]+a[21]+a[23]+a[9]+a[11]==9)
                    conclusion="金钱豹";
                if(a[1]+a[2]+a[21]>=1&&((a[5]+a[6]+a[17]+a[18]+a[23]>=1&&a[23]==1)||(a[5]+a[6]+a[17]+a[18]>=1&&a[5]==1)||(a[6]+a[17]+a[18]==3&&a[5]+a[6]+a[17]+a[18]>=1))&&a[9]+a[12]==2&&a[1]+a[2]+a[5]+a[6]+a[17]+a[18]+a[21]+a[23]+a[9]+a[12]==9)
                    conclusion="虎";
            }
            if(curr_index==10){
                if(a[1]+a[2]+a[21]>=1&&((a[5]+a[6]+a[17]+a[18]+a[23]>=1&&a[23]==1)||(a[5]+a[6]+a[17]+a[18]>=1&&a[5]==1)||(a[6]+a[17]+a[18]==3&&a[5]+a[6]+a[17]+a[18]>=1))&&a[9]+a[11]==2&&a[1]+a[2]+a[5]+a[6]+a[17]+a[18]+a[21]+a[23]+a[9]+a[11]==10)
                    conclusion="金钱豹";
                if(a[1]+a[2]+a[21]>=1&&((a[5]+a[6]+a[17]+a[18]+a[23]>=1&&a[23]==1)||(a[5]+a[6]+a[17]+a[18]>=1&&a[5]==1)||(a[6]+a[17]+a[18]==3&&a[5]+a[6]+a[17]+a[18]>=1))&&a[9]+a[12]==2&&a[1]+a[2]+a[5]+a[6]+a[17]+a[18]+a[21]+a[23]+a[9]+a[12]==10)
                    conclusion="虎";
            }
            System.out.println("\n分析完毕！由条件");
            for (int i = 0; i < discribe.size(); i++)
                System.out.println(discribe.get(i));
            for (int i = 0; i < conclu.size(); i++)
                if(!discribe.contains(conclu.get(i)))
                    System.out.println(conclu.get(i));
            System.out.println("判断出该动物是：" + (conclusion == "" ? "暂时还没有学习到的未知生物" : conclusion));

            System.out.println("请问还要继续判断吗？(1确认\\0否定)");
            int is_continue=0;
            while(true){
                try {                                                        //防止选错
                    is_continue = s.nextInt();
                } catch (Exception e) {
                    System.out.println("请输入正确的数字编号!请选择：");
                    s.next();
                    continue;
                }
                if(is_continue!=1&&is_continue!=0)
                {
                    System.out.println("请输入0或1！");
                    continue;
                }
                break;
            }
            if(is_continue==1) {
                System.out.println("请选择特征（0表示退出）：");
                if(conclu.contains(conclusion)||conclusion=="")
                    continue;
                conclu.add(conclusion);
                conclu_index++;
                continue;
            }
            break;
        }
        //System.out.println(curr_index);

    }

}
