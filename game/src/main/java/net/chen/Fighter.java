package net.chen;

import static net.chen.index.fxp;

public class Fighter {
        public int compare(int monster) {
            int mactor = 0;
            if (monster == 1) {
                mactor = 1;//ikuuu
            }else if(monster == 2){
                mactor = 2;//qkunn
            }else if(monster ==3){
                mactor =3;//ekuuu
            }

            if (fxp > mactor) {
                //System.out.println("玩家赢!");
                return 1;
            } else if (fxp < mactor) {
                //System.out.println("怪物赢!");
                return 0;
            }else{
                return -1;
            }
        }
    }




