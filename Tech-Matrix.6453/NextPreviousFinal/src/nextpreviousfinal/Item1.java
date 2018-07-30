/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextpreviousfinal;

/**
 *
 * @author USER
 */
public class Item1 {
     private byte[] image1;
    
    public Item1(/*String ID, String NAME, String DESCRIPTION,*/ byte[] IMAGE1)
    {
        //this.id = ID;
        //this.name = NAME;
        //this.description = DESCRIPTION;
        this.image1 = IMAGE1;
    }
    
    /*public String getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getDescription()
    {
        return description;
    }*/
    
    public byte[] getImage()
    {
        return image1;
    }
    
}
