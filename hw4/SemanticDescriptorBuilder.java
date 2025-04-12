package hw4;

import java.util.ArrayList;
import java.util.HashMap;

public class SemanticDescriptorBuilder extends SemanticDescriptors{
    //FINAL????? ENEKATALAVA TI EGRAPSAME RE ANDY

    //MALAKA TO VSC PROTEINEI MOU RECOMMENDED LEKSEIS NA SYMPLIRWSEI STA GREEKLISH

    public SemanticDescriptorBuilder(HashMap<String, HashMap<String, Integer>> map) {
        super(map);
    }   

    public final HashMap<String, HashMap<String, Integer>> listToMap(ArrayList<ArrayList<String>> listOfLists) {
    /**
     * code
     */
    return new SemanticDescriptorBuilder(map).getMap();
    }
    //map???? en arga en mporw na skeftw traaa
}
