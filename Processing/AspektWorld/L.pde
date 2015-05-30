import processing.core.PVector;


class Line {
    /**
     *
     */
    private final AspektWorld aspektWorld;
    public PVector another;
    public PVector yetanother;
    public int lc;
 
    public Line( AspektWorld aspektWorld, float ax, float ay, float az, float tx, float ty, float tz ) {
        this.aspektWorld = aspektWorld;
        another = new PVector(ax,ay,az);
        yetanother = new PVector(tx,ty,tz);
        lc = this.aspektWorld.color (200,200,200,200);
    } 
 
    public void draw() {
        this.aspektWorld.stroke(lc);
        this.aspektWorld.line(another.x,another.y,another.z,yetanother.x,yetanother.y,yetanother.z); 
    }
}
