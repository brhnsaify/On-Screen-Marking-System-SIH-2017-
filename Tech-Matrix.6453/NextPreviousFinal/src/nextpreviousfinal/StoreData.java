
package nextpreviousfinal;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static nextpreviousfinal.OnScreenMarkingSystem.count_next_copy;

public class StoreData 
{
    
    public static void main(String[] args) throws FileNotFoundException, IOException, NotFoundException, ChecksumException, FormatException 
    {
       try 
       {    
           
                 int c = new File ("C:\\Users\\Neo\\Documents\\NetBeansProjects\\NextPreviousFinal\\SudentsFirstPage").list().length;
                 int v = new File ("C:\\Users\\Neo\\Documents\\NetBeansProjects\\NextPreviousFinal\\StudentsZipFIle").list().length;
             File file[]=new File[c];
             FileInputStream fis[]=new FileInputStream[c];
             
             File Fzip [] = new File[v];
             FileInputStream fis2[]=new FileInputStream[v];
           for(int p=0;p<c;p++)
           {
                    file [p]  =new File("C:\\Users\\Neo\\Documents\\NetBeansProjects\\NextPreviousFinal\\SudentsFirstPage\\s"+(p+1)+".png");   
           
                   fis [p]= new FileInputStream(file[p]);
                  
                   BufferedImage image = ImageIO.read(fis[p]); //reading the image file

                    int rows = 8; //You should decide the values for rows and cols variables
                    int cols = 11;
                    int chunks = rows * cols;

                    int chunkWidth = 74; // determines the chunk width and height
                    int chunkHeight = 62;
                    int count = 0;
                    BufferedImage imgs[] = new BufferedImage[chunks]; //Image array to hold image chunks
                      for (int x = 0; x < rows; x++)
                      {
                          for (int y = 0; y < cols; y++) 
                          {
                          //Initialize the image array with image chunks
                          imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

                          // draws the image chunk
                          Graphics2D gr = imgs[count++].createGraphics();
                          gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
                          gr.dispose();
                          }
                      }
                    System.out.println("Splitting done");

                    //writing mini images into image files
                    int j=1;
                      for (int i = 26; i < imgs.length; i++) 
                      {
                          ImageIO.write(imgs[i], "jpg", new File("img" + j + ".jpg"));j++;
                          if(i==32)
                          {
                          i=36;
                          }
                          if(i==43)
                          {
                          i=47;
                          }
                          if(i==54)
                          {
                           i=58;
                          }
                          if(i==65)
                          {
                          i=imgs.length;
                          }
                      }
                    System.out.println("Questions Mini images created");

                    {
                      int chunk;
                      rows = 8; //You should decide the values for rows and cols variables
                      cols = 3;
                      chunk = rows * cols;

                      chunkWidth = 280; // determines the chunk width and height
                      chunkHeight = 66;
                      count = 0;
                      BufferedImage img[] = new BufferedImage[chunk]; //Image array to hold image chunks
                      for (int x = 0; x < rows; x++) 
                      {
                          for (int y = 0; y < cols; y++)
                          {
                              //Initialize the image array with image chunks
                              imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

                              // draws the image chunk
                              Graphics2D gr = imgs[count++].createGraphics();
                              gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
                              gr.dispose();
                          }
                      }
                    //System.out.println("Splitting done");

                    //writing mini images into image files
                      for (int i = 2; i < 6; i++)
                      { 
                          ImageIO.write(imgs[i], "jpg", new File("S"+i+".jpg"));
                          if(i==2)
                          {
                          i=4;
                          }


                      }
                    }
                    System.out.println("Student Info's Mini image created");

                    //oraclle JDBC


                  Class.forName("oracle.jdbc.driver.OracleDriver");

                      Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");

                      PreparedStatement ps=con.prepareStatement("insert into StoreFinal values(?,?,?,?,?)");  

          //CopyNumber
                      {  InputStream barCodeInputStream;
                          barCodeInputStream = new FileInputStream("C:\\Users\\Neo\\Documents\\NetBeansProjects\\NextPreviousFinal\\S2.jpg");
                      BufferedImage barCodeBufferedImage = ImageIO.read(barCodeInputStream);

                      LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);
                      BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                      com.google.zxing.Reader reader = new MultiFormatReader();
                      Result result = reader.decode(bitmap);
                      System.out.println(result.getText());
                      ps.setString(1,result.getText());
                     }

          //SRNo            

                      { InputStream barCodeInputStream;
                          barCodeInputStream = new FileInputStream("C:\\Users\\Neo\\Documents\\NetBeansProjects\\NextPreviousFinal\\S5.jpg");
                      BufferedImage barCodeBufferedImage = ImageIO.read(barCodeInputStream);

                      LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);
                      BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                      com.google.zxing.Reader reader = new MultiFormatReader();
                      Result result = reader.decode(bitmap);
                      System.out.println(result.getText());
                      ps.setString(2,result.getText());
                      }                         


           //QSeq                                      
                      StringBuilder sb= new StringBuilder();
                      StringBuilder sb1= new StringBuilder();
                      

                      for (int k=1;k<=28;k++)
                      {
                        //scanning Barcode and storing them in databse 
                        InputStream barCodeInputStream;
                              barCodeInputStream = new FileInputStream("C:\\Users\\Neo\\Documents\\NetBeansProjects\\NextPreviousFinal\\img"+k+".jpg");
                        BufferedImage barCodeBufferedImage = ImageIO.read(barCodeInputStream);

                        LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);
                        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                        com.google.zxing.Reader reader = new MultiFormatReader();
                        Result result = reader.decode(bitmap);

                        System.out.print(result.getText()+",");
                        ps.setString(3, result.getText()+",");
                        
                      if(result.getText().equals("-1"))
                      { sb1.append(result.getText()+",");
                      } 
                      else
                      {
                      sb.append(result.getText()+",");
                        //System.out.println("Barcode text is " + result.getText()); 
                      }
                      }
                      
                      ps.setString(3, (sb.toString()+sb1.toString()));


                      // Zipstore

                       Fzip [p]= new File("C:\\Users\\Neo\\Documents\\NetBeansProjects\\NextPreviousFinal\\StudentsZipFIle\\S"+(p+1)+".zip");
                          fis2[p] = new FileInputStream(Fzip[p]);
                      ps.setBinaryStream(4, fis2[p], (int) Fzip[p].length());

                      ps.setString(5,"s"+Integer.toString(p+1));
                      
                      
                      int i=ps.executeUpdate();  
                      System.out.println(i+"StoreFinal record affected");                          
                      con.close();
                      
            }
        }
       
       catch (Exception e)
        {
            System.out.println(e);
        }

    }
}


  