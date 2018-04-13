package viresh.com.score597;

import viresh.com.score597.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DrawerData {
    List<Map<String,?>> drawerList;
    public static final int TYPE1 = 1;
    public static final int TYPE2 = 2;
    public static final int TYPE3 = 3;

    public List<Map<String, ?>> getDrawerList() {
        return drawerList;
    }

    public int getSize(){
        return drawerList.size();
    }

    public HashMap getItem(int i){
        return (HashMap) drawerList.get(i);
    }

    public DrawerData(){
        HashMap item;
        drawerList =new ArrayList<Map<String,?>>();

        item = new HashMap();
        item.put("type",TYPE1); item.put("icon", R.drawable.icon1); item.put("title", "Home");
        drawerList.add(item);
        item = new HashMap();
        item.put("type",TYPE1); item.put("icon", R.drawable.icon2); item.put("title", "Basketbal Rooster");
        drawerList.add(item);
        item = new HashMap();
        item.put("type",TYPE1); item.put("icon", R.drawable.icon3); item.put("title", "Voetbal Rooster");
        drawerList.add(item);
        item = new HashMap();

//        item = new HashMap();
//        item.put("type",TYPE2); item.put("icon", R.drawable.simple_line);
//        drawerList.add(item);

//        item = new HashMap();
//        item.put("type",TYPE3); item.put("title", "Over Score597");
//        drawerList.add(item);
    }



}