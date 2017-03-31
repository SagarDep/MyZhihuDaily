package com.example.zy1584.myzhihudaily.ui.main.dailyStories.bean;

import com.example.zy1584.myzhihudaily.base.BaseItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zy1584 on 2017-3-30.
 */

public class DailyStoriesBean {

    /**
     * date : 20170330
     * stories : [{"images":["https://pic1.zhimg.com/v2-aa49b42673629c07ea02887613847574.jpg"],
     * "type":0,"id":9325768,"ga_prefix":"033017","title":"村上春树说永远不要同情自己，但也许他错了"},
     * {"images":["https://pic3.zhimg.com/v2-8f35ab02e4701dc7a3bde6aba54712f2.jpg"],"type":0,
     * "id":9324114,"ga_prefix":"033016","title":"火了六百年的孙悟空告诉你「如何当一个好 IP」"},
     * {"images":["https://pic3.zhimg.com/v2-427d1ed1ef3ebe9a4a5105320b08c5b2.jpg"],"type":0,
     * "id":9325616,"ga_prefix":"033015","title":"关于「老花眼」，这些都是误解"},{"images":["https://pic2.zhimg
     * .com/v2-3cd4c23abafdc5f20e91635a2974a905.jpg"],"type":0,"id":9325630,"ga_prefix":"033015",
     * "title":"「徐静蕾老师，作为一位女导演，你觉得\u2026\u2026」"},{"images":["https://pic2.zhimg
     * .com/v2-cbeb61555625f52e459ba18e6803a2e9.jpg"],"type":0,"id":9325522,"ga_prefix":"033014",
     * "title":"含金量高，报考限制少，工作不难找，这个证真有这么好吗？"},{"images":["https://pic2.zhimg
     * .com/v2-0c8bba5ea3bd0409d3d7058800a06a61.jpg"],"type":0,"id":9325420,"ga_prefix":"033013",
     * "title":"职人介绍所：老大难的数学，对 chenqin 来说只是工具"},{"images":["https://pic1.zhimg
     * .com/v2-842274ea2a3f710a0ac10be402d4ed20.jpg"],"type":0,"id":9319892,"ga_prefix":"033013",
     * "title":"数量 vs 质量，谁能拿到共享单车大战的赛点？"},{"images":["https://pic3.zhimg
     * .com/v2-2ba945d5385958924eb5737f858e741a.jpg"],"type":0,"id":9325114,"ga_prefix":"033012",
     * "title":"大误 · 贝壳驱壳蛋壳甲壳脑壳，都很疼"},{"title":"这些世界上最孤独的地方，寂寞又美好","ga_prefix":"033010",
     * "images":["https://pic4.zhimg.com/v2-381364d88a12d3b62792484928db3ddb.jpg"],
     * "multipic":true,"type":0,"id":9321605},{"images":["https://pic4.zhimg
     * .com/v2-0983ac630d50d798ba099a0cce8c0ca3.jpg"],"type":0,"id":9323759,"ga_prefix":"033009",
     * "title":"网络主播唱别人的歌侵权吗？这事有点难办啊"},{"images":["https://pic1.zhimg
     * .com/v2-24595fc746a95746a89bc025487c22c4.jpg"],"type":0,"id":9324381,"ga_prefix":"033008",
     * "title":"作为小公司的 HR 简历都收不到几封，怎样才能招到人？"},{"images":["https://pic2.zhimg
     * .com/v2-bed650539e44230b78e1bb268e70db11.jpg"],"type":0,"id":9323859,"ga_prefix":"033007",
     * "title":"对于大多数河南人，这一碗是三天不喝就浑身难受的瘾"},{"images":["https://pic2.zhimg
     * .com/v2-10fa2912cb3760ee2305d101be8c03c1.jpg"],"type":0,"id":9323747,"ga_prefix":"033007",
     * "title":"用户成本越来越高，整个游戏行业都跟着变了"},{"images":["https://pic3.zhimg
     * .com/v2-170e78570ad03eab19486103e5304f5a.jpg"],"type":0,"id":9323243,"ga_prefix":"033007",
     * "title":"把电线杆变成 Wi-Fi 热点，印度这么搞有点杯水车薪"},{"images":["https://pic2.zhimg
     * .com/v2-b500be749e3c2fc48f3b3c99057d8621.jpg"],"type":0,"id":9322990,"ga_prefix":"033006",
     * "title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic2.zhimg.com/v2-daea62f9c2c38935d1b9bbeee8e97c0d.jpg",
     * "type":0,"id":9325630,"ga_prefix":"033015","title":"「徐静蕾老师，作为一位女导演，你觉得\u2026\u2026」"},
     * {"image":"https://pic4.zhimg.com/v2-f870febf2141e1fd1280bbdfc1e4b09f.jpg","type":0,
     * "id":9325522,"ga_prefix":"033014","title":"含金量高，报考限制少，工作不难找，这个证真有这么好吗？"},
     * {"image":"https://pic4.zhimg.com/v2-4ac0e51f8fa20d93b244f4311604f3cb.jpg","type":0,
     * "id":9323859,"ga_prefix":"033007","title":"对于大多数河南人，这一碗是三天不喝就浑身难受的瘾"},
     * {"image":"https://pic4.zhimg.com/v2-1fe9d81f03117f83b9dc57ab1b35b5b7.jpg","type":0,
     * "id":9323243,"ga_prefix":"033007","title":"把电线杆变成 Wi-Fi 热点，印度这么搞有点杯水车薪"},
     * {"image":"https://pic4.zhimg.com/v2-ef0f3abd29fb7e2cc001c921a564f037.jpg","type":0,
     * "id":9321564,"ga_prefix":"032907","title":"中国的文化娱乐产业，正在被腾讯和阿里跑马圈地"}]
     */

    private String date;
    private List<StoriesBean> stories = new ArrayList<>();
    private List<TopStoriesBean> top_stories = new ArrayList<>();

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean implements BaseItem {
        /**
         * images : ["https://pic1.zhimg.com/v2-aa49b42673629c07ea02887613847574.jpg"]
         * type : 0
         * id : 9325768
         * ga_prefix : 033017
         * title : 村上春树说永远不要同情自己，但也许他错了
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images = new ArrayList<>();

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean implements BaseItem {
        /**
         * image : https://pic2.zhimg.com/v2-daea62f9c2c38935d1b9bbeee8e97c0d.jpg
         * type : 0
         * id : 9325630
         * ga_prefix : 033015
         * title : 「徐静蕾老师，作为一位女导演，你觉得……」
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
