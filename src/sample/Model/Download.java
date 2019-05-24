package sample.Model;



public class Download {
    private  String name;
    private String size;
    private String url;
//    private String Date;
//    private String status;
    private String speed;
    public Download(String name, String url,String size,String speed){
        this.name = name;
        this.size = size;
        this.url = url;
       this.speed=speed;
//        this.Date=Date;



    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }


//    public String getDate() {
//        return Date;
//    }
//
//    public void setDate(String date) {
//       this. Date = date;
//    }

//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
}
