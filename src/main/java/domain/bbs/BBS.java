package domain.bbs;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 12
 * Time: 오후 3:33
 */
public class BBS {

    private Long id;

    private String title;

    private String content;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }
}
