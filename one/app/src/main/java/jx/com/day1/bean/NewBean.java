package jx.com.day1.bean;

public class NewBean {

    public Data data;

    public Data getData() {
        return data;
    }

    public class Data {
        public String images;
        public String title;
        public float price;
        public float createtime;
        public String subhead;

        public String getImages() {
            return images;
        }

        public String getTitle() {
            return title;
        }

        public float getPrice() {
            return price;
        }

        public float getCreatetime() {
            return createtime;
        }

        public String getSubhead() {
            return subhead;
        }
    }



}
