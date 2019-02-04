import java.util.ArrayList;
import java.util.List;

public class NumList
{
    private Long bnusNo;

    private Long drwtNo3;

    private Long drwtNo2;

    private Long drwtNo1;

    private Long firstWinamnt;

    private Long totSellamnt;

    private Long drwtNo6;

    private Long drwtNo5;

    private String drwNoDate;

    private Long drwtNo4;

    private Long drwNo;

    private Long firstPrzwnerCo;

    public NumList(){}

    public Long getBnusNo ()
    {
        return bnusNo;
    }

    public void setBnusNo (Long bnusNo)
    {
        this.bnusNo = bnusNo;
    }

    public Long getDrwtNo3 ()
    {
        return drwtNo3;
    }

    public void setDrwtNo3 (Long drwtNo3)
    {
        this.drwtNo3 = drwtNo3;
    }

    public Long getDrwtNo2 ()
    {
        return drwtNo2;
    }

    public void setDrwtNo2 (Long drwtNo2)
    {
        this.drwtNo2 = drwtNo2;
    }

    public Long getDrwtNo1 ()
    {
        return drwtNo1;
    }

    public void setDrwtNo1 (Long drwtNo1)
    {
        this.drwtNo1 = drwtNo1;
    }

    public Long getFirstWinamnt ()
    {
        return firstWinamnt;
    }

    public void setFirstWinamnt (Long firstWinamnt)
    {
        this.firstWinamnt = firstWinamnt;
    }

    public Long getTotSellamnt ()
    {
        return totSellamnt;
    }

    public void setTotSellamnt (Long totSellamnt)
    {
        this.totSellamnt = totSellamnt;
    }

    public Long getDrwtNo6 ()
    {
        return drwtNo6;
    }

    public void setDrwtNo6 (Long drwtNo6)
    {
        this.drwtNo6 = drwtNo6;
    }

    public Long getDrwtNo5 ()
    {
        return drwtNo5;
    }

    public void setDrwtNo5 (Long drwtNo5)
    {
        this.drwtNo5 = drwtNo5;
    }

    public String getDrwNoDate ()
    {
        return drwNoDate;
    }

    public void setDrwNoDate (String drwNoDate)
    {
        this.drwNoDate = drwNoDate;
    }

    public Long getDrwtNo4 ()
    {
        return drwtNo4;
    }

    public void setDrwtNo4 (Long drwtNo4)
    {
        this.drwtNo4 = drwtNo4;
    }

    public Long getDrwNo ()
    {
        return drwNo;
    }

    public void setDrwNo (Long drwNo)
    {
        this.drwNo = drwNo;
    }

    public Long getFirstPrzwnerCo ()
    {
        return firstPrzwnerCo;
    }

    public void setFirstPrzwnerCo (Long firstPrzwnerCo)
    {
        this.firstPrzwnerCo = firstPrzwnerCo;
    }
    
    public String toString() {
    	return drwNo + "È¸Â÷: " +  "[" +
    			drwtNo1 + ", " + drwtNo2 + ", " +
    			drwtNo3 + ", " + drwtNo4 + ", " +
    			drwtNo5 + ", " + drwtNo6 + " + " + bnusNo +"]\n";
    }
    
    public List<Long> numbers(){
    	List<Long> list = new ArrayList<Long>();
    	//list.add(drwNo);
    	
    	list.add(drwtNo1);
    	list.add(drwtNo2);
    	list.add(drwtNo3);
    	list.add(drwtNo4);
    	list.add(drwtNo5);
    	list.add(drwtNo6);
    	
    	return list;
    }
    
    
}