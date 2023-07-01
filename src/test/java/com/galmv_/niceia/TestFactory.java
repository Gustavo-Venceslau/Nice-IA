package com.galmv_.niceia;

import com.galmv_.niceia.comment.Comment;
import com.galmv_.niceia.comment.CommentRepository;
import com.galmv_.niceia.comment.CommentService;
import com.galmv_.niceia.post.Post;
import com.galmv_.niceia.post.PostRepository;
import com.galmv_.niceia.post.PostService;
import com.galmv_.niceia.student.Student;
import com.galmv_.niceia.student.StudentRepository;
import com.galmv_.niceia.student.StudentService;
import com.galmv_.niceia.student.enums.StudentRole;
import jakarta.annotation.Resource;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@Configuration
@RunWith(SpringRunner.class)
public class TestFactory {

    @Resource
    protected StudentRepository studentRepository;
    @Resource
    protected PostRepository postRepository;
    @Resource
    protected CommentRepository commentRepository;

    @Autowired
    protected StudentService studentService;
    @Autowired
    protected PostService postService;
    @Autowired
    protected CommentService commentService;

    protected Student student = new Student(null, "Gustavo", "de Almeida", "gustavo@gmail.com", "1234", StudentRole.USER);
    protected Post post = new Post(null, "Good Morning", "ImageURL", student);
    protected Comment comment = new Comment(null, "Good way, guys!", post, student);

    @Before
    public void setUp(){
        studentRepository.save(student);
        postRepository.save(post);
        commentRepository.save(comment);
    }

}
