//package com.deft.entity;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity(name = "Post")
//@Table(name = "post")
//public class Post {
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    private String title;
//
//    @OneToMany(mappedBy = "post",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    @JoinColumn(name = "post_id")
//    private List<PostComment> comments = new ArrayList<>();
//
//
//}
//@Entity(name = "PostComment")
//@Table(name = "post_comment")
// class PostComment{
//
//    @Id
//    @GeneratedValue
//    private Long id;
//    private String review;
//
//}
//
//
////Bây giờ, nếu chúng ta gắn một bài đăng (Post) và ba bình luận (PostComment):
////        Post post = new Post("First post");
////
////        post.getComments().add(
////        new PostComment("My first review")
////        );
////        post.getComments().add(
////        new PostComment("My second review")
////        );
////        post.getComments().add(
////        new PostComment("My third review")
////        );
////
////        entityManager.persist(post);
//
//
//
//
//
////    Hibernate sẽ thực hiện các câu lệch SQL dưới đây :
////    insert into post (title, id)
////    values ('First post', 1)
////
////    insert into post_comment (review, id)
////    values ('My first review', 2)
////
////    insert into post_comment (review, id)
////    values ('My second review', 3)
////
////    insert into post_comment (review, id)
////    values ('My third review', 4)
////
////    insert into post_post_comment (Post_id, comments_id)
////    values (1, 2)
////
////    insert into post_post_comment (Post_id, comments_id)
////    values (1, 3)
////
////    insert into post_post_comment (Post_id, comments_id)
////    values (1, 4)
//
