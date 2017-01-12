public class Main {
    public static void main(String[] args) {
        String key = "sleutel".toUpperCase();
        String ori = "nzsl hprp xxvow xydwe siv np heukwnztnhemuc aum rwrsem. lzx gy olw aie pilwic hen kaifxr, yy dsxl lym pusxy apjv. oszj vmt swm dx swpp zvzlp axxldwih rzvtk. my oi nzpaxrow syyiyayk zelf ay lpl aye mwaildiy ksxtx bp hbie ei eeyy qixx jpoygiy. f mm 2382929 pf i bw 1399. ggzv aie nsxxvpf zug ow zcxvow xydwe tw xpv veltoewc gxkysie yeuk lknmc. osy tbny pv lxpwow mapw oukevlpvm wlepraxrzepr brndfwcxj dpimmivwyw.aie pillxp hilw ewwoygw epx 256 gilfiyarzoehtyo yg swe npipvp ykftb gakymiwv. xtx ypxue hwch wey dxyxhd riwhhpwch. lpl ihmiclpoyg tk rihme riwhhpwch wy mmipvd axazgy ioicyprifiy. lym cwdyfmell mm ipf vyxod rintpwwy xbi nzsl hp vfmxxptbvlybh vzsl wasemyl rwdgbxmowy tbny. hysi kaenbid xsymiy oym rtwe qhvowy yphyvsowpvx. xstp gelke dx zhwsmlmyypr hsv oi peljoih zlf t, u wy x sa.".toUpperCase();
        int[][] vigTable = createVigenereTable();
        String newKey = reformat(ori, key);
        System.out.println(decrypt(ori, newKey, vigTable));
    }

    public static String decrypt(String text, String key, int[][] vigTable) {
        String solution = "";
        for(int i = 0; i < text.length(); i++) {
            char textL = text.charAt(i);
            char keyL = key.charAt(i);
            char decryptedLetter = lookupLetter((int) textL, (int) keyL, vigTable);
            solution += decryptedLetter;
        }
        return solution;
    }

    public static char lookupLetter(int textLetter, int keyLetter, int[][] vigTable) {
        if(keyLetter >= 65 && keyLetter <= 90) {
            for(int i = 0; i < vigTable[keyLetter-65].length; i++) {
                if(vigTable[keyLetter-65][i] == textLetter)
                    return (char)(i + 65);
            }
        }
        return (char)textLetter;
    }

    public static String reformat(String s, String key) {
        int repeatKey = 2 * s.length() / key.length();
        String newKey = "";

        for(int i = 0; i < repeatKey; i++) {
            newKey += key;
        }

        return newKey.substring(0, s.length());
    }

    public static int[][] createVigenereTable()
    {
        int table[][]=new int[26][26];
        int rem=0, n=26;
        int value;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                value=j+rem;
                if(value>25)
                {
                    value=value-26;
                }
                table[i][j]=value+65;
            }
            rem++;
        }
        return table;
    }
}