package demo.wuchunmei.com.bean;

import java.util.List;

/**
 * 作者：wuchunmei on 5/3/18 06:22
 * <p>
 * 邮箱：646812329@qq.com
 *
 *data[
 * {
 "shareCount": null,
 "title": null,
 "imageUrls": [
 "https://ccm.ddcdn.com/photo-s/0e/09/6d/39/caption.jpg",
 "https://ccm.ddcdn.com/photo-s/0e/09/6d/3d/caption.jpg",
 "https://ccm.ddcdn.com/photo-s/0e/09/70/ee/caption.jpg",
 "https://ccm.ddcdn.com/photo-s/0e/09/70/f2/caption.jpg"
 ],
 "publishDate": 1481897067,
 "id": "5229",
 "content": "",
 "likeCount": null,
 "posterId": null,
 "publishDateStr": "2016-12-16T14:04:27",
 "url": "https://www.tripadvisor.cn/TourismBlog-t5229.html",
 "commentCount": null,
 "posterScreenName": "Ailsa岚"

 },
 ]*/
public class Travel extends Entity{
    private String shareCount;
    private String  title;
    private String publishDate;
    private String id;
    private String content;
    private String likeCount;
    private String posterId;
    private String publishDateStr;
    private String url;
    private String commentCount;
    private String posterScreenName;
    private List<String> imageUrls;

    public String getShareCount() {
        return shareCount;
    }

    public void setShareCount(String shareCount) {
        this.shareCount = shareCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public String getPosterId() {
        return posterId;
    }

    public void setPosterId(String posterId) {
        this.posterId = posterId;
    }

    public String getPublishDateStr() {
        return publishDateStr;
    }

    public void setPublishDateStr(String publishDateStr) {
        this.publishDateStr = publishDateStr;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getPosterScreenName() {
        return posterScreenName;
    }

    public void setPosterScreenName(String posterScreenName) {
        this.posterScreenName = posterScreenName;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "shareCount=" + shareCount +
                ", title='" + title + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", id='" + id + '\'' +
                ", commentCount='" + commentCount + '\'' +
                ", likeCount='" + likeCount + '\'' +
                ", posterScreenName=" + posterScreenName +
                '}';
    }
}
