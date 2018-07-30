import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author LENOVO
 */
public class Test 
{
    public static  Set<Integer> difference(Set<Integer> set1,Set<Integer> set2)
    {
        Set<Integer> tmp=new TreeSet<Integer>(set1);
        tmp.removeAll(set2);
        return tmp;
    }
    
    public static void main(String[] args) {
        String str=null;

          try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");         
                Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                
                //for() total number of questions attempted times...         
                ResultSet rs=stmt.executeQuery("select * from StoreFinal");  
       
                rs.absolute(1);
                str = rs.getString(3); 
                String Arr[]=str.split(",");
                System.out.println("Array size : "+Arr.length);
            /*    for(int i=0;i<Arr.length;i++)
                {
                    System.out.println(Arr[i]);
                }*/
                
                int[] results = new int[Arr.length];
                
                for (int j = 0; j < Arr.length; j++) 
                {
                    results[j] = Integer.parseInt(Arr[j]);
                    if(results[j]==(-1))
                    {
                        break;
                    }
                    System.out.println(results[j]);
                }
                
                        String Arr2[] = new String [Arr.length];
                for(int n=0; n<Arr.length;n++)
                {
                         Arr2[n]= String.valueOf((n+1));
                         
                System.out.println(Arr2[n]);
                }
                
                TreeSet<Integer> setA=new TreeSet<Integer>();
        TreeSet<Integer> setB=new TreeSet<Integer>();
        
        
        for(int i=0;i<Arr.length;i++)
        {
            setA.add(Integer.parseInt(Arr2[i]));
        }
        for(int i=0;i<Arr.length;i++)
        {   if(Arr[i].equals("-1"))
             {
             break;
             }
            setB.add(Integer.parseInt(Arr[i]));
        }
        
        int x=Test.difference(setA,setB).size();
        Iterator it=Test.difference(setA, setB).iterator();
        while(it.hasNext())
                    System.out.println("Element : "+it.next());
        //System.out.println("Difference : "+difference(setA,setB)+" and number of elements : "+x);
                
                
            }
                catch (Exception e){System.out.println(""+e);}
        
    }
          
}

