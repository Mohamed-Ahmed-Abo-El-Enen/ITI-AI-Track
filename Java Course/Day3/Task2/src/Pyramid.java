public class Pyramid
{
    private String Pharaoh;
    private String ancientName;
    private String modernName;
    private String Dynasty;
    private String Site;
    private float Base1;
    private float Base2;
    private float Height;
    private float Slope;
    private float Volume;
    private float Latitude;
    private float Longitude;
    private String Type;
    private String Lepsius;
    private String Material;
    private String Comment;

    Pyramid()
    {
        this.Pharaoh = "";
        this.ancientName = "";
        this.modernName = "";
        this.Dynasty = "";
        this.Site = "";
        this.Base1 = 0;
        this.Base2 = 0;
        this.Height = 0;
        this.Slope = 0;
        this.Volume = 0;
        this.Latitude = 0;
        this.Longitude = 0;
        this.Type = "";
        this.Lepsius = "";
        this.Material = "";
        this.Comment = "";
    }

    Pyramid(String Pharaoh, String modernName, String Site, float Height)
    {
        this.Pharaoh = Pharaoh;
        this.ancientName = "";
        this.modernName = modernName;
        this.Dynasty = "";
        this.Site = Site;
        this.Base1 = 0;
        this.Base2 = 0;
        this.Height = Height;
        this.Slope = 0;
        this.Volume = 0;
        this.Latitude = 0;
        this.Longitude = 0;
        this.Type = "";
        this.Lepsius = "";
        this.Material = "";
        this.Comment = "";
    }

    public String getAncientName() {
        return ancientName;
    }

    public String getModernName() {
        return modernName;
    }

    public String getPharaoh() {
        return Pharaoh;
    }

    public float getHeight() {
        return Height;
    }

    public String getSite() {
        return Site;
    }
}
