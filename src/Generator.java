import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
 
public class Generator {
	Set<Integer> set = new HashSet<Integer>();
    Integer sum=0;
    List<Integer> list;
    
    WinList winList = new WinList();
    
    List generator() {

        while(set.size() < 6){
            Double d = Math.random() * 45 + 1;
            set.add(d.intValue()); 
            
            sum += d.intValue();
        }
         
        list = new ArrayList<Integer>(set);
        Collections.sort(list);
        
        if(check1()&&check2()&&check3()&&check4()&&check5()&&check6()) {
        	return list;
        }
        
        else {
        	sum = 0;
        	set = new HashSet<Integer>();
        	return generator();
        }
    	
    }
    
    /*조건1: 연속 수가 3쌍이 넘지 않게*/
    boolean check1() {
    	int conti_cnt = 0;
    	for (int i=0; i<5; i++) {
    		int diff = list.get(i+1) - list.get(i);
    		if (diff==1) conti_cnt++;
    	}
    	if (conti_cnt>3) return false;
    	return true;
    }

	/*조건2: 전체 홀짝 제외*/
    boolean check2() {
        int flag = 0;
        for(int i=0; i<6; i++) {
        	int idx = list.get(i)%2;
        	
        	if (i==0) flag = idx;
        	else {
        		if (idx != flag) break;
        	}
        	
        	if (i==5) return false;
        }
        return true;
    }

	/*조건3: 합이 95이상 180 이하*/
    boolean check3() {
        if (sum < 90 || sum > 180) return false;
        
        else return true;
    }
    
    /*조건4: 최대간격이 7이상 22이하*/
    boolean check4() {
    	int diff_max=0;
    	for (int i=0; i<5; i++) {
    		int diff = list.get(i+1) - list.get(i);
    		if (diff>diff_max) diff_max = diff;
    	}
    	if (diff_max<7 || diff_max>22) return false;
    	return true;
    }
    
    /*조건5: 3의배수가 적어도 1번 포함됨*/
    boolean check5() {
    	for (int i=0; i<6; i++) {
    		if (list.get(i)%3==0) return true;
    	}
    	return false;
    }
    
    /*조건6: 지금까지 나온 1등 조합이 나오지 x, 갱신 가능*/
    boolean check6() {
    	List<Set> rntList = winList.getList();
    	
    	for (Set s : rntList) {
    		Set<Integer> tmp = new HashSet<Integer>();
    		for (Integer i: set) {
    			tmp.add(i);
    		}
    		tmp.retainAll(s);
    		if (tmp.size()>=4) return false;
    	}
    	
    	return true;
    }
}

