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
public class Item {
    private byte[] image;
    
    public Item(/*String ID, String NAME, String DESCRIPTION,*/ byte[] IMAGE)
    {
        //this.id = ID;
        //this.name = NAME;
        //this.description = DESCRIPTION;
        this.image = IMAGE;
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
        return image;
    }
    
}
