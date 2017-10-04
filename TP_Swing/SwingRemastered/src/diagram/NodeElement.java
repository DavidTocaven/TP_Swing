/**
 *  A node element represents any kind of node symbol that appears in a
 *	collaboration diagram. A concrete example of this is an
 *	instance symbol.
 *
 *  @author	K Barclay
 */



package diagram;



import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.*;
import javax.swing.*;
import javax.swing.event.PopupMenuListener;


import window.*;



public abstract class NodeElement	extends ModelElement {

	public		NodeElement(int upperLeftX, int upperLeftY) {
    	bounds = new Rectangle(upperLeftX, upperLeftY, DEFAULTWIDTH, DEFAULTHEIGHT);
    	showFlag = false;
    	
    	// Initialisation de theMousePoint et startMousePOint
    	theMousePoint = new Point();
    	theStartMousePoint = new Point();
    	
    	propertyPanel = ColliePropertyPanel.getColliePropertyPanel();
    }
    public		NodeElement(Point mousePoint) {
    	this(mousePoint.x, mousePoint.y);
    }
    
    
    public boolean	isHit(int mouseX, int mouseY) {
    	return bounds.contains(mouseX, mouseY);
    }
    

    public Point	getLocation()			{ return bounds.getLocation(); }
    public Rectangle	getBounds()			{ return bounds; }
    
    public void		setLocation(int x, int y)	{ bounds.setLocation(x, y); }
    public void		setLocation(Point point)	{ this.setLocation(point.x, point.y); }
     
    public String	getName()			{ return name; }
    public void		setName(String name)		{ this.name = name; }
    
    public String	getClassifier()			{ return classifier; }
    public void		setClassifier(String classifier)	{ this.classifier = classifier; }
    
    public ArrayList	getAttributes()			{ return attributes; }
    
    
    
    public boolean	isShowAttributes()		{ return showFlag; }
    public void		setShowAttributes(boolean show)	{ showFlag = show; }
    
    
	
    
    
    public void		addRelation(LinkageElement relation) {
        if(relation != null)
            theRelations.add(relation);
    }
    
    
    
    public void		doRightMousePressed(MouseEvent event, Graphics graphicsContext) {
    	System.out.println("Right Mouse");
    	
    	// Codé le 24/09/2017
    	// PopupMenu COnfiguration Question 3
        JPopupMenu popmenu = new JPopupMenu("Menu Contextuel");
    	
    	// Ajout au menu
    	popmenu.add(itemEdit.getItem());
    	popmenu.add(itemEditAtt.getItem());
    	popmenu.add(itemShow.getItem());
    	popmenu.add(itemDelete.getItem());
    	
    	// Affichage du PopupMenu
    	popmenu.show( event.getComponent() ,event.getX(), event.getY());
    }
    
    
    
    /*
     *  Pseudo mouse button event handlers for the start of dragging a node. We note
     *	the mouse position for subsequent dragging operations and we also record
     *	the mouse point as the start point of the dragging activity.
     */
    public void		doLeftMousePressed(MouseEvent event, Graphics graphicsContext) {
    	//theMousePoint.setLocation(event.getPoint());
    	// Récuérer le coin Gauche Haut de l'image et faire la soustraction avec la position du pointeur
    	//System.out.println("x = " + theMousePoint.x + ", y = "+ theMousePoint.y);
    	//System.out.println("nom : "+ this.name);
    	//System.out.println("att" + attributes);
    	System.out.println("position : " + bounds.getHeight()+ " " + bounds.getWidth());
    	propertyPanel.ShowProperties();//TODO
    }
    
    /*
     *  The node has arrived at it new position. Reposition the node according to the
     *	new mouse location.
     */
	public void		doLeftMouseReleased(MouseEvent event, Graphics graphicsContext) {
    	// ajout le 21/09
    	// On prend le dernier point de la souris
    	theMousePoint.setLocation(event.getPoint());
    	
    	System.out.println("propertyPanel limit X = " + diagramPanel.getCollieDiagramPanel().getHeight());
    	
    	// Codé le 24/09/2017
    	// Modifie la location de l'image selon l'endroit de la souris
    	//setLocation(theMousePoint);
    	
    //	draw(graphicsContext.create(theMousePoint.x, theMousePoint.y, DEFAULTWIDTH, DEFAULTHEIGHT));
    }
    
    /* 
     *	Render the node in its original position to obliterate it, then redraw
     *  it at its new location.
     */
    public void		doLeftMouseDragged(MouseEvent event, Graphics graphicsContext) {
    	// ajout le 21/09 
    	theMousePoint = (event.getPoint());
    	System.out.println("x = " + theMousePoint.x + ", y = "+ theMousePoint.y);
    	setLocation(control_x(event.getPoint().x),control_y(event.getPoint().y)); 		//	Enlevé le 03/10/2017. RAison : c'est de la merde putain
    	
//    	draw(graphicsContext.create(theMousePoint.x, theMousePoint.y, DEFAULTWIDTH, DEFAULTHEIGHT));
	
    }
    

    
    /*	Encapsule la donnée dans le panel*/
    private int control_y(int y) {
		if(y < 0) {
			System.out.println("Error Y ");
			return 0;
			
		}else  if(y > CollieDiagramPanel.getCollieDiagramPanel().getHeight()){
			System.out.println("Error Y Bas ");
			return  CollieDiagramPanel.getCollieDiagramPanel().getHeight()  + DEFAULTHEIGHT;
		}else
		{
			return y;
		}
	}
    /*	Encapsule la donnée dans le panel*/
    private int control_x(int x) {
		if(x < 0) {
			System.out.println("Error X ");
			return 0;
			
		}else  if(x > CollieDiagramPanel.getCollieDiagramPanel().getWidth()){
			return CollieDiagramPanel.getCollieDiagramPanel().getWidth() - DEFAULTWIDTH;
		}else
		{
			return x;
		}
	}
    
    
	public void		updateRelations(int offsetX, int offsetY) {
    	final int size = theRelations.size();
    	for(int k = 0; k < size; k++) {
    	    LinkageElement relation = (LinkageElement)theRelations.get(k);
    	    relation.update(this, offsetX, offsetY);
    	}
    }
    
    
    
    public int		getCompassBearing(Point point) {
    	return this.getCompassBearing(point.x, point.y);
    }
    
    public int		getCompassBearing(int x, int y) {
    	if(x < bounds.x && y < bounds.y)
    	    return NORTHWEST;
    	else if(x > (bounds.x + bounds.width) && y < bounds.y)
    	    return NORTHEAST;
    	else if(y < bounds.y)
    	    return NORTH;
    	else if(x < bounds.x && y > (bounds.y + bounds.height))
    	    return SOUTHWEST;
    	else if(x > (bounds.x + bounds.width) && y > (bounds.y + bounds.height))
    	    return SOUTHEAST;
    	else if(y > (bounds.y + bounds.height))
    	    return SOUTH;
    	else if(x < bounds.x)
    	    return WEST;
    	else if(x > (bounds.x + bounds.width))
    	    return EAST;
    	else
    	    return CENTRE;
    }
    
    public boolean		isNorth(final Point point) 			{ return (this.getCompassBearing(point) == NORTH); }
    public boolean		isWest(final Point point) 			{ return (this.getCompassBearing(point) == WEST); }
    public boolean		isEast(final Point point) 			{ return (this.getCompassBearing(point) == EAST); }
    public boolean		isSouth(final Point point) 			{ return (this.getCompassBearing(point) == SOUTH); }
    public boolean		isNortherly(final Point point) 			{ final int compass = this.getCompassBearing(point); return (compass == NORTHWEST || compass == NORTH || compass == NORTHEAST); }
    public boolean		isWesterly(final Point point) 			{ final int compass = this.getCompassBearing(point); return (compass == NORTHWEST || compass == WEST || compass == SOUTHWEST); }
    public boolean		isEasterly(final Point point) 			{ final int compass = this.getCompassBearing(point); return (compass == NORTHEAST || compass == EAST || compass == SOUTHEAST); }
    public boolean		isSoutherly(final Point point) 			{ final int compass = this.getCompassBearing(point); return (compass == SOUTHWEST || compass == SOUTH || compass == SOUTHEAST); }
    public boolean		isLatitudinal(final Point point)		{ final int compass = this.getCompassBearing(point); return (compass == WEST 	|| compass == CENTRE || compass == EAST); }
    public boolean		isLongitudinal(final Point point)		{ final int compass = this.getCompassBearing(point); return (compass == NORTH 	|| compass == CENTRE || compass == SOUTH); }



// ---------- statics -------------------------------------

    public static final int		NORTHWEST	= 0;
    public static final int		NORTH		= 1;
    public static final int		NORTHEAST	= 2;
    public static final int		WEST		= 3;
    public static final int		CENTRE		= 4;
    public static final int		EAST		= 5;
    public static final int		SOUTHWEST	= 6;
    public static final int		SOUTH		= 7;
    public static final int		SOUTHEAST	= 8;
    
    
    
    protected static final int		DEFAULTWIDTH	= 60;
    protected static final int		DEFAULTHEIGHT	= 30;
    
    protected static final String	EDITINSTANCE	= "Edit instance...";
    protected static final String	EDITATTRIBUTES	= "Edit attributes...";
    protected static final String	SHOWATTRIBUTES	= "Show attributes...";
    protected static final String	HIDEATTRIBUTES	= "Hide attributes...";
    protected static final String	DELETEINSTANCE	= "Delete instance";
    
    
    
// ---------- properties ----------------------------------
    
    protected Rectangle			bounds;
    
    protected String			name		= ""; // Nom de l'image ajouté sur le diagramme
    protected String			classifier	= "";
    protected ArrayList<String>			attributes	= new ArrayList<String>(8);
    
    protected boolean			showFlag;
    
    protected ArrayList		theRelations	= new ArrayList(8);
    
    protected Point			theMousePoint;		// during dragging
    protected Point			theStartMousePoint;
    
 //* PopMenu properties
    private EditInstances itemEdit = new EditInstances();
    private ShowAttributes itemShow = new ShowAttributes();
    private EditAttributes itemEditAtt = new EditAttributes();
    private DeleteInstance itemDelete = new DeleteInstance();
    

    

    private ColliePropertyPanel propertyPanel;
    private static CollieDiagramPanel diagramPanel;

}	// class: NodeElement

// ============================================================================
