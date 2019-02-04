import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WinList {
	
	String path = "RecentWinList.txt";
	List<Set> list;
	Set<Integer> set;
	public WinList() {
		list = new ArrayList<Set>();
		set = new HashSet<Integer>();
		readFile();
	}
	
	public void readFile() {
		
		try {
			File file = new File("RecentWinList.txt");
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null){
            	String[] str = line.split(" ");//Integer.parseInt(line.split(" ").toString());
            	for (String o: str) {
            		set.add(Integer.parseInt(o));
            	}
                
                list.add(set);
               // System.out.println(list.get(0));
                set = new HashSet<Integer>();
               
            }           
            bufReader.close();

		} catch (FileNotFoundException e) {
			new LoadRecentNum();
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public List<Set> getList() {
		return list;
	}
	
}