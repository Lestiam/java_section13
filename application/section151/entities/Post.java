package application.section151.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

//    é uma constante, e o provate static é para que eu não tenha um cópia deste objeto para cada post da minha aplicação,
//    será apenas uma cópia para minha aplicação inteira
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private String title;
    private String content;
    private Integer likes;
    List<Comment> comments = new ArrayList<>();

    public Post(){
    }

    public Post(Date moment, String title, String content, Integer likes) {
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    //não pode haver um método para setar a minha lista, eu preciso ter um método para adicionar e remover

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();//o StringBuilder deixa o programa muito mais leve quando precisarmos concatenar várias Strings
        sb.append(title + "\n");//append significa acrscentar no final
        sb.append(likes);
        sb.append(" Likes - ");
        sb.append(sdf.format(moment) + "\n");
        sb.append(content + "\n");
        sb.append("Comments: \n");
        for (Comment c : comments) {//para cada Comment c na minha lista de comentários(comments) do Post, eu vou mandar acrescentar esse Commentet c aqui também no meu StringBuilder
              sb.append(c.getText() + "\n");
        }
        return sb.toString(); //convcerto meu StringBuilder para String
    }
}
